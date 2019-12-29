package gui;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import utils.Point3D;
import utils.Range;
import gui.Graph_GUI;

public class Main {

	public static void main(String[] args) {
		DGraph g = new DGraph();
		Graph_Algo gg = new Graph_Algo();
		Graph_Algo gg2= new Graph_Algo();

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();

		n1.setKey(1);
		n2.setKey(2);
		n3.setKey(3);
		n4.setKey(4);
		n5.setKey(5);
		n6.setKey(6);

		Point3D p1 = new Point3D(30,30);
		Point3D p2 = new Point3D(12,-16);
		Point3D p3 = new Point3D(-13,-7);
		Point3D p4 = new Point3D(-70,22);
		Point3D p5 = new Point3D(10,-52);
		Point3D p6 = new Point3D(29,-2);

		n1.setLocation(p1);
		n2.setLocation(p2);
		n3.setLocation(p3);
		n4.setLocation(p4);
		n5.setLocation(p5);
		n6.setLocation(p6);

		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);

		g.connect(n1.getKey(), n2.getKey(), 10);
		g.connect(n2.getKey(), n3.getKey(), 12);
		g.connect(n3.getKey(), n4.getKey(), 1);
		g.connect(n3.getKey(), n5.getKey(), 2);
		g.connect(n4.getKey(), n5.getKey(), 5);
		g.connect(n6.getKey(), n5.getKey(), 3);
		g.connect(n1.getKey(), n6.getKey(), 6);


		
	
	
	Graph_GUI gui = new Graph_GUI(g);
	gui.drawGraph();
	gg.shortestPath(n4.getKey(), n5.getKey());
	}

}
