package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;

public interface DAO {

    void save(FileWriter fileWriter);

    void load(BufferedReader bufferedReader);

}
