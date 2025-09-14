package TEPOO.persistencia_de_preferencias;

import java.io.*;
import java.util.Properties;

public class PreferenceService {
  private static final String FILE_NAME = "preferences.txt";

  public void savePreferences(String username, boolean rememberMe) {
    Properties props = new Properties();
    props.setProperty("username", username);
    props.setProperty("rememberMe", String.valueOf(rememberMe));

    try (FileWriter writer = new FileWriter(FILE_NAME)) {
      props.store(writer, "User Preferences");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Preferences loadPreferences() {
    Properties props = new Properties();
    Preferences preferences = new Preferences("", false);

    try (FileReader reader = new FileReader(FILE_NAME)) {
      props.load(reader);
      String username = props.getProperty("username", "");
      boolean rememberMe = Boolean.parseBoolean(props.getProperty("rememberMe", "false"));
      preferences = new Preferences(username, rememberMe);
    } catch (IOException e) {
      // Arquivo não existe na primeira execução, ignora
    }
    return preferences;
  }
}
