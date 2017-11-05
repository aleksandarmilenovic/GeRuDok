package tree;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;
import collection.model.WorkspaceM;
import gui.AppWindow;

@SuppressWarnings("serial")
public class TreePanel extends JPanel {

	private JTree tree;

	public TreePanel() {
		super(new GridLayout(1, 0));

		WorkspaceM workSpace = new WorkspaceM();
		TreeCellRenderer renderer = new TreeCellRenderer();

		TreeM trem = new TreeM(workSpace);
		tree = new JTree();
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setCellRenderer(renderer);
		TreeCellEditor editor = new TreeCellEditor(tree, renderer);
		tree.setModel(trem);

		tree.setCellEditor(editor);

		editor.addCellEditorListener(new CellEditListener(editor));

		tree.addMouseListener(new TreeMouseListener());

		tree.addTreeSelectionListener(new TreeSelectioner());

		AppWindow.getInstance().setJtree(tree);
		AppWindow.getInstance().setTreeModel(trem);

		JScrollPane treeScroll = new JScrollPane(tree);
		Dimension minimumSize = new Dimension(200, 100);
		treeScroll.setMinimumSize(minimumSize);
		add(treeScroll);
	}
}
