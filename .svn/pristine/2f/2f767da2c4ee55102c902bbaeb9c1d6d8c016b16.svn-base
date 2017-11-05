package localization;

import java.util.Locale;
import java.util.ResourceBundle;

import gui.AppWindow;

public class Localization {
	private static Localization instance = null;
	private ResourceBundle bundle;
	private Language language;

	public static Localization getInstance() {
		if (instance == null) {
			instance = new Localization();
		}
		return instance;
	}

	private Localization() {
		Locale.setDefault(new Locale("en", "UK"));
		bundle = ResourceBundle.getBundle("Localization.MessageResources", Locale.getDefault());
		language = Language.ENGLISH;
	}

	public void updateComponents() {

		AppWindow.getInstance().updateComponent();
		AppWindow.getInstance().getActionManager().updateActions();
		AppWindow.getInstance().getMenu().updateElem();
	}

	public void languageChange(Language language) {

		switch (language) {
		case ENGLISH:
			Locale.setDefault(new Locale("en", "UK"));
			break;
		case SERBIAN_CYRILIC:
			Locale.setDefault(new Locale("sr", "RS", "Cyrillic"));
			break;
		case SERBIAN_LATIN:
			Locale.setDefault(new Locale("sr", "RS", "Latin"));
			break;
		default:
			break;
		}
		this.language = language;
		bundle = ResourceBundle.getBundle("Localization.MessageResources", Locale.getDefault());
		updateComponents();
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public Language getLanguage() {
		return language;
	}

}
