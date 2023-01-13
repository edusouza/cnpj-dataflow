import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.io.gcp.datastore.DatastoreIO
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.ParDo
import transformers.CnaePTransformer
import transformers.QuebraLinhaCSV
import transformers.entity.CnaeEntityTransformer

fun main(args: Array<String>) {

    val options = PipelineOptionsFactory.fromArgs(*args).withValidation().create()

    val p = Pipeline.create(options)

    p.apply(TextIO.read().from("<caminho dos arquivos de cnae>"))
        .apply(ParDo.of(QuebraLinhaCSV()))
        .apply(ParDo.of(CnaePTransformer()))
        .apply(ParDo.of(CnaeEntityTransformer()))
        .apply(DatastoreIO.v1().write().withProjectId("<api-project-id>"))

    p.run().waitUntilFinish()
}