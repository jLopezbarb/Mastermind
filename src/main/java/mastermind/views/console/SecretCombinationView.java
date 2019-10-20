package mastermind.views.console;

import mastermind.utils.IO;

public class SecretCombinationView {

    public void writeln(int width){
        for (int i = 0; i < width; i++) {
            IO.write(Message.SECRET);
        }
        IO.writeln();
    }
}
