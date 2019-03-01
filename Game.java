import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

	private static final long serialVerionUID = 1L;
	
	public Game(){
		new Frame(1000,700,"Linear Quest", this);
	}

	public void run(){

	}

	public static void main(String args[]){
		new Game();
	}
}