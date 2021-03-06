package actions.AA;

import javax.swing.JTree;
import javax.swing.tree.MutableTreeNode;
import actions.addnew.NewDocumentAction;
import actions.addnew.NewGraphSlotAction;
import actions.addnew.NewPageAction;
import actions.addnew.NewProjectAction;
import actions.addnew.NewTextSlotAction;
import actions.language.LanguageEnglishAction;
import actions.language.LanguageSerbianAction;
import actions.language.LanguageSerbianCyrAction;
import actions.tile.TileCascadeAction;
import actions.tile.TileHorizontallyAction;
import actions.tile.TileMatricallyAction;
import actions.tile.TileVerticallyAction;
import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.WorkspaceM;
import collection.model.element.CircleElement;
import collection.model.element.RectangleElement;
import gui.AppWindow;
import state.actions.CopySelected;
import state.actions.CopyStablo;
import state.actions.CutSelected;
import state.actions.CutStablo;
import state.actions.DeleteSelected;
import state.actions.PasteSelected;
import state.actions.PasteStablo;
import state.actions.RotateSelectedLeft;
import state.actions.RotateSelectedRight;
import state.actions.ToCircleState;
import state.actions.ToLassoState;
import state.actions.ToRectangleState;
import state.actions.ToSelectState;

public class ActionManager {

	private static DeleteAction deleteAction;
	private static OpenProjectAction openProjectAction;
	private static CloseAllAction closeAllAction;
	private static CloseAction closeAction;
	private static NewProjectAction newProjectAction;
	private static NewDocumentAction newDocumentAction;
	private static NewPageAction newPageAction;
	private static NewGraphSlotAction newGraphSlotAction;
	private static ImportProjectAction importProjectAction;
	private static ExportProjectAction exportProjectAction;
	private static ExitAction exitAction;
	private static TileHorizontallyAction tileHorizontallyAction;
	private static TileVerticallyAction tileVerticallyAction;
	private static TileMatricallyAction tileMatricallyAction;
	private static TileCascadeAction tileCascadeAction;
	private static NextProjectAction nextProjectAction;
	private static PreviousProjectAction previousProjectAction;
	private static LanguageEnglishAction languageEnglishAction;
	private static LanguageSerbianAction languageSerbianAction;
	private static LanguageSerbianCyrAction languageSerbianCyrAction;
	private static NewTextSlotAction newTextSlotAction;
	private static ToRectangleState rectangleState;
	private static ToCircleState circleState;
	private static ToLassoState toLassoState;
	private static ToSelectState toSelectState;

	private static RotateSelectedRight rotateSelectedRight;
	private static RotateSelectedLeft rotateSelectedLeft;

	private static DeleteSelected deleteSelected;
	private static CopySelected copySelected;
	private static CutSelected cutSelected;
	private static PasteSelected pasteSelected;

	private static CopyStablo copyStablo;
	private static PasteStablo pasteStablo;
	private static CutStablo cutStablo;

	private static UndoAction undoAction;
	private static RedoAction redoAction;

	private static SwitchWorkspaceAction switchWorkspaceAction;

