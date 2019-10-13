package mastermind.models.DAO;

import mastermind.models.SecretCombination;

import java.io.BufferedReader;

public class SecretCombinationDAO extends CombinationDAO {

    SecretCombinationDAO(SecretCombination secretCombination) {
        super(secretCombination);
    }

    public void load(BufferedReader bufferedReader) {
        this.combination.getColors().clear();
        super.load(bufferedReader);
    }
}
