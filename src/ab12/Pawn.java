package ab12;

import java.io.Serializable;

/**
 * Created by butkoav on 24.09.2016.
 */
class Pawn implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1317111678203754693L;
	private int x;
    private int y;

    public void draw() {

    }

     Pawn(int x, int y) {
        this.x = x;
        this.y = y;
    }

     int getX() {
        return x;
    }

     int getY() {
        return y;
    }

     void setX(int x) {
        this.x = x;
    }
}
