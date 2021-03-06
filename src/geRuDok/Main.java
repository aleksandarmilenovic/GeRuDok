package geRuDok;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.*;
import collection.controller.ProjectController;
import collection.model.ProjectM;
import gui.AppWindow;
import localization.Localization;
import tree.TreeM;
import values.Settings;

public class Main {

	public static void main(String[] args) {

		loadingScreen();

		AppWindow appWindow = AppWindow.getInstance();
		Settings.getInstance().applySettings();
		TreeM trem = appWindow.getTreeModel();
		TreeNode[] pat = trem.getPathToRoot((TreeNode) trem.getRoot());
		JTree jtre = appWindow.getJtree();
		jtre.setSelectionPath(new TreePath(pat));
		tryLoadWorkspace();
		appWindow.getStatusBar().setWorkspaceLabelText(Settings.getInstance().getPathToWorkspace());
		appWindow.getStatusBar().displayLanguage();
		appWindow.setVisible(true);
	}

	public static void tryLoadWorkspace() {
		String pathToWork = Settings.getInstance().getPathToWorkspace();
		if (pathToWork != null) {
			loadWorkspaceFromPath(pathToWork);
		} else {
			chooseWorkspace();
		}
	}

	private static void loadingScreen() {

		JProgressBar bar = new JProgressBar();
		bar.setValue(0);
		bar.setStringPainted(true);

		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("", new ImageIcon("src/logo.jpg"), SwingConstants.CENTER));

		window.getContentPane().add(bar, BorderLayout.SOUTH);
		window.setBounds(400, 250, 400, 300);
		window.setVisible(true);
		try {
			Thread.sleep(300);
			bar.setString("Initializing GeRuDoc...");
			Thread.sleep(900);
			bar.setString(null);
			bar.setValue(25);
			Thread.sleep(300);
			bar.setString("Config...");
			Thread.sleep(500);
			bar.setString(null);
			bar.setValue(40);
			Thread.sleep(300);
			bar.setString("Config...");
			Thread.sleep(700);
			bar.setString(null);
			bar.setValue(50);
			Thread.sleep(400);
			bar.setString("Config...");
			Thread.sleep(500);
			bar.setString(null);
			bar.setValue(70);
			Thread.sleep(300);
			bar.setValue(80);
			Thread.sleep(300);
			bar.setString("Config..");
			Thread.sleep(600);
			bar.setString(null);
			bar.setValue(100);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		window.setVisible(false);

	}

	private static void loadWorkspaceFromPath(String pathToWork) {

		File folder = new File("pathToWork");
		File[] files = folder.listFiles();
		try {
			for (File file : files) {
				String extension = ".geru";
				if (file.getPath().endsWith(extension)) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
						ProjectM pm = (ProjectM) ois.readObject();
						new ProjectController(pm);
						ois.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		} catch (Exception ef) {
			chooseWorkspace();
		}
	}

	public static void chooseWorkspace() {
		AppWindow.getInstance().setVisible(false);
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		jfc.setDialogTitle(Localization.getInstance().getBundle().getString("directory"));

		if (jfc.showOpenDialog(AppWindow.getInstance()) == JFileChooser.APPROVE_OPTION) {
			File folder = jfc.getSelectedFile();

			String chosenPath = folder.getAbsolutePath();
			Settings.getInstance().setPathToWorkspace(chosenPath);

			File[] files = folder.listFiles();
			for (File file : files) {
				String extension = ".geru";
				if (file.getPath().endsWith(extension)) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
						ProjectM pm = (ProjectM) ois.readObject();
						new ProjectController(pm);
						ois.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		} else {
			System.exit(0);
		}
	}
}