package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public abstract class Mastermind {

	private Logic logic;
	private View view;

	protected Mastermind() {
		this.logic = this.createLogic();
		this.view = new ConsoleView();
	}


	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null) {
                this.view.interact(acceptorController);
            }
		} while (acceptorController != null);
	}

	protected abstract Logic createLogic();
	
}

