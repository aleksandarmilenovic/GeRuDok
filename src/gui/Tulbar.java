package gui;

import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class Tulbar extends JToolBar {
	@SuppressWarnings("static-access")
	public Tulbar() {
		setOrientation(JToolBar.HORIZONTAL);
		setFloatable(false);
		add(AppWindow.getInstance().getActionManager().getNewProjectAction());
		add(AppWindow.getInstance().getActionManager().getNewDocumentAction());
		add(AppWindow.getInstance().getActionManager().getNewPageAction());
		add(AppWindow.getInstance().getActionManager().getNewSlotAction());
		add(AppWindow.getInstance().getActionManager().getTextSlotAction());
		add(AppWindow.getInstance().getActionManager().getTileHorizontallyAction());
		add(AppWindow.getInstance().getActionManager().getTileVerticallyAction());
		add(AppWindow.getInstance().getActionManager().getTileMatricallyAction());
		add(AppWindow.getInstance().getActionManager().getTileCascadeAction());
		add(AppWindow.getInstance().getActionManager().getPreviousProjectAction());
		add(AppWindow.getInstance().getActionManager().getNextProjectAction());
	}
}
