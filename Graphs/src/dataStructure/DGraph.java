package dataStructure;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DGraph implements graph{
	private Map<Integer, node_data> graph = new HashMap<Integer,node_data>();

	@Override
	public node_data getNode(int key) {
		return (node_data) this.graph.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return ((Node)graph.get(src)).edges.get(dest);
	}

	@Override
	public void addNode(node_data n) {
		graph.put(n.getKey(),n); 
	}

	@Override
	public void connect(int src, int dest, double w) {
		Edge e = new Edge(src, dest, w);
		((Node)graph.get(src)).edges.put(dest, e);
	}
	@Override
	public Collection<node_data> getV() {
		return graph.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		Node n = new Node();
		Iterator<Node> itP1 = n.iteretor();
		if(this.graph.containsKey(key) == true) {
			graph.put(key, null);
			this.graph.remove(key);
		}
		
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
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
		// TODO Auto-generated method stub
		return 0;
	}
	

}
