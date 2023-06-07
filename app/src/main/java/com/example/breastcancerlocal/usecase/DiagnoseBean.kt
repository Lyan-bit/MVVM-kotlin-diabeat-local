package com.example.breastcancerlocal.usecase

import android.content.Context
import com.example.breastcancerlocal.model.Diabeats
import com.example.breastcancerlocal.viewModel.DiabeatsCRUDViewModel
import com.example.breastcancerlocal.viewModel.ClassificationViewModel

class DiagnoseBean(c: Context) {
    private var classificationViewModel: ClassificationViewModel = ClassificationViewModel.getInstance(c)
    private var crudViewModel: DiabeatsCRUDViewModel = DiabeatsCRUDViewModel.getInstance(c)

    private var classification = ""
    private var instanceClassification: Diabeats? = null

    private var errors = ArrayList<String>()

    fun setclassification(classificationx: String) {
        classification = classificationx
    }

    fun resetData() {
        classification = ""
    }

     fun isdiagnoseerror(): Boolean {
        errors.clear()
        instanceClassification = crudViewModel.getDiabeatsByPK(classification)
        if (instanceClassification == null) {
            errors.add("classification must be a valid Classification id")
        }
        return errors.isNotEmpty()
    }

    fun errors(): String {
        return errors.toString()
    }

    fun diagnose (): String {
        return classificationViewModel.classify(instanceClassification!!)
    }
}
