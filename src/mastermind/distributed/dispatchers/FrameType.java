package mastermind.distributed.dispatchers;

public enum FrameType {
    START,
    STATE,
    PROPOSE,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    NEW_GAME,
    CLOSE,

    COLORS,
    ATTEMPTS,
    BLACKS,
    WHITES,

    WINNER,
    LOOSER,
    NEXT,

    GET_TITLE,
    SET_TITLE,
    LOAD_GAME,
    GAME_TITLES,
    SAVE;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
