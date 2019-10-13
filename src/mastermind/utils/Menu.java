package mastermind.utils;

import java.util.ArrayList;

public class Menu {

    private static final String OPTION = "----- Choose an option ----- ";
    private ArrayList<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList();
        for (Command command : this.commandList) {
            if (command.isActive()) {
                commands.add(command);
            }
        }
        boolean error;
        int option;
        do {
            error = false;
            IO.writeln(OPTION);
            for (int i = 0; i < commands.size(); i++) {
                IO.writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            option = IO.readInt("") - 1;
            if (!new ClosedInterval(0, commands.size() - 1).includes(option)) {
                error = true;
            }
            IO.writeln();
        } while (error);
        commands.get(option).execute();
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }

}
