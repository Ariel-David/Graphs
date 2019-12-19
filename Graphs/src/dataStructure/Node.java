package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import utils.Point3D;

public class Node implements node_data{
	private int key;
	private double Weight;
	private int tag;
	private Point3D location;
	String info;	
	public	Map<Integer, edge_data> edges= new HashMap<Integer,edge_data>();
	
	public void setKey(int key) {
		this.key = key;
	}
	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public Point3D getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.location = new Point3D(p);

	}

	@Override
	public double getWeight() {
		return this.Weight;
	}

	@Override
	public void setWeight(double w) {
		this.Weight = w;

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
	public Iterator<Node> iteretor() {
		return this.iteretor();
	}

}
