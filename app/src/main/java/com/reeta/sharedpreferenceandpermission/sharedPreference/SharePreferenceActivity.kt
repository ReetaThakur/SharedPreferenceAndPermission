package com.reeta.sharedpreferenceandpermission.sharedPreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reeta.sharedpreferenceandpermission.R
import com.reeta.sharedpreferenceandpermission.sharedPreference.PreferenceHelper.getPreference1
import kotlinx.android.synthetic.main.activity_share_preference.*


class SharePreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_preference)
        PreferenceHelper.getPreference1(this)
        var value= PreferenceHelper.getData(this@SharePreferenceActivity,"value")
        tvName.text=value.toString()
        btnNameSave.setOnClickListener {
            PreferenceHelper.writeIntToPreference(20,this,"value")
        }
    }
}