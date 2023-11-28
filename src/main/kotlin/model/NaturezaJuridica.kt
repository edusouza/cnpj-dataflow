package model

import org.apache.beam.sdk.coders.DefaultCoder
import org.apache.beam.sdk.extensions.avro.coders.AvroCoder

@DefaultCoder(AvroCoder::class)
data class NaturezaJuridica(
    val codigo: String? = null,
    val descricao: String? = null
)
