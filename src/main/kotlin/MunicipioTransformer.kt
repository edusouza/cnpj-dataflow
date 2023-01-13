import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.ParDo
import org.apache.beam.sdk.transforms.ToString
import transformers.MunicipioPTransformer
import transformers.QuebraLinhaCSV

class MunicipioTransformer {

}

fun main() {

    // Create a PipelineOptions object. This object lets us set various execution
    // options for our pipeline, such as the runner you wish to use. This example
    // will run with the DirectRunner by default, based on the class path configured
    // in its dependencies.
    val options = PipelineOptionsFactory.create()

    // In order to run your pipeline, you need to make following runner specific changes:
    //
    // CHANGE 1/3: Select a Beam runner, such as BlockingDataflowRunner
    // or FlinkRunner.
    // CHANGE 2/3: Specify runner-required options.
    // For BlockingDataflowRunner, set project and temp location as follows:
    //   DataflowPipelineOptions dataflowOptions = options.as(DataflowPipelineOptions.class);
    //   dataflowOptions.setRunner(BlockingDataflowRunner.class);
    //   dataflowOptions.setProject("SET_YOUR_PROJECT_ID_HERE");
    //   dataflowOptions.setTempLocation("gs://SET_YOUR_BUCKET_NAME_HERE/AND_TEMP_DIRECTORY");
    // For FlinkRunner, set the runner as follows. See {@code FlinkPipelineOptions}
    // for more details.
    //   options.as(FlinkPipelineOptions.class)
    //      .setRunner(FlinkRunner.class);

    // Create the Pipeline object with the options we defined above
    val p = Pipeline.create(options)

    p.apply(TextIO.read().from("<caminho dos arquivos de municipios>"))
        .apply(ParDo.of(QuebraLinhaCSV()))
        .apply(ParDo.of(MunicipioPTransformer()))
        .apply(ToString.elements())
        .apply(TextIO.write().to("municipios"))

    p.run().waitUntilFinish()
}

