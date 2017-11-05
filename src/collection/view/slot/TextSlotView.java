package collection.view.slot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import collection.model.SlotTM;
import collection.view.SlotView;
import gui.AppWindow;
import tree.TreeM;

@SuppressWarnings("serial")
public class TextSlotView extends SlotView {

	private TextEditingArea mArea;
	private TitledBorder slotStamp;

	public TextSlotView(SlotTM textSlot) {
		super(textSlot);
		initTextArea();
		mArea.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				JTree tree = AppWindow.getInstance().getJtree();
				TreeM tmodel = AppWindow.getInstance().getTreeModel();
				TreeNode[] path = tmodel.getPathToRoot(getModel());
				tree.setSelectionPath(new TreePath(path));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					TextEditingWindow editingWindow = TextEditingWindow.getInstance(textSlot);
					editingWindow.setVisible(true);
				}
			}
		});
	}

	public TextEditingArea getTextArea() {
		return mArea;
	}

	private void initTextArea() {
		mArea = new TextEditingArea(((SlotTM) getModel()).getContent());
		mArea.setEnabled(false);
		setLayout(new BorderLayout());
		add(mArea, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);
		mArea.setText(((SlotTM) getModel()).getContent());
	}

	public TitledBorder getSlotStamp() {
		slotStamp = super.getTitledBorder();
		return slotStamp;
	}

	public void setSlotStampTitle(String editedarg) {
		getSlotStamp().setTitle(editedarg);
		updateUI();
	}

	public void setSlotStampUnselected() {
		TitledBorder borderUnselect = new TitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.white, Color.white),
				super.getModel().getName(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, getFont(), Color.BLACK);

		super.setBorder(borderUnselect);

	}

	public void setSlotStampSelected() {
		TitledBorder borderSelect = new TitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE),
				super.getModel().getName(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, getFont(), Color.BLUE);
		super.setBorder(borderSelect);
		updateUI();
	}

	public void dispose() {
		this.getParent().remove(this);
		try {
			finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
