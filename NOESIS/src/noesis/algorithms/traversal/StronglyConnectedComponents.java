package noesis.algorithms.traversal;

import noesis.*;
import noesis.algorithms.NodeVisitor;

// Kosaraju's two pass O(m+n) algorithm

public class StronglyConnectedComponents 
{
	private Network network;
	private int index[];
	private int components; 

	private int order[];
	private int sizes[];
	
	public StronglyConnectedComponents (Network network)
	{
		this.network    = network;
		this.index      = new int[network.size()];
		this.components = 0;
	}
	
	public final Network getNetwork ()
	{
		return this.network;
	}
	
	/**
	 * Number of strongly connected components.
	 * @return The number of strongly connected components in the network
	 */
	
	public final int components ()
	{
		return components;
	}
	
	/**
	 * Component index.
	 * @return An integer indicating the strongly connected component for the specified node.
	 */
	
	public final int component (int node)
	{
		return index[node];
	}
	
	/**
	 * Component size.
	 * @return An integer representing the size of the strongly connected component the specified node belongs to.
	 */
	
	public final int componentSize (int node)
	{
		if (sizes==null)
			sizes = componentSizes();
		
		return sizes[component(node)-1];
	}
	
	/**
	 * Component index.
	 * @return An array indicating the strongly connected component for each node.
	 */
	
	public final int[] componentIndex ()
	{
		return index;
	}
	
	/**
	 * Strongly-connected component sizes
	 * @return An array containing the number of nodes within each strongly connected component.
	 */
	
	public final int[] componentSizes ()
	{
		sizes = new int[components];
		
		for (int i=0; i<network.size(); i++)
			sizes[ index[i]-1 ]++;
		
		return sizes;
	}
	
	
	private Network reverseNetwork (Network net)
	{
		Network reverse = new BasicNetwork();
		int     size = net.size();
		int     degree;
		
		reverse.setSize(size);
		
		for (int i=0; i<size; i++) {
			degree = net.outDegree(i);

			for (int j=0; j<degree; j++)
		    	reverse.add( net.outLink(i,j), i);
		}
		
		return reverse;
	}
	
	public final void compute ()
	{
		// Topological sort on reverse network
		// (finishing time for each node)
		
		Network reverse = reverseNetwork(network);
		
		TopologicalSort ts = new TopologicalSort(reverse);
		
		ts.sort();
		
		order = ts.nodes();
		
		// DFS on original network
		// (in decreasing order of finishing time)
		
		NetworkDFS dfs = new NetworkDFS(network);
	
		dfs.setNodeVisitor(new StrongComponentVisitor(this));
		
		for (int i=0; i<network.size(); i++) {
			if (index[order[i]]==0) {
				components++;
				dfs.traverse(order[i]);
			}
		}
	}

	// Visitor
	
	private class StrongComponentVisitor extends NodeVisitor
	{
		private StronglyConnectedComponents scc;
		
		public StrongComponentVisitor (StronglyConnectedComponents scc)
		{
			this.scc = scc;
		}

		@Override
		public void visit(int node) 
		{
			scc.index[node] = scc.components;
		}	
	}

}
