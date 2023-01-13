package converter

import model.Cnae
import kotlin.reflect.KClass

object CnaeConverter : Converter<Cnae>() {

    override fun getClass(): KClass<Cnae> = Cnae::class
}