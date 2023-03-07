package com.example.breastcancerlocal.database

import android.content.Context
import com.example.breastcancerlocal.model.DiabeatsVO
import java.util.ArrayList

class DataBaseManger constructor(context: Context) : Diabeat {
    private var db: DB

    init {
        db = DB(context, null)
    }

    override fun listDiabeats(): ArrayList<DiabeatsVO> {
        return db.listDiabeats()
    }

    override fun editDiabeats(x: DiabeatsVO) {
        db.editDiabeats(x)
    }

    override fun createDiabeats(x: DiabeatsVO) {
        db.createDiabeats(x)
    }

    override fun deleteDiabeats(id: String) {
        db.deleteDiabeats(id)
    }

    override fun searchByDiabeatsid(idx: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsid(idx)
    }

    override fun searchByDiabeatspregnancies(pregnanciesx: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatspregnancies(pregnanciesx)
    }

    override fun searchByDiabeatsglucose(glucosex: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsglucose(glucosex)
    }

    override fun searchByDiabeatsbloodPressure(bloodPressurex: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsbloodPressure(bloodPressurex)
    }

    override fun searchByDiabeatsskinThickness(skinThicknessx: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsskinThickness(skinThicknessx)
    }

    override fun searchByDiabeatsinsulin(insulinx: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsinsulin(insulinx)
    }

    override fun searchByDiabeatsbmi(bmix: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsbmi(bmix)
    }

    override fun searchByDiabeatsdiabetesPedigreeFunction(diabetesPedigreeFunctionx: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsdiabetesPedigreeFunction(diabetesPedigreeFunctionx)
    }

    override fun searchByDiabeatsage(agex: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsage(agex)
    }

    override fun searchByDiabeatsoutcome(outcomex: String): ArrayList<DiabeatsVO> {
        return db.searchByDiabeatsoutcome(outcomex)
    }

}