package transformers

import model.Empresa
import org.apache.beam.sdk.transforms.DoFn

class EmpresaPTransformer : DoFn<MutableList<String>, Empresa>() {

    @ProcessElement
    fun processElement(@Element lista: MutableList<String>, saida: OutputReceiver<Empresa>) {
        saida.output(
            Empresa(
                cnpjBasico = lista[0],
                razaoSocial = lista[1],
                naturezaJuridica = lista[2],
                qualiResponsavel = lista[3],
                capitalSocial = lista[4],
                porteEmpresa = lista[5],
                enteFederativo = lista[6]
            )
        )
    }
}