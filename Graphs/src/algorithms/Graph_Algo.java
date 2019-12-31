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

	@Override
	public boolean isConnected() {
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
	graph.getNode(src);
	shortPathDist(src,dest,s);
	return graph.getNode(dest).getWeight();

}

private void shortPathDist(int src, int dest, String s) {
	if(graph.getNode(src).getTag() == 1 && graph.getNode(src) == graph.getNode(dest)) {
		return;
	}
	for (edge_data edges : graph.getE(src)) {
		double newSum = edges.getWeight() + graph.getNode(edges.getSrc()).getWeight();
		double currentSum = graph.getNode(edges.getSrc()).getWeight();
		if(newSum < currentSum) {
			graph.getNode(edges.getDest()).setWeight(newSum);
			graph.getNode(edges.getDest()).setInfo(s + "->" +src);
			graph.getNode(src).setTag(1);
			shortPathDist(edges.getDest(), dest , s + "->" +src);
		}
	}
}

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

@Override
public List<node_data> TSP(List<Integer> targets) {
	boolean flag = false;
	List<node_data> ans = new ArrayList<node_data>();
	Iterator<Integer> it = targets.iterator();
	while(it.hasNext() && !flag) {
		ans = check(it.next(), targets);
		if(ans != null) {
			flag = true;
		}
	}
	return ans;
}

private List<node_data> check(Integer curentNode , List<Integer> list) {
	List<node_data> nodePath = new ArrayList<node_data>();
	nodePath.add(graph.getNode(curentNode));
	list.remove(new Integer(curentNode));
	edge_data temp;
	Iterator<edge_data> iter = graph.getE((graph.getNode(curentNode)).getKey()).iterator();
	while(iter.hasNext()) {
		temp = iter.next();
		nodePath.add(graph.getNode(temp.getDest()));
		if(list.contains(temp.getDest())) {
			list.remove(new Integer(temp.getDest()));
		}
	}
	if(!list.isEmpty()) {
		return null;
	}
	else {
		return nodePath;
	}
}


@Override
public graph copy() {
	Graph_Algo ga = new Graph_Algo();
	this.save("temp.txt");
	ga.init("temp.txt");
	return ga.graph;
}
}
