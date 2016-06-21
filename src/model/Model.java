package model;

import java.util.ArrayList;

public class Model {

	private ArrayList<Component> list = new ArrayList<Component>();
	
	private final int gwidth = 800;
	private final int gheight = 800;
	
	private int score = 0;
	private final int brickScore = 10;
		
	private Brick[][] b = new Brick[9][10];
	private Brick def = new Brick(0, 0, 80, 30);
	
	private Ball ball = new Ball(gwidth/2-10, gheight/2 - 10, 20, 20);
	private Bat bat = new Bat(gwidth/2 - 80, gheight - 40, 160, 20);
	
	// Fügt Elemente erstmals hinzu
//	public void start() {
//		int bwidth = def.getWidth();
//		int bheight = def.getHeight();
//		for(int y = 0; y < 10; y+= bheight) {
//			for(int x = 0; x < 9; x+= bwidth) {
//				b[x/bwidth][y/bheight] = new Brick(x, y, 80, 30);
//				list.add(b[x/bwidth][y/bheight]);
//			}
//		}
//		list.add(ball);
//		list.add(bat);
//	}
	
	 //Fügt Elemente erstmals hinzu
   public void start() {
	   int bwidth = def.getWidth();
	   int bheight = def.getHeight();
	   int y = 0;
	   int x = 0;
	   for(int i = 0; i <= 9; i++)
	   {
	       for(int j = 0; j <= 8; j++)
	       {
	           b[j][i] = new Brick(x, y, 80, 30);
	           list.add(b[j][i]);
	           x+=bwidth;
	       }
	       y+= bheight;
	       x = 0;
	   }
	   list.add(ball);
	   list.add(bat);
   }
	
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

	public boolean touchesVoid(){ // Ball raus
		if(ball.getY() >= 800){
			return true;
		}
		return false;
	}
	
	public boolean touchesBat() {
		if(ball.getX() + ball.getWidth() - bat.getX() >= 0 && ball.getX() - (bat.getX() + bat.getWidth()) <= bat.getWidth() && ball.getY() + ball.getHeight() >= bat.getY()){
			return true;
		}
		return false;
	}
	
	public int[] touchesBrick(){
		int[] touchesBrick = new int[3];
		
		for(int i = 0; i <= 8; i++){
			for(int j = 0; j <= 9; j++){
				if(!b[i][j].isGone() &&// von unten
				   ball.getY() <= b[i][j].getY() + b[i][j].getHeight() &&
				   ball.getY() >= b[i][j].getY() &&
				   ball.getX() + ball.getWidth() >= b[i][j].getX() &&
				   ball.getX() <= b[i][j].getX() + b[i][j].getWidth()){
					
					touchesBrick[0] = i;
					touchesBrick[1] = j;
					touchesBrick[2] = 2;
					return touchesBrick;
							
				}else if(!b[i][j].isGone() && // von oben
						 ball.getY() + ball.getHeight() >= b[i][j].getY() &&
						 ball.getY() <= b[i][j].getY() + b[i][j].getHeight() &&
						 ball.getX() + ball.getWidth() >= b[i][j].getX() &&
						 ball.getX() <= b[i][j].getX() + b[i][j].getWidth()){
					
					touchesBrick[0] = i;
					touchesBrick[1] = j;
					touchesBrick[2] = 2;
					return touchesBrick;
															
				}else if(!b[i][j].isGone() &&	// von links
						 ball.getX() + ball.getWidth() >= b[i][j].getX() &&
						 ball.getX() + ball.getWidth() <= b[i][j].getX() +  b[i][j].getWidth() &&
						 
						 ball.getY() + ball.getHeight() >= b[i][j].getY() &&
						 ball.getY() <= b[i][j].getY() + b[i][j].getHeight() ){  
					
					touchesBrick[0] = i;
					touchesBrick[1] = j;
					touchesBrick[2] = 1;
					return touchesBrick;
					
				}else if(!b[i][j].isGone() && 			// von rechts
						 ball.getY() + ball.getHeight() >= b[i][j].getY() &&
 						 ball.getY() <= b[i][j].getY() + b[i][j].getHeight() &&
						 
						 ball.getX() <= b[i][j].getX() + b[i][j].getWidth() &&
						 ball.getX() >= b[i][j].getX()){ 
					
					touchesBrick[0] = i;
					touchesBrick[1] = j;
					touchesBrick[2] = 1;
					System.out.println("Von rechts.");
					return touchesBrick;
				
				}
			}
		}
		touchesBrick[0] = -1;
		touchesBrick[1] = -1;
		touchesBrick[2] = -1;
		return touchesBrick;
	}
	
	public void destroyBrick(int[] i) {
		int x = i[0];
		int y = i[1];
		b[x][y].setGone();
	}
	
	public void refresh() {
		for(int y = 0; y <= 9; y++) {
			for(int x = 0; x <= 8; x++) {
				if(!b[x][y].isGone()) {
					list.add(b[x][y]);
			}
		}
		list.add(ball);
		list.add(bat);
		}
		
	}
	
	public void addComponent(Component c) {
		list.add(c);		
	}
	
	public ArrayList<Component> returnList() {
		ArrayList<Component> cache = list;
		list = new ArrayList<Component>();
		return cache;
	}
	
}
