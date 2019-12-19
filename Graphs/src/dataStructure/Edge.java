package dataStructure;

public class Edge implements edge_data {
	int src;
	int dest;
	double Weight;
	String info;
	int tag;
	
	public Edge(int src, int dest, double weight) {
		this.src = src;
		this.dest = dest;
		this.Weight = weight;
	}
	
	@Override
	public int getSrc() {
		return this.src;
	}

	@Override
	public int getDest() {
		return this.dest;
	}

	@Override
	public double getWeight() {
		return this.Weight;
	}

	@Override
	public String getInfo() {
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		this.info = s;
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		this.tag = t;
	}

}
