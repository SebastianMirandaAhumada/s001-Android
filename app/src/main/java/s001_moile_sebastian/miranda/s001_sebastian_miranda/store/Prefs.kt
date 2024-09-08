package s001_moile_sebastian.miranda.s001_sebastian_miranda.store

import android.content.Context



class Prefs(val context:Context) {
    val SHARED_NAME= "myBD"
    val SHARED_EMAIL = "email"
    val SHARED_PASS ="pass"
    val SHARED_USER_NAME = "userName"
    val DELIMITER = ","

    //Preferencias Compartidas
    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveEmail(email: String){
        storage.edit().putString(SHARED_EMAIL,email).apply()

    }
    fun savePass(pass:String){
        storage.edit().putString(SHARED_PASS,pass).apply()
    }
    fun saveUser(userName:String){
        storage.edit().putString(SHARED_USER_NAME,userName).apply()
    }

    fun getName():String{
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getPass():String{
        return storage.getString(SHARED_PASS, "")!!
    }
    fun getEmail():String{
        return storage.getString(SHARED_EMAIL, "")!!
    }

}