package mastermind.models.DAO;

import mastermind.models.Combination;
import mastermind.types.Color;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class CombinationDAO implements DAO {

    protected Combination combination;

    CombinationDAO(Combination combination) {
        this.combination = combination;
    }


    @Override
    public void save(FileWriter fileWriter) {
        try {
            for (Color color : this.combination.getColors()) {
                fileWriter.write(color.name() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(BufferedReader bufferedReader) {
        try {
            for (int i = 0; i < Combination.getWidth(); i++) {
                String color = bufferedReader.readLine();
                this.combination.add(Color.valueOf(color));
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
