package mastermind.views.console.menu.start;

import mastermind.controllers.StartController;
import mastermind.utils.Menu;

public class StartMenu extends Menu {

    public StartMenu(StartController startController) {
        this.addCommand(new NewGameCommand(startController));
        this.addCommand(new SavedGameCommand(startController));
    }
}
