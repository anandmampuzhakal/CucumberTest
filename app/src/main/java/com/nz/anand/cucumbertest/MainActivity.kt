package com.nz.anand.cucumbertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import modularization.libraries.actions.Actions
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Actions.openOnBoardIntent(this))
    }
}