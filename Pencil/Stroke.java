import ecs100.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class Stroke {
    private ArrayList<Double> strokeX = new ArrayList<>();
    private ArrayList<Double> strokeY = new ArrayList<>();
    
    public Color color;
    public double lineWidth;

    public Stroke(Color color, double lineSize, double x, double y) {
        add(x,y);
        this.color = color;
        this.lineWidth = lineSize;
    }
    /**
     * add method
     */
    public void add(double x, double y) {
        strokeX.add(x);
        strokeY.add(y);
    }
    /**
     * inbuilt stroke draw method
     */
    public void draw() {
        if (strokeX.size() == 1) {
            strokeX.add(strokeX.get(0));
            strokeY.add(strokeY.get(0));
        }
        for (int i = 1; i < strokeX.size(); i++) {
            UI.setColor(color);
            UI.setLineWidth(lineWidth);
            UI.drawLine(strokeX.get(i-1), strokeY.get(i-1), strokeX.get(i), strokeY.get(i));
        }
    }
    /**
     * Erase method. I know this definitely isn't the best way to do it 
     * but it works lmao
     */
        public void erase() {
        if (strokeX.size() == 1) {
            strokeX.add(strokeX.get(0));
            strokeY.add(strokeY.get(0));
        }
        for (int i = 1; i < strokeX.size(); i++) {
            UI.setColor(Color.white); // erase color
            UI.setLineWidth(lineWidth+4);
            UI.drawLine( strokeX.get(i-1), strokeY.get(i-1), strokeX.get(i), strokeY.get(i));
            UI.setColor(color);
        }
    }
}