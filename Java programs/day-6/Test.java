package Cards;

public class Test {
	public static void main(String args[]) {
		Point p = new Point(0,0);
		Line l1=new Line(1.0,-1.0,5.0);
		Line l2=new Line(2.0,-1.0,10.0);
		
		System.out.println(l1.pointToLineDist(p));
		System.out.println(l2.pointToLineDist(p));
		Point inter= l1.pointOfInter(l2);
		System.out.println(inter.x+" , "+inter.y);
	}
}
