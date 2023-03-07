package com.example.breastcancerlocal.viewModel

import android.content.Context
import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import com.example.breastcancerlocal.model.Diabeats
import com.example.breastcancerlocal.model.DiabeatsVO
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel

class ClassificationViewModel (context: Context): ViewModel() {

    private val assetManager: AssetManager = context.assets
    private val crudViewModel = DiabeatsCRUDViewModel.getInstance(context)

    companion object {
        private var instance: ClassificationViewModel? = null
        fun getInstance(context: Context): ClassificationViewModel {
            return instance ?: ClassificationViewModel(context)
        }
    }

    //classification
    private fun loadModelFile(assetManager: AssetManager, modelPath: String): ByteBuffer {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(
            FileChannel.MapMode.READ_ONLY,
            startOffset, declaredLength)
    }

    fun classify(classification: Diabeats) : String {
        var res = ""
        lateinit var tflite : Interpreter
        lateinit var tflitemodel : ByteBuffer

        try{
            tflitemodel = loadModelFile(assetManager, "diabeats.tflite")
            tflite = Interpreter(tflitemodel)
        } catch(ex: Exception){
            ex.printStackTrace()
        }

        val done: Float = (classification.pregnancies.toFloat() - 0) / (17-0)
        val dtwo: Float = ((classification.glucose - 0) / (199-0)).toFloat()
        val dthree: Float = ((classification.bloodPressure - 0) / (122-0)).toFloat()
        val dfour: Float = ((classification.skinThickness - 0) / (99-0)).toFloat()
        val dfive: Float = ((classification.insulin - 0) / (846-0)).toFloat()
        val dsix: Float = ((classification.bmi - 0) / (67.1f-0)).toFloat()
        val dseven: Float = ((classification.diabetesPedigreeFunction - .078f) / (2.42f-.078f)).toFloat()
        val deight: Float = ((classification.age - 21) / (81-21)).toFloat()

        val inputVal: FloatArray = floatArrayOf(done, dtwo, dthree, dfour, dfive, dsix, dseven,deight)
        val outputVal: ByteBuffer = ByteBuffer.allocateDirect(8)
        outputVal.order(ByteOrder.nativeOrder())

        tflite.run(inputVal, outputVal)
        outputVal.rewind()

        val result = FloatArray(2)
        for (i in 0..1) {
            result[i] = outputVal.float
        }

        if (result[0]>result[1])
            res = "Result is negative"

        else
            res = "Result is positive"

        classification.outcome = res
        crudViewModel.editDiabeats(DiabeatsVO( classification))

        return res

    }
}