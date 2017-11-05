package collection.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import collection.model.DocumentM;

public class DocumentView extends JInternalFrame implements Serializable {

	private static final long serialVersionUID = 3124296225976615289L;
	private JToolBar pagesTBar = new JToolBar();
	String title;
	DocumentM model;
	int rows = 1;

	kontejner container = new kontejner();

	public DocumentView() {
		hideUI();
		pagesTBar.setOrientation(JToolBar.HORIZONTAL);
		pagesTBar.setFloatable(false);
		pagesTBar.setVisible(true);
		setVisible(true);
		setLayout(new BorderLayout());
		ScrollPane skrol = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		getContentPane().add(skrol);
		add(pagesTBar, BorderLayout.NORTH);
		skrol.add(container, BorderLayout.CENTER);
		skrol.setVisible(true);
		container.setLayout(new GridLayout(0, 1, 10, 10));
		JPanel pen = new JPanel();
		pen.setBackground(Color.black);
		container.addMouseListener(new ViewSelectionListener());
	}

	@SuppressWarnings("serial")
	public class kontejner extends Container {
		DocumentM modelic;

		public DocumentM getModel() {
			return modelic;
		}

		public void setModel(DocumentM m) {
			modelic = m;

		}
	}

	public void addPagePane(PageView pageV) {

		container.add(pageV);
		rows++;
		UpdateTbar();
	}

	public void UpdateTbar() {
		int pagecount = container.getComponents().length;
		pagesTBar.removeAll();
		for (int i = 1; i <= pagecount; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int cols = Integer.parseInt(((JButton) e.getSource()).getText());
					container.setLayout(new GridLayout(0, cols, 10, 10));
					container.validate();
					container.repaint();
					pack();
				}
			});
			pagesTBar.add(b);
		}
		GridLayout gL = (GridLayout) (container.getLayout());

		if (container.getComponentCount() != 0 && gL.getColumns() > container.getComponentCount()) {
			container.setLayout(new GridLayout(0, container.getComponentCount(), 10, 10));
			container.validate();
			container.repaint();
			pack();
		}
	}

	private void hideUI() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setBorder(null);
	}

	public void setTitle(String name) {
		title = name;
	}

	public DocumentM getModel() {
		return model;
	}

	public void setModel(DocumentM model) {
		this.model = model;
		container.setModel(model);
	}
}
