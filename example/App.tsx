import { StyleSheet, Text, View } from 'react-native';

import * as ExpoInitialLink from 'expo-initial-link';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>{ExpoInitialLink.isActivatedByDeepLink() ? "true" : "false" }</Text>
      <Text>{ExpoInitialLink.hello()}</Text>
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
