import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.ParDo
import org.apache.beam.sdk.transforms.ToString
import transformers.PaisPTransformer
import transformers.QuebraLinhaCSV

class PaisPipeline {
}

fun main() {

    val options = PipelineOptionsFactory.create()

    val p = Pipeline.create(options)

    p.apply(TextIO.read().from("<caminho dos arquivos de pais>"))
        .apply(ParDo.of(QuebraLinhaCSV()))
        .apply(ParDo.of(PaisPTransformer()))
        .apply(ToString.elements())
        .apply(TextIO.write().to("pais"))

    p.run().waitUntilFinish()
}