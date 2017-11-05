package collection.model.element;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.event.EventListenerList;

import collection.model.SlotGM;
import gui.AppWindow;

import tree.TreeM;

@SuppressWarnings("serial")
public class ElementSelectionManager extends DefaultSingleSelectionModel {


	private ArrayList<ElementHandles> allElementHandles = new ArrayList<ElementHandles>();
	private ArrayList<Element> selectionList = new ArrayList<Element>();
	private SlotGM mElementParent;
	@SuppressWarnings("unused")
	private EventListenerList listenerList = new EventListenerList();

	public ElementSelectionManager(SlotGM slotGM) {
		mElementParent = slotGM;
	}

	public void addToSelectionList(Element element) {
		selectionList.add(element);
		allElementHandles.add(new ElementHandles(element));
		try {
			mElementParent.getSlotController().getGraphSlotView().updateUI();
			mElementParent.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
		} catch (Exception e) {
		}

	}

	
	public void addToSelectionList(ArrayList<Element> list) {
		selectionList.addAll(list);
	}

	
	public int getSelectionListSize() {
		return selectionList.size();
	}

	public Element getElementFromSelectionListAt(int index) {
		return (Element) selectionList.get(index);
	}

	public int getIndexByObject(Element element) {
		return selectionList.indexOf(element);
	}

	
	public void removeFromSelectionList(Element element) {

		selectionList.remove(element);
	}

	public void removeAllFromSelectionList() {
		selectionList.clear();
	}

	public void removeAllSelectedFromParent() {
		if (selectionList.size() > 0) {

			TreeM treemodel = AppWindow.getInstance().getTreeModel();
			for (Element element : selectionList) {
				mElementParent.removeElementFromList(element);
				treemodel.removeNodeFromParent(element);
			}
		}
		removeAllFromSelectionList();

	}

	public ArrayList<Element> getSelectionList() {
		return selectionList;
	}

	public Iterator<Element> getSelectionListIterator() {
		return selectionList.iterator();
	}

	public boolean isElementSelected(Element element) {
		return selectionList.contains(element);

	}

	public void selectElements(Rectangle2D rec, ArrayList<Element> elements) {

		for (Element element : elements) {
			if (rec.intersects(element.getPosition().getX() - element.getDimension().getWidth() / 2,
					element.getPosition().getY() - element.getDimension().getHeight() / 2,
					element.getDimension().getWidth(), element.getDimension().getHeight())) {
				if (!isElementSelected(element)) {
					addToSelectionList(element);
				}
			} else {
				removeFromSelectionList(element);
				mElementParent.getSlotController().getGraphSlotView().updateUI();
				mElementParent.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
			}
		}
	}

	
	public void clearAllHandles() {
		allElementHandles.clear();
		for (Element element : selectionList) {
			allElementHandles.add(new ElementHandles(element));
		}
	}

	public ElementHandles handleHit(Point2D point) {
		for (ElementHandles elementHandles : allElementHandles) {
			ArrayList<ElementHandle> handles = elementHandles.getHandles();
			for (ElementHandle elementHandle : handles) {
				if (elementHandle.contains(point)) {
					return elementHandles;
				}
			}
		}
		return null;
	}

	public ArrayList<ElementHandle> selectedElementHandles(Element element) {
		for (ElementHandles elementHandles : allElementHandles) {
			if (elementHandles.getElement().equals(element)) {
				return elementHandles.getHandles();
			}
		}
		return null;
	}
}
