package Cards;
import java.lang.Math;
public class Point {
	double x;
	double y;
	public Point(double x, double y)
	{
		this.x=x;
		this.y=y;
	}
	public double distFromOtherPoint(Point p)
	{
		double dist= Math.sqrt((Math.pow(p.x-x,2)+Math.pow(p.y-y,2)));
		return dist;
	}
}
