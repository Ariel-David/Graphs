package gui;

import static org.junit.Assert.assertEquals;

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
		DGraph g = new DGraph();
		Graph_Algo gg = new Graph_Algo();
		Point3D x = new Point3D(16,-14,0);
		Point3D y = new Point3D(30,15,0);
		Point3D z = new Point3D(-30,-15,0);
		Point3D w = new Point3D(-50,20,0);
		Point3D q = new Point3D(0,15,0);
		Point3D p = new Point3D(0,40,0);

		DGraph dg = new DGraph();
		Node n1 = new Node(1, 3, 0, w, "");
		Node n2 = new Node(2, 2, 0, x, "");
		Node n3 = new Node(3, 14, 0, y, "");
		Node n4 = new Node(4, 32, 0, z, "");
		Node n5 = new Node(5, 8, 0, q,"");
		Node n6 = new Node(6, 7, 0, p, "");
		dg.addNode(n1);
		dg.addNode(n2);
		dg.addNode(n3);
		dg.addNode(n4);
		dg.addNode(n5);
		dg.addNode(n6);
		dg.connect(n1.getKey(),n2.getKey(),1);
		dg.connect(n2.getKey(),n3.getKey(),2);
		dg.connect(n4.getKey(),n1.getKey(),3);
		dg.connect(n3.getKey(),n5.getKey(),4);
		dg.connect(n5.getKey(),n6.getKey(),4);
		dg.connect(n3.getKey(),n4.getKey(),4);
		dg.connect(n6.getKey(),n1.getKey(),4);

		Graph_GUI gui = new Graph_GUI(dg);
		gui.drawGraph();
		gg.init(dg);



	}

}
