package mastermind.views.console.menu.play;

import mastermind.controllers.PlayController;
import mastermind.views.console.GameView;
import mastermind.views.console.ProposalView;
import mastermind.views.console.WinnerView;
import mastermind.views.console.menu.Command;

public class ProposeCommand extends Command {


    public ProposeCommand(PlayController playController) {
        super(CommandTitle.PROPOSE_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        new ProposalView().interact(this.playController);
        new GameView(playController);
        new WinnerView(playController);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
