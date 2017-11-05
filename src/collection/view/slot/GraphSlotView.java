package collection.view.slot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import collection.model.SlotGM;
import collection.view.SlotView;
import gui.AppWindow;

@SuppressWarnings("serial")
public class GraphSlotView extends SlotView {

	private TitledBorder slotStamp;

	private GraphSlotCanvas canvas;
	private GraphEditingWindow editingWindow = null;

	public static final int CIRCLE = 1;
	public static final int RECTANGLE = 2;

	public GraphSlotView(SlotGM grafSlot) {
		super(grafSlot);
		createCanvas();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getClickCount() == 2) {
					AppWindow.getInstance().setPastePomeraj(0);
					editingWindow = new GraphEditingWindow((SlotGM) getModel());
					editingWindow.setVisible(true);
				}
			}
		});

	}

	public GraphEditingWindow getEditingWindow() {
		return editingWindow;
	}

	public void createCanvas() {
		canvas = new GraphSlotCanvas((SlotGM) getModel());
		setLayout(new BorderLayout());
		add(canvas, BorderLayout.CENTER);

	}

	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);

		repaint();

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
