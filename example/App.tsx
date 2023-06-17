import { StyleSheet, Text, View } from 'react-native';

import * as ExpoInitialLink from 'expo-initial-link';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>{`${ExpoInitialLink.isActivatedByDeepLink()}`}</Text>
      <Text>{ExpoInitialLink.getInitialLink()}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
