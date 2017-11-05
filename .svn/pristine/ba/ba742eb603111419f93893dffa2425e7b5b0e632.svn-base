package collection.model;

import java.io.Serializable;

import javax.swing.tree.DefaultMutableTreeNode;

import collection.controller.PageController;

@SuppressWarnings("serial")
public class PageM extends DefaultMutableTreeNode implements Serializable {

	transient PageController pageController;
	String defPageName = "Page ";
	String PageName;
	int PageIndex;

	public PageM() {
		super("Page");
	}

	public void setPageName(String PageName) {
		this.PageName = PageName;
		setUserObject(PageName);
	}

	public void defaultPageName() {
		this.PageName = (defPageName + (getParent().getIndex(this) + 1));
		setUserObject(defPageName + (getParent().getIndex(this) + 1));
	}

	public String getPageName() {
		return PageName;
	}

	public void setController(PageController pageController) {
		this.pageController = pageController;
	}

	public PageController getPageController() {
		return pageController;
	}

}
