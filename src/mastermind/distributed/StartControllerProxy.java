package mastermind.distributed;

import mastermind.controllers.StartController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.models.Session;
import mastermind.distributed.dispatchers.TCPIP;

public class StartControllerProxy extends StartController {
    private TCPIP tcpip;

    public StartControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void start() {
        this.tcpip.send(FrameType.START.name());
    }

    @Override
    public String[] getGamesNames() {
        this.tcpip.send(FrameType.GAME_TITLES.name());
        int length = this.tcpip.receiveInt();
        String[] names = new String[length];
        for (int i = 0; i < length; i++) {
            names[i] = this.tcpip.receiveLine();
        }
        return names;
    }

    @Override
    public void start(String title) {
        this.tcpip.send(FrameType.LOAD_GAME.name());
        this.tcpip.send(title);
    }

}
