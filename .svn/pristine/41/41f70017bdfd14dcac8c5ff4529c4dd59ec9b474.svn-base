package collection.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import collection.model.SlotM;

@SuppressWarnings("serial")
public class SlotView extends JPanel implements Observer, Serializable {

	private SlotM mModel;
	private TitledBorder mTitledBorder;

	public SlotView(SlotM slot) {

		mModel = slot;

		initPanel();

		addMouseListener(new ViewSelectionListener());
	}

	private void initPanel() {

		setLayout(new BorderLayout());
		setOpaque(true);

		setMinimumSize(new Dimension(20, 250));
		mTitledBorder = new TitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.white), mModel.getName(),
				TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, getFont(), Color.BLACK);
		setBorder(mTitledBorder);
	}

	public SlotM getModel() {
		return mModel;
	}

	public void setLabel() {
		mTitledBorder.setTitle(mModel.getName());
	}

	public TitledBorder getTitledBorder() {
		return mTitledBorder;
	}

	@Override
	public void update(Observable o, Object arg) {
		mTitledBorder.setTitle(mModel.getName());
		repaint();
	}
}
