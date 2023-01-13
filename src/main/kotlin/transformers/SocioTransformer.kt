package transformers

import model.Socio
import org.apache.beam.sdk.transforms.DoFn

class SocioTransformer : DoFn<MutableList<String>, Socio>() {

    @ProcessElement
    fun processElement(@Element lista: MutableList<String>, saida: OutputReceiver<Socio>) {
        saida.output(
            Socio(
                cnpjBasico = lista[0],
                identificadorSocio = lista[1],
                nomeSocio = lista[2],
                cpfCnpj = lista[3],
                qualificacao = lista[4],
                dataEntrada = lista[5],
                pais = lista[6],
                cpfRepresentante = lista[7],
                nomeRepresentante = lista[8],
                codigoRepresentante = lista[9],
                faixaEtaria = lista[10]
            )
        )
    }
}
