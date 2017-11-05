package collection.controller;

import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.view.DocumentView;
import collection.view.PageView;
import gui.AppWindow;
import tree.TreeM;

public class PageController {
	private PageM pagmodel;
	private PageView pagview;

	private TreeM treemodel;

	public PageController() {

		treemodel = AppWindow.getInstance().getTreeModel();
		pagmodel = new PageM();
		pagview = new PageView();
		pagmodel.setController(this);
		pagview.setModel(pagmodel);
		treemodel.add(pagmodel);
		pagmodel.defaultPageName();
		treemodel.refresh();
		SetPageViewTitle();
		pagview.addStamp();
		((DocumentView) ((DocumentController) ((DocumentM) pagmodel.getParent()).getController()).getDocView())
				.addPagePane(pagview);
		((DocumentView) ((DocumentController) ((DocumentM) pagmodel.getParent()).getController()).getDocView()).hide();
		((DocumentView) ((DocumentController) ((DocumentM) pagmodel.getParent()).getController()).getDocView()).show();

	}

	public PageController(PageM model) {

		pagmodel = model;
		pagview = new PageView();
		pagview.setModel(pagmodel);
		pagmodel.setController(this);
		SetPageViewTitle();
		pagview.addStamp();

		for (int i = 0; i < pagmodel.getChildCount(); i++) {
			if (pagmodel.getChildAt(i) instanceof SlotGM) {
				SlotGM mod = (SlotGM) pagmodel.getChildAt(i);
				new GraphSlotController(mod);
			}
			if (pagmodel.getChildAt(i) instanceof SlotTM) {
				SlotTM mod = (SlotTM) pagmodel.getChildAt(i);
				new TextSlotController(mod);
			}
		}

		((DocumentView) ((DocumentController) ((DocumentM) pagmodel.getParent()).getController()).getDocView())
				.addPagePane(pagview);
		((DocumentView) ((DocumentController) ((DocumentM) pagmodel.getParent()).getController()).getDocView()).hide();
		((DocumentView) ((DocumentController) ((DocumentM) pagmodel.getParent()).getController()).getDocView()).show();
	}

	public void SetPageViewTitle() {
		pagview.setTitleAndNum(pagmodel.getPageName());
	}

	public void Refresh() {

	}

	public PageView getPageView() {
		return pagview;
	}

	public PageM getPageModel() {
		return pagmodel;
	}

	public void RefreshPage() {
	}
}