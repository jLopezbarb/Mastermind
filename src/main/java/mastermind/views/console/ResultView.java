package mastermind.views.console;

import mastermind.models.Result;
import mastermind.utils.IO;

public class ResultView {

    public void writeln(Result result) {
        IO.writeln(Message.RESULT.replace("#blacks", String.valueOf(result.getBlacks()))
                .replace("#whites", String.valueOf(result.getWhites())));
    }
}
