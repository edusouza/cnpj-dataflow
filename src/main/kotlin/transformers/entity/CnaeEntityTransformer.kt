package transformers.entity

import converter.CnaeConverter
import model.Cnae

class CnaeEntityTransformer : EntityTransformer<Cnae>() {

    override fun getValuesInMap(model: Cnae): MutableMap<String, Any?> = CnaeConverter.converter(model)

    override fun getEntityName(): String = CnaeConverter.getName<Cnae>()

    override fun getKeyId(model: Cnae): String = model.codigo!!
}