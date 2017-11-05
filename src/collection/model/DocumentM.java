package collection.model;

import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;
import collection.controller.DocumentController;
import gui.AppWindow;

@SuppressWarnings("serial")
public class DocumentM extends DefaultMutableTreeNode implements Serializable {
	transient DocumentController documentController;

	String defDocumentName = "Document ";
	String DocumentName;

	public DocumentM() {
		super("Document");
		AppWindow.getInstance().setDokumentIndex(AppWindow.getInstance().getDokumentIndex() + 1);

	}

	public void setDocumentName(String DocumentName) {
		this.DocumentName = DocumentName;
		setUserObject(DocumentName);
	}

	public void defaultDocumentName() {
		this.DocumentName = (defDocumentName + (getParent().getIndex(this) + 1));
		setUserObject(defDocumentName + (getParent().getIndex(this) + 1));
	}

	public String getDocumentName() {
		return DocumentName;
	}

	public void setController(DocumentController documentController) {
		this.documentController = documentController;
	}

	public DocumentController getController() {
		return documentController;
	}

}
