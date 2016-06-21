package model;

public class Brick extends Component{
	
//	private final int width = (800 / 12) - 10;
//	private final int height = (800 / 12) - 10;
	private boolean gone = false;
	
	public Brick(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
//	public boolean touchesBall(int ballX, int ballY, int ballD) {
//		int bR = ballD/2;
//		int bX = ballX + bR;
//		int bY = ballY + bR;
//		if(bX > x && bX < x + width && bY > y && bY < y + height){
//			return true;
//		}
//		System.out.println(""+ bX);
//		System.out.println(""+ bY);
//		System.out.println(""+ bR);
//		System.out.println(""+ x);
//		System.out.println(""+ y);
//		return false;
//		}else if(ballX + ballR < x || ballX - ballR > x + width ||
//				ballY + ballR < y || ballY - ballR > y + height){
//			return false;
//		} 
//		
//	}
	
	public boolean isGone(){
		return gone;
	}
	
	public void setGone(){
		gone = !gone;
	}

	@Override
	public String getClassName() {
		return "brick";
	}
}
