package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.node_data;
import gui.Graph_GUI;
import utils.Point3D;

public class Graph_AlgoTest {

	@Test
	public void testInitGraph() {
		DGraph gd = new DGraph();
		Node n1 = new Node(5,0,0,new Point3D(3,4),"");
		Node n2 = new Node(8,0,0,new Point3D(1,4),"");
		gd.addNode(n1);
		gd.addNode(n2);
		Graph_Algo ga = new Graph_Algo();
		ga.init(gd);
		assertEquals(gd.nodeSize(), ga.graph.nodeSize());
	}

	@Test
	public void testInitString() {
		DGraph gd = new DGraph();
		Node n1 = new Node(5,0,0,new Point3D(3,4),"");
		Node n2 = new Node(8,0,0,new Point3D(1,4),"");
		gd.addNode(n1);
		gd.addNode(n2);
		Graph_Algo ga1 = new Graph_Algo();
		ga1.init(gd);
		String file = "Graph_file.txt";
		ga1.save(file);
		Graph_Algo ga2 = new Graph_Algo();
		ga2.init(file);
		assertEquals(ga2.equals(ga1), ga1.equals(ga2));
	}

	@Test
	public void testSave() {
		DGraph gd = new DGraph();
		Node n1 = new Node(5,0,0,new Point3D(3,4),"");
		Node n2 = new Node(8,0,0,new Point3D(1,4),"");
		gd.addNode(n1);
		gd.addNode(n2);
		Graph_Algo ga1 = new Graph_Algo();
		ga1.init(gd);
		String file = "Graph_file.txt";
		ga1.save(file);
		Graph_Algo ga2 = new Graph_Algo();
		ga2.init(gd);
		assertEquals(ga2.equals(ga1), ga1.equals(ga2));
	}

	@Test
	public void testIsConnected() {
		Point3D x = new Point3D(0,30,0);
		Point3D y = new Point3D(-30,-15,0);
		Point3D z = new Point3D(30,-15,0);
		Point3D w = new Point3D(0,-20,0);
		Point3D q = new Point3D(0,15,0);

		node_data a = new Node(1,3,2,x,"");
		node_data b = new Node(2,4,3,y,"");
		node_data c = new Node(3,5,4,z,"");
		node_data e = new Node(4,6,5,w,"");

		DGraph d = new DGraph();
		d.addNode(a);
		d.addNode(b);
		d.addNode(c);
		d.addNode(e);

		d.connect(a.getKey(),b.getKey(),1);
		d.connect(b.getKey(),c.getKey(),2);
		d.connect(c.getKey(),a.getKey(),3);
		d.connect(c.getKey(),e.getKey(),4);
		d.connect(e.getKey(),b.getKey(),4);
		d.connect(e.getKey(),a.getKey(),4);
		
		Graph_Algo ga = new Graph_Algo();
		ga.init(d);
		assertTrue(ga.isConnected());
	}

	@Test
	public void testShortestPathDist() {
		fail("Not yet implemented");
	}

	@Test
	public void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testTSP() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopy() {
		fail("Not yet implemented");
	}

}
