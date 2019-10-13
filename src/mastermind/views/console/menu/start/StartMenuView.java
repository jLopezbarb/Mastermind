package mastermind.views.console.menu.start;

import mastermind.controllers.StartController;
import mastermind.utils.Menu;

class StartMenuView extends Menu {

    StartMenuView(StartController startController){
        String[] gamesNames = startController.getGamesNames();
        for (String title : gamesNames) {
            this.addCommand(new GameSelectCommand(title, startController));
        }
    }
}
