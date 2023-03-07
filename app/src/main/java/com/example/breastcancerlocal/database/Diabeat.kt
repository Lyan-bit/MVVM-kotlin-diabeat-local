package com.example.breastcancerlocal.database

import com.example.breastcancerlocal.model.DiabeatsVO
import java.util.ArrayList

interface Diabeat {
    fun listDiabeats(): ArrayList<DiabeatsVO>
    fun editDiabeats(x: DiabeatsVO)
    fun createDiabeats(x: DiabeatsVO)
    fun deleteDiabeats(id: String)
    fun searchByDiabeatsid(idx: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatspregnancies(pregnanciesx: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsglucose(glucosex: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsbloodPressure(bloodPressurex: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsskinThickness(skinThicknessx: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsinsulin(insulinx: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsbmi(bmix: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsdiabetesPedigreeFunction(diabetesPedigreeFunctionx: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsage(agex: String): ArrayList<DiabeatsVO>
    fun searchByDiabeatsoutcome(outcomex: String): ArrayList<DiabeatsVO>
}