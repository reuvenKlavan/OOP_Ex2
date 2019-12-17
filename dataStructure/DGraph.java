package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


public class DGraph implements graph{
	
	private Collection<LinkedList<node_data>> graph;
	private ArrayList<node_data> VertexSet;
	private ArrayList<edge_data> EdgeSet;
	
	public DGraph (){
		graph = new ArrayList<LinkedList<node_data>>();
		VertexSet = new ArrayList<node_data>();
		EdgeSet = new ArrayList<edge_data>();
	}
	
	@Override
	public node_data getNode(int key) {
		Iterator<node_data> iter = VertexSet.iterator();
		node_data output = null;
		boolean found = false;
		while(iter.hasNext() && !found) {
			node_data next = iter.next();
			if(key == next.getKey()) {
				output = next;
				found = true;
			}
		}
		return output;
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		Iterator<edge_data> iter = EdgeSet.iterator();
		edge_data output = null;
		boolean found = false;
		while(iter.hasNext() && !found) {
			edge_data next = iter.next();
			if(src == next.getSrc() && dest == next.getDest()) {
				output = next;
				found = true;
			}
		}
		return output;
	}

	@Override
	public void addNode(node_data n) {
		VertexSet.add(n);
		LinkedList<node_data> toAdd = new LinkedList<node_data>();
		toAdd.add(n);
		graph.add(toAdd);
	}

	@Override
	public void connect(int src, int dest, double w) {
		node_data source = getNode(src);
		node_data destination = getNode(dest);
		//edge_data toAdd = new Edge ()
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		int modeCounter = 0;
		modeCounter++;
		return modeCounter;
	}

}
