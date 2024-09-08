package s001_moile_sebastian.miranda.s001_sebastian_miranda.store

import android.app.Application

class UseApplication:Application() {

    companion object{
        lateinit var prefs :Prefs
    }

    override fun onCreate(){
        super.onCreate()
         prefs = Prefs(applicationContext)

    }


}