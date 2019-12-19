package dataStructure;

import java.awt.Color;

import utils.Point3D;

public class Vertex implements node_data {

	private Point3D V;
	private Color state;
	private static int counter = 0;
	private int key;
	private double weight;
	private String info;
	public static Color [] Colors = {Color.WHITE, Color.DARK_GRAY, Color.BLACK};
	
	public Vertex(double x, double y, double z) {
		this.V = new Point3D(x,y,z);
		this.state = Colors[0];
		info = "";
		counter++;
		key = counter;
		this.weight = Double.MAX_VALUE;
		
	}
	
	
	@Override
	public int getKey() {
		return key;
	}

	@Override
	public Point3D getLocation() {
		return V;
	}

	@Override
	public void setLocation(Point3D p) {
		double x = p.x();
		double y = p.y();
		double z = p.z();
		Point3D tmp = new Point3D(x,y,z);
		V = tmp;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double w) {
		if(w>0) 
			this.weight = w;
		else 
			throw new IllegalArgumentException("non positive weight");
	}

	@Override
	public String getInfo() {
		return info;
	}

	@Override
	public void setInfo(String s) {
		info = s;		
	}

	@Override
	public int getTag() {
		if (state == Color.WHITE) {
			return 0;
		}
		else if(state == Color.GRAY) {
			return 1;
		}
		else {
			return 2;
		}
	}

	@Override
	public void setTag(int t) {
		if(t == 0) {
			state = Color.WHITE;
		}
		else if(t == 1) {
			state = Color.GRAY;
		}
		else if (t == 2) {
			state = Color.BLACK;
		}
		else 
			throw new IllegalArgumentException("illegal input");
	}
}
