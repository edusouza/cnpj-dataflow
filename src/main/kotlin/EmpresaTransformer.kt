import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.ParDo
import org.apache.beam.sdk.transforms.ToString
import transformers.EmpresaPTransformer
import transformers.QuebraLinhaCSV

class EmpresaTransformer {
}

fun main() {
    val options = PipelineOptionsFactory.create()

    val p = Pipeline.create(options)

    p.apply(TextIO.read().from("<caminho dos arquivos de empresa>"))
        .apply(ParDo.of(QuebraLinhaCSV()))
        .apply(ParDo.of(EmpresaPTransformer()))
        .apply(ToString.elements())
        .apply(TextIO.write().to("empresas"))
}