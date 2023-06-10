import ExpoModulesCore

public class AppLifecycleDelegate: ExpoAppDelegateSubscriber {
  public func application(
    _ application: UIApplication,
    continue userActivity: NSUserActivity,
    restorationHandler: @escaping ([UIUserActivityRestoring]?) -> Void
  ) -> Bool {
    UserDefaults.standard.set(false, forKey:"_isUniversalLinkLaunch");
    guard userActivity.activityType == NSUserActivityTypeBrowsingWeb,
      let incomingURL = userActivity.webpageURL,
      let _ = NSURLComponents(url: incomingURL, resolvingAgainstBaseURL: true) else {
        return false
    }
    UserDefaults.standard.set(true, forKey:"_isUniversalLinkLaunch");
    return true
  }

  public func applicationDidBecomeActive(_ application: UIApplication) {
    // The app has become active.
    let isUniversalLinkLaunch = UserDefaults.standard.bool(forKey: "_isUniversalLinkLaunch")
    if isUniversalLinkLaunch == true {
      UserDefaults.standard.set(true, forKey:"isActivatedByDeepLink")
      UserDefaults.standard.set(false, forKey:"_isUniversalLinkLaunch");
    } else {
      UserDefaults.standard.set(false, forKey:"isActivatedByDeepLink")
    }
  }

  public func applicationWillResignActive(_ application: UIApplication) {
    // The app is about to become inactive.
  }

  public func applicationDidEnterBackground(_ application: UIApplication) {
    // The app is now in the background.
    UserDefaults.standard.set(false, forKey:"_isUniversalLinkLaunch");
  }

  public func applicationWillEnterForeground(_ application: UIApplication) {
    // The app is about to enter the foreground.
  }

  public func applicationWillTerminate(_ application: UIApplication) {
    // The app is about to terminate.
  }
}