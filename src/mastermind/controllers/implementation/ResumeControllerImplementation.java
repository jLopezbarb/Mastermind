package mastermind.controllers.implementation;

import mastermind.controllers.ControllersVisitor;
import mastermind.controllers.ResumeController;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

    public ResumeControllerImplementation(Session session) {
        super(session);
    }

    public void resume(boolean newGame) {
        if (newGame) {
            ((SessionImplementation) this.session).resume();
        } else {
            ((SessionImplementation)this.session).next();
        }
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }


}
