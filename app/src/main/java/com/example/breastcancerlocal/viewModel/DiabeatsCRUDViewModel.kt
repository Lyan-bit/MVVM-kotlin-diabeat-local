package com.example.breastcancerlocal.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.breastcancerlocal.database.DataBaseManger
import com.example.breastcancerlocal.model.Diabeats
import com.example.breastcancerlocal.model.DiabeatsVO


class DiabeatsCRUDViewModel constructor(context: Context): ViewModel() {

    private var dbm: DataBaseManger = DataBaseManger (context)
    private var currentDiabeats: DiabeatsVO? = null
    private var currentDiabeatss: ArrayList<DiabeatsVO> = ArrayList()

    companion object {
        private var instance: DiabeatsCRUDViewModel? = null
        fun getInstance(context: Context): DiabeatsCRUDViewModel {
            return instance ?: DiabeatsCRUDViewModel(context)
        }
    }

    fun stringListDiabeats(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (x in currentDiabeatss.indices) {
            res.add(currentDiabeatss[x].toString())
        }
        return res
    }

    fun getDiabeatsByPK(value: String): Diabeats? {
        val res: List<DiabeatsVO> = dbm.searchByDiabeatsid(value)
        return if (res.isEmpty()) {
            null
        } else {
            val vo: DiabeatsVO = res[0]
            val itemx = Diabeats.createByPKDiabeats(value)
            itemx.id = vo.id
            itemx.pregnancies = vo.pregnancies
            itemx.glucose = vo.glucose
            itemx.bloodPressure = vo.bloodPressure
            itemx.skinThickness = vo.skinThickness
            itemx.insulin = vo.insulin
            itemx.bmi = vo.bmi
            itemx.diabetesPedigreeFunction = vo.diabetesPedigreeFunction
            itemx.age = vo.age
            itemx.outcome = vo.outcome
            itemx
        }
    }

    fun retrieveDiabeats(value: String): Diabeats? {
        return getDiabeatsByPK(value)
    }

    fun allDiabeatsids(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].id)
        }
        return res
    }

    fun allDiabeatspregnancies(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].pregnancies.toString())
        }
        return res
    }

    fun allDiabeatsglucosess(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].glucose.toString())
        }
        return res
    }

    fun allDiabeatsbloodPressures(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].bloodPressure.toString())
        }
        return res
    }

    fun allDiabeatsskinThickness(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].skinThickness.toString())
        }
        return res
    }

    fun allDiabeatsinsulins(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].insulin.toString())
        }
        return res
    }

    fun allDiabeatsbmis(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].bmi.toString())
        }
        return res
    }

    fun allDiabeatsdiabetesPedigreeFunctions(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].diabetesPedigreeFunction.toString())
        }
        return res
    }

    fun allDiabeatsages(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].age.toString())
        }
        return res
    }

    fun allDiabeatsoutcomes(): ArrayList<String> {
        currentDiabeatss = dbm.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (Diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[Diabeats].outcome.toString())
        }
        return res
    }

    fun setSelectedDiabeats(x: DiabeatsVO) {
        currentDiabeats = x
    }

    fun setSelectedDiabeats(i: Int) {
        if (i < currentDiabeatss.size) {
            currentDiabeats = currentDiabeatss[i]
        }
    }

    fun getSelectedDiabeats(): DiabeatsVO? {
        return currentDiabeats
    }

    fun persistDiabeats(x: Diabeats) {
        val vo = DiabeatsVO(x)
        dbm.editDiabeats(vo)
        currentDiabeats = vo
    }

    fun listDiabeats(): ArrayList<DiabeatsVO> {
        currentDiabeatss = dbm.listDiabeats()
        return currentDiabeatss
    }

    fun editDiabeats(x: DiabeatsVO) {
        dbm.editDiabeats(x)
        currentDiabeats = x
    }

    fun createDiabeats(x: DiabeatsVO) {
        dbm.createDiabeats(x)
        currentDiabeats = x
    }

    fun deleteDiabeats(id: String) {
        dbm.deleteDiabeats(id)
        currentDiabeats = null
    }

    fun searchByDiabeatsid(idx: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsid(idx)
        return currentDiabeatss
    }

    fun searchByDiabeatspregnancie(pregnanciex: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatspregnancies(pregnanciex)
        return currentDiabeatss
    }

    fun searchByDiabeatsglucose(glucosex: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsglucose(glucosex)
        return currentDiabeatss
    }

    fun searchByDiabeatsbloodPressure(bloodPressurex: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsbloodPressure(bloodPressurex)
        return currentDiabeatss
    }

    fun searchByDiabeatsskinThickness(skinThicknessx: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsskinThickness(skinThicknessx)
        return currentDiabeatss
    }

    fun searchByDiabeatsinsulin(insulinx: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsinsulin(insulinx)
        return currentDiabeatss
    }

    fun searchByDiabeatsbmi(bmix: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsbmi(bmix)
        return currentDiabeatss
    }

    fun searchByDiabeatsdiabetesPedigreeFunction(diabetesPedigreeFunctionx: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsdiabetesPedigreeFunction(diabetesPedigreeFunctionx)
        return currentDiabeatss
    }

    fun searchByDiabeatsage(agex: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsage(agex)
        return currentDiabeatss
    }

    fun searchByDiabeatsoutcome(outcomex: String): List<DiabeatsVO> {
        currentDiabeatss = dbm.searchByDiabeatsoutcome(outcomex)
        return currentDiabeatss
    }

}
