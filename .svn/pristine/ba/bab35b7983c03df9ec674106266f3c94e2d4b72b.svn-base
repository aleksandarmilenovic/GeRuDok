package actions.AA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import collection.model.ProjectM;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class ExportProjectAction extends AbstractAction {
	public ExportProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/export.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("exportprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("exportprojectaction"));
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

		JTree tree = AppWindow.getInstance().getJtree();

		ProjectM projectModel = (ProjectM) tree.getLastSelectedPathComponent();

		File projectFile = projectModel.getProjectFile();

		if (jfc.showSaveDialog(AppWindow.getInstance()) == JFileChooser.APPROVE_OPTION) {
			ObjectOutputStream oos;
			try {
				if (projectFile == null) {
					projectFile = jfc.getSelectedFile();
				}
				String fileExtension = ".geru";
				if (!jfc.getSelectedFile().getAbsolutePath().endsWith(fileExtension)) {
					projectFile = new File(jfc.getSelectedFile() + fileExtension);
				}
				oos = new ObjectOutputStream(new FileOutputStream(projectFile));
				oos.writeObject(projectModel);
				oos.flush();
				oos.close();
				projectModel.setProjectFile(jfc.getSelectedFile());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	
		}
	}

	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("exportprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("exportprojectaction"));
	}
}