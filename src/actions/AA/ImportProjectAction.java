package actions.AA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import collection.controller.ProjectController;
import collection.model.ProjectM;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class ImportProjectAction extends AbstractAction {
	public ImportProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

		putValue(SMALL_ICON, loadIcon("images/import.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("importprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("importprojectaction"));

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

	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser jfc = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("GeRuDok file", "geru");
		jfc.setFileFilter(filter);
		if (jfc.showOpenDialog(AppWindow.getInstance()) == JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				ProjectM pm = (ProjectM) ois.readObject();
				new ProjectController(pm);
				ois.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("importprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("importprojectaction"));
	}
}
