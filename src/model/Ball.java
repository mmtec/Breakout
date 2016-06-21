package model;

public class Ball extends Component {

	private int vx = -3;
	private int vy = -3;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}
	
	public int getVx() {
		return vx;
	}

	public int getVy() {
		return vy;
	}
	
	public String getClassName() {
		return "ball";
	}

	
}
