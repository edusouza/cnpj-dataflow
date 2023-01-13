package transformers

import model.Motivo
import org.apache.beam.sdk.transforms.DoFn

class MotivoPTransformer : DoFn<MutableList<String>, Motivo>() {

    @ProcessElement
    fun processElement(@Element lista: MutableList<String>, saida: OutputReceiver<Motivo>) {
        saida.output(
            Motivo(
                codigo = lista[0],
                descricao = lista[1]
            )
        )
    }
}