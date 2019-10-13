package mastermind.distributed;

import mastermind.controllers.SaveController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Session;

public class SaveControllerProxy extends SaveController {

    private TCPIP tcpip;

    SaveControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void save(String name) {
        this.tcpip.send(FrameType.SAVE.name());
        this.tcpip.send(name);
    }

    @Override
    public void save() {

    }

    @Override
    public void next() {
        this.tcpip.send(FrameType.NEXT.name());
    }
}
