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
public class CutSelected extends AbstractAction {
	/**
	 * Konstruktor: postavlja ikonicu, ime, opis
	 */
	public CutSelected() {
		putValue(SMALL_ICON, loadIcon("images/cut.png"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("cut"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("cut"));

	}

	/**
	 * ucitava ikonicu
	 */
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
		// Postavljam BioCut na true, treba mi jer u paste proveram da li je bio
		// cut, kako bih dozvolio samo jedan paste
		AppWindow.getInstance().setBioCut(true);
		// Praznim listu elemenata za kopiranje kako bih mogao da je popunim
		// novim elemntima
		AppWindow.getInstance().getGrafickiElementiCopyCut().clear();
		// vracam paste pomeraj na nulu za novo cut-ovanje
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
			// sve elemente koji su u selectionList uklanjam iz roditelja,
			// odnosno Slota u stablu, sto ce prouzrokovati njihovo brisanje i
			// sa SlotViewa, i iz GraphEditingWindow-a
			((SlotGM) node).getElementSelectionManager().removeAllSelectedFromParent();

			try {// update-ujem slotView kako bi se obrisali
				((SlotGM) node).getSlotController().getGraphSlotView().updateUI();
				// Update-ujem graphEditingWindow kako bi se obrisali
				((SlotGM) node).getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
			} catch (Exception e2) {
			}

		}
	}

	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("cut"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("cut"));
		
	}
}