package converter

import model.Socio
import kotlin.reflect.KClass

object SocioConverter: Converter<Socio>(){

    /*
    fun converter(socio: Socio): MutableMap<String, Any?> {

        val memberProperties = Socio::class.memberProperties
        return memberProperties
            .associateBy(keySelector = { it.name }, valueTransform = { it.getValue(socio, it) })
            .toMutableMap()
    }*/
    override fun getClass(): KClass<Socio> = Socio::class
}