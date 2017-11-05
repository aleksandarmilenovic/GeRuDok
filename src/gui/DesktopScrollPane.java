package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

@SuppressWarnings("serial")
public class DesktopScrollPane extends JScrollPane {

	private JDesktopPane desktopPane;
	private InternalFrameComponentListener componentListener;

	public DesktopScrollPane(JDesktopPane desktopPane) {

		componentListener = new InternalFrameComponentListener();
		this.desktopPane = desktopPane;
		desktopPane.addContainerListener(new ContainerListener() {
			@Override
			public void componentAdded(ContainerEvent e) {
				onComponentAdded(e);
			}

			@Override
			public void componentRemoved(ContainerEvent e) {
				onComponentRemoted(e);
			}
		});
		setViewportView(desktopPane);

		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

	private void onComponentRemoted(ContainerEvent event) {
		Component removedComponent = event.getChild();
		if (removedComponent instanceof JInternalFrame)
			removedComponent.removeComponentListener(componentListener);

	}

	private void onComponentAdded(ContainerEvent event) {
		Component addedComponent = event.getChild();
		if (addedComponent instanceof JInternalFrame) {
			addedComponent.addComponentListener(componentListener);
			resizeDesktop();
		}
	}

	public JInternalFrame[] getAllFrames() {
		return desktopPane.getAllFrames();
	}

	public void setDesktopSize(Dimension dim) {
		desktopPane.setPreferredSize(dim);
		desktopPane.revalidate();
	}

	public void resizeDesktop() {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				Rectangle viewPort = getViewport().getViewRect();

				int maxX = viewPort.width + viewPort.x, maxY = viewPort.height + viewPort.y;
				int minX = viewPort.x, minY = viewPort.y;

				JInternalFrame frame = null;
				JInternalFrame[] frames = getAllFrames();

				for (int i = 0; i < frames.length; i++) {

					frame = frames[i];

					if (frame.getX() < minX) {
						minX = frame.getX();
					}
					if ((frame.getX() + frame.getWidth()) > maxX) {
						maxX = frame.getX() + frame.getWidth();
					}

					if (frame.getY() < minY) {
						minY = frame.getY();
					}
					if ((frame.getY() + frame.getHeight()) > maxY) {
						maxY = frame.getY() + frame.getHeight();
					}
				}

				if (minX < 0)
					minX = 0;
				if (minY < 0)
					minY = 0;

				setVisible(false);

				if (minX != 0 || minY != 0) {

					for (int i = 0; i < frames.length; i++) {
						frame = frames[i];
						frame.setLocation(frame.getX() - minX, frame.getY() - minY);
					}

					JViewport view = getViewport();
					view.setViewSize(new Dimension((maxX - minX), (maxY - minY)));
					view.setViewPosition(new Point((viewPort.x - minX), (viewPort.y - minY)));
					setViewport(view);
				}

				setDesktopSize(new Dimension(maxX - minX, maxY - minY));
				setVisible(true);

			}
		});
	}

	private class InternalFrameComponentListener implements ComponentListener {

		@Override
		public void componentResized(ComponentEvent e) {
			resizeDesktop();
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			resizeDesktop();
		}

		@Override
		public void componentShown(ComponentEvent e) {
		}

		@Override
		public void componentHidden(ComponentEvent e) {
		}
	}
}
