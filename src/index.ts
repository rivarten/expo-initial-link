// Import the native module. On web, it will be resolved to ExpoInitialLink.web.ts
// and on native platforms to ExpoInitialLink.ts
import ExpoInitialLinkModule from "./ExpoInitialLinkModule";

export function isActivatedByDeepLink(): boolean {
  return ExpoInitialLinkModule.isActivatedByDeepLink();
}

export function getInitialLink(): string {
  return ExpoInitialLinkModule.getInitialLink();
}
