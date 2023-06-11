package com.example.breastcancerlocal.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.breastcancerlocal.model.DiabeatsVO

class DB (context: Context, factory: SQLiteDatabase.CursorFactory?) :
	SQLiteOpenHelper(context, DATABASENAME, factory, DATABASEVERSION) {

	companion object{
		lateinit var database: SQLiteDatabase

		private val DATABASENAME = "diabeatsApp.db"
		private val DATABASEVERSION = 1

		const val DiabeatsTABLENAME = "Diabeats"
		const val DiabeatsCOLIDTable = 0
		const val DiabeatsCOLID = 1
		const val DiabeatsCOLPREGNANCIES = 2
		const val DiabeatsCOLGLUCOSE = 3
		const val DiabeatsCOLBLOODPRESSURE = 4
		const val DiabeatsCOLSKINTHICKNESS = 5
		const val DiabeatsCOLINSULIN = 6
		const val DiabeatsCOLBMI = 7
		const val DiabeatsCOLDIABETESPEDIGREEFUNCTION = 8
		const val DiabeatsCOLAGE = 9
		const val DiabeatsCOLOUTCOME = 10

		val DiabeatsCOLS: Array<String> = arrayOf<String>("idTable", "id", "pregnancies", "glucose", "bloodPressure", "skinThickness", "insulin", "bmi", "diabetesPedigreeFunction", "age", "outcome")
		const val DiabeatsNUMBERCOLS = 10

	}
	private val DiabeatsCREATESCHEMA =
		"create table Diabeats (idTable integer primary key autoincrement" +
				", id VARCHAR(50) not null"+
				", pregnancies integer not null"+
				", glucose integer not null"+
				", bloodPressure integer not null"+
				", skinThickness integer not null"+
				", insulin integer not null"+
				", bmi double not null"+
				", diabetesPedigreeFunction double not null"+
				", age integer not null"+
				", outcome VARCHAR(50) not null"+
				")"

	override fun onCreate(db: SQLiteDatabase) {
		db.execSQL(DiabeatsCREATESCHEMA)
	}

	override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
		db.execSQL("DROP TABLE IF EXISTS " + DiabeatsCREATESCHEMA)
		onCreate(db)
	}

	fun onDestroy() {
		database.close()
	}

	fun listDiabeats(): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val cursor: Cursor =
			database.query(DiabeatsTABLENAME, DiabeatsCOLS, null, null, null, null, null)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun createDiabeats(diabeatsvo: DiabeatsVO) {
		database = writableDatabase
		database.insert(DiabeatsTABLENAME, DiabeatsCOLS[1], putData(diabeatsvo))
	}

	fun searchByDiabeatsid(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where id = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatspregnancies(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where pregnancies = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsglucose(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where glucose = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsbloodPressure(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where bloodPressure = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsskinThickness(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where skinThickness = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsinsulin(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where insulin = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsbmi(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where bmi = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsdiabetesPedigreeFunction(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where diabetesPedigreeFunction = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsage(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where age = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}

	fun searchByDiabeatsoutcome(value: String): ArrayList<DiabeatsVO> {
		val res = ArrayList<DiabeatsVO>()
		database = readableDatabase
		val args = arrayOf(value)
		val cursor: Cursor = database.rawQuery(
			"select idTable, id, pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age, outcome from Diabeats where outcome = ?",
			args
		)
		cursor.moveToFirst()
		while (!cursor.isAfterLast()) {
			res.add(setData(cursor))
			cursor.moveToNext()
		}
		cursor.close()
		return res
	}


	fun editDiabeats(diabeatsvo: DiabeatsVO) {
		database = writableDatabase
		val args = arrayOf(diabeatsvo.id)
		database.update(DiabeatsTABLENAME, putData(diabeatsvo), "id =?", args)
	}

	fun deleteDiabeats(value: String) {
		database = writableDatabase
		val args = arrayOf(value)
		database.delete(DiabeatsTABLENAME, "id = ?", args)
	}

	private fun setData(cursor: Cursor): DiabeatsVO {
		val diabeatsvo = DiabeatsVO()
		diabeatsvo.id = cursor.getString(DiabeatsCOLID)
		diabeatsvo.pregnancies = cursor.getInt(DiabeatsCOLPREGNANCIES)
		diabeatsvo.glucose = cursor.getInt(DiabeatsCOLGLUCOSE)
		diabeatsvo.bloodPressure = cursor.getInt(DiabeatsCOLBLOODPRESSURE)
		diabeatsvo.skinThickness = cursor.getInt(DiabeatsCOLSKINTHICKNESS)
		diabeatsvo.insulin = cursor.getInt(DiabeatsCOLINSULIN)
		diabeatsvo.bmi = cursor.getDouble(DiabeatsCOLBMI)
		diabeatsvo.diabetesPedigreeFunction = cursor.getDouble(
			DiabeatsCOLDIABETESPEDIGREEFUNCTION
		)
		diabeatsvo.age = cursor.getInt(DiabeatsCOLAGE)
		diabeatsvo.outcome = cursor.getString(DiabeatsCOLOUTCOME)
		return diabeatsvo
	}

	private fun putData(diabeatsvo: DiabeatsVO): ContentValues {
		val wr = ContentValues(DiabeatsNUMBERCOLS)
		wr.put(DiabeatsCOLS[DiabeatsCOLID], diabeatsvo.id)
		wr.put(DiabeatsCOLS[DiabeatsCOLPREGNANCIES], diabeatsvo.pregnancies)
		wr.put(DiabeatsCOLS[DiabeatsCOLGLUCOSE], diabeatsvo.glucose)
		wr.put(DiabeatsCOLS[DiabeatsCOLBLOODPRESSURE], diabeatsvo.bloodPressure)
		wr.put(DiabeatsCOLS[DiabeatsCOLSKINTHICKNESS], diabeatsvo.skinThickness)
		wr.put(DiabeatsCOLS[DiabeatsCOLINSULIN], diabeatsvo.insulin)
		wr.put(DiabeatsCOLS[DiabeatsCOLBMI], diabeatsvo.bmi)
		wr.put(DiabeatsCOLS[DiabeatsCOLDIABETESPEDIGREEFUNCTION], diabeatsvo.diabetesPedigreeFunction)
		wr.put(DiabeatsCOLS[DiabeatsCOLAGE], diabeatsvo.age)
		wr.put(DiabeatsCOLS[DiabeatsCOLOUTCOME], diabeatsvo.outcome)
		return wr
	}

}
