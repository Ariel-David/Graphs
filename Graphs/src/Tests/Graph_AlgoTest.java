package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		assertTrue(ga2.graph.equals(ga2.graph));
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
		gg.init(dg);
		double expected = 11;
		double actual = gg.shortestPathDist(6, 4);
		boolean flag = false;
		if(expected == actual) {
			flag = true;
		}
		else {
			flag = false;
		}
		assertTrue(flag);
	}

	@Test
	public void testShortestPath() {
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
		gg.init(dg);
		List<node_data> list1 = new ArrayList<node_data>();
		List<node_data> list2 = new ArrayList<node_data>();
		list1.add(n6);
		list1.add(n1);
		list1.add(n2);
		list1.add(n3);
		list1.add(n4);
		list2 = gg.shortestPath(6, 4);
		boolean flag = false;
		if(list1.equals(list2)) {
			flag = true;
		}
		else {
			flag = false;
		}
		assertTrue(flag);
	}

	@Test
	public void testTSP() {
		Point3D x = new Point3D(16,-14,0);
		Point3D y = new Point3D(30,15,0);
		Point3D z = new Point3D(-30,-15,0);
		Point3D w = new Point3D(-50,20,0);
		Point3D q = new Point3D(0,15,0);
		Point3D p = new Point3D(0,40,0);
		Graph_Algo ga = new Graph_Algo();
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
		ga.init(dg);

		List<Integer> targets=new ArrayList<>();
		targets.add(2);
		targets.add(4);

		List<node_data> ans = ga.TSP(targets);
		List<node_data> expected = new ArrayList<node_data>();
		expected.add(new Node(2));
		expected.add(new Node(3));
		expected.add(new Node(4));

		assertEquals(expected, ans);

	}


}
