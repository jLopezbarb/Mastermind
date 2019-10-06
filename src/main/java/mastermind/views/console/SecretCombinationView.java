package mastermind.views.console;

import mastermind.controllers.ProposeController;
import mastermind.utils.IO;

public class SecretCombinationView {

    protected final ProposeController controller;

    SecretCombinationView(ProposeController controller){
        this.controller = controller;
    }

    void writeln(){
        IO.writeln(this.controller.getSecretCombination().toString());
    }
}
