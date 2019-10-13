package mastermind.views.console.menu.play;

public enum CommandTitle {

    PROPOSE_COMMAND("Propose Combination"),
    UNDO_COMMAND("Undo previous Proposal"),
    REDO_COMMAND("Redo previous Proposal"),
    EXIT_COMMAND("Exit game");

    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
