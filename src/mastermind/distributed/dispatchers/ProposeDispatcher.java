package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public class ProposeDispatcher extends Dispatcher{


    public ProposeDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int length = this.tcpip.receiveInt();
        List<Color> colors = new ArrayList();
        for (int i=0; i<length; i++) {
            colors.add(this.tcpip.receiveColor());
        }
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).addProposedCombination(colors));
    }
}
