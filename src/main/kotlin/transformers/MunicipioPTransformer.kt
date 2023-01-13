package transformers

import model.Municipio
import org.apache.beam.sdk.transforms.DoFn

class MunicipioPTransformer : DoFn<MutableList<String>, Municipio>() {

    @ProcessElement
    fun processElement(@Element lista:MutableList<String>, saida: OutputReceiver<Municipio>) {
        saida.output(Municipio(codigoIbge = lista[0], nome = lista[1]))
    }
}