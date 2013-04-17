package noesis.io.graphics;

import ikor.model.graphics.Style;

import java.awt.Color;


public abstract class NodeRenderer 
{
	public static final int DEFAULT_SIZE = 16;
	public static final int DEFAULT_WIDTH = 2;
	
	private int size = DEFAULT_SIZE;
	private Indexer<Integer> sizeIndex;
	private Indexer<Integer> colorIndex;
	private ColorMap colorMap;
	
	
	// Node size

	public final int getSize()
	{
		return size;
	}
	
	public final void setSize (int size)
	{
		if (size>=0)
			this.size = size;
	}
	
	public final Indexer<Integer> getSizeIndexer ()
	{
		return sizeIndex;
	}
	
	public final void setSizeIndexer (Indexer<Integer> sizeIndex)
	{
		this.sizeIndex = sizeIndex;
	}
	
	
	public final int getSize (int node)
	{
		if (sizeIndex==null)
			return size;
		else
			return size + sizeIndex.index(node);
	}
	
	// Node colors

	public final Indexer<Integer> getColorIndexer ()
	{
		return colorIndex;
	}
	
	public final void setColorIndexer (Indexer<Integer> colorIndex)
	{
		this.colorIndex = colorIndex;
	}
	
	public final ColorMap getColorMap ()
	{
		return colorMap;
	}
	
	public final void setColorMap (ColorMap colorMap)
	{
		this.colorMap = colorMap;
	}
	
	public final int getColorIndex (int node)
	{
		if (colorIndex!=null)
			return colorIndex.index(node); 
		else
			return 0;
	}
	
	public final Color getColor (int node)
	{
		return colorMap.getColor( getColorIndex(node) );
	}
	
	public abstract Style getStyle (int node);
	
	// Node rendering
	
	public abstract void render (NetworkRenderer drawing, int node);
	
	public abstract void update (NetworkRenderer drawing, int node);
	
}
