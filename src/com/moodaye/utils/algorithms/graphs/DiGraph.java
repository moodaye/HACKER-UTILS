package com.moodaye.utils.algorithms.graphs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** Directed Graph - Re: Sedgewick ... Algorithms */
public class DiGraph {
	private final int V;
	private int E;
	private Set<Integer> adj[];
	
	public DiGraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Set<Integer>[]) new HashSet[V];
	}
	
	public DiGraph(Scanner in){
		this(in.nextInt());
		int e = in.nextInt();
		for (int i = 0; i < e; i++)
			addEdge(in.nextInt(), in.nextInt());
	}
	
	public int V(){ return V;}
	public int E(){ return E;}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public DiGraph reverse(){
		DiGraph reversed = new DiGraph(V);
		for( int v = 0; v < adj.length; v++)
			for ( int w : adj(v))
				reversed.addEdge(w, v);
		return reversed;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(V + " " + E);
		for( int v = 0; v < adj.length; v++)
			for ( int w : adj(v))
				sb.append(v + " " + w);
		return sb.toString();
	}
}
