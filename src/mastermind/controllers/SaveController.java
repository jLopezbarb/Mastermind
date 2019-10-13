package mastermind.controllers;

import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Session;

public abstract class SaveController extends AcceptorController {

    public SaveController(Session session) {
        super(session);
    }

    public abstract void save(String name);

    public abstract void save();

    public abstract void next();

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
