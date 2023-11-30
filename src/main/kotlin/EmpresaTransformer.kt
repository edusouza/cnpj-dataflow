import options.InputOutputOptions
import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.io.gcp.datastore.DatastoreIO
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.ParDo
import org.apache.beam.sdk.transforms.ToString
import transformers.EmpresaPTransformer
import transformers.QuebraLinhaCSV
import transformers.entity.EmpresaEntityTransformer

class EmpresaTransformer {
}

fun main(args: Array<String>) {
    val options = PipelineOptionsFactory.fromArgs(*args).withValidation().`as`(InputOutputOptions::class.java)

    val p = Pipeline.create(options)

    p.apply(TextIO.read().from(options.getInputFile()))
        .apply(ParDo.of(QuebraLinhaCSV()))
        .apply(ParDo.of(EmpresaPTransformer()))
        .apply(ParDo.of(EmpresaEntityTransformer()))
        .apply(DatastoreIO.v1().write().withProjectId(""))

    p.run().waitUntilFinish()
}