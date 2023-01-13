package model

import org.apache.beam.sdk.coders.AvroCoder
import org.apache.beam.sdk.coders.DefaultCoder

@DefaultCoder(AvroCoder::class)
data class Qualificacao(
    val codigo: String? = null,
    val descricao: String? = null
)
