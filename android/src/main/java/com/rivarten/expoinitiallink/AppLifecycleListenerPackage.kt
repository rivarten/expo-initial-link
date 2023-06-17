// android/src/main/java/expo/modules/mylib/MyLibPackage.kt
package com.rivarten.expoinitiallink

import android.content.Context
import expo.modules.core.interfaces.Package
import expo.modules.core.interfaces.ReactActivityLifecycleListener
import com.rivarten.expoinitiallink.AppReactActivityLifecycleListener

class AppLifecycleListenerPackage : Package {
  override fun createReactActivityLifecycleListeners(activityContext: Context): List<ReactActivityLifecycleListener> {
    return listOf(AppReactActivityLifecycleListener())
  }
}