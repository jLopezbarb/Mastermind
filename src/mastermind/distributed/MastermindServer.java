package mastermind.distributed;

import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.models.DAO.SessionImplementationDAO;

public class MastermindServer {
    private DispatcherPrototype dispatcherPrototype;

    private LogicImplementationServer logicServer;

    private MastermindServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicImplementationServer(new SessionImplementationDAO());
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }
}
