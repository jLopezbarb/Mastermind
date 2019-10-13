package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class WhiteDispatcher extends Dispatcher {

    public WhiteDispatcher(PlayControllerImplementation playControllerImplementation){
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getWhites(position));
    }
}
