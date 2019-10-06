package mastermind.views.console;

import mastermind.controllers.ProposeController;
import mastermind.models.Error;
import mastermind.utils.IO;

public class ProposedCombinationView  {

    protected final ProposeController controller;

    ProposedCombinationView(ProposeController controller){
        this.controller = controller;
    }

    void writeAttemps() {
        IO.writeln(Message.ATTEMPTS.replaceAll("#attempts", "" + this.controller.getAttemps()));
    }

    void writeGameInfo() {
        for (int i = 0; i < this.controller.getAttemps(); i++) {
            IO.write(this.controller.getProposedCombinations().get(i).toString());
            IO.writeln(this.controller.getResults().get(i).toString());
        }
    }

    void propose() {
        Error error;
        String characters;
        do {
            characters = IO.readString(Message.PROPOSED_COMBINATION);
            error = this.controller.isCorrectCombination(characters);
            if (error != null){
                IO.writeln(error.toString());
            }
        } while (error != null);
        this.controller.addCombination(characters);
    }
}
