package model;

import java.util.ArrayList;

public class Model {

	private ArrayList<Component> list = new ArrayList<Component>();
	
	private final int gwidth = 800;
	private final int gheight = 800;
	
	private int score = 0;
	private final int brickScore = 10;
		
	private Brick[][] b = new Brick[100][100];
	private Brick def = new Brick(0, 0, 80, 30);
	private int bwidth = def.getWidth();
	private int bheight = def.getHeight();
	
	private Ball ball;
	private Bat bat;
	
	// Fügt Elemente erstmals hinzu
	public void start() {
		int bwidth = def.getWidth();
		int bheight = def.getHeight();
		ball = new Ball(gwidth/2-10, gheight/3 - 10, 20, 20);
		bat = new Bat(gwidth/2 - 80, gheight - 40, 160, 20);
		for(int y = 0; y < gheight / 3; y+= bheight) {
			for(int x = 0; x < gwidth; x+= bwidth) {
				b[x/bwidth][y/bheight] = new Brick(x, y, 80, 30);
				list.add(b[x/bwidth][y/bheight]);
			}
		}
		list.add(ball);
		list.add(bat);
	}
	
	 //Fügt Elemente erstmals hinzu
//   public void start() {
//	   int bwidth = def.getWidth();
//	   int bheight = def.getHeight();
//	   int y = 0;
//	   int x = 0;
//	   for(int i = 0; i <= 9; i++)
//	   {
//	       for(int j = 0; j <= 8; j++)
//	       {
//	           b[j][i] = new Brick(x, y, 80, 30);
//	           list.add(b[j][i]);
//	           x+=bwidth;
//	       }
//	       y+= bheight;
//	       x = 0;
//	   }
//	   list.add(ball);
//	   list.add(bat);
//   }
	
	public int[] getBallPosition() {
		int[] i = new int[2];
		i[0] = ball.getX();
		i[1] = ball.getY();
		return i;
	}
	
	public int[] getBatPosition() {
		int[] i = new int[2];
		i[0] = bat.getX();
		i[1] = bat.getY();
		return i;
	}
	
	public void moveBat(boolean right, int px) {
		
		if(right) {
			bat.setX(bat.getX() + px);
		} else {
			bat.setX(bat.getX() - px);
		}
		
	}
	
	public void refreshBallPosition() {
		ball.setX(ball.getX() + ball.getVx());
		ball.setY(ball.getY() + ball.getVy());
	}

	public void reverseXSpeed(){
		ball.setVx(ball.getVx() * -1);
	}
	
	public void reverseYSpeed(){
		ball.setVy(ball.getVy() * -1);
	}
	
