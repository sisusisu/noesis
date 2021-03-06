package noesis.analysis;

import ikor.parallel.Task;
import noesis.Network;
import noesis.network.LinkIndex;
import noesis.network.LinkIndexer;

/**
 * Link score.
 * 
 * @author Fernando Berzal (berzal@acm.org)
 */

public class LinkScore extends Score
{
	private Network network;
	private LinkIndexer index;

	
	// Constructors
	
	public LinkScore (Task creator, Network network, LinkIndexer index)
	{
		super(network.links());
		
		this.network = network;
		this.index = index;
		
		setMetadata(creator);
	}

	public LinkScore (Task creator, Network network)
	{
		this (creator, network, new LinkIndex(network));
	}
	
	
	// Getters
	
	public final Network getNetwork ()
	{
		return network;
	}
	
	public final LinkIndexer getIndex ()
	{
		return index;
	}
		
	public double get (int source, int destination)
	{
		int link = index.index(source, destination);
		
		if (link!=-1)
			return get(link);
		else
			return Double.NaN;
	}
	
	public void set (int source, int destination, double value)
	{
		int link = index.index(source, destination);
		
		if (link!=-1)
			set(link, value);
	}
}
