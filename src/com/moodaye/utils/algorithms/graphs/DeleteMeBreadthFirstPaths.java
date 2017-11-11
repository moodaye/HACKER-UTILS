package com.moodaye.utils.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeleteMeBreadthFirstPaths {
	private final int s;
	private boolean marked[];
	private int pathTo[];
	
	
	public DeleteMeBreadthFirstPaths(Graph G, int s){
		this.s = s;
		marked = new boolean[G.V()];
		pathTo = new int[G.V()];
		bfs(G,s);
	}
	
	private void bfs(Graph g, int v){
		Queue<Integer> queue = new LinkedList<>();
		
		marked[v] = true;
		queue.add(v);
		
		while(queue.size() != 0){
			int w = queue.remove();
			for ( int i : g.adj(w)){
				queue.add(i);
				pathTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v){ return marked[v];}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int x = v; x != s; x = pathTo[x])
			stack.push(x);
		
		stack.push(s);
		return stack;
	}
}