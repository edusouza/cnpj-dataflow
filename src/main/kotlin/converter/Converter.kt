package converter

import model.Model
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

abstract class Converter<T : Model> {

    fun converter(model: T): MutableMap<String, Any?> {

        val kClass = getClass()
        val memberProperties = kClass.memberProperties

        return memberProperties
            .associateBy(keySelector = { it.name }, valueTransform = { it.getValue(model, it) })
            .toMutableMap()
    }

    abstract fun getClass(): KClass<T>

    inline fun <reified T: Model> getName(): String = T::class.simpleName!!
}