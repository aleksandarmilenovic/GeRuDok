package collection.view.slot;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;

import collection.model.SlotTM;
import gui.AppWindow;

@SuppressWarnings("serial")
public class TextEditingWindow extends JDialog {

	private SlotTM mModel;
	private TextEditingArea mArea;

	private static TextEditingWindow instance = null;

	public static TextEditingWindow getInstance(SlotTM textSlot) {
		if (instance == null) {
			instance = new TextEditingWindow(textSlot);
		}
		return instance;
	}

	public static TextEditingWindow getInstance() {

		return instance;
	}

	public TextEditingWindow(SlotTM model) {
		mModel = model;
		initTextArea();
		initDialog();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				mModel.setContent(mArea.getText());
				mModel.notifyObservers();
				instance = null;
			}
		});
	};

	public void initDialog() {
		setTitle(mModel.toString());
		setSize(640, 480);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(AppWindow.getInstance());
	}

	public void initTextArea() {
		mArea = new TextEditingArea(mModel.getContent());
		mArea.setEditable(true);
		add(mArea, BorderLayout.CENTER);
	}

	public TextEditingArea getmArea() {
		return mArea;
	}

	public void setmArea(TextEditingArea mArea) {
		this.mArea = mArea;
	}
}
