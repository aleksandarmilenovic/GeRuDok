package state.actions;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import collection.model.DocumentM;
import collection.model.SlotGM;
import collection.model.element.CircleElement;
import collection.model.element.Element;
import collection.model.element.RectangleElement;
import collection.model.element.SerializableStrokeAdapter;
import gui.AppWindow;
import localization.Localization;
import tree.TreeM;

@SuppressWarnings("serial")
public class PasteStablo extends AbstractAction {

	public PasteStablo() {
		putValue(SMALL_ICON, loadIcon("images/paste.jpg"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("paste"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("paste"));

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

		JTree tree = AppWindow.getInstance().getJtree();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();// slot
		SlotGM slot = (SlotGM) node;
		DocumentM dok = (DocumentM) node.getParent().getParent();
		TreeM treeModel = AppWindow.getInstance().getTreeModel();

		if (node instanceof SlotGM) {
			// Da li se paste izvrsava u istom slotu u kom je bio Copy/Cut
			if (slot.equals(AppWindow.getInstance().getIzvorniSlotCopyCut())) {

				// Proveravam da li je bio cut, jer ako jeste, onda se pastuje
				// na isto mesto, bez pomeraja
				if (AppWindow.getInstance().isBioCut()) {
					AppWindow.getInstance().setPastePomeraj(0);
				}
				// Ako nije, pastePomeraj se uvelicava za 20
				else {
					AppWindow.getInstance().setPastePomeraj(AppWindow.getInstance().getPastePomeraj() + 20);
				}

				// Vrtim kroz sve elemente u listi grafickiElementiCopyCut u
				// kojoj su mi elementi za kopiranje
				// I uzimam jedan po jedan element E da bih od njega pravio
				// kopiju
				int j;
				for (j = 0; j < AppWindow.getInstance().getGrafickiElementiCopyCut().size(); j++) {
					Element E = AppWindow.getInstance().getGrafickiElementiCopyCut().get(j);

					// Ako je pravougaonik, pravim element klase
					// RectangleElement
					if (E instanceof RectangleElement) {
						// Pozivam konstruktor RectangleElement i pravim element
						// e1, kojem dajem dimenziju, i ime originala
						// a poziciju mu dajem na osnovu pozicije originala i
						// pastePomeraja
						Element e1 = new RectangleElement(E.getName(),
								new Point((int) E.getPosition().getX() + AppWindow.getInstance().getPastePomeraj(),
										(int) E.getPosition().getY() + AppWindow.getInstance().getPastePomeraj()),
								new SerializableStrokeAdapter(new BasicStroke(1)), E.getDimension(), Color.BLUE);

						// Dodajem e1 u treeModel koji ce se pobrinuti za
						// iscrtavanje
						try {
							treeModel.add((RectangleElement) e1);
						} catch (Exception e2) {

						}
					}
					// Ako je krug, pravim element klase CircleElement
					else if (E instanceof CircleElement) {
						// Pozivam konstruktor CirlceElement i pravim element
						// e1, kojem dajem dimenziju, i ime originala
						// a poziciju mu dajem na osnovu pozicije originala i
						// pastePomeraja
						Element e1 = new CircleElement(E.getName(),
								new Point((int) E.getPosition().getX() + AppWindow.getInstance().getPastePomeraj(),
										(int) E.getPosition().getY() + AppWindow.getInstance().getPastePomeraj()),
								new SerializableStrokeAdapter(new BasicStroke(1)), E.getDimension(), Color.BLUE);

						try {
							treeModel.add((CircleElement) e1);
						} catch (Exception e2) {

						}
					}
				}

			}
			// Ako nije isti slot , u redu, samo proveri da je isti dokument u
			// pitanju
			else {
				// Ako jeste isti dokument u pitanju radi sve isto kao da je
				// isti slot, samo se pomeraj uvelicava na kraju, pa nas cut i
				// ne brine, jer se cut samo jednom izvrsava
				if (dok.equals(AppWindow.getInstance().getIzvorniDokumentCopyCut())) {

					int j;
					for (j = 0; j < AppWindow.getInstance().getGrafickiElementiCopyCut().size(); j++) {
						Element E = AppWindow.getInstance().getGrafickiElementiCopyCut().get(j);
						if (E instanceof RectangleElement) {
							Element e1 = new RectangleElement(E.getName(),
									new Point((int) E.getPosition().getX() + AppWindow.getInstance().getPastePomeraj(),
											(int) E.getPosition().getY() + AppWindow.getInstance().getPastePomeraj()),
									new SerializableStrokeAdapter(new BasicStroke(1)), E.getDimension(), Color.BLUE);
							try {
								treeModel.add((RectangleElement) e1);
							} catch (Exception e2) {
							}

						} else if (E instanceof CircleElement) {
							Element e1 = new CircleElement(E.getName(),
									new Point((int) E.getPosition().getX() + AppWindow.getInstance().getPastePomeraj(),
											(int) E.getPosition().getY() + AppWindow.getInstance().getPastePomeraj()),
									new SerializableStrokeAdapter(new BasicStroke(1)), E.getDimension(), Color.BLUE);
							try {
								treeModel.add((CircleElement) e1);
							} catch (Exception e2) {
							}
						}
					}
					AppWindow.getInstance().setPastePomeraj(AppWindow.getInstance().getPastePomeraj() + 20);

				}
				// Ako nije isti dokument, ispisi poruku o gresci
				else {
					String naslov = Localization.getInstance().getBundle().getString("error");
					String poruka = Localization.getInstance().getBundle().getString("poruka");
					JOptionPane.showMessageDialog(null, poruka, naslov, JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		AppWindow.getInstance().getGrafickiElementiCopyCut().clear();
	}

	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("paste"));
	}
}
