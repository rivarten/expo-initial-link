package com.rivarten.expoinitiallink

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import expo.modules.core.interfaces.Package
import android.content.SharedPreferences
import android.content.Context
import com.rivarten.expoinitiallink.AppLifecycleListenerPackage

class ExpoInitialLinkModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('ExpoInitialLink')` in JavaScript.
    Name("ExpoInitialLink")

    Function("isActivatedByDeepLink") {
      return@Function getPreferences().getBoolean("isActivatedByDeepLink", false)
    }

    Function("getInitialLink") {
      return@Function getPreferences().getString("appLinkUri", "")
    }

  }

  private val context
  get() = requireNotNull(appContext.reactContext)

  private fun getPreferences(): SharedPreferences {
    return context.getSharedPreferences(context.packageName + ".applinks", Context.MODE_PRIVATE)
  }

}
