package mastermind.models;

public class State {
		
	private StateValue stateValue;
	
	State() {
		this.stateValue = StateValue.INITIAL;
	}
	
	public void next() {
		this.stateValue = StateValue.values()[this.stateValue.ordinal()+1];
	}
	
	void reset() {
		this.stateValue = StateValue.INITIAL;
	}

	StateValue getValueState() {
		return this.stateValue;
	}

	void setStateValue(StateValue stateValue){
	    this.stateValue = stateValue;
    }
}
