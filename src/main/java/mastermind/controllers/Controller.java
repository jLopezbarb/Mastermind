package mastermind.controllers;

import mastermind.models.Session;

public abstract class Controller {

    Session session;

    Controller(Session session) {
        this.session = session;
    }

    public abstract void control();

}
