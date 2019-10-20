package mastermind.views.console;

import mastermind.models.Session;

public class GameView {

    public void writeln(Session session) {
        new AttemptsView().writeln(session.getAttempts());
        new SecretCombinationView().writeln(session.getWidth());
        for (int i = 0; i < session.getAttempts(); i++) {
            this.writeCombination(session, i);
        }
    }

    private void writeCombination(Session session, int attempt){
        new CombinationView().write(session.getCombination(attempt));
        new ResultView().writeln(session.getResult(attempt));
    }
}
