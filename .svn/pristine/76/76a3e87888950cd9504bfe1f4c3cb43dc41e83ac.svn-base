package actions.AA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class ExitAction extends AbstractAction {
	public ExitAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X,
				java.awt.event.InputEvent.CTRL_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("exitaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("exitaction"));	
		putValue(SMALL_ICON, loadIcon("images/exit.png"));
	}

	private Icon loadIcon(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;

		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		} else {
			System.err.println("Resource not found: " + fileName);
		}

		return icon;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String yes=Localization.getInstance().getBundle().getString("yes");
		String no=Localization.getInstance().getBundle().getString("no");
		String check=Localization.getInstance().getBundle().getString("exitcheck");
		String title=Localization.getInstance().getBundle().getString("appname");
		AppWindow prozor = AppWindow.getInstance();
		String ObjButtons[] = {yes,no};
        int PromptResult = JOptionPane.showOptionDialog(prozor,check,title,JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        
		}
	public void updateAction(){
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("exitaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("exitaction"));
		}
}