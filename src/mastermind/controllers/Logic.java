package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.Session;
import mastermind.models.StateValue;

public class Logic {
	
	protected Session session;

    protected Map<StateValue, AcceptorController> acceptorControllers;
		
	public Logic() {
        this.acceptorControllers = new HashMap();
	}
	
	public AcceptorController getController() {
		return this.acceptorControllers.get(this.session.getValueState());
	}
	
}
