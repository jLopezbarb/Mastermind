package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;

public abstract class Combination {
	
	private static final int WIDTH = 4;

	protected List<Color> colors;
	
	protected Combination (){
		this.colors = new ArrayList();
	}
	
	public static int getWidth() {
		return Combination.WIDTH;
	}

    public List<Color> getColors() {
        return this.colors;
    }

    public void add(Color color){
	    if (this.colors.size() < this.WIDTH){
	        this.colors.add(color);
        }
    }

}
