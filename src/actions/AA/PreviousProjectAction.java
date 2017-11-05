package actions.AA;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import collection.model.ProjectM;
import collection.model.WorkspaceM;
import gui.AppWindow;
import localization.Localization;
import tree.TreeM;

public class PreviousProjectAction extends AbstractAction {
	private static final long serialVersionUID = 1L;


	public PreviousProjectAction() {
		putValue(SMALL_ICON, loadIcon("images/previous.png"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("previous"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("previous"));
	}
	
	private Icon loadIcon(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		} else {
			System.err.println("Resource not found: " + fileName);
		}
		return icon;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		
		JTree tree = AppWindow.getInstance().getJtree();
		TreeM tmodel = AppWindow.getInstance().getTreeModel();
		WorkspaceM wmodel = (WorkspaceM) tmodel.getRoot();
		
		
		
		if(tree.getLastSelectedPathComponent() instanceof ProjectM){
		
		ProjectM pmodel = ((ProjectM)tree.getLastSelectedPathComponent());	
		try {
			if(!pmodel.getPreviousSibling().equals(null)){
			
				TreeNode[] path = tmodel.getPathToRoot(pmodel.getPreviousSibling());
				tree.setSelectionPath(new TreePath(path));
			}
		} catch (Exception e1) {
		}
		}
		else{
			try {
				ProjectM pmodel= (ProjectM)wmodel.getFirstChild();
				TreeNode[] path = tmodel.getPathToRoot(pmodel);
				tree.setSelectionPath(new TreePath(path));
			} catch (Exception e1) {
			}
			
			
		}

		ActionManager.setActivex();
	}
	
		
	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("previous"));
	}

	
	
}
