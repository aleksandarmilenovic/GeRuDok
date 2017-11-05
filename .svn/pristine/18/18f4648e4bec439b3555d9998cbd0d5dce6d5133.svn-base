package collection.controller;

import collection.model.PageM;
import collection.model.SlotGM;
import collection.view.PageView;
import collection.view.slot.GraphSlotView;
import gui.AppWindow;
import tree.TreeM;

public class GraphSlotController {
	private TreeM treemodel;
	private SlotGM grafSlot;
	private GraphSlotView graphSlotView;

	public GraphSlotController() {
		treemodel = AppWindow.getInstance().getTreeModel();
		grafSlot = new SlotGM();
		grafSlot.setController(this);
		graphSlotView = new GraphSlotView(grafSlot);
		treemodel.add(grafSlot);
		grafSlot.defaultSlotGMName();
		treemodel.refresh();
		SetSlotTitle();
		((PageView) ((PageController) ((PageM) grafSlot.getParent()).getPageController()).getPageView())
				.addSlotPane(graphSlotView);
		((PageView) ((PageController) ((PageM) grafSlot.getParent()).getPageController()).getPageView()).hide();
		((PageView) ((PageController) ((PageM) grafSlot.getParent()).getPageController()).getPageView()).show();
	}

	public GraphSlotController(SlotGM model) {

		grafSlot = model;
		grafSlot.setController(this);
		graphSlotView = new GraphSlotView(grafSlot);
		SetSlotTitle();
		((PageView) ((PageController) ((PageM) grafSlot.getParent()).getPageController()).getPageView())
				.addSlotPane(graphSlotView);
		((PageView) ((PageController) ((PageM) grafSlot.getParent()).getPageController()).getPageView()).hide();
		((PageView) ((PageController) ((PageM) grafSlot.getParent()).getPageController()).getPageView()).show();

	}

	private void SetSlotTitle() {
		graphSlotView.setLabel();
	}

	public GraphSlotView getGraphSlotView() {
		return graphSlotView;
	}

}
