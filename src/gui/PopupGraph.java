package gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class PopupGraph extends JPopupMenu {
	private JMenuItem copy;
	private JMenuItem cut;
	private JMenuItem paste;
	private JMenuItem delete;

	public PopupGraph() {

		delete = new JMenuItem(AppWindow.getInstance().getActionManager().getDeleteSelected());
		copy = new JMenuItem(AppWindow.getInstance().getActionManager().getCopySelected());
		cut = new JMenuItem(AppWindow.getInstance().getActionManager().getCutSelected());
		paste = new JMenuItem(AppWindow.getInstance().getActionManager().getPasteSelected());
		add(copy);
		add(cut);
		add(paste);
		add(delete);

	}
}
