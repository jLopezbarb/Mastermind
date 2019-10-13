package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.types.Color;

import java.util.List;

public class ColorDispatcher extends Dispatcher{

    public ColorDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        List<Color> colors = ((PlayControllerImplementation) this.acceptorController).getColors(position);
        this.tcpip.send(colors.size());
        for (Color color: colors) {
            this.tcpip.send(color);
        }
    }
}
