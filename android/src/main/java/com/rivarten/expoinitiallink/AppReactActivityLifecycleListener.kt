package com.rivarten.expoinitiallink

import android.app.Activity
import android.os.Bundle
import expo.modules.core.interfaces.ReactActivityLifecycleListener
import android.content.SharedPreferences
import android.content.Context
import android.content.Intent
import android.net.Uri

class AppReactActivityLifecycleListener : ReactActivityLifecycleListener {
  private fun getPreferences(activity: Activity): SharedPreferences {
    return activity.getSharedPreferences(activity.packageName + ".applinks", Context.MODE_PRIVATE)
  }

  override fun onCreate(activity: Activity, savedInstanceState: Bundle?) {
    val preference = getPreferences(activity)
    preference.edit().putBoolean("_isAppLinkLaunch", false).commit()
    preference.edit().putBoolean("isActivatedByDeepLink", false).commit()
    val intent: Intent = activity!!.getIntent()
    val action: String? = intent?.action
    val data: Uri? = intent?.data
    preference.edit().putString("appLinkUri", data.toString()).commit()
    if (data.toString() != "null") {
      preference.edit().putBoolean("_isAppLinkLaunch", true).commit()
    }
  }

  override fun onResume(activity: Activity) {
    val preference = getPreferences(activity)
    val isAppLinkLaunch = preference.getBoolean("_isAppLinkLaunch", false)
    if (isAppLinkLaunch) {
      preference.edit().putBoolean("isActivatedByDeepLink", true).commit()
    } else {
      preference.edit().putBoolean("isActivatedByDeepLink", false).commit()
    }
  }

  override fun onPause(activity: Activity) {
    val preference = getPreferences(activity)
    preference.edit().putBoolean("_isAppLinkLaunch", false).commit()
    preference.edit().putString("appLinkUri", "").commit()
    preference.edit().putBoolean("isActivatedByDeepLink", false).commit()
  }
  override fun onDestroy(activity: Activity) {
    val preference = getPreferences(activity)
    preference.edit().putBoolean("_isAppLinkLaunch", false).commit()
    preference.edit().putString("appLinkUri", "").commit()
    preference.edit().putBoolean("isActivatedByDeepLink", false).commit()
  }
}