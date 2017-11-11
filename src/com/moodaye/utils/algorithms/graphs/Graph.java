package com.moodaye.utils.algorithms.graphs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** Undirected Graph - Re: Sedgewick ... Algorithms */
public class Graph {
	private final int V;
	private int E;
	private Set<Integer> adj[];
	
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = (Set<Integer>[]) new HashSet[V];
	}
	
	public Graph(Scanner in){
		this(in.nextInt());
		int e = in.nextInt();
		for (int i = 0; i < e; i++)
			addEdge(in.nextInt(), in.nextInt());
	}
	
	public int V(){ return V;}
	public int E(){ return E;}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
