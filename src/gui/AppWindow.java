package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import actions.AA.ActionManager;
import actions.AA.ExitAction;
import collection.model.DocumentM;
import collection.model.SlotGM;
import collection.model.element.Element;
import collection.view.ViewSelectionListener;
import commands.CommandManager;
import localization.Localization;
import tree.TreeM;
import tree.TreePanel;

@SuppressWarnings("serial")
public class AppWindow extends JFrame {

	// Deklaracija promenljivih
	private static AppWindow instance = null;
	private ActionManager actionManager;
	private Tulbar tulbar;
	private Menu menu;
	private JDesktopPane desktop = new JDesktopPane();
	private JPanel rightPanel;
	private ResourceBundle resourceBundle;
	private TreeM treeModel;
	private JTree jtree;
	private Popup popup;
	private StatusBar statusBar;

	public StatusBar getStatusBar() {
		return statusBar;
	}
	// Globalne promenljive za Cut/Copy/Paste grafickih elemenata
	private ArrayList<Element> grafickiElementiCopyCut; // lista za kopiranje,
														// clear na svakom
														// copy/cut-u
	private boolean bioCut = false;
	private CommandManager commandManager;
	private int dokumentIndex;

	private SlotGM izvorniSlotCopyCut;
	private boolean bioCutCopyStablo = false;
	private boolean bioPaste = false;
	private int pastePomeraj = 0;
	private int flag = 1;
	private DocumentM izvorniDokumentCopyCut;

	public DocumentM getIzvorniDokumentCopyCut() {
		return izvorniDokumentCopyCut;
	}

	public void setIzvorniDokumentCopyCut(DocumentM izvorniDokumentCopyCut) {
		this.izvorniDokumentCopyCut = izvorniDokumentCopyCut;
	}

	// Kreiranje prozora
	public static AppWindow getInstance() {
		if (instance == null) {
			instance = new AppWindow();
			instance.init();
		}
		return instance;
	}
	private void init() {
		commandManager = new CommandManager();
		actionManager = new ActionManager();
		dokumentIndex = 0;
		initGui();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grafickiElementiCopyCut = new ArrayList<Element>();
	}

	private void initGui() {
		popup = new Popup();
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File("src\\gui\\images\\bumerangLogoSmall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setIconImage(logo);
		
		menu = new Menu();
		setJMenuBar(menu);
		tulbar = new Tulbar();
		getContentPane().add(tulbar, BorderLayout.NORTH);
		desktop.setBackground(Color.WHITE);
		desktop.setVisible(true);
		DesktopScrollPane deskSkrol = new DesktopScrollPane(desktop);
		deskSkrol.setMinimumSize(new Dimension(200, 150));
		TreePanel trek = new TreePanel();
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, trek, deskSkrol);
		split.setDividerLocation(250);
		add(split, BorderLayout.CENTER);
		setSize(1000, 800);
		setMinimumSize(new Dimension(500, 400));
		setLocationRelativeTo(null);
		setTitle(Localization.getInstance().getBundle().getString("appname"));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		statusBar = new StatusBar();
		this.getContentPane().add(statusBar, BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				ExitAction exit = new ExitAction();
				ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null);
				exit.actionPerformed(e);
			}
		});
		desktop.addMouseListener(new ViewSelectionListener());
		ActionManager.setActivex();
		popup.setActivex();
	}

	public void updateComponent() {
		setTitle(Localization.getInstance().getBundle().getString("appname"));
	}

	// Konstruktor,prazan (Ne poziva se direktno)
	public AppWindow() {

	}

	// Geteri i seteri
	public void setJtree(JTree jtree) {
		this.jtree = jtree;
	}

	public Tulbar getTulbar() {
		return tulbar;
	}

	public void setTulbar(Tulbar tulbar) {
		this.tulbar = tulbar;
	}

	public static void setInstance(AppWindow instance) {
		AppWindow.instance = instance;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	public void setPopup(Popup popup) {
		this.popup = popup;
	}

	public void setGrafickiElementiCopyCut(ArrayList<Element> grafickiElementiCopyCut) {
		this.grafickiElementiCopyCut = grafickiElementiCopyCut;
	}

	public JTree getJtree() {
		return jtree;
	}

	public void setTreeModel(TreeM treeModel) {
		this.treeModel = treeModel;
	}

	public TreeM getTreeModel() {
		return treeModel;
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public JDesktopPane getDesktop() {
		return desktop;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public SlotGM getIzvorniSlotCopyCut() {
		return izvorniSlotCopyCut;
	}

	public void setIzvorniSlotCopyCut(SlotGM izvorniSlotCopyCut) {
		this.izvorniSlotCopyCut = izvorniSlotCopyCut;
	}

	public int getDokumentIndex() {
		return dokumentIndex;
	}

	public void setDokumentIndex(int dokumentIndex) {
		this.dokumentIndex = dokumentIndex;
	}

	public boolean isBioCut() {
		return bioCut;
	}

	public void setBioCut(boolean bioCut) {
		this.bioCut = bioCut;
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public Menu getMenu() {
		return menu;
	}

	public Popup getPopup() {
		return popup;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public boolean isBioPaste() {
		return bioPaste;
	}

	public void setBioPaste(boolean bioPaste) {
		this.bioPaste = bioPaste;
	}

	public ArrayList<Element> getGrafickiElementiCopyCut() {
		return grafickiElementiCopyCut;
	}

	public boolean isBioCutCopyStablo() {
		return bioCutCopyStablo;
	}

	public void setBioCutCopyStablo(boolean bioCutCopyStablo) {
		this.bioCutCopyStablo = bioCutCopyStablo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getPastePomeraj() {
		return pastePomeraj;
	}

	public void setPastePomeraj(int pastePomeraj) {
		this.pastePomeraj = pastePomeraj;
	}
}