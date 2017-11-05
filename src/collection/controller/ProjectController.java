package collection.controller;

import collection.model.DocumentM;
import collection.model.ProjectM;
import collection.view.ProjectView;
import gui.AppWindow;
import tree.TreeM;

public class ProjectController {

	private ProjectM projmodel;
	private ProjectView projview;
	private TreeM treemodel;

	public ProjectController() {
		projmodel = new ProjectM();
		projmodel.setController(this);
		projview = new ProjectView();
		projview.setModel(projmodel);
		treemodel = AppWindow.getInstance().getTreeModel();
		treemodel.add(projmodel);
		projmodel.defaultProjectName();
		treemodel.refresh();
		SetTitle();
		AppWindow.getInstance().getDesktop().add(projview);
		projview.toFront();
	}

	public ProjectController(ProjectM pm) {
		projmodel = pm;
		projmodel.setController(this);
		projview = new ProjectView();
		projview.setModel(projmodel);
		treemodel = AppWindow.getInstance().getTreeModel();
		treemodel.add(projmodel);
		treemodel.refresh();
		SetTitle();

		for (int i = 0; i < projmodel.getChildCount(); i++) {
			new DocumentController((DocumentM) projmodel.getChildAt(i));
		}

		AppWindow.getInstance().getDesktop().add(projview);
		projview.toFront();
	}

	public void SetTitle() {
		projview.setTitle(projmodel.getProjectName());
	}

	public void Refresh() {
	}

	public ProjectView getProjectView() {
		return projview;
	}

	public ProjectM getProjectModel() {
		return projmodel;
	}
}
