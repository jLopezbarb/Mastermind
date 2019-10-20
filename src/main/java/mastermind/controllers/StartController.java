package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.console.SecretCombinationView;
import mastermind.views.console.StartView;

public class StartController extends Controller {

    StartController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        new StartView().writeln();
        new SecretCombinationView().writeln(this.session.getWidth());
        this.session.next();
    }


}
