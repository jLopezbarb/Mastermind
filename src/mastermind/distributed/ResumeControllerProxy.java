package mastermind.distributed;

import mastermind.controllers.ResumeController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.models.Session;
import mastermind.distributed.dispatchers.TCPIP;


public class ResumeControllerProxy extends ResumeController {

    private TCPIP tcpip;

    public ResumeControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void resume(boolean newGame) {
        this.tcpip.send(FrameType.NEW_GAME.name());
        this.tcpip.send(newGame);
    }

}
