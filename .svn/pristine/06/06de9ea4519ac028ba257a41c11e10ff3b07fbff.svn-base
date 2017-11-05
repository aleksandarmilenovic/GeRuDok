package gui;

import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.WorkspaceM;

public class BorderUnselector {

	public BorderUnselector() {

		AppWindow.getInstance().getStatusBar().setStatusLabelText("");
		WorkspaceM vork = (WorkspaceM) AppWindow.getInstance().getTreeModel().getRoot();

		for (int i = 0; i < vork.getChildCount(); i++) {

			ProjectM projekt = (ProjectM) vork.getChildAt(i);

			for (int j = 0; j < projekt.getChildCount(); j++) {

				DocumentM dokument = (DocumentM) projekt.getChildAt(j);

				for (int k = 0; k < dokument.getChildCount(); k++) {

					PageM pejdz = (PageM) dokument.getChildAt(k);
					try {
						pejdz.getPageController().getPageView().setUnselectedBorder();
					} catch (Throwable e) {

					}

					for (int l = 0; l < pejdz.getChildCount(); l++) {
						if (pejdz.getChildAt(l) instanceof SlotGM) {
							try {
								((SlotGM) pejdz.getChildAt(l)).getSlotController().getGraphSlotView()
										.setSlotStampUnselected();
							} catch (Throwable e) {

							}
						}

						if (pejdz.getChildAt(l) instanceof SlotTM) {
							try {
								((SlotTM) pejdz.getChildAt(l)).getTextslotcontroller().getTextSlotView()
										.setSlotStampUnselected();
							} catch (Throwable e) {

							}
						}
					}

				}
			}
		}

		try {
			finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
