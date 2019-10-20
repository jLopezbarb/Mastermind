package mastermind.views.console;

import mastermind.models.Color;
import mastermind.utils.IO;

import java.util.List;

class CombinationView {

    void write(List<Color> colors) {
        for (Color color: colors) {
            IO.write(color.toString());
        }
    }
}
