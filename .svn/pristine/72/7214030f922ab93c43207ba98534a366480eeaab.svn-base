package gui;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import localization.Language;
import localization.Localization;

@SuppressWarnings("serial")
public class StatusBar extends JToolBar {

	public void setStatusLabelText(String tekst) {
		statusLabel.setText(tekst);
	}

	public void setLanguageLabelText(String tekst) {
		languageLabel.setText(tekst);
	}

	public void setWorkspaceLabelText(String tekst) {
		workspaceLabel.setText(tekst);
	}

	private JLabel statusLabel = new JLabel();
	private JLabel languageLabel = new JLabel();
	private JLabel workspaceLabel = new JLabel();

	public StatusBar() {
		setFloatable(false);
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		Border bora = new EtchedBorder(EtchedBorder.RAISED);

		statusLabel.setBorder(bora);
		languageLabel.setBorder(bora);
		workspaceLabel.setBorder(bora);
		workspaceLabel.setHorizontalAlignment(CENTER);
		setLayout(new BorderLayout(0, 0));
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(workspaceLabel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.WEST);
		add(jp, BorderLayout.CENTER);
		add(languageLabel, BorderLayout.EAST);
	}

	public void displayLanguage() {
		Language currentLanguage = Localization.getInstance().getLanguage();
		switch (currentLanguage) {
		case ENGLISH:
			languageLabel.setText(Localization.getInstance().getBundle().getString("eng"));
			break;
		case SERBIAN_CYRILIC:
			languageLabel.setText(Localization.getInstance().getBundle().getString("srbcyr"));
			break;
		case SERBIAN_LATIN:
			languageLabel.setText(Localization.getInstance().getBundle().getString("srblat"));
			break;
		default:
			break;
		}
	}
}
