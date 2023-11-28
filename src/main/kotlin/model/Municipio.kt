package model

import org.apache.beam.sdk.coders.DefaultCoder
import org.apache.beam.sdk.extensions.avro.coders.AvroCoder

@DefaultCoder(AvroCoder::class)
data class Municipio(
    val codigoIbge: String? = null,
    val nome: String? = null
)
