package algorithms;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import gui.Graph_GUI;
import utils.Point3D;

class test
{ 

	public static void main(String args[]) { 
		DGraph graphi = new DGraph();
		Graph_Algo gg = new Graph_Algo();
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
		
		graphi.addNode(n1);
		graphi.addNode(n2);
		graphi.addNode(n3);
		graphi.addNode(n4);
		graphi.addNode(n5);
		graphi.addNode(n6);
		
		graphi.connect(n1.getKey(), n2.getKey(), 10);
		graphi.connect(n2.getKey(), n4.getKey(), 15);
		graphi.connect(n2.getKey(), n3.getKey(), 12);
		graphi.connect(n3.getKey(), n4.getKey(), 1);
		graphi.connect(n3.getKey(), n5.getKey(), 2);
		graphi.connect(n4.getKey(), n5.getKey(), 5);
		graphi.connect(n1.getKey(), n6.getKey(), 15);
		graphi.connect(n6.getKey(), n5.getKey(), 10);

		gg.copy(graphi);
		
	}
} 



