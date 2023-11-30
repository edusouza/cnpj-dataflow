package options

import org.apache.beam.sdk.options.Default
import org.apache.beam.sdk.options.PipelineOptions

/**
 * @author eduardo
 * @Date 30/11/2023
 */
interface InputOutputOptions : PipelineOptions {
    fun getInputFile(): String
    fun setInputFile(value: String)
    fun getOutputFile(): String
    fun setOutputFile(value: String)
}