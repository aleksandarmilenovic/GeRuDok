package collection.view.slot;

import java.awt.Dimension;

import javax.swing.JToolBar;

import gui.AppWindow;

@SuppressWarnings("serial")
public class GraphSlotToolbar extends JToolBar {

	public GraphSlotToolbar() {
		setFloatable(false);
		setRollover(true);
		addButtons();
	}

	@SuppressWarnings("static-access")
	public void addButtons() {
		add(AppWindow.getInstance().getActionManager().getRectangleState());
		add(AppWindow.getInstance().getActionManager().getCircleState());
		addSeparator(new Dimension(20, 0));

		add(AppWindow.getInstance().getActionManager().getToSelectState());
		add(AppWindow.getInstance().getActionManager().getToLassoState());
		addSeparator(new Dimension(20, 0));

		add(AppWindow.getInstance().getActionManager().getRotateSelectedLeft());
		add(AppWindow.getInstance().getActionManager().getRotateSelectedRight());
		addSeparator(new Dimension(20, 0));

		add(AppWindow.getInstance().getActionManager().getCopySelected());
		add(AppWindow.getInstance().getActionManager().getCutSelected());
		add(AppWindow.getInstance().getActionManager().getPasteSelected());
		addSeparator(new Dimension(20, 0));

		add(AppWindow.getInstance().getActionManager().getDeleteSelected());
		addSeparator(new Dimension(20, 0));
		
		AppWindow.getInstance().getActionManager().getUndoAction().setEnabled(false);
		AppWindow.getInstance().getActionManager().getRedoAction().setEnabled(false);
		add(AppWindow.getInstance().getActionManager().getUndoAction());
		add(AppWindow.getInstance().getActionManager().getRedoAction());
	}
}
