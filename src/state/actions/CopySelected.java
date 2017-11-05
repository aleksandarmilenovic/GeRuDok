package state.actions;

import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import collection.model.DocumentM;
import collection.model.SlotGM;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class CopySelected extends AbstractAction {
	public CopySelected() {
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
		// vracam paste pomeraj na nulu za novo kopiranje
		AppWindow.getInstance().setPastePomeraj(0);
		// Stablo
		JTree tree = AppWindow.getInstance().getJtree();
		// Slot iz kojeg cut-ujem element(e)
		SlotGM node = (SlotGM) tree.getLastSelectedPathComponent();
		// Cuvam izvorisni slot, da bih proverio da li kopiram u istom slotu ili
		// u razlicitom
		AppWindow.getInstance().setIzvorniSlotCopyCut(node);
		// Izvorni slot, da bih proverio da li se cut izvrsava unutar istog
		// dokumenta
		DocumentM dok = (DocumentM) node.getParent().getParent();
		AppWindow.getInstance().setIzvorniDokumentCopyCut(dok);

		if (node instanceof SlotGM) {
			// Dodajem sve selektovane elemente iz SelectionList u
			// GrafickiElementiCopyCut listu koju koristim za
			// kopiranje/cut-ovanje
			AppWindow.getInstance().getGrafickiElementiCopyCut()
					.addAll(((SlotGM) node).getElementSelectionManager().getSelectionList());
		}
	}
	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("copy"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("copy"));
	}
}