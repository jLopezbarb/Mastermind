package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.StartControllerImplementation;

public class LoadGameDispatcher extends Dispatcher {

    public LoadGameDispatcher(StartControllerImplementation startControllerImplementation) {
        super(startControllerImplementation);
    }

    @Override
    public void dispatch() {
        String title = this.tcpip.receiveLine();
        ((StartControllerImplementation) this.acceptorController).start(title);
    }

}