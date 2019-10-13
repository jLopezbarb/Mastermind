package mastermind.distributed;

import mastermind.distributed.dispatchers.FrameType;
import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;
import mastermind.distributed.dispatchers.TCPIP;

import java.util.List;

public class SessionProxy implements Session {
    private final TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }

    @Override
    public int getWidth() {
        return Combination.getWidth();
    }

    @Override
    public String getName() {
        this.tcpip.send(FrameType.GET_TITLE.name());
        return this.tcpip.receiveLine();
    }

    @Override
    public void setName(String name) {
        this.tcpip.send(FrameType.SET_TITLE.name());
        this.tcpip.send(name);
    }
}
