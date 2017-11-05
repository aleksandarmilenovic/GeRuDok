package collection.model;

import java.io.Serializable;

import collection.controller.TextSlotController;

@SuppressWarnings("serial")
public class SlotTM extends SlotM implements Serializable {

	transient TextSlotController textslotcontroller;
	String defSlotTMName = "Text Slot ";
	String SlotTMName;
	private String mContent = "";

	int SlotTMIndex;

	public SlotTM() {
	}

	public void setSlotTMName(String SlotTMName) {
		this.SlotTMName = SlotTMName;
		setSuperTm(this);
		setName(SlotTMName);
		setUserObject(SlotTMName);
	}

	public void defaultSlotTMName() {
		this.SlotTMName = (defSlotTMName + (getParent().getIndex(this) + 1));
		setName(SlotTMName);
		setUserObject(defSlotTMName + (getParent().getIndex(this) + 1));
	}

	public String getSlotTMName() {
		return SlotTMName;
	}

	public void setController(TextSlotController textSlotController) {
		this.textslotcontroller = textSlotController;
	}

	public TextSlotController getTextslotcontroller() {
		return textslotcontroller;
	}

	public String getContent() {
		return mContent;
	}

	public void setContent(String mContent) {
		this.mContent = mContent;
	}

	public void notifyObservers() {
		textslotcontroller.getTextSlotView().getTextArea().setText(mContent);
	}

}
