package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.CommandHistory;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;

public class HistoryCommandTest {
    private HistoryCommand historyCommand = new HistoryCommand();
    private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private CommandHistory history = new CommandHistory();

    private String successCommand = new String();

    @Test
    public void execute() {
        historyCommand.setData(emptyAddressBook, emptyPersonList, history);
        CommandResult result = historyCommand.execute();
        assertEquals(HistoryCommand.MESSAGE_NO_HISTORY, result.feedbackToUser);

        String command1 = "add";
        history.addHistory(command1);
        successCommand = successCommand.concat(String.format(historyCommand.MESSAGE_SUCCESS, String.join("\n", history.showHistory())));

        result = historyCommand.execute();
        assertEquals(successCommand, result.feedbackToUser);

        String command2 = "randomCommand";
        String command3 = "select 1";
        history.addHistory(command2);
        history.addHistory(command3);
        successCommand = successCommand.concat("\n" + command2);
        successCommand = successCommand.concat("\n" + command3);
        result = historyCommand.execute();
        assertEquals(successCommand, result.feedbackToUser);
    }
}
