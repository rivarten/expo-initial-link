import * as React from 'react';

import { ExpoInitialLinkViewProps } from './ExpoInitialLink.types';

export default function ExpoInitialLinkView(props: ExpoInitialLinkViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