	public ActionManager() {
		closeAllAction = new CloseAllAction();
		closeAction = new CloseAction();

		newProjectAction = new NewProjectAction();
		newDocumentAction = new NewDocumentAction();
		newTextSlotAction = new NewTextSlotAction();
		newPageAction = new NewPageAction();
		newGraphSlotAction = new NewGraphSlotAction();

		importProjectAction = new ImportProjectAction();

		exportProjectAction = new ExportProjectAction();

		exitAction = new ExitAction();

		tileHorizontallyAction = new TileHorizontallyAction();
		tileVerticallyAction = new TileVerticallyAction();
		tileMatricallyAction = new TileMatricallyAction();
		tileCascadeAction = new TileCascadeAction();
		nextProjectAction = new NextProjectAction();
		previousProjectAction = new PreviousProjectAction();

		

		languageEnglishAction = new LanguageEnglishAction();
		languageSerbianAction = new LanguageSerbianAction();
		languageSerbianCyrAction = new LanguageSerbianCyrAction();

		rectangleState = new ToRectangleState();
		circleState = new ToCircleState();
		toLassoState = new ToLassoState();
		toSelectState = new ToSelectState();

		rotateSelectedRight = new RotateSelectedRight();
		rotateSelectedLeft = new RotateSelectedLeft();

		deleteSelected = new DeleteSelected();
		copySelected = new CopySelected();
		cutSelected = new CutSelected();
		pasteSelected = new PasteSelected();

		copyStablo = new CopyStablo();
		pasteStablo = new PasteStablo();
		cutStablo = new CutStablo();

		switchWorkspaceAction = new SwitchWorkspaceAction();
		openProjectAction = new OpenProjectAction();

		deleteAction = new DeleteAction();

		undoAction = new UndoAction();
		redoAction = new RedoAction();

	}

	public void updateActions() {
		newProjectAction.updateAction();
		newDocumentAction.updateAction();
		newPageAction.updateAction();
		newGraphSlotAction.updateAction();
		newTextSlotAction.updateAction();
		closeAction.updateAction();
		closeAllAction.updateAction();
		exitAction.updateAction();
		importProjectAction.updateAction();
		exportProjectAction.updateAction();
		tileCascadeAction.updateAction();
		tileHorizontallyAction.updateAction();
		tileMatricallyAction.updateAction();
		tileVerticallyAction.updateAction();
		nextProjectAction.updateAction();
		previousProjectAction.updateAction();

		languageSerbianCyrAction.updateAction();
		languageSerbianAction.updateAction();
		languageEnglishAction.updateAction();
		rectangleState.updateAction();
		circleState.updateAction();
		toLassoState.updateAction();
		toSelectState.updateAction();

		rotateSelectedLeft.updateAction();
		rotateSelectedRight.updateAction();

		deleteSelected.updateAction();
		copySelected.updateAction();
		cutSelected.updateAction();
		pasteSelected.updateAction();

		copyStablo.updateAction();
		pasteStablo.updateAction();
		cutStablo.updateAction();

		switchWorkspaceAction.updateAction();
		openProjectAction.updateAction();
		deleteAction.updateAction();

		undoAction.updateAction();
		redoAction.updateAction();
		
	}

	public static void setActivex() {

		switchWorkspaceAction.setEnabled(true);

		newProjectAction.setEnabled(false);
		newDocumentAction.setEnabled(false);
		newPageAction.setEnabled(false);
		newGraphSlotAction.setEnabled(false);
		newTextSlotAction.setEnabled(false);
		exportProjectAction.setEnabled(false);

		closeAction.setEnabled(false);
		closeAllAction.setEnabled(false);
		openProjectAction.setEnabled(false);
		deleteAction.setEnabled(false);
		copyStablo.setEnabled(false);
		pasteStablo.setEnabled(false);
		cutStablo.setEnabled(false);
		importProjectAction.setEnabled(false);

		nextProjectAction.setEnabled(false);
		previousProjectAction.setEnabled(false);

		JTree tree = AppWindow.getInstance().getJtree();
		MutableTreeNode node = (MutableTreeNode) tree.getLastSelectedPathComponent();

		WorkspaceM wmodel = (WorkspaceM) AppWindow.getInstance().getTreeModel().getRoot();

		if (wmodel.getChildCount() > 0) {

			closeAllAction.setEnabled(true);
			nextProjectAction.setEnabled(true);
			previousProjectAction.setEnabled(true);
		}

		if (node instanceof WorkspaceM)

		{
			importProjectAction.setEnabled(true);
			newProjectAction.setEnabled(true);
		} else if (node instanceof ProjectM)

		{
			deleteAction.setEnabled(true);
			openProjectAction.setEnabled(true);
			closeAction.setEnabled(true);
			newDocumentAction.setEnabled(true);
			exportProjectAction.setEnabled(true);
		} else if (node instanceof DocumentM)

		{
			deleteAction.setEnabled(true);
			newPageAction.setEnabled(true);
		} else if (node instanceof PageM)

		{
			deleteAction.setEnabled(true);
			newGraphSlotAction.setEnabled(true);
			newTextSlotAction.setEnabled(true);
		} else if (node instanceof SlotGM)

		{
			if (AppWindow.getInstance().isBioCutCopyStablo()) {
				pasteStablo.setEnabled(true);
			}
			deleteAction.setEnabled(true);
		} else if (node instanceof SlotTM)

		{
			deleteAction.setEnabled(true);
		} else if (node instanceof RectangleElement)

		{
			deleteAction.setEnabled(true);
			copyStablo.setEnabled(true);
			cutStablo.setEnabled(true);
		} else if (node instanceof CircleElement)

		{
			deleteAction.setEnabled(true);
			copyStablo.setEnabled(true);
			cutStablo.setEnabled(true);
		}

	}

