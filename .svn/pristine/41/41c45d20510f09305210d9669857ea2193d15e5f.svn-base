package collection.controller;

import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.view.DocumentView;
import collection.view.ProjectView;
import gui.AppWindow;
import tree.TreeM;

public class DocumentController {
	private DocumentM docmodel;
	private DocumentView docview;

	private TreeM treemodel;

	public DocumentController() {
		treemodel = AppWindow.getInstance().getTreeModel();
		docmodel = new DocumentM();
		docview = new DocumentView();
		docmodel.setController(this);
		docview.setModel(docmodel);
		treemodel.add(docmodel);
		docmodel.defaultDocumentName();
		treemodel.refresh();
		SetDocViewTitle();

		((ProjectView) ((ProjectController) ((ProjectM) docmodel.getParent()).getController()).getProjectView())
				.addDocPane(docview);
		((ProjectView) ((ProjectController) ((ProjectM) docmodel.getParent()).getController()).getProjectView())
				.updateUI();

	}

	public DocumentController(DocumentM model) {
		docmodel = model;
		docview = new DocumentView();
		docmodel.setController(this);
		docview.setModel(docmodel);
		SetDocViewTitle();

		for (int i = 0; i < docmodel.getChildCount(); i++) {
			new PageController((PageM) docmodel.getChildAt(i));
		}

		((ProjectView) ((ProjectController) ((ProjectM) docmodel.getParent()).getController()).getProjectView())
				.addDocPane(docview);
		((ProjectView) ((ProjectController) ((ProjectM) docmodel.getParent()).getController()).getProjectView())
				.updateUI();

	}

	public void SetDocViewTitle() {
		docview.setTitle(docmodel.getDocumentName());
	}

	public void Refresh() {

	}

	public DocumentView getDocView() {
		return docview;
	}

	public DocumentM getDocModel() {
		return docmodel;
	}

	public void RefreshDoc() {
	}
}
