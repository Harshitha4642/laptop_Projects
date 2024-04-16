package Cards;
import java.lang.Math;
public class Line {
	double a;
	double b;
	double c;
	
	public Line(double a, double b, double c)
	{
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public double pointToLineDist (Point p)
	{
		double r1=Math.sqrt(a*a+b*b);
		double r2=Math.abs(a*p.x+b*p.y+c);
		double result= r1/r2;
		return(result);
	}
	
	public Point pointOfInter(Line l) {
		if(l.a/a==l.b/b)
		{
			System.out.println("Parallel lines");
			return null;
		}
		Point intersection= new Point((b*l.c- l.b*c)/(a*l.b-l.a*b), (c*l.a - l.c*a)/(a*l.b-l.a*b) );
		return(intersection);
	}
}
