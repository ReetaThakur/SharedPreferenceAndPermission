package com.reeta.sharedpreferenceandpermission.sharedPreference

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    //file name where we will store our data
    private val SHARED_KEY = "com.reeta.sharecropper"


    //for getting sharedPreference object
    fun getPreference1(context: Context): SharedPreferences? {
        return context.getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE)

    }

    // for writing data in the file
    fun writeIntToPreference(value:Int, context: Context,key:String){
        val editor:SharedPreferences.Editor= getPreference1(context)!!.edit()
        editor.putInt(key,value).apply()
    }

    //getting data into activity
    fun getData(context: Context,key: String): Int? {
       return getPreference1(context)?.getInt(key,2)
    }
}