package com.example.lincs.aprendizagem

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.content.ContextCompat

import android.util.Log


class MainActivity : AppCompatActivity() {
    private val PREF_KEY_USER_MODIFICATION = "com.example.lincs.aprendizagem.PREF_KEY_USER_MODIFICATION"
    private val PREF_KEY_FIRST_START = "com.example.lincs.aprendizagem.PREF_KEY_FIRST_START"
    private val REQUEST_CODE_INTRO = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var firstStart = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean(PREF_KEY_FIRST_START, true)
        if (firstStart) {
            //a variavel de intro fica como false
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putBoolean(PREF_KEY_USER_MODIFICATION, false)
                    .apply()

            val intent = Intent(this, MainIntroActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_INTRO)

            PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putBoolean(PREF_KEY_FIRST_START, false)
                    .apply()




        }

        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        var introstart = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean(PREF_KEY_USER_MODIFICATION, false)

        var permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)

        var contractCheck = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("CheckBoxTerm", false)

        if ((introstart && permissionCheck == RESULT_OK)&&(!contractCheck)){val intent = Intent(this, MainIntroActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_INTRO)
            Log.i("leri","Deus é tudo1")}
        else if ((introstart && permissionCheck == RESULT_OK)&&(contractCheck)){val intent = Intent(this, MainIntroActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_INTRO)
            Log.i("leri","Deus é tudo2")}
        else if ((introstart && permissionCheck != RESULT_OK)&&(!contractCheck)){val intent = Intent(this, MainIntroActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_INTRO)
            Log.i("leri","Deus é tudo3")}
        Log.i("intro",introstart.toString())
        Log.i("Permissão",permissionCheck.toString())
        super.onResume()

    }

}