	public CloseAllAction getCloseAllAction() {
		return closeAllAction;
	}

	public ExitAction getExitAction() {
		return exitAction;
	}

	public CloseAction getCloseAction() {
		return closeAction;
	}

	public NewPageAction getNewPageAction() {
		return newPageAction;
	}

	public NewGraphSlotAction getNewSlotAction() {
		return newGraphSlotAction;
	}

	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}

	public ImportProjectAction getImportProjectAction() {
		return importProjectAction;
	}

	public ExportProjectAction getExportProjectAction() {
		return exportProjectAction;
	}

	public TileMatricallyAction getTileMatricallyAction() {
		return tileMatricallyAction;
	}

	public TileCascadeAction getTileCascadeAction() {
		return tileCascadeAction;
	}

	public TileHorizontallyAction getTileHorizontallyAction() {
		return tileHorizontallyAction;
	}

	public TileVerticallyAction getTileVerticallyAction() {
		return tileVerticallyAction;
	}

	public static NextProjectAction getNextProjectAction() {
		return nextProjectAction;
	}

	public static PreviousProjectAction getPreviousProjectAction() {
		return previousProjectAction;
	}

	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}

	public LanguageEnglishAction getEnglishAction() {
		return languageEnglishAction;
	}

	public LanguageSerbianAction getSerbianAction() {
		return languageSerbianAction;
	}

	public LanguageSerbianCyrAction getSerbianCyrAction() {
		return languageSerbianCyrAction;
	}

	public NewTextSlotAction getTextSlotAction() {
		return newTextSlotAction;
	}

	public ToRectangleState getRectangleState() {
		return rectangleState;
	}

	public ToCircleState getCircleState() {
		return circleState;
	}

	public ToLassoState getToLassoState() {
		return toLassoState;
	}

	public ToSelectState getToSelectState() {
		return toSelectState;
	}

	public DeleteSelected getDeleteSelected() {
		return deleteSelected;
	}

	public CopySelected getCopySelected() {
		return copySelected;
	}

	public CutSelected getCutSelected() {
		return cutSelected;
	}

	public PasteSelected getPasteSelected() {
		return pasteSelected;
	}

	public CutStablo getCutStablo() {
		return cutStablo;
	}

	public CopyStablo getCopyStablo() {
		return copyStablo;
	}

	public PasteStablo getPasteStablo() {
		return pasteStablo;
	}

	public SwitchWorkspaceAction getSwitchWorkspaceAction() {
		return switchWorkspaceAction;
	}

	public OpenProjectAction getOpenProjectAction() {
		return openProjectAction;
	}

	public DeleteAction getDeleteAction() {
		return deleteAction;
	}

	public static RotateSelectedRight getRotateSelectedRight() {
		return rotateSelectedRight;
	}

	public static RotateSelectedLeft getRotateSelectedLeft() {
		return rotateSelectedLeft;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

}
