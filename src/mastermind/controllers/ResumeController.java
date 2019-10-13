package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class ResumeController extends AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

	public void resume(boolean newGame) {
		if (newGame) {
            ((SessionImplementation) this.session).resume();
		} else {
            ((SessionImplementation) this.session).next();
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}



}
