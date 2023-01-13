package transformers

import model.NaturezaJuridica
import org.apache.beam.sdk.transforms.DoFn

class NaturezaJuridicaPTransformer : DoFn<MutableList<String>, NaturezaJuridica>() {

    @ProcessElement
    fun processElement(@Element lista: MutableList<String>, saida: OutputReceiver<NaturezaJuridica>) {
        saida.output(
            NaturezaJuridica(
                codigo = lista[0],
                descricao = lista[1]
            )
        )
    }
}