package mastermind.models;


import java.util.List;

public class ProposedCombination extends Combination {

    public ProposedCombination(List<Color> colors){
        this.colors = colors;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Color color : this.colors) {
            result.append(color.toString());
        }
        return result.toString();
    }

    boolean contains(Color color, int position) {
        return this.colors.get(position) == color;
    }

    boolean contains(Color color) {
        for (Color value : this.colors) {
            if (value == color) {
                return true;
            }
        }
        return false;
    }
}
