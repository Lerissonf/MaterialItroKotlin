package com.example.lincs.aprendizagem


import android.Manifest
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.view.View
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import com.heinrichreimersoftware.materialintro.slide.Slide

class MainIntroActivity : IntroActivity() {
     private val PREF_KEY_USER_MODIFICATION = "com.example.lincs.aprendizagem.PREF_KEY_USER_MODIFICATION"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isFullscreen = true
        isButtonBackVisible = true
        isButtonNextVisible = true
        buttonCtaTintMode = BUTTON_CTA_TINT_MODE_TEXT
        buttonBackFunction = BUTTON_BACK_FUNCTION_BACK
        buttonNextFunction = BUTTON_NEXT_FUNCTION_NEXT_FINISH
//        setContentView(R.layout.activity_intro)

        SimpleSlide.Builder()
                .title(R.string.slide_1_title_PT_BR)
                .description(R.string.slide_1_descreption_PT_BR)
                .image(R.drawable.logo)
                .background(R.color.color_material_metaphor)
                .backgroundDark(R.color.color_dark_material_metaphor)
                .scrollable(true)
                .build()
                .also{ addSlide(it) }

        val permissionsSlide: Slide? = if( Build.VERSION.SDK_INT >=Build.VERSION_CODES.M) {
            SimpleSlide.Builder()
                    .title(R.string.slide_3_title_PT_BR)
                    .description(R.string.slide_3_descreption_PT_BR)
                    .background(R.color.color_permissions)
                    .image(R.drawable.hard_disk)
                    .backgroundDark(R.color.color_dark_permissions)
                    .scrollable(true)
                    .permissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE))
                    .build()
                    .also { addSlide(it) }
        }else{
            null
        }
        var slide1:Slide? = if (!PreferenceManager.getDefaultSharedPreferences(this)
                        .getBoolean("CheckBoxTerm", false)){
            FragmentSlide.Builder()
                    .background(R.color.color_material_metaphor)
                    .backgroundDark(R.color.color_dark_material_metaphor)
                    .fragment(ContractFragment.newInstance())
                    .build()
                    .also{addSlide(it)}
        }
        else{
            null
        }




        addOnNavigationBlockedListener { position, _ ->
            val contentView = findViewById<View>(android.R.id.content)
            if (contentView != null) {
                val slide = getSlide(position)

                if (slide == permissionsSlide) {
                    Snackbar.make(contentView, R.string.please_permisssions3_PT_BR, Snackbar.LENGTH_LONG)
                            .show()
                }
                else if (slide == slide1) {
                    Snackbar.make(contentView, R.string.please_contract_PT_BR, Snackbar.LENGTH_LONG)
                            .show()
                }
            }
        }
        PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putBoolean(PREF_KEY_USER_MODIFICATION, true)
                .apply()

    }



}
