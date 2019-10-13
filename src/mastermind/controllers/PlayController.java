package mastermind.controllers;

import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

import java.util.List;

public abstract class PlayController extends AcceptorController{

    protected PlayController(Session session) {
        super(session);
    }

    public abstract void undo();

    public abstract void redo();

    public abstract boolean undoable();

    public abstract boolean redoable();

    public abstract int getAttempts();

    public abstract List<Color> getColors(int position);

    public abstract int getBlacks(int position);

    public abstract int getWhites(int position);

    public abstract boolean isWinner();

    public abstract boolean isLooser();

    public abstract Error addProposedCombination(List<Color> colors);

    public abstract void next();

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
