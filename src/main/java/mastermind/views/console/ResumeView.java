package mastermind.views.console;

import mastermind.utils.YesNoDialog;

public class ResumeView {

    public boolean newGame(){
        return new YesNoDialog().read(Message.RESUME);
    }
}
