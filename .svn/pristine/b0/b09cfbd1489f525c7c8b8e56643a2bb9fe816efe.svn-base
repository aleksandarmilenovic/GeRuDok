package collection.model;

import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class SlotM extends DefaultMutableTreeNode {

	String slotName = "Graphic Slot";
	SlotTM tm;
	SlotGM gm;
	Object notif;

	public void setSuperTm(SlotTM tm) {
		this.tm = tm;
	}

	public void setSuperGm(SlotGM gm) {
		this.gm = gm;
	}

	public void setName(String slotName) {
		this.slotName = slotName;
	}

	public String getName() {
		return slotName;
	}

	public Object getNotif() {
		return notif;
	}

	public void notifyObservers(Object arg) {
		notif = arg;
	}
}
