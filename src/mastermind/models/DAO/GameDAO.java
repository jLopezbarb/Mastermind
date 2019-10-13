package mastermind.models.DAO;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameDAO implements DAO{

    private Game game;

    private SecretCombinationDAO secretCombinationDAO;

    GameDAO(Game game) {
        this.game = game;
        this.secretCombinationDAO = new SecretCombinationDAO(this.game.getSecretCombination());
    }

    @Override
    public void save(FileWriter fileWriter) {
        try {
            fileWriter.write(this.game.getAttempts() + "\n");
            this.secretCombinationDAO.save(fileWriter);
            for (int i = 0; i < this.game.getAttempts(); i++) {
                new ProposedCombinationDAO(this.game.getProposedCombination(i)).save(fileWriter);
                new ResultDAO(this.game.getResult(i)).save(fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(BufferedReader bufferedReader) {
        try{
            this.game.setAttempts(Integer.parseInt(bufferedReader.readLine()));
            this.secretCombinationDAO.load(bufferedReader);
            for (int i = 0; i < this.game.getAttempts(); i++) {
                ProposedCombinationDAO proposedCombinationDAO = new ProposedCombinationDAO(new ProposedCombination());
                proposedCombinationDAO.load(bufferedReader);
                this.game.addProposedCombination(proposedCombinationDAO.getProposedCombination());
                ResultDAO resultDAO = new ResultDAO(new Result());
                resultDAO.load(bufferedReader);
                this.game.addResult(resultDAO.getResult());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
