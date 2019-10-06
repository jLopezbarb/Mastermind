package mastermind.views;

import mastermind.controllers.Controller;
import mastermind.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public abstract void interact(Controller controller);

}
