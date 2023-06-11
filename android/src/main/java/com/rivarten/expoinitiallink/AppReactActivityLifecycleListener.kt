package com.rivarten.expoinitiallink

import android.app.Activity
import android.os.Bundle
import expo.modules.core.interfaces.ReactActivityLifecycleListener
import android.content.SharedPreferences
import android.content.Intent
import android.net.Uri
import android.content.Context

class AppReactActivityLifecycleListener : ReactActivityLifecycleListener {
  override fun onCreate(activity: Activity, savedInstanceState: Bundle?) {
    val preference = activity!!.getPreferences(Context.MODE_PRIVATE)
    preference.edit().putBoolean("_isAppLinkLaunch", false).commit()
    val intent: Intent = activity!!.getIntent()
    val action: String? = intent?.action
    val data: Uri? = intent?.data
    if (!data.toString().isNullOrEmpty()) {
      preference.edit().putBoolean("_isAppLinkLaunch", true).commit()
    }
  }

  override fun onResume(activity: Activity) {
    val preference = activity!!.getPreferences(Context.MODE_PRIVATE)
    val isAppLinkLaunch = preference.getBoolean("_isAppLinkLaunch", false)
    if (isAppLinkLaunch) {
      preference.edit().putBoolean("isActivatedByDeepLink", true).commit()
      preference.edit().putBoolean("_isAppLinkLaunch", false).commit()
    } else {
      preference.edit().putBoolean("isActivatedByDeepLink", false).commit()
    }
  }

  override fun onPause(activity: Activity) {
    val preference = activity!!.getPreferences(Context.MODE_PRIVATE)
    preference.edit().putBoolean("_isAppLinkLaunch", false).commit()
  }
}