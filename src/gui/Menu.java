package gui;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import localization.Localization;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {

	JMenu fileMenu = new JMenu(Localization.getInstance().getBundle().getString("file"));

	JMenu windowMenu = new JMenu(Localization.getInstance().getBundle().getString("window"));

	JMenu helpMenu = new JMenu(Localization.getInstance().getBundle().getString("help"));

	JMenu languages = new JMenu(Localization.getInstance().getBundle().getString("languages"));

	JMenu addmenu = new JMenu(Localization.getInstance().getBundle().getString("add"));

	public Menu() {

		fileMenu.setMnemonic('F');
		windowMenu.setMnemonic('W');
		helpMenu.setMnemonic('H');

		fileMenu.add(AppWindow.getInstance().getActionManager().getSwitchWorkspaceAction());

		fileMenu.addSeparator();

		fileMenu.add(AppWindow.getInstance().getActionManager().getImportProjectAction());
		fileMenu.add(AppWindow.getInstance().getActionManager().getExportProjectAction());

		fileMenu.addSeparator();

		addmenu.setIcon(loadIcon("images/newFile.png"));
		addmenu.add(AppWindow.getInstance().getActionManager().getNewProjectAction());
		addmenu.add(AppWindow.getInstance().getActionManager().getNewDocumentAction());
		addmenu.add(AppWindow.getInstance().getActionManager().getNewPageAction());
		addmenu.add(AppWindow.getInstance().getActionManager().getNewSlotAction());
		addmenu.add(AppWindow.getInstance().getActionManager().getTextSlotAction());
		fileMenu.add(addmenu);

		fileMenu.addSeparator();

		fileMenu.add(AppWindow.getInstance().getActionManager().getCloseAllAction());

		fileMenu.addSeparator();

		fileMenu.add(AppWindow.getInstance().getActionManager().getExitAction());
		add(fileMenu);

		windowMenu.add(AppWindow.getInstance().getActionManager().getTileHorizontallyAction());
		windowMenu.add(AppWindow.getInstance().getActionManager().getTileVerticallyAction());
		windowMenu.add(AppWindow.getInstance().getActionManager().getTileMatricallyAction());
		windowMenu.add(AppWindow.getInstance().getActionManager().getTileCascadeAction());
		add(windowMenu);

		languages.add(AppWindow.getInstance().getActionManager().getEnglishAction());
		languages.add(AppWindow.getInstance().getActionManager().getSerbianAction());
		languages.add(AppWindow.getInstance().getActionManager().getSerbianCyrAction());
		add(languages);

		add(helpMenu);

	}

	private Icon loadIcon(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;

		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		} else {
			System.err.println("Resource not found: " + fileName);
		}
		return icon;
	}

	public void updateElem() {
		fileMenu.setText(Localization.getInstance().getBundle().getString("file"));
		helpMenu.setText(Localization.getInstance().getBundle().getString("help"));
		windowMenu.setText(Localization.getInstance().getBundle().getString("window"));
		languages.setText(Localization.getInstance().getBundle().getString("languages"));
		addmenu.setText(Localization.getInstance().getBundle().getString("add"));
	}
}
