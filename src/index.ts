import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to ExpoInitialLink.web.ts
// and on native platforms to ExpoInitialLink.ts
import ExpoInitialLinkModule from './ExpoInitialLinkModule';
import ExpoInitialLinkView from './ExpoInitialLinkView';
import { ChangeEventPayload, ExpoInitialLinkViewProps } from './ExpoInitialLink.types';

// Get the native constant value.
export const PI = ExpoInitialLinkModule.PI;

export function hello(): string {
  return ExpoInitialLinkModule.hello();
}

export async function setValueAsync(value: string) {
  return await ExpoInitialLinkModule.setValueAsync(value);
}

const emitter = new EventEmitter(ExpoInitialLinkModule ?? NativeModulesProxy.ExpoInitialLink);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { ExpoInitialLinkView, ExpoInitialLinkViewProps, ChangeEventPayload };
