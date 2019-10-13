package mastermind.controllers.implementation;

import mastermind.controllers.ControllersVisitor;
import mastermind.controllers.SaveController;
import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

    private SessionImplementationDAO sessionImplementationDAO;

    public SaveControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
    }

    @Override
    public void save(String name) {
        this.sessionImplementationDAO.save(name);
    }

    @Override
    public void save() {

    }

    @Override
    public void next() {
        ((SessionImplementation) this.session).next();
    }

}
