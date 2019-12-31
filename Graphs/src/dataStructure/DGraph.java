package dataStructure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class DGraph implements graph, Serializable{
	public Map<Integer, node_data> graph = new HashMap<Integer,node_data>();
	public int countNode = 0;
	public int countEdge = 0;
	public int ModeCount = 0;

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
		countNode++;
		ModeCount++;
	}

	@Override
	public void connect(int src, int dest, double w) {
		Edge e = new Edge(src, dest, w);
		((Node)graph.get(src)).edges.put(dest, e);
		countEdge++;
		ModeCount++;
	}
	
	@Override
	public Collection<node_data> getV() {
		return graph.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return ((Node)graph.get(node_id)).edges.values();
	}

	@Override
	public node_data removeNode(int key) {
		node_data n = new Node();
		Iterator<Integer> iter = graph.keySet().iterator();
		while(iter.hasNext()) {
			removeEdge(iter.next(), key);
		}
		graph.put(key, null);
		n = this.graph.remove(key);
		countNode--;
		ModeCount++;
		return n;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		edge_data e = ((Node)graph.get(src)).edges.remove(dest);
		countEdge--;
		ModeCount++;
		if(e == null) {
			return null;
		}
		else {
			return e;
		}	
	}

	@Override
	public int nodeSize() {
		return countNode;
	}

	@Override
	public int edgeSize() {
		return countEdge;
	}

	@Override
	public int getMC() {
		return ModeCount;
	}
	

}
