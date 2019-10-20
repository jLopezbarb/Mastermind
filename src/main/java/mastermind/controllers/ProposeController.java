package mastermind.controllers;

import mastermind.models.*;
import mastermind.models.Error;
import mastermind.views.console.ErrorView;
import mastermind.views.console.GameView;
import mastermind.views.console.Message;
import mastermind.views.console.ProposedCombinationView;


import java.util.List;

public class ProposeController extends Controller {


    ProposeController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        Error error;
        do{
            List<Color> colors = new ProposedCombinationView().propose();
            error = this.addCombination(colors);
            if (error != null){
                new ErrorView(error).writeln();
            }
        } while (error != null);
        new GameView().writeln(this.session);
        this.isFinished();
    }

    private Error addCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = mastermind.models.Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                Color color = colors.get(i);
                if (color == null) {
                    error = mastermind.models.Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i+1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                            break;
                        }
                    }
                }
            }
        }
        if (error == null){
            this.session.addProposedCombination(new ProposedCombination(colors));
        }
        return error;
    }

    private void isFinished() {
        if (this.session.isWinner()) {
            new ProposedCombinationView().writeln(Message.WINNER);
            this.session.next();
        } else if (this.session.isLooser()) {
            new ProposedCombinationView().writeln(Message.LOOSER);
            this.session.next();
        }
    }
}
