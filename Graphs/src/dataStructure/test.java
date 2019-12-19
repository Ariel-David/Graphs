package dataStructure;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node();
		n1.setKey(1);
		Node n2 = new Node();
		n2.setKey(2);
		Node n3 = new Node();
		n3.setKey(3);
		Node n4 = new Node();
		n4.setKey(4);
		DGraph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		Edge e1 = new Edge(n1.getKey(), n4.getKey(), 5.0);
		//Edge e2 = new Edge(n2.getKey(), n3.getKey(), 6.0);
		Edge e3 = new Edge(n1.getKey(), n2.getKey(), 2.0);
		Edge e4 = new Edge(n1.getKey(), n3.getKey(), 3.0);
		g.connect(n2.getKey(), n3.getKey(), 6.0);
		n1.edges.put(n4.getKey(), e1);



		
	}

}
