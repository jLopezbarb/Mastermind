package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.console.ResumeView;

public class ResumeController extends Controller{

    ResumeController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        if (new ResumeView().newGame()){
            this.session.reset();
        } else{
            this.session.next();
        }
    }

}
