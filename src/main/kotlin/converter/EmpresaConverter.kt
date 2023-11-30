package converter

import model.Empresa
import kotlin.reflect.KClass

/**
 * @author eduardo
 * @Date 30/11/2023
 */
object EmpresaConverter : Converter<Empresa>() {
    override fun getClass(): KClass<Empresa> = Empresa::class
}