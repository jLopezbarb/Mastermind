package mastermind.controllers.implementation;


import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.controllers.RedoController;
import mastermind.controllers.UndoController;
import mastermind.controllers.ExitController;
import mastermind.controllers.ControllersVisitor;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

import java.util.List;

public class PlayControllerImplementation extends PlayController {

    private ProposalController proposalController;

    private UndoController undoController;

    private RedoController redoController;

    private ExitController exitController;

    PlayControllerImplementation(Session session) {
        super(session);
        this.proposalController = new ProposalController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
        this.exitController = new ExitController(this.session);
    }

    public void undo() {
        this.undoController.undo();
    }

    public Session getSession() {
        return this.session;
    }

    @Override
    public void redo() {
        this.redoController.redo();
    }

    @Override
    public boolean undoable() {
        return this.undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return this.redoController.redoable();
    }

    @Override
    public int getAttempts() {
        return this.proposalController.getAttempts();
    }

    @Override
    public List<Color> getColors(int position) {
        return this.proposalController.getColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.proposalController.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.proposalController.getWhites(position);
    }

    @Override
    public boolean isWinner() {
        return this.proposalController.isWinner();
    }

    @Override
    public boolean isLooser() {
        return this.proposalController.isLooser();
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        return this.proposalController.addProposedCombination(colors);
    }

    @Override
    public void next() {
        this.exitController.next();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
