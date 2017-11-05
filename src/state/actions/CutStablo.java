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
public class CutStablo extends AbstractAction {

	public CutStablo() {
		putValue(SMALL_ICON, loadIcon("images/cut.png"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("cut"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("cut"));
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

		//Praznim listu elemenata za kopiranje
		AppWindow.getInstance().getGrafickiElementiCopyCut().clear(); 
		AppWindow.getInstance().setPastePomeraj(0);
		AppWindow.getInstance().setBioCutCopyStablo(true);
		
		
		
		JTree tree = AppWindow.getInstance().getJtree();
		//Element
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		//Slot
		SlotGM slot = (SlotGM) node.getParent();
		AppWindow.getInstance().setIzvorniSlotCopyCut(slot);
		//Dokument
		DocumentM dok = (DocumentM) slot.getParent().getParent();
		AppWindow.getInstance().setIzvorniDokumentCopyCut(dok);

		if(node instanceof RectangleElement){
			
			
			if (slot instanceof SlotGM) {					
				((SlotGM) slot).getElementSelectionManager().addToSelectionList((RectangleElement)node);				
				AppWindow.getInstance().getGrafickiElementiCopyCut().add((RectangleElement)node);				
			}		
		}
		if(node instanceof CircleElement){
			
		
			if (slot instanceof SlotGM) {					
				((SlotGM) slot).getElementSelectionManager().addToSelectionList((CircleElement)node);
				
				AppWindow.getInstance().getGrafickiElementiCopyCut().add((CircleElement)node);			
			}		
		}	

		
		
		if (slot instanceof SlotGM) {
			//sve elemente koji su u selectionList uklanjam iz roditelja, odnosno Slota u stablu, sto ce prouzrokovati njihovo brisanje i sa SlotViewa, i iz GraphEditingWindow-a
			((SlotGM) slot).getElementSelectionManager().removeAllSelectedFromParent();
			//update-ujem slotView kako bi se obrisali
			((SlotGM) slot).getSlotController().getGraphSlotView().updateUI();
			try {
				//Update-ujem graphEditingWindow kako bi se obrisali
				((SlotGM) slot).getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
			} catch (Exception e1) {
			}
		
			
		}	
		
		
	}

	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("cut"));
	}
}
