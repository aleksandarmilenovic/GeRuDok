package collection.controller;

import collection.model.PageM;
import collection.model.SlotTM;
import collection.view.PageView;
import collection.view.slot.TextSlotView;
import gui.AppWindow;
import tree.TreeM;

public class TextSlotController {
	private TreeM treemodel;
	private SlotTM textSlot;
	private TextSlotView textSlotView;

	public TextSlotController() {
		treemodel = AppWindow.getInstance().getTreeModel();

		textSlot = new SlotTM();
		textSlot.setController(this);
		textSlotView = new TextSlotView(textSlot);
		treemodel.add(textSlot);
		textSlot.defaultSlotTMName();
		treemodel.refresh();
		SetSlotTitle();
		((PageView) ((PageController) ((PageM) textSlot.getParent()).getPageController()).getPageView())
				.addTextPane(textSlotView);
		((PageView) ((PageController) ((PageM) textSlot.getParent()).getPageController()).getPageView()).hide();
		((PageView) ((PageController) ((PageM) textSlot.getParent()).getPageController()).getPageView()).show();
	}

	public TextSlotController(SlotTM model) {
		textSlot = model;
		textSlot.setController(this);
		textSlotView = new TextSlotView(textSlot);
		SetSlotTitle();
		((PageView) ((PageController) ((PageM) textSlot.getParent()).getPageController()).getPageView())
				.addTextPane(textSlotView);
		((PageView) ((PageController) ((PageM) textSlot.getParent()).getPageController()).getPageView()).hide();
		((PageView) ((PageController) ((PageM) textSlot.getParent()).getPageController()).getPageView()).show();
	}

	private void SetSlotTitle() {
		textSlotView.setLabel();
	}

	public TextSlotView getTextSlotView() {
		return textSlotView;
	}
}
