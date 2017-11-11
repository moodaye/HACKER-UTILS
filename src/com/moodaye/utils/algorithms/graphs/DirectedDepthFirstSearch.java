package com.moodaye.utils.algorithms.graphs;

/** one design note - no reference to Graph is saved! */
public class DirectedDepthFirstSearch {
	int count;
	boolean[] marked;
	
	public DirectedDepthFirstSearch(DiGraph G, int s){ 
		marked = new boolean[G.V()]; 
		dfs(G,s);
	}
	
	public DirectedDepthFirstSearch(DiGraph G, Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for ( int s : sources)
			if ( ! marked[s] )dfs(G, s);
	}
	
	private void dfs(DiGraph G, int v){
		marked[v] = true;
		count++;
		for ( int w : G.adj(v))
			if(! marked[w]) dfs(G,w);
	}
	
	public boolean marked(int w){ return marked[w];}
	
	public int count(){ return count;}
}
