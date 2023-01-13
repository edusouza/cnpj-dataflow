package transformers

import model.Qualificacao
import org.apache.beam.sdk.transforms.DoFn

class QualificacaoPTransformer : DoFn<MutableList<String>, Qualificacao>() {

    @ProcessElement
    fun processElement(@Element lista: MutableList<String>, saida: OutputReceiver<Qualificacao>) {
        saida.output(
            Qualificacao(
                codigo = lista[0],
                descricao = lista[1]
            )
        )
    }
}