import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.FileIO
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.DoFn
import org.apache.beam.sdk.transforms.ParDo
import org.apache.beam.sdk.transforms.ToString

class AllFilesPipelines {
}

fun main() {
    val options = PipelineOptionsFactory.create()

    val p = Pipeline.create(options)

    p.apply(FileIO.match().filepattern("<caminho dos arquivos csv"))
        .apply(FileIO.readMatches())
        .apply(ParDo.of(object : DoFn<FileIO.ReadableFile, String>() {
            @ProcessElement
            fun processElement(@Element file: FileIO.ReadableFile, saida: OutputReceiver<String>) {
                println("${file.metadata.resourceId().filename}")
                saida.output(file.metadata.resourceId().filename)
            }
        }))
        .apply(ToString.elements())
        // .apply(DatastoreIO.v1().write().withProjectId("api-projecy").to(""))
        .apply(TextIO.write().to("arquivos"))
}