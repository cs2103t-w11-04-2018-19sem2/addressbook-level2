package seedu.addressbook.data;

import java.util.ArrayList;

/**
 * Represents the history of the inputs entered by user.
 */
public class CommandHistory {
    /** The list of command history */
    private ArrayList<String> commandHistory;

    public CommandHistory() {
        this.commandHistory = new ArrayList<>();
    }

    public void addHistory(String command) {
        this.commandHistory.add(command);
    }

    public boolean isEmpty() {
        return this.commandHistory.isEmpty();
    }

    /** Return a string array representation of the input history list */
    public String[] showHistory() {
        return this.commandHistory.toArray(new String[0]);
    }
}
