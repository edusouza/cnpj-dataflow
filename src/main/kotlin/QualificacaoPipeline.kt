import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.ParDo
import org.apache.beam.sdk.transforms.ToString
import transformers.QualificacaoPTransformer
import transformers.QuebraLinhaCSV

class QualificacaoPipeline {
}

fun main() {

    val options = PipelineOptionsFactory.create()

    val p = Pipeline.create(options)

    p.apply(TextIO.read().from("<caminho dos arquivos de qualificacao>"))
        .apply(ParDo.of(QuebraLinhaCSV()))
        .apply(ParDo.of(QualificacaoPTransformer()))
        .apply(ToString.elements())
        .apply(TextIO.write().to("qualificacao"))

    p.run().waitUntilFinish()
}