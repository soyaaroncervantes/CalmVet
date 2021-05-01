package com.soyaaroncervantes.calmvet.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

import com.soyaaroncervantes.calmvet.R
import com.soyaaroncervantes.calmvet.databinding.ActivityMainBinding
import com.soyaaroncervantes.calmvet.services.singleton.SDKSingletons

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView( this, R.layout.activity_main )
    // Init Firebase Emulator
    SDKSingletons.firebase
    SDKSingletons.facebook
  }
}