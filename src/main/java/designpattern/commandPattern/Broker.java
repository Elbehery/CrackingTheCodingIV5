package designpattern.commandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 03.04.16.
 */
public class Broker {
    private List<Command> commands = new ArrayList<Command>();

    public void takeCommand(Command command) {
        commands.add(command);
    }

    public void placeCommands() {

        for (Command command : commands) {
            command.execute();
        }

        commands.clear();
    }
}