	//für die Methode touches wall return int -1 falls nicht und 1 falls es die linke oder die rechte wand berührt und 2 falls es die obere berührt
	public int touchesWall(){
		if(ball.getX() <= 0 || ball.getX() >= 800){ // linke bzw. rechte Wand berührt
			return 1;
		}
		if(ball.getY() <= 0){  // obere Wand
			return 2;
		}

			return -1;	// berührt keine Wand
	}

	
	/**
	 * Überprüft, ob der Ball im Void ist.
	 * @return boolean Der Ball ist im Void
	 */
	public boolean touchesVoid(){ // Ball raus
		if(!touchesBat() && ball.getY() > bat.getY()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Überprüft, ob der Ball den Schläger berührt.
	 * @return boolean Berührt den Schläger 
	 */
	
	public boolean touchesBat() {
		if(ball.getX() + ball.getWidth() - bat.getX() >= 0 && ball.getX() - (bat.getX() + bat.getWidth()) <= bat.getWidth() && ball.getY() + ball.getHeight() >= bat.getY()){
			return true;
		}
		return false;
	}
	
	/**
	 * Überprüft, ob der Ball derzeit einen Brick berührt.
	 * @return Int-Array; [0]: x-Koordinate des Brick[][]-Arrays; [1]: y-Koordinate desselbigen; [2]: 1, falls von links/rechts - 2, falls von oben/unten  
	 */
	public int[] touchesBrick(){
		int[] touchesBrick = new int[3];
		
		for(int i = 0; i < gwidth; i += bwidth){
 			for(int j = 0; j < gheight/3; j += bheight){
				int x, y;
				x = i / bwidth;
				y = j / bheight;
				if(!b[x][y].isGone() &&// von unten
				   ball.getY() <= b[x][y].getY() + bheight &&
				   ball.getY() >= b[x][y].getY() &&
				   ball.getX() + ball.getWidth() >= b[x][y].getX() &&
				   ball.getX() <= b[x][y].getX() + bwidth){
					
					touchesBrick[0] = x;
					touchesBrick[1] = y;
					touchesBrick[2] = 2;
					return touchesBrick;
							
				}else if(!b[x][y].isGone() && // von oben
						 ball.getY() + ball.getHeight() >= b[x][y].getY() &&
						 ball.getY() <= b[x][y].getY() + bheight &&
						 ball.getX() + ball.getWidth() >= b[x][y].getX() &&
						 ball.getX() <= b[x][y].getX() + bwidth){
					
					touchesBrick[0] = x;
					touchesBrick[1] = y;
					touchesBrick[2] = 2;
					return touchesBrick;
															
				}else if(!b[x][y].isGone() &&	// von links
						 ball.getX() + ball.getWidth() >= b[x][y].getX() &&
						 ball.getX() + ball.getWidth() <= b[x][y].getX() +  bwidth &&
						 
						 ball.getY() + ball.getHeight() >= b[x][y].getY() &&
						 ball.getY() <= b[x][y].getY() + bheight ){  
					
					touchesBrick[0] = x;
					touchesBrick[1] = y;
					touchesBrick[2] = 1;
					return touchesBrick;
					
				}else if(!b[x][y].isGone() && 			// von rechts
						 ball.getY() + ball.getHeight() >= b[x][y].getY() &&
 						 ball.getY() <= b[x][y].getY() + bheight &&
						 
						 ball.getX() <= b[x][y].getX() + bwidth &&
						 ball.getX() >= b[x][y].getX()){ 
					
					touchesBrick[0] = x;
					touchesBrick[1] = y;
					touchesBrick[2] = 1;
					return touchesBrick;
				
				}
			}
		}
		touchesBrick[0] = -1;
		touchesBrick[1] = -1;
		touchesBrick[2] = -1;
		return touchesBrick;
	}
	
	/**
	 * Zerstört einen Brick.
	 * @param i Int-Array mit x-Koordinate in [0] und y-Koordinate in [1] des zu zerstörenden Bricks
	 */
	public void destroyBrick(int[] i) {
		int x = i[0];
		int y = i[1];
		b[x][y].setGone();
	}
	
	
	/**
	 * Fügt Bricks, Bat und Ball mit derzeitiger Position der Liste hinzu.
	 */
	public void refresh() {
		int x, y;
		for(int j = 0; j < gheight/3; j += bheight) {
			for(int i = 0; i < gwidth; i += bwidth) {
				x = i/bwidth;
				y = j/bheight;
				if(!b[x][y].isGone()) {
					list.add(b[x][y]);
			}
		}
		list.add(ball);
		list.add(bat);
		}
		
	}
	
	/**
	 * Fügt eine Komponente der Liste hinzu.
	 * @param c Zu hinzufügende Komponente
	 */
	public void addComponent(Component c) {
		list.add(c);		
	}
	
	/**
	 * Gibt die Liste zurück.
	 * @return Die ArrayList
	 */
	
	public ArrayList<Component> returnList() {
		ArrayList<Component> cache = list;
		list = new ArrayList<Component>();
		return cache;
	}
	
	/**
	 * Überprüft, ob es noch Bricks gibt.
	 * @return boolean Es gibt noch Bricks
	 */
	public boolean anyBricksLeft() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 10; j++) {
				if(!b[i][j].isGone()) {
					return true;
				}
			}
		}
		return false;
	}
}
