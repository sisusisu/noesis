package ikor.collection;

// Title:       iKor Collection Framework
// Version:     1.0
// Copyright:   2011
// Author:      Fernando Berzal Galiano
// E-mail:      berzal@acm.org

import java.util.Iterator;

/**
 * List iterator
 * 
 * @author Fernando Berzal
 *
 * @param <T> List item type
 */
public class ListIterator<T> implements Iterator<T> 
{
	List<T> list;
	int     index;
	int     last;

	public ListIterator (List<T> list)
	{
		this(list,0,list.size()-1);
	}

	public ListIterator (List<T> list, int start, int end)
	{
		this.list  = list;
		this.index = start;
		this.last  = end;
	}

	@Override
	public boolean hasNext() {
		return (index<last);
	}

	@Override
	public T next() {
		return (T) list.get(index++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("An subsequence cannot have elements removed");
	}
}