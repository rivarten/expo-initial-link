# Expo Initial Link

## Overview

The Expo Initial Link module was developed to support specific behaviors of Linking.getInitialURL().

- With Linking.getInitialURL() alone, it's impossible to distinguish between when the app is opened with DeepLink such as UniversalLink or AppLinks, and when it returns from the background to the foreground.
- The linking prop of the NavigationContainer in @react-navigation/native cannot handle complex processes, so it can't cope with cases where you want to handle DeepLink on your own.

To solve these problems, we have made it possible to get the launch status on the Expo App side by subscribing to lifecycle events in native code. There is no need to switch to the bare workflow to solve these issues. Using EASBuild will suffice.

## Usage

To determine whether the app has been launched by a deep link, simply add the following code where needed:

```javascript
import * as ExpoInitialLink from 'expo-initial-link';

ExpoInitialLink.isActivatedByDeepLink();
```