package model

import org.apache.beam.sdk.coders.AvroCoder
import org.apache.beam.sdk.coders.DefaultCoder

@DefaultCoder(AvroCoder::class)
data class Socio(
    val cnpjBasico: String? = null,
    val identificadorSocio: String? = null,
    val nomeSocio: String? = null,
    val cpfCnpj: String? = null,
    val qualificacao: String? = null,
    val dataEntrada: String? = null,
    val pais: String? = null,
    val cpfRepresentante: String? = null,
    val nomeRepresentante: String? = null,
    val codigoRepresentante: String? = null,
    val faixaEtaria: String? = null
) : Model
