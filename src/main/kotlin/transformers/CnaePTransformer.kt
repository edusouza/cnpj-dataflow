package transformers

import model.Cnae
import org.apache.beam.sdk.transforms.DoFn

class CnaePTransformer : DoFn<MutableList<String>, Cnae>() {

    @ProcessElement
    fun processElement(@Element lista: MutableList<String>, saida: OutputReceiver<Cnae>) {
        saida.output(Cnae(codigo = lista[0], descricao = lista[1]))
    }
}