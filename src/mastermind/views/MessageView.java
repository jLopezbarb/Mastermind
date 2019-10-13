package mastermind.views;

public enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-("),
    SAVE("Do you want to save the game?"),
    NAME("Name: "),
    NEW_GAME("Start new game"),
    SAVED_GAME("Open a saved game");

	private String message;
	
	MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
