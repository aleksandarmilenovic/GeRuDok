package values;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import localization.Language;
import localization.Localization;

@SuppressWarnings("serial")
public class Settings implements Serializable {

	private Language language = Language.ENGLISH;
	private String pathToWorkspace = null;
	private static Settings instance = null;

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
		saveSettings(this);
	}

	public Settings() {
	}

	public static Settings getInstance() {
		if (instance == null) {
			instance = new Settings();
			instance.loadSettings();
		}
		return instance;
	}

	public void applySettings() {
		Localization.getInstance().languageChange(language);
	}

	public static void saveSettings(Settings s) {

		File settingsFile = null;

		ObjectOutputStream oos;
		Settings set = s;
		try {
			String fileExtension = ".grd";
			settingsFile = new File("src/values/settings" + fileExtension);
			oos = new ObjectOutputStream(new FileOutputStream(settingsFile));
			oos.writeObject(set);
			oos.flush();
			oos.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void loadSettings() {
		String fileExtension;
		fileExtension = ".grd";
		File settingsFile = new File("src/values/settings" + fileExtension);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(settingsFile));
			Settings settings = (Settings) ois.readObject();
			this.language = settings.getLanguage();
			this.pathToWorkspace = settings.pathToWorkspace;
			ois.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public String getPathToWorkspace() {
		return pathToWorkspace;
	}

	public void setPathToWorkspace(String pathToWorkspace) {
		this.pathToWorkspace = pathToWorkspace;
		saveSettings(this);
	}
}
