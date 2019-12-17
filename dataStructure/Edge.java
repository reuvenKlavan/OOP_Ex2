package dataStructure;

import java.awt.Color;

public class Edge implements edge_data {

	private String info;
	private node_data source;
	private node_data destination;
	private double weight;
	private Color state;
	public static Color [] Colors = {Color.WHITE, Color.DARK_GRAY, Color.BLACK};
	
	public Edge (node_data source, node_data destination, double weight) {
		this.source = source;
		this.destination = destination;
		if (this.weight > 0) {
			this.weight = weight;
		}
		else throw new IllegalArgumentException("non positive weight");
		info = "";
	}
	
	@Override
	public int getSrc() {
		return source.getKey();
	}

	@Override
	public int getDest() {
		return destination.getKey();
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public String getInfo() {
		return info;
	}

	@Override
	public void setInfo(String s) {
		info =s;		
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
