package transformers

import model.Pais
import org.apache.beam.sdk.transforms.DoFn

class PaisPTransformer : DoFn<MutableList<String>, Pais>() {

    @ProcessElement
    fun processElement(@Element lista: MutableList<String>, saida: OutputReceiver<Pais>) {
        saida.output(
            Pais(
                codigo = lista[0],
                descricao = lista[1]
            )
        )
    }
}