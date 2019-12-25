package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.MenuBar;
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
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Range;
import utils.StdDraw;
import dataStructure.Edge;

public class Graph_GUI extends JFrame implements ActionListener{
	graph graphGui = new DGraph();


	public Graph_GUI(graph g, int width, int height ,Range x , Range y){
		this.graphGui = g;
		StdDraw.setCanvasSize(width,height);
		StdDraw.setXscale(x.get_min(),x.get_max());
		StdDraw.setYscale(y.get_min(),y.get_max());
		drawEdges();
		drawPoints();
		printKey();
		drawDirection();
		drawEdgesWeight();
	}

	public void drawPoints() {
		StdDraw.setPenColor(Color.pink);
		StdDraw.setPenRadius(0.02);
		StdDraw.setFont(new Font("Ariel", 3, 1));
		Iterator<node_data> iter = this.graphGui.getV().iterator();
		while(iter.hasNext()) {
			node_data currentNode = iter.next();
			StdDraw.point(currentNode.getLocation().x(), currentNode.getLocation().y());
		}
	}
	public void printKey() {
		StdDraw.setPenColor(Color.red);
		StdDraw.setPenRadius(1);
		StdDraw.setFont(new Font("Ariel", 3, 16));
		Iterator<node_data> iter = this.graphGui.getV().iterator();
		while(iter.hasNext()) {
			node_data currentNode = iter.next();
			StdDraw.text(currentNode.getLocation().x()-1, currentNode.getLocation().y()-5,""+currentNode.getKey());;
		}
	}
	public void drawEdges() {
		StdDraw.setPenColor(Color.black);
		StdDraw.setPenRadius(0.004);
		Iterator<node_data> iterNodes = this.graphGui.getV().iterator();
		while(iterNodes.hasNext()){
			node_data currentNode = iterNodes.next();
			Iterator<edge_data> iterEdges = this.graphGui.getE(currentNode.getKey()).iterator();
			while(iterEdges.hasNext()){
				edge_data currentEdge = iterEdges.next();
				StdDraw.line(graphGui.getNode(currentEdge.getSrc()).getLocation().x(), graphGui.getNode(currentEdge.getSrc()).getLocation().y(),graphGui.getNode(currentEdge.getDest()).getLocation().x(), graphGui.getNode(currentEdge.getDest()).getLocation().y());	
			}
		}
	}
	public void drawDirection() {
		StdDraw.setPenColor(Color.black);
		StdDraw.setPenRadius(0.004);
		Iterator<node_data> iterNodes = this.graphGui.getV().iterator();
		while(iterNodes.hasNext()){
			node_data currentNode = iterNodes.next();
			Iterator<edge_data> iterEdges = this.graphGui.getE(currentNode.getKey()).iterator();
			while(iterEdges.hasNext()){
				edge_data currentEdge = iterEdges.next();
				StdDraw.setPenRadius(0.010);
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.point(((graphGui.getNode(currentEdge.getSrc()).getLocation().x()+
						graphGui.getNode(currentEdge.getDest()).getLocation().x()*7)/8),
						((graphGui.getNode(currentEdge.getSrc()).getLocation().y())+
						graphGui.getNode(currentEdge.getDest()).getLocation().y()*7)/8);
			}
		}
	}
	public void drawEdgesWeight() {
		StdDraw.setPenColor(Color.DARK_GRAY);
		StdDraw.setPenRadius(0.004);
		Iterator<node_data> iterNodes = this.graphGui.getV().iterator();
		while(iterNodes.hasNext()){
			node_data currentNode = iterNodes.next();
			Iterator<edge_data> iterEdges = this.graphGui.getE(currentNode.getKey()).iterator();
			while(iterEdges.hasNext()){
				edge_data currentEdge = iterEdges.next();
				StdDraw.text(((graphGui.getNode(currentEdge.getSrc()).getLocation().x()+
						graphGui.getNode(currentEdge.getDest()).getLocation().x())/2),
						((graphGui.getNode(currentEdge.getSrc()).getLocation().y())+
						graphGui.getNode(currentEdge.getDest()).getLocation().y())/2,
						""+currentEdge.getWeight());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem menuItem1 = new JMenuItem(" Save...   ");
		menu.add(menuItem1);
		return menuBar;
	}
}

