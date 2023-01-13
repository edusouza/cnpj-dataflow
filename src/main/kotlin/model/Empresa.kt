package model

import org.apache.beam.sdk.coders.AvroCoder
import org.apache.beam.sdk.coders.DefaultCoder

@DefaultCoder(AvroCoder::class)
data class Empresa(
    val cnpjBasico: String? = null,
    val razaoSocial: String? = null,
    val naturezaJuridica: String? = null,
    val qualiResponsavel: String? = null,
    val capitalSocial: String? = null,
    val porteEmpresa: String? = null,
    val enteFederativo: String? = null
)
