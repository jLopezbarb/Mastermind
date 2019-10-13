package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;
import mastermind.views.console.menu.start.StartMenu;

class StartView extends WithConsoleView {
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		this.console.writeln(MessageView.TITLE.getMessage());
        new StartMenu(startController).execute();
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
