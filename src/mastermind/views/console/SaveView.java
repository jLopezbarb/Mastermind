package mastermind.views.console;

import mastermind.controllers.SaveController;
import mastermind.utils.IO;
import mastermind.utils.YesNoDialog;
import mastermind.views.MessageView;

public class SaveView {

    void interact(SaveController saveController) {
        boolean save = new YesNoDialog().read(MessageView.SAVE.getMessage());
        if (save){
            String name = IO.readString(MessageView.NAME.getMessage());
            saveController.save(name);
        }
        saveController.next();
    }

}
