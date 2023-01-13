package transformers.entity

import converter.SocioConverter
import model.Socio
import java.util.*

class SocioEntityTransformer : EntityTransformer<Socio>() {

    override fun getValuesInMap(socio: Socio) = SocioConverter.converter(socio)

    override fun getEntityName() = SocioConverter.getName<Socio>()

    override fun getKeyId(model: Socio): String = UUID.randomUUID().toString()
}