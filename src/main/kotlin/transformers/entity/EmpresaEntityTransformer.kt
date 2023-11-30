package transformers.entity

import converter.EmpresaConverter
import model.Empresa

/**
 * @author eduardo
 * @Date 30/11/2023
 */
class EmpresaEntityTransformer : EntityTransformer<Empresa>() {
    override fun getValuesInMap(empresa: Empresa): MutableMap<String, Any?> = EmpresaConverter.converter(empresa)

    override fun getEntityName(): String = EmpresaConverter.getName<Empresa>()

    override fun getKeyId(model: Empresa): String = model.cnpjBasico!!
}