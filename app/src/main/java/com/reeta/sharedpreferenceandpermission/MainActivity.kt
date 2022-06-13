package com.reeta.sharedpreferenceandpermission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.reeta.sharedpreferenceandpermission.databinding.ActivityMainBinding
import com.reeta.sharedpreferenceandpermission.permissions.PermissionsActivity
import com.reeta.sharedpreferenceandpermission.sharedPreference.SharePreferenceActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.apply {
            btnPermission.setOnClickListener {
              val intent=Intent(this@MainActivity,PermissionsActivity::class.java)
                startActivity(intent)
            }
            btnSharedPrefrence.setOnClickListener {
                val intent=Intent(this@MainActivity,SharePreferenceActivity::class.java)
                startActivity(intent)
            }

        }
    }
}