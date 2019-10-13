package mastermind.distributed;

import mastermind.controllers.implementation.LogicImplementation;
import mastermind.distributed.dispatchers.*;
import mastermind.models.DAO.SessionImplementationDAO;

public class LogicImplementationServer extends LogicImplementation {

    public LogicImplementationServer(SessionImplementationDAO sessionImplementationDAO) {
        super(sessionImplementationDAO);
    }

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.PROPOSE, new ProposeDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.COLORS, new ColorDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.BLACKS, new BlackDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.WHITES, new WhiteDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_TITLE, new GetTitleDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SET_TITLE, new SetTitleDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.GAME_TITLES, new GameTitlesDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.LOAD_GAME, new LoadGameDispatcher(this.startControllerImplementation));
    }
}
