package commands;

import java.io.Serializable;
import java.util.ArrayList;

import gui.AppWindow;

@SuppressWarnings("serial")
public class CommandManager implements Serializable {

	private ArrayList<Command> commands;
	private int currentCommandIndex = 0;

	public ArrayList<Command> getCommands() {
		return commands;
	}

	public int getCurrentCommandIndex() {
		return currentCommandIndex;
	}

	public void setCurrentCommandIndex(int currentCommandIndex) {
		this.currentCommandIndex = currentCommandIndex;
	}

	public CommandManager() {
		commands = new ArrayList<Command>();
	}

	public void addCommand(Command newCommand) {
		while (currentCommandIndex < commands.size()) {
			commands.remove(currentCommandIndex);
		}
		commands.add(newCommand);
		doCommand();
	}

	public void doCommand() {
		if (currentCommandIndex < commands.size()) {
			if (commands.get(currentCommandIndex) instanceof RotateCommand) {
				commands.get(currentCommandIndex).doCommand();
			} else
				commands.get(currentCommandIndex).doCommand();
			currentCommandIndex++;
			AppWindow.getInstance().getActionManager().getUndoAction().setEnabled(true);
		}
		if (currentCommandIndex == commands.size()) {
			AppWindow.getInstance().getActionManager().getRedoAction().setEnabled(false);
		}
	}

	public void undoCommand() {
		if (currentCommandIndex > 0) {
			currentCommandIndex--;
			if (commands.get(currentCommandIndex) instanceof RotateCommand) {
				commands.get(currentCommandIndex).undoCommand();
			} else
				commands.get(currentCommandIndex).undoCommand();
			AppWindow.getInstance().getActionManager().getRedoAction().setEnabled(true);
		}
		if (currentCommandIndex == 0) {
			AppWindow.getInstance().getActionManager().getUndoAction().setEnabled(false);
		}
	}
}
