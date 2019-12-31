package gui;

import java.util.ArrayList;
import java.util.List;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import utils.Range;
import gui.Graph_GUI;

public class Main {

	public static void main(String[] args) {
//		DGraph g = new DGraph();
	Graph_Algo gg = new Graph_Algo();
		
		Point3D x = new Point3D(0,30,0);
		Point3D y = new Point3D(-30,-15,0);
		Point3D z = new Point3D(30,-15,0);
		Point3D w = new Point3D(0,-20,0);
		Point3D q = new Point3D(0,15,0);

		node_data a = new Node(1,3,2,x,"michal");
		node_data b = new Node(2,4,3,y,"yarden");
		node_data c = new Node(3,5,4,z,"sf");
		node_data e = new Node(4,6,5,w,"sd");
		//node_data f = new Node(5,7,6,q,"ssss");

		DGraph d = new DGraph();
		d.addNode(a);
		d.addNode(b);
		d.addNode(c);
		d.addNode(e);
		//		d.addNode(f);
		d.connect(a.getKey(),b.getKey(),1);
		d.connect(b.getKey(),c.getKey(),2);
		d.connect(c.getKey(),a.getKey(),3);
		d.connect(c.getKey(),e.getKey(),4);
		d.connect(e.getKey(),b.getKey(),4);
		d.connect(e.getKey(),a.getKey(),4);
		Graph_GUI gui = new Graph_GUI(d);
//
//		Point3D p1 = new Point3D(33,30);
//		Point3D p2 = new Point3D(-12,-16);
//		Point3D p3 = new Point3D(44,-7);
//		Point3D p4 = new Point3D(-70,22);
//		Point3D p5 = new Point3D(10,-52);
//		Point3D p6 = new Point3D(29,-2);
//		
//		Node n0 = new Node(0, 0 , 0, p1, "");
//		Node n1 = new Node(1, 0 , 0, p2, "");
//		Node n2 = new Node(2, 0 , 0, p3, "");
//		Node n3 = new Node(3, 0 , 0, p4, "");
//
//		g.addNode(n0);
//		g.addNode(n1);
//		g.addNode(n2);
//		g.addNode(n3);
//		
//		g.connect(n0.getKey(), n1.getKey(), 10);
//		g.connect(n0.getKey(), n2.getKey(), 12);
//		g.connect(n0.getKey(), n3.getKey(), 1);
//		g.connect(n2.getKey(), n0.getKey(), 2);
//		g.connect(n2.getKey(), n1.getKey(), 5);
//		g.connect(n1.getKey(), n3.getKey(), 8);
//

//		Graph_GUI gui = new Graph_GUI(g);
		gui.drawGraph();
		gg.init(d);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(1);
		gg.TSP(list);
		
	}

}
