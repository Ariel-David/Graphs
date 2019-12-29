package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Range;
import utils.StdDraw;
import dataStructure.Edge;

public class Graph_GUI extends JFrame implements ActionListener{
	graph graph;
	Graph_Algo algoGraph;

	public Graph_GUI() {
		graph = new DGraph();
		algoGraph = new Graph_Algo();
	}
	public Graph_GUI(graph g){
		this.graph = g;
		algoGraph = new Graph_Algo();
		algoGraph.init(this.graph);
	}
	public void drawGraph() {
		setScale();
		drawEdges();
		drawVertex();
		printKey();
		drawDirection();
		drawEdgesWeight();
	}

	public void setScale() {
		int x_min = 0;
		int x_max = 0;
		int y_min = 0;
		int y_max = 0;
		Iterator<node_data> iter = this.graph.getV().iterator();
		while(iter.hasNext()) {
			node_data currentNode = iter.next();
			if(currentNode.getLocation().x() < x_min) {
				x_min = (int) currentNode.getLocation().x();
			}
			if(currentNode.getLocation().x() > x_max) {
				x_max = (int) currentNode.getLocation().x();
			}
			if(currentNode.getLocation().y() < y_min) {
				y_min = (int) currentNode.getLocation().y();
			}
			if(currentNode.getLocation().y() > y_max) {
				y_max = (int) currentNode.getLocation().y();
			}
		}

		StdDraw.setCanvasSize();
		StdDraw.setXscale(x_min-10,x_max+10);
		StdDraw.setYscale(y_min-10,y_max+10);
	}

	public void drawVertex() {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.017);
		Iterator<node_data> iter = this.graph.getV().iterator();
		while(iter.hasNext()) {
			node_data currentNode = iter.next();
			StdDraw.point(currentNode.getLocation().x(), currentNode.getLocation().y());
		}
	}

	public void printKey() {
		StdDraw.setPenColor(Color.red);
		StdDraw.setFont(new Font("Ariel", 3, 15));
		StdDraw.setPenRadius(0.8);
		Iterator<node_data> iter = this.graph.getV().iterator();
		while(iter.hasNext()) {
			node_data currentNode = iter.next();
			StdDraw.text(currentNode.getLocation().x()-1, currentNode.getLocation().y()-5,""+currentNode.getKey());;
		}
	}
	public void drawEdges() {
		StdDraw.setPenColor(Color.black);
		StdDraw.setPenRadius(0.002);
		Iterator<node_data> iterNodes = this.graph.getV().iterator();
		while(iterNodes.hasNext()){
			node_data currentNode = iterNodes.next();
			Iterator<edge_data> iterEdges = this.graph.getE(currentNode.getKey()).iterator();
			while(iterEdges.hasNext()){
				edge_data currentEdge = iterEdges.next();
				StdDraw.line(graph.getNode(currentEdge.getSrc()).getLocation().x(), graph.getNode(currentEdge.getSrc()).getLocation().y(),graph.getNode(currentEdge.getDest()).getLocation().x(), graph.getNode(currentEdge.getDest()).getLocation().y());	
			}
		}
	}
	public void drawDirection() {
		Iterator<node_data> iterNodes = this.graph.getV().iterator();
		while(iterNodes.hasNext()){
			node_data currentNode = iterNodes.next();
			Iterator<edge_data> iterEdges = this.graph.getE(currentNode.getKey()).iterator();
			while(iterEdges.hasNext()){
				edge_data currentEdge = iterEdges.next();
				StdDraw.setPenRadius(0.010);
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.point(((graph.getNode(currentEdge.getSrc()).getLocation().x()+
						graph.getNode(currentEdge.getDest()).getLocation().x()*7)/8),
						((graph.getNode(currentEdge.getSrc()).getLocation().y())+
								graph.getNode(currentEdge.getDest()).getLocation().y()*7)/8);
			}
		}
	}
	public void drawEdgesWeight() {
		StdDraw.setFont(new Font("Ariel", 2, 15));
		StdDraw.setPenColor(Color.BLUE.darker());
		Iterator<node_data> iterNodes = this.graph.getV().iterator();
		while(iterNodes.hasNext()){
			node_data currentNode = iterNodes.next();
			Iterator<edge_data> iterEdges = this.graph.getE(currentNode.getKey()).iterator();
			while(iterEdges.hasNext()){
				edge_data currentEdge = iterEdges.next();
				StdDraw.text((graph.getNode(currentEdge.getSrc()).getLocation().x()+
						graph.getNode(currentEdge.getDest()).getLocation().x())/2,
						(graph.getNode(currentEdge.getSrc()).getLocation().y()+
								graph.getNode(currentEdge.getDest()).getLocation().y())/2,
						""+currentEdge.getWeight());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		}
	}


