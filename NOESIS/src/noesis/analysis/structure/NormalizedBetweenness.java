package noesis.analysis.structure;

import noesis.Network;
import noesis.algorithms.traversal.StronglyConnectedComponents;

// Normalized betweenness centrality, between 0 and 1.
// - Freeman's betweenness between (2n-1) and (n^2-(n-1)) in strongly-connected networks
// - Normalization:  ( score - (2n-1) ) / ( n^2 - (n-1) - (2n-1) ) where n is the size of the strongly-connected component

public class NormalizedBetweenness extends Betweenness
{
	public NormalizedBetweenness (Network network)
	{
		super(network);
	}	

	@Override
	public String getName() 
	{
		return "betweenness-norm";
	}	

	@Override
	public String getDescription() 
	{
		return "Normalized betweenness";
	}		
	
	@Override
	public double get(int node)
	{
		return normalizedBetweenness(node); // vs. standardBetweenness(node);
	}

	// Normalized to the [0,1] interval taking into account component sizes
	
	private StronglyConnectedComponents scc;
	
	public double normalizedBetweenness (int node)
	{
		int size;
		
		checkDone();
		
		if (scc==null) {
			scc = new StronglyConnectedComponents( getNetwork() );
			scc.compute();
		}
		
		size = scc.componentSize(node);
				
		return ( super.get(node) - (2*size-1) ) /(size*size-size+1); 
	}	

}