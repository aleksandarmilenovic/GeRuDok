package collection.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import collection.model.PageM;
import collection.view.slot.GraphSlotView;
import collection.view.slot.TextSlotView;

public class PageView extends JInternalFrame implements Observer, Serializable {

	private static final long serialVersionUID = 3124296225976615289L;

	private PageM model;
	private String title;
	private String num;
	private Border insideLine;
	private Border outsideEmpty;
	private Border border;
	int slotCount = 1;
	JLabel stamp;
	Container slotSpace = new Container();

	public PageView() {
		hideUI();
		setBackground(Color.white);
		setPreferredSize(new Dimension(80, 300));
		setVisible(true);
		slotSpace.setLayout(new GridLayout(0, slotCount, 0, 0));
		add(slotSpace, BorderLayout.CENTER);
		addMouseListener(new ViewSelectionListener());
		setUnselectedBorder();
	}

	public void addStamp() {
		stamp = new JLabel(title);
		stamp.setHorizontalAlignment(SwingConstants.CENTER);
		stamp.setBackground(Color.WHITE);
		stamp.setOpaque(true);
		stamp.setBorder(BorderUIResource.getEtchedBorderUIResource());
		stamp.setPreferredSize(new Dimension(200, 20));
		add(stamp, BorderLayout.SOUTH);
	}

	private void hideUI() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setBorder(null);
	}

	public void setTitleAndNum(String name) {
		this.title = name;
		String temp = name;
		this.num = temp.substring(4);
	}

	public String getTitle() {
		return title;
	}

	public String getNum() {
		return num;
	}

	public void addSlotPane(GraphSlotView graphSlotView) {
		slotSpace.add(graphSlotView);
		slotCount++;
	}

	@Override
	public void update(Observable o, Object arg) {

	}

	public void addTextPane(TextSlotView textSlotView) {
		slotSpace.add(textSlotView);
	}

	public PageM getModel() {
		return model;
	}

	public void setModel(PageM model) {
		this.model = model;
	}

	public JLabel getStamp() {
		return stamp;
	}

	public void setSelectedBorder() {
		outsideEmpty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		insideLine = BorderFactory.createLineBorder(Color.BLUE, 2);
		border = BorderFactory.createCompoundBorder(outsideEmpty, insideLine);
		setBorder(border);
	}

	public void setUnselectedBorder() {
		outsideEmpty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		insideLine = BorderFactory.createLineBorder(Color.BLACK, 2);
		border = BorderFactory.createCompoundBorder(outsideEmpty, insideLine);
		setBorder(border);
	}

}