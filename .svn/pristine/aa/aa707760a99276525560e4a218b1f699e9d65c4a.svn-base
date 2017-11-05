package state.actions;

import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import collection.model.DocumentM;
import collection.model.SlotGM;
import collection.model.element.CircleElement;
import collection.model.element.RectangleElement;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class CopyStablo extends AbstractAction {
	public CopyStablo() {
		putValue(SMALL_ICON, loadIcon("images/copy.png"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("copy"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("copy"));
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
		// Praznim listu elemenata za kopiranje
		AppWindow.getInstance().getGrafickiElementiCopyCut().clear();
		AppWindow.getInstance().setPastePomeraj(0);
		AppWindow.getInstance().setBioCutCopyStablo(true);

		JTree tree = AppWindow.getInstance().getJtree();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();// Element
		SlotGM slot = (SlotGM) node.getParent();// Slot
		AppWindow.getInstance().setIzvorniSlotCopyCut(slot);
		DocumentM dok = (DocumentM) slot.getParent().getParent();// Dokument
		AppWindow.getInstance().setIzvorniDokumentCopyCut(dok);

		if (node instanceof RectangleElement) {

			if (slot instanceof SlotGM) {
				((SlotGM) slot).getElementSelectionManager().addToSelectionList((RectangleElement) node);
				AppWindow.getInstance().getGrafickiElementiCopyCut().add((RectangleElement) node);
			}
		}
		if (node instanceof CircleElement) {

			if (slot instanceof SlotGM) {
				((SlotGM) slot).getElementSelectionManager().addToSelectionList((CircleElement) node);

				AppWindow.getInstance().getGrafickiElementiCopyCut().add((CircleElement) node);
			}
		}

	}

	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("copy"));
	}
}