package mastermind.views.console;

import mastermind.models.Error;
import mastermind.utils.IO;

public class ErrorView {

    private Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public void writeln(){
        IO.writeln(this.error.toString());
    }


}
