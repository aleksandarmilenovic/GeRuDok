package collection.model;

import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;

import collection.controller.GraphSlotController;
import collection.model.element.CircleElement;
import collection.model.element.Element;
import collection.model.element.ElementSelectionManager;
import collection.model.element.RectangleElement;
import commands.CommandManager;
import state.StateManager;

@SuppressWarnings("serial")
public class SlotGM extends SlotM implements Serializable {
	transient GraphSlotController slotController;

	private String mName;
	ArrayList<Element> elements;

	private transient CommandManager commandManager;

	private StateManager stateManager;
	private ElementSelectionManager elementSelectionManager;
	private AffineTransform mTransformation;

	String defSlotGMName = "Graphic Slot ";
	String SlotGMName;
	int SlotGMIndex;

	public static final int CIRCLE = 0;
	public static final int RECTANGLE = 1;

	public GraphSlotController getSlotController() {
		return slotController;
	}

	public void setSlotController(GraphSlotController slotController) {
		this.slotController = slotController;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public AffineTransform getmTransformation() {
		return mTransformation;
	}

	public void setmTransformation(AffineTransform mTransformation) {
		this.mTransformation = mTransformation;
	}

	public String getDefSlotGMName() {
		return defSlotGMName;
	}

	public void setDefSlotGMName(String defSlotGMName) {
		this.defSlotGMName = defSlotGMName;
	}

	public int getSlotGMIndex() {
		return SlotGMIndex;
	}

	public void setSlotGMIndex(int slotGMIndex) {
		SlotGMIndex = slotGMIndex;
	}

	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}

	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public void setElementSelectionManager(ElementSelectionManager elementSelectionManager) {
		this.elementSelectionManager = elementSelectionManager;
	}

	public SlotGM() {

		commandManager = new CommandManager();
		elements = new ArrayList<Element>();
		stateManager = new StateManager(this);
		elementSelectionManager = new ElementSelectionManager(this);
		mTransformation = new AffineTransform();

	}

	public void setSlotGMName(String SlotGMName) {
		this.SlotGMName = SlotGMName;
		setUserObject(SlotGMName);
	}

	public void defaultSlotGMName() {
		this.SlotGMName = (defSlotGMName + (getParent().getIndex(this) + 1));
		setName(SlotGMName);
		setUserObject(defSlotGMName + (getParent().getIndex(this) + 1));
	}

	public String getSlotGMName() {
		return SlotGMName;
	}

	public void setController(GraphSlotController slotController) {
		this.slotController = slotController;
	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	public ElementSelectionManager getElementSelectionManager() {
		return elementSelectionManager;
	}

	// -------Metode za podrsku stateManagera-----------

	public StateManager getStateManager() {
		return stateManager;
	}

	public void startRectangleState() {
		stateManager.setRectangleState();
	}

	public void startCircleState() {
		stateManager.setCircleState();
	}

	public void startSelectState() {
		stateManager.setSelectState();
	}

	public void startLassoState() {
		stateManager.setLassoState();
	}

	public void startMoveState() {
		stateManager.setMoveState();
	}

	public void startResizeState() {
		stateManager.setResizeState();
	}

	public void addElement(int index, RectangleElement inserted) {

		elements.add(index, (Element) inserted);
		this.getSlotController().getGraphSlotView().repaint();
		try {
			this.getSlotController().getGraphSlotView().getEditingWindow().repaint();
		} catch (Exception e) {

		}

	}

	public void addElement(int index, CircleElement inserted) {

		elements.add(index, (Element) inserted);
		this.getSlotController().getGraphSlotView().repaint();
		this.getSlotController().getGraphSlotView().getEditingWindow().repaint();
	}

	public void removeElementFromList(Element forRemoval) {
		elements.remove(forRemoval);
	}

	public int getElementsCount() {
		return elements.size();
	}

	public void removeElement(Element element) {
		elements.remove(element);
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	public void addElement(Element element) {
		elements.add(element);
	}
}
