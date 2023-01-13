package transformers

import org.apache.beam.sdk.transforms.DoFn

class QuebraLinhaCSV : DoFn<String, MutableList<String>>() {

    @ProcessElement
    fun processElement(@Element linha: String, saida: OutputReceiver<MutableList<String>>) {

        val lista = linha
            .split(";")
            .map { campo ->
                campo.removeSurrounding("\"")
            }.toMutableList()
        saida.output(lista)
    }
}