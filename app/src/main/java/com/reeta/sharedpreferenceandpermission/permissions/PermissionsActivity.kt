package com.reeta.sharedpreferenceandpermission.permissions

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.reeta.sharedpreferenceandpermission.R
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {

    private val REQUEST_CODE=1
    private val permission = arrayOf(android.Manifest.permission.CAMERA,
        android.Manifest.permission.READ_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        btnPermi.setOnClickListener {

            //for request the permission
          ActivityCompat.requestPermissions(this, permission,REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0]== PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
             showToast("Both the permission granted")
            // if permission granted then write logic according to that permission in thi method
        }else if (grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_DENIED){
            showToast("Camera granted but storage denied")
        }else if (grantResults[0]==PackageManager.PERMISSION_DENIED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
            showToast("Camera denied but storage granted")

            //this method for do not show again box
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,permission[0])){
                showToast("Camera denied but storage granted")
            }else{
                showToast("Camera denied by checking the do not show again ")
            }

        }else if (grantResults[0]==PackageManager.PERMISSION_DENIED && grantResults[1]==PackageManager.PERMISSION_DENIED){
           // showToast("both permission is denied")

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,permission[0]) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this,permission[1])){
                showToast("both permission denied")
            }else{
                showToast("both denied by selecting do not show again")
            }

            //if both permission denied then request again and again use this method
          //  ActivityCompat.requestPermissions(this, permission,REQUEST_CODE)
        }
        else{
            showToast("both permission is denied")
        }
    }

    private fun showToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}