package com.moodaye.utils.algorithms.graphs;

import java.util.Stack;

public class DepthFirstPaths {
	int[] edgeTo;
	boolean marked[];
	final int s;
	
	public DepthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		for ( int w : G.adj(v))
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G, w);
			}
	}
	
	public boolean hasPathTo(int v){return marked[v];}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack = new Stack<>();
		for (int x = v; x != s; x = edgeTo[x]){
			stack.push(x);
		}
		return stack;
	}

}
