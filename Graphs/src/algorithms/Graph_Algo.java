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
import java.util.ArrayList;
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
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.StdDraw;
/**
 * This class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2
 * @author Ariel David
 *
 */
public class Graph_Algo implements graph_algorithms,Serializable{
	public graph graph;

	/**
	 * Default constructor
	 */
	public Graph_Algo() {
		this.graph = new DGraph();
	}

	/**
	 * copy constructor
	 * @param g.
	 */
	public Graph_Algo(graph g) {
		this.graph = g;
	}


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
			System.out.println("Object has been deserialized"); 

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
			System.out.println("Object has been serialized"); 
		}   
		catch(IOException ex)  { 
			System.out.println("IOException is caught"); 
		}
	}

	/**
	 * Returns true if and only if (iff) there is a valid path from EVREY node to each
	 * other node. NOTE: assume directional graph - a valid path (a-->b) does NOT imply a valid path (b-->a).
	 * @return
	 */
	@Override
	public boolean isConnected() {
		if(this.graph.nodeSize() <= 1) {
			return true;
		}
		boolean flag = false;
		Stack<node_data> s = new Stack<node_data>();
		Iterator<node_data> iterNode = graph.getV().iterator();
		while(iterNode.hasNext()) {
			for (node_data nodes : graph.getV()) {
				nodes.setTag(0);
			}
			node_data currentNode = iterNode.next();
			s.add(currentNode);
			currentNode.setTag(1);
			if(neiburs(currentNode,s).isEmpty()) {
				flag = true;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * this methods check the neighbours of current node and return a new list of the neighbours
	 * @param currentNode
	 * @param s
	 * @return
	 */
	private Stack<node_data> neiburs(node_data currentNode, Stack<node_data> s) {
		Iterator<edge_data> iterEdge = graph.getE(currentNode.getKey()).iterator();
		if(s.isEmpty()) {
			return s;
		}
		else {
			while(iterEdge.hasNext()) {
				edge_data e = iterEdge.next();
				if(graph.getNode(e.getDest()).getTag() == 0 ) {
					s.push(graph.getNode(e.getDest()));
					graph.getNode(e.getDest()).setTag(1);
					neiburs(graph.getNode(e.getDest()), s);
				}
			}
			s.pop();
		}
		return s;
	}

	/**
	 * returns the length of the shortest path between src to dest
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	@Override
	public double shortestPathDist(int src, int dest) {
		String s = "";
		if(src == dest) {
			return 0;
		}
		for(node_data vertex : graph.getV()) {
			vertex.setWeight(Double.POSITIVE_INFINITY);
			vertex.setTag(0);
		}
		graph.getNode(src).setWeight(0);;
		shortestPathDistHelper(src,dest,s);
		return graph.getNode(dest).getWeight();

	}
	/**
	 * This is the recursive method thats get a src of a node and dest of another node,
	 * and calculating the shortest path from the src node to his dest.
	 * @param src - represent the start node.
	 * @param dest - represent the final node.
	 * @param info - a string that helps to store the path that have past at each point of the way.
	 */
	private void shortestPathDistHelper(int src, int dest, String s) {
		if(graph.getNode(src).getTag() == 1 && graph.getNode(src) == graph.getNode(dest)) {
			return;
		}
		for (edge_data edges : graph.getE(src)) {
			double newSum = edges.getWeight() + graph.getNode(edges.getSrc()).getWeight();
			double currentSum = graph.getNode(edges.getDest()).getWeight();
			if(newSum < currentSum) {
				graph.getNode(edges.getDest()).setWeight(newSum);
				graph.getNode(edges.getDest()).setInfo(s + "->" +src);
				graph.getNode(src).setTag(1);
				shortestPathDistHelper(edges.getDest(), dest , s + "->" +src);
			}
		}
	}

	/**
	 * returns the the shortest path between src to dest - as an ordered List of nodes:
	 * src--> n1-->n2-->...dest
	 * see: https://en.wikipedia.org/wiki/Shortest_path_problem
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	@Override
	public List<node_data> shortestPath(int src, int dest) {
		List<node_data> visited = new ArrayList<>();
		if(shortestPathDist(src, dest) == Double.POSITIVE_INFINITY) {
			return null;
		}
		String str = graph.getNode(dest).getInfo();
		str = str.substring(2);
		String [] splitArray = str.split("->");
		for(int i=0; i<splitArray.length; i++) {
			visited.add(graph.getNode(Integer.parseInt(splitArray[i])));
		}
		visited.add(graph.getNode(dest));
		return visited;
	}

	/**
	 * computes a relatively short path which visit each node in the targets List.
	 * Note: this is NOT the classical traveling salesman problem, 
	 * as you can visit a node more than once, and there is no need to return to source node - 
	 * just a simple path going over all nodes in the list. 
	 * @param targets
	 * @return
	 */
	@Override
	public List<node_data> TSP(List<Integer> targets) {
		List<node_data> Nodes = new ArrayList<node_data>();
		List<node_data> temp = new ArrayList<node_data>();
		List<node_data> ans = new ArrayList<node_data>();

		for (Integer key : targets) {
			if(graph.getNode(key)==null) {
				return null;
			}
			Nodes.add(graph.getNode(key));
		}

		for(int i=0; i<Nodes.size()-1; i++) {
			List<node_data> list = new ArrayList<node_data>();

			list = (ArrayList<node_data>) shortestPath(Nodes.get(i).getKey(), Nodes.get(i+1).getKey());

			if(list==null) {
				return null;
			}
			for(int j=0; j<list.size(); j++) {
				temp.add(list.get(j));
			}
		}
		if(temp.size() % 2 == 0) {
			for(int i=0; i<temp.size(); i++) {
				if(i == temp.size()-1) {
					if(temp.get(i-1) != temp.get(i)) {
						ans.add(temp.get(i));
					}
				}
				else if(temp.get(i) == temp.get(i+1)) {
					ans.add(temp.get(i));
					i++;
				}
				else {
					ans.add(temp.get(i));
				}
			}
		}
		else {
			for(int i=0; i<temp.size()-1; i++) {
				if(i == temp.size()-2) {
					if(temp.get(i) == temp.get(i+1)) {
						ans.add(temp.get(i));
						i++;
					}
					else {
						ans.add(temp.get(i));
						ans.add(temp.get(i+1));
					}
				}

				if(temp.get(i) == temp.get(i+1)) {
					ans.add(temp.get(i));
					i++;
				}
				else {
					ans.add(temp.get(i));
				}
			}
		}
		return ans;	
	}

	@Override
	public graph copy() {
		Graph_Algo ga = new Graph_Algo();
		this.save("temp.txt");
		ga.init("temp.txt");
		return ga.graph;
	}
}
