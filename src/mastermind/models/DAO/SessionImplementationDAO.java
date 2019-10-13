package mastermind.models.DAO;

import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;

import java.io.*;

public class SessionImplementationDAO {

    private static final String EXTENSION = ".mastermind";

    private static final String DIRECTORY = System.getProperty("user.dir") + "/partidas";

    private static File directory;

    static {
        SessionImplementationDAO.directory = new File(SessionImplementationDAO.DIRECTORY);
        if (!SessionImplementationDAO.directory.exists()) {
            SessionImplementationDAO.directory.mkdir();
        }
    }

    private SessionImplementation sessionImplementation;

    private GameDAO gameDAO;

    public void connect(SessionImplementation sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
        this.gameDAO = new GameDAO(this.sessionImplementation.getGame());
    }

    public String[] getGamesNames(){
        return SessionImplementationDAO.directory.list();
    }

    public void save(String name) {
        if (name.endsWith(SessionImplementationDAO.EXTENSION)) {
            name = name.replace(SessionImplementationDAO.EXTENSION, "");
        }
        File file = new File(SessionImplementationDAO.directory, name + SessionImplementationDAO.EXTENSION);
        try {
            FileWriter fileWriter = new FileWriter(file);
            this.gameDAO.save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String name) {
        this.sessionImplementation.setName(name);
        File file = new File(SessionImplementationDAO.directory, name);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            this.gameDAO.load(bufferedReader);
            this.sessionImplementation.resetRegistry();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sessionImplementation.setStateValue(StateValue.IN_GAME);
        if (this.sessionImplementation.isLooser() || this.sessionImplementation.isWinner()) {
            this.sessionImplementation.setStateValue(StateValue.FINAL);
        }
    }

}
