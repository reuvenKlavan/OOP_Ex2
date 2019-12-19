package algorithms;

import java.awt.Container;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	private graph algo; 

	@Override
	public void init(graph g) {
		algo = g;		
	}

	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub

	}
	/**
	 * This function checks if all of the vertices are connected to each other.
	 * The function uses a recursive function that checks
	 * every vertex if it is connected to the next vertex until all of the tags are BLACK.
	 * The function checks if the received graph (using the recursive function described above) is connected,
	 * and then the way it checks the reverse graph as well.
	 * Iff (if and only if) any vertex x -> y is true and any vertex y -> x is true so the graph is strongly connected.
	 */
	@Override
	public boolean isConnected() {
		boolean first = false;
		node_data start = null;
		for (int i = 1; i < algo.nodeSize() && !first; i++) {
			start = algo.getNode(i);
			if (start != null) {
				first = true;
			}
		}

		int visitedAll = DFS(algo, start.getKey(), 0);
		if (visitedAll != algo.nodeSize()) return false;

		Collection<node_data> ver = algo.getV();
		graph reverse = new DGraph();

		for (node_data v : ver) {
			reverse.addNode(v);
		}

		for (node_data v : ver) {
			LinkedList<edge_data> source = (LinkedList<edge_data>)algo.getE(v.getKey());
			for (edge_data e : source) {
				reverse.connect(e.getDest(), e.getSrc(), e.getWeight());
			}
		}

		visitedAll = DFS(reverse, start.getKey(), 0);
		if (visitedAll != reverse.nodeSize())
			return false;

		return true;
	}

	/**
	 * This function checks what is the shortest (by weight) way to get from one vertex to another.
	 * The functions runs recursively on all of the vertices and scales them by the shortest possible path.
	 * 
	 */
	@Override
	public double shortestPathDist(int src, int dest) {
		
		if(src == dest) return algo.getNode(dest).getWeight();
		
		double output = 0;
		node_data source = algo.getNode(src);
		source.setTag(1);
		LinkedList<edge_data> srcEdge = (LinkedList<edge_data>) algo.getE(src);
		for (edge_data e : srcEdge) {
			node_data next = algo.getNode(e.getDest());
			if (e.getWeight() + source.getWeight() < next.getWeight()) {
				next.setWeight(e.getWeight() + source.getWeight());
			}
			double tmp = shortestPathDist(e.getDest(), dest);
			if (tmp < output) {
				output = tmp;
			}
		}
		source.setTag(2);
		
		return output;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

	private int DFS (graph check ,int start, int visited) {
		if (algo.nodeSize() == visited) {
			return visited;
		}
		else {
			visited++;
			node_data startNode = check.getNode(start);
			startNode.setTag(2);
			Collection<edge_data> edges =check.getE(start);
			for (edge_data e : edges) {
				node_data des = check.getNode(e.getDest());
				if(des.getTag() != 2) {
					return DFS(check, e.getDest(), visited);
				}
			}
		}
		return -1;
	}

}
