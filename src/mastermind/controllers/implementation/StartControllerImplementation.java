package mastermind.controllers.implementation;

import mastermind.controllers.ControllersVisitor;
import mastermind.controllers.StartController;
import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

    private SessionImplementationDAO sessionImplementationDAO;

    public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    public void start() {
        ((SessionImplementation)this.session).next();
    }

    @Override
    public String[] getGamesNames() {
        return this.sessionImplementationDAO.getGamesNames();
    }

    @Override
    public void start(String title) {
        this.sessionImplementationDAO.load(title);
    }
}
