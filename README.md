# cnpj-dataflow

Este é um projeto Java Maven que utiliza o Apache Beam para processar dados do CNPJ.

## Estrutura do Projeto

O projeto está estruturado da seguinte maneira:

- `src/main/kotlin`: Contém o código fonte do projeto.
    - `AllFilesPipelines.kt`: Descrição do arquivo.
    - `converter`: Contém classes para converter dados.
    - `EmpresaTransformer.kt`: Descrição do arquivo.
    - `extensions`: Descrição do diretório.
    - `model`: Contém as classes de modelo.
    - `MotivoTransformer.kt`: Descrição do arquivo.
    - `MunicipioTransformer.kt`: Descrição do arquivo.
    - `NaturezaJuridicaPipeline.kt`: Descrição do arquivo.
    - `PaisPipeline.kt`: Descrição do arquivo.
    - `pipelines`: Descrição do diretório.
    - `QualificacaoPipeline.kt`: Descrição do arquivo.
    - `transformers`: Descrição do diretório.
- `src/main/resources`: Contém os recursos do projeto.
- `src/test`: Contém os testes do projeto.

## Como Construir

Para construir o projeto, execute o seguinte comando no terminal:

```sh
mvn clean install
```

## Como Executar

Para executar o projeto, execute o seguinte comando no terminal:

```sh
mvn exec:java -Dexec.mainClass="br.com.dataflow.pipeline.EmpresaPipeline" 
            -Dexec.args="--inputFile=gs://<bucket>/2019-12-01/EMPRECSV.DEC 
            --output=gs://<bucket>/2019-12-01/EMPRECSV.DEC"
```

## Como Executar os Testes

Para executar os testes do projeto, execute o seguinte comando no terminal:

```sh
mvn test
```

## Como executar o projeto no Google Cloud Dataflow com o Apache Beam

Para executar o projeto no Google Cloud Dataflow com o Apache Beam, execute o seguinte comando no terminal:

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

## Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.