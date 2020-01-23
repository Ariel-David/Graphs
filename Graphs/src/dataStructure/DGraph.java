package dataStructure;



import java.io.Serializable;
import java.util.Collection;

import java.util.HashMap;

import java.util.Iterator;


import java.util.Map;

import utils.Point3D;


public class DGraph implements graph, Serializable{
	/**
	 * A hash map that contains all the nodes in this DGraph as values,
	 *  and their key's are the map keys.
	 */
	public Map<Integer, node_data> graph = new HashMap<Integer,node_data>();
	public int countNode = 0;
	public int countEdge = 0;
	public int ModeCount = 0;

	@Override
	public node_data getNode(int key) {
		if(graph.get(key) == null) {
			return null;
		}
		return (node_data) this.graph.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if((graph.get(src) == null) && (graph.get(dest) == null)){
			return null;
		}	
		return ((Node)graph.get(src)).edges.get(dest);
	}

	@Override
	public void addNode(node_data n) {
		if(graph.containsKey(n.getKey())) {
			throw new RuntimeException("This vertex with the same key is already exist");
		}
		graph.put(n.getKey(),n); 
		countNode++;
		ModeCount++;
	}

	@Override
	public void connect(int src, int dest, double w) {
		if(((Node)graph.get(src)).edges.containsKey(dest)) {
			throw new RuntimeException("This edge is already exist");
		}

		if((graph.get(src)==null) || (graph.get(dest)==null)) {
			throw new RuntimeException("Invalid input");
		}

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
		if(!graph.containsKey(key)) {
			return null;
		}
		else {
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
	}
	
	public static  DGraph createCrazy() {
		DGraph c = new DGraph();
		for(int i=0; i<1000000; i++) {
			c.addNode(new Node(i, 0.0,0,new Point3D(i/1000,i/1000), ""));
		}
		return c;
	}
	
	@Override
	public edge_data removeEdge(int src, int dest) {
		if(((Node)graph.get(src)).edges.containsKey(dest)) {
			edge_data e = ((Node)graph.get(src)).edges.remove(dest);
			countEdge--;
			ModeCount++;
			return e;
		}
		else {
			return null;
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
