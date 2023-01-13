package transformers.entity

import com.google.datastore.v1.Entity
import com.google.datastore.v1.client.DatastoreHelper
import model.Model
import org.apache.beam.sdk.transforms.DoFn
import java.util.*

abstract class EntityTransformer<T: Model> : DoFn<T, Entity>() {

    abstract fun getValuesInMap(model: T): MutableMap<String, Any?>

    abstract fun getEntityName(): String

    abstract fun getKeyId(model: T): String

    @ProcessElement
    fun processElement(@Element model: T, saida: OutputReceiver<Entity>) {

        val mapSocio = getValuesInMap(model)
        val kindName = getEntityName()

        val builder = Entity.newBuilder()
        val key = DatastoreHelper.makeKey(kindName, getKeyId(model)).build()
        builder.setKey(key)

        val propertiesMap = mapSocio.map { (k, v) ->
            val valueBuilder = when (v) {
                is Boolean -> DatastoreHelper.makeValue(v)
                is Date -> DatastoreHelper.makeValue(v)
                is Long -> DatastoreHelper.makeValue(v)
                is String -> DatastoreHelper.makeValue(v)
                else -> DatastoreHelper.makeValue(v.toString())
            }
            Pair(k, valueBuilder.build())
        }.associateBy({ it.first }, { it.second })

        builder.putAllProperties(propertiesMap)

        saida.output(builder.build())
    }
}