package model

import org.apache.beam.sdk.coders.AvroCoder
import org.apache.beam.sdk.coders.DefaultCoder

@DefaultCoder(AvroCoder::class)
data class Municipio(
    val codigoIbge: String? = null,
    val nome: String? = null
)
