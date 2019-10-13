package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.StartControllerImplementation;

public class GameTitlesDispatcher extends Dispatcher {

    public GameTitlesDispatcher(StartControllerImplementation startControllerImplementation) {
        super(startControllerImplementation);
    }

    @Override
    public void dispatch() {
        String[] names = ((StartControllerImplementation) this.acceptorController).getGamesNames();
        this.tcpip.send(names.length);
        for (String name : names) {
            this.tcpip.send(name);
        }
    }

}
