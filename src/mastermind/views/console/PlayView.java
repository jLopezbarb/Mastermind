package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.WithConsoleView;
import mastermind.views.console.menu.play.PlayMenu;

class PlayView extends WithConsoleView {

    void interact(PlayController playController) {
        new PlayMenu(playController).execute();

    }
}
