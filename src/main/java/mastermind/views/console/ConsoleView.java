package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.controllers.StartController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.ProposeController;
import mastermind.utils.YesNoDialog;
import mastermind.views.View;

public class ConsoleView extends View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController controller) {
        controller.start();
    }

    @Override
    public void visit(ProposeController proposeController) {
        new GameView(proposeController).writeln();
        proposeController.finish();
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(Message.RESUME));
    }

}
