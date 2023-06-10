import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { ExpoInitialLinkViewProps } from './ExpoInitialLink.types';

const NativeView: React.ComponentType<ExpoInitialLinkViewProps> =
  requireNativeViewManager('ExpoInitialLink');

export default function ExpoInitialLinkView(props: ExpoInitialLinkViewProps) {
  return <NativeView {...props} />;
}
