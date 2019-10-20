package mastermind.views.console;

import mastermind.utils.IO;

public class AttemptsView {

    public void writeln(int attempts){
        IO.writeln(Message.ATTEMPTS.replace("#attempts", String.valueOf(attempts)));
    }
}
