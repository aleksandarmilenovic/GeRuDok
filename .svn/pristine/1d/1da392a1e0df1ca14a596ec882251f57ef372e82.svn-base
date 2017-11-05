package collection.view.slot;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;
import collection.model.SlotGM;
import collection.model.element.ElementHandle;
import collection.model.element.ElementHandles;
import gui.AppWindow;
import gui.PopupGraph;
import state.LassoState;
import state.MoveState;
import state.ResizeState;
import state.SelectState;
import state.StateManager;

@SuppressWarnings("serial")
public class GraphEditingWindow extends JDialog implements Observer {

	private GraphEditingWindow instance;
	private SlotGM gMslot;
	private GraphSlotCanvas canvas;
	private GraphSlotToolbar toolbar;
	private PopupGraph meni;
	boolean stateCheck = false;

	public GraphEditingWindow(SlotGM model) {
		gMslot = model;
		AppWindow.getInstance().getJtree().setSelectionPath(new TreePath(model.getPath()));
		initDialog();
		createCanvas();
		initToolbar();
		instance = this;
	}

	public void initDialog() {
		setTitle(gMslot.toString());
		setSize(500, 500);
		setMinimumSize(new Dimension(400, 400));
		setMaximumSize(new Dimension(500, 500));
		setResizable(false);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/collection/view/slot/slotM.png");
		this.setIconImage(img);
		setAlwaysOnTop(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				((StateManager) gMslot.getStateManager()).resetCurrentState();
				gMslot.getElementSelectionManager().removeAllFromSelectionList();
				gMslot.getSlotController().getGraphSlotView().repaint();
			}
		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLocationRelativeTo(AppWindow.getInstance());
	}

	public void createCanvas() {
		GraphController controller = new GraphController();
		canvas = new GraphSlotCanvas(gMslot);
		canvas.addMouseListener(controller);
		canvas.addMouseMotionListener(controller);
		add(canvas, BorderLayout.CENTER);
	}

	public void initToolbar() {
		toolbar = new GraphSlotToolbar();
		add(toolbar, BorderLayout.PAGE_START);
	}

	public SlotGM getModel() {
		return gMslot;
	}

	public GraphSlotView getView() {
		return getModel().getSlotController().getGraphSlotView();
	}

	@Override
	public void update(Observable o, Object arg) {

		if (arg instanceof Rectangle2D) {
			canvas.setPaint((Rectangle2D) arg, true);

		} else {
			canvas.turnOFF();
			repaint();
		}

		repaint();
		canvas.repaint();
	}

	public class GraphController extends MouseAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			setMouseCursor(e.getPoint());
		}

		public void mouseClicked(MouseEvent e) {
			if (SwingUtilities.isRightMouseButton(e)) {
				meni = new PopupGraph();
				meni.show(instance, e.getX(), e.getY());

			}
		}

		@SuppressWarnings("static-access")
		@Override
		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				canvas.startingPoint = e.getPoint();
				canvas.transformToUserSpace(canvas.startingPoint);
				getView().repaint();
				repaint();
			}
			gMslot.getStateManager().getCurrentState().mousePressed(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			((StateManager) gMslot.getStateManager()).getCurrentState().mouseReleased(e);
			getView().repaint();
			repaint();
			update(null, gMslot.getNotif());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			update(null, gMslot.getNotif());
			((StateManager) gMslot.getStateManager()).getCurrentState().mouseDragged(e);
			getView().repaint();
			repaint();
		}
	}

	public void setMouseCursor(Point2D point) {

		ElementHandles handles = gMslot.getElementSelectionManager().handleHit(point);
		ElementHandle.Handles handle = null;

		if (handles != null) {
			for (ElementHandle elementHandle : handles.getHandles()) {
				if (elementHandle.contains(point)) {
					handle = elementHandle.getHandleType();
				}
			}
		}
		if (gMslot.getStateManager().getCurrentState() instanceof LassoState) {
			Cursor kresor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
			canvas.setCursor(kresor);
		} else {
			if ((gMslot.getStateManager().getCurrentState() instanceof SelectState)
					|| (gMslot.getStateManager().getCurrentState() instanceof MoveState)
					|| (gMslot.getStateManager().getCurrentState() instanceof ResizeState)) {
				stateCheck = true;
			} else
				stateCheck = false;

			if (stateCheck && handle != null) {

				Cursor cursor = null;

				switch (handle) {
				case CENTER:
					cursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
					break;
				case NORTH:
					cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
					break;
				case SOUTH:
					cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
					break;
				case EAST:
					cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
					break;
				case  WEST:
					cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
					break;
				case SOUTHEAST:
					cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
					break;
				case NORTHWEST:
					cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
					break;
				case SOUTHWEST:
					cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
					break;
				case NORTHEAST:
					cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
					break;
				}
				canvas.setCursor(cursor);
			} else {
				canvas.setCursor(Cursor.getDefaultCursor());
			}
		}

	}

	public GraphSlotCanvas getCanvas() {
		return canvas;
	}
}