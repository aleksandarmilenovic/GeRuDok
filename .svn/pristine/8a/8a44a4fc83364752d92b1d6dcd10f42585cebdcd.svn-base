package collection.model;

import java.io.File;
import java.io.Serializable;

import javax.swing.tree.DefaultMutableTreeNode;

import collection.controller.ProjectController;

@SuppressWarnings("serial")
public class ProjectM extends DefaultMutableTreeNode implements Serializable {

	transient ProjectController controller;

	File projectFile;
	String defProjectName = "Project ";
	String projectName;
	int projectIndex;

	public ProjectM() {
		super("Project");
	}

	public void setController(ProjectController controller) {
		this.controller = controller;
	}

	public ProjectController getController() {
		return controller;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
		setUserObject(projectName);
	}

	public void defaultProjectName() {
		this.projectName = (defProjectName + (getParent().getIndex(this) + 1));
		setUserObject(defProjectName + (getParent().getIndex(this) + 1));
	}

	public String getProjectName() {
		return projectName;
	}

	public File getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}

}
