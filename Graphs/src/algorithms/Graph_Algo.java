package algorithms;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms,Serializable{
	public graph graph;

	@Override
	public void init(graph g) {
		this.graph = (DGraph) g;
	}

	@Override
	public void init(String file_name) {
		try {    
			FileInputStream file = new FileInputStream(file_name); 
			ObjectInputStream in = new ObjectInputStream(file);  
			graph = (graph) in.readObject(); 
			in.close(); 
			file.close();   
		} 

		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 

		catch(ClassNotFoundException ex) 
		{ 
			System.out.println("ClassNotFoundException is caught"); 
		} 		
	}

	@Override
	public void save(String file_name) {
		try {    
			FileOutputStream file = new FileOutputStream(file_name); 
			ObjectOutputStream out = new ObjectOutputStream(file); 

			out.writeObject(graph);
			out.close(); 
			file.close();  
		}   
		catch(IOException ex)  { 
			System.out.println("IOException is caught"); 
		}
	}

	@Override
	public boolean isConnected() {
		Queue<Node> q= new ArrayBlockingQueue<Node>(graph.nodeSize());
		if(graph.nodeSize()==1) {
			return true;
		}
		for (node_data nodes : graph.getV()) {
			nodes.setTag(0);
		}
		for (node_data v : graph.getV() ) {
			Node node = (Node) v;
			if (graph.getE(v.getKey()) == null) {
				return false;
			}
			q.add((Node) node);
			node.setTag(1);
			while (!q.isEmpty()) {
				for (edge_data edge : q.peek().edges.values()) {
					node_data des = (node_data) graph.getNode(edge.getDest());
					if(des.getTag()==0) {
						des.setTag(1);
						q.add((Node) des);
					}
					q.remove();
				}
				for (node_data nodes : graph.getV()) {
					if (nodes.getTag()==0) {
						return false;
					}
					else {
						nodes.setTag(0);
					}
				}
			}
			for (node_data n : graph.getV()) {
				n.setTag(0);
			}
		}
		return true;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		return dest;
//		calculateMinimumDistance(evaluationNode, edgeWeigh, sourceNode);
//		return dest;
	}

	public graph calculateShortestPathFromSource(graph graph, int source) {
		return graph;
//		DGraph graphDijkstra = new DGraph();
//		graphDijkstra = (DGraph) g;
//		graphDijkstra.getNode(source).setWeight(0);
//		Set<Node> settledNodes = new HashSet<>();
//		Set<Node> unsettledNodes = new HashSet<>();
//		unsettledNodes.add((Node) graphDijkstra.getNode(source));
//		while (unsettledNodes.size() != 0) {
//			Node currentNode = getLowestDistanceNode(unsettledNodes);
//			unsettledNodes.remove(currentNode);
//			for (edge_data adjacencyPair : graphDijkstra.getE(currentNode.getKey())) {
//				Node adjacentNode =  (Node) graphDijkstra.getNode(adjacencyPair.getSrc());
//				Double edgeWeight = adjacencyPair.getWeight();
//				if (!settledNodes.contains(adjacentNode)) {
//					calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//					unsettledNodes.add(adjacentNode);
//				}
//			}
//			//			for(int i=0; i<currentNode.edges.size(); i++) {
//			//				Node adjacentNode = (Node) currentNode.edges.get(i);
//			//				Double edgeWeight = currentNode.edges.get(i).getWeight();
//			//				if (!settledNodes.contains(adjacentNode)) {
//			//					calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//			//					unsettledNodes.add(adjacentNode);
//			//				}
//			//			}
//			settledNodes.add(currentNode);
//		}
//		return graph;
	}

	private void calculateMinimumDistance(Node evaluationNode, Double edgeWeigh, Node sourceNode) {
//		Double sourceDistance = sourceNode.getWeight();
//		if (sourceDistance + edgeWeigh < evaluationNode.getWeight()) {
//			evaluationNode.setWeight(sourceDistance + edgeWeigh);
//			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.ShortestPath);
//			shortestPath.add(sourceNode);
//			evaluationNode.setShortestPath(shortestPath);
//		}
//
	}
//
	private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		return null;
//		Node lowestDistanceNode = null;
//		double lowestDistance = Integer.MAX_VALUE;
//		for (Node node: unsettledNodes) {
//			double nodeDistance = node.getWeight();
//			if (nodeDistance < lowestDistance) {
//				lowestDistance = nodeDistance;
//				lowestDistanceNode = node;
//			}
//
//		}
//	return lowestDistanceNode;
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
		return this.graph = (graph) new Graph_Algo();
	}

	public void copy(DGraph graphi) {
		this.graph = new DGraph();
		this.graph = graphi;
	}

}
