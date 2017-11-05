package collection.model;

import java.io.Serializable;

import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class WorkspaceM extends DefaultMutableTreeNode implements Serializable {

	String workspaceName;

	public WorkspaceM() {
		super("Workspace");
	}

	public void setWorkspaceName(String workspaceName) {
		this.workspaceName = workspaceName;
		setUserObject(workspaceName);
	}

	public String getWorkspaceName() {
		return workspaceName;
	}

}
