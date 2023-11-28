# cnpj-dataflow

This is a Maven Java project that uses Apache Beam to process CNPJ data.

## Project Structure

The project is structured as follows:

- `src/main/kotlin`: Contains the project's source code.
    - `AllFilesPipelines.kt`: File description.
    - `converter`: Contains classes for data conversion.
    - `EmpresaTransformer.kt`: File description.
    - `extensions`: Directory description.
    - `model`: Contains model classes.
    - `MotivoTransformer.kt`: File description.
    - `MunicipioTransformer.kt`: File description.
    - `NaturezaJuridicaPipeline.kt`: File description.
    - `PaisPipeline.kt`: File description.
    - `pipelines`: Directory description.
    - `QualificacaoPipeline.kt`: File description.
    - `transformers`: Directory description.
- `src/main/resources`: Contains project resources.
- `src/test`: Contains project tests.

## How to Build

To build the project, run the following command in the terminal:

```sh
mvn clean install
```

## How to Execute

To execute the project, run the following command in the terminal:

```sh
mvn exec:java -Dexec.mainClass="br.com.dataflow.pipeline.EmpresaPipeline" 
            -Dexec.args="--inputFile=gs://<bucket>/2019-12-01/EMPRECSV.DEC 
            --output=gs://<bucket>/2019-12-01/EMPRECSV.DEC"
```

## How to Run Tests

To run the project tests, execute the following command in the terminal:

```sh
mvn test
```

## How to run the project on Google Cloud Dataflow with Apache Beam

To run the project on Google Cloud Dataflow with Apache Beam, execute the following command in the terminal:

```sh
mvn compile exec:java -Dexec.mainClass="br.com.dataflow.pipeline.EmpresaPipeline" 
                    -Dexec.args="--project=cnpj-dataflow 
                    --stagingLocation=gs://<bucket>/staging 
                    --tempLocation=gs://<bucket>/temp 
                    --runner=DataflowRunner 
                    --inputFile=gs://<bucket>/2019-12-01/EMPRECSV.DEC 
                    --output=gs://<bucket>/2019-12-01/EMPRECSV.DEC 
                    --workerMachineType=n1-standard-1 
                    --numWorkers=1"
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
