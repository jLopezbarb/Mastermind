package mastermind.views.console;

import mastermind.models.Color;
import mastermind.utils.IO;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombinationView  {

    public List<Color> propose() {
        String proposedColors = IO.readString(Message.PROPOSED_COMBINATION);
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < proposedColors.length(); i++) {
            colors.add(Color.getInstance(proposedColors.charAt(i)));
        }
        return colors;
    }

    public void writeln(String message){
        IO.writeln(message);
    }
}
