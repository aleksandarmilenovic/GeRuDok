package collection.view;

import java.awt.Dimension;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import collection.model.DocumentM;
import collection.model.ProjectM;
import gui.AppWindow;
import tree.TreeM;

public class ProjectView extends JInternalFrame implements Serializable {

	private static final long serialVersionUID = 3124296225976615289L;

	boolean alreadyListening = false;
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;
	private tabic tabber = new tabic();
	ProjectM model;

	public ProjectView() {
		super("Naslov", true, true, true, true);
		this.setFrameIcon(new ImageIcon("src/collection/view/images/project.png"));

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		setSize(new Dimension(600, 600));
		setMinimumSize(new Dimension(600, 600));
		setPreferredSize(new Dimension(600, 600));
		tabber.setVisible(false);

		tabber.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(tabber);
		openFrameCount++;
		setVisible(true);

		tabber.addMouseListener(new ViewSelectionListener());
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				JTree tree = AppWindow.getInstance().getJtree();
				TreeM tmodel = AppWindow.getInstance().getTreeModel();
				TreeNode[] path = tmodel.getPathToRoot(model);
				tree.setSelectionPath(new TreePath(path));

				super.internalFrameActivated(e);
			}
		});
	}

	void startChangeListener() {
		alreadyListening = true;
		tabber.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JTree tree = AppWindow.getInstance().getJtree();
				TreeM tmodel = AppWindow.getInstance().getTreeModel();
				if (tabber.getSelectedIndex() != -1) {
					DocumentM model = ((DocumentView) tabber.getSelectedComponent()).getModel();
					TreeNode[] path = tmodel.getPathToRoot(model);
					tree.setSelectionPath(new TreePath(path));
				}
			}
		});
	}

	@SuppressWarnings("serial")
	public class tabic extends JTabbedPane {
		ProjectM modelic;

		public ProjectM getModelic() {
			return modelic;
		}

		public void setModelic(ProjectM modelic) {
			this.modelic = modelic;
		}
	}

	public void addDocPane(DocumentView docV) {
		tabber.addTab(docV.title, docV);
		tabber.setVisible(true);
		if (alreadyListening == false) {
			startChangeListener();
		}
	}

	public void removeDocPane(DocumentView docV) {
		tabber.remove(docV);
	}

	public tabic getTabber() {
		return tabber;
	}

	public ProjectM getModel() {
		return model;
	}

	public void setModel(ProjectM model) {
		this.model = model;
		tabber.setModelic(model);
	}

}