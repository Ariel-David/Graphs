package dataStructure;

import java.io.Serializable;


public class Edge implements edge_data,Serializable {
	int src;
	int dest;
	double Weight;
	String info;
	int tag;

	public Edge() {
		this.src = 0;
		this.dest = 0;
		this.tag = 0;
		this.info = "";
		this.Weight = 0;
	}

	public Edge(int src, int dest, double weight, String info , int tag) {
		this.src = src;
		this.dest = dest;
		this.tag = tag;
		this.info = info;
		this.Weight = weight;
	}
	
	public Edge(Edge e) {
		this.src = e.src;
		this.dest = e.dest;
		this.tag = e.tag;
		this.info = e.info;
		this.Weight = e.Weight;
	}
	
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
