package ikor.collection;

//Title:       iKor Collection Framework
//Version:     1.0
//Copyright:   2011
//Author:      Fernando Berzal Galiano
//E-mail:      berzal@acm.org

import java.util.Comparator;
import java.util.Iterator;

/**
 * Standard priority queue implementation, based on java.util.PriorityQueue.
 * The standard implementation provides O(log n) time for the insertion  
 * get() and add() methods; linear time for the remove() and contains() methods; 
 * and constant time for the peek() and size() retrieval methods.
 * 
 * @author Fernando Berzal
 */
public class DynamicPriorityQueue<T> implements PriorityQueue<T> 
{
	private static final int INITIAL_CAPACITY = 8;
	
	private java.util.PriorityQueue<T> queue;
	
	// Constructors
	
	/**
	 * Default constructor: Creates a priority queue.
	 */
	
	public DynamicPriorityQueue ()
	{
		this.queue = new java.util.PriorityQueue<T>(INITIAL_CAPACITY);
	}
	
	/**
	 * Constructor: Creates a priority queue 
	 * that orders its elements according to the specified comparator.
	 * 
	 * @param comparator The comparator used to order this priority queue. If null, then the order depends on the elements' natural ordering.
	 */
	
	public DynamicPriorityQueue (Comparator comparator)
	{
		this.queue = new java.util.PriorityQueue<T>(INITIAL_CAPACITY, comparator);
	}
	
	
	// PriorityQueue interface
	
	/**
	 * Adds the specified element to the queue: O(log n).
	 * 
	 * @see ikor.collection.MutableCollection#add(java.lang.Object)
	 */
	@Override
	public boolean add(T object) 
	{
		return queue.add(object);
	}

	/**
	 * Removes a single instance of the specified element from this priority queue, if it is present: O(n).
	 * 
	 * @see ikor.collection.MutableCollection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(T object) 
	{
		return queue.remove(object);
	}

	/**
	 * Removes all elements from this priority queue.
	 * 
	 * @see ikor.collection.MutableCollection#clear()
	 */
	@Override
	public void clear() 
	{
		queue.clear();
	}

	/**
	 * Number of elements in this priority queue: O(1).
	 * 
	 * @see ikor.collection.Collection#size()
	 */
	@Override
	public int size() 
	{
		return queue.size();
	}

	/**
	 * Returns true if this collection contains the specified element: O(n).
	 * 
	 * @see ikor.collection.Collection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(T object) 
	{
		return queue.contains(object);
	}

	/**
	 * Returns an iterator over the elements in this priority queue.
	 * 
	 * @see ikor.collection.Collection#iterator()
	 */
	@Override
	public Iterator<T> iterator() 
	{
		return queue.iterator();
	}

	/**
	 * Retrieves, but does not remove, the head of this queue: O(1).
	 * 
	 * @return head of this queue, null if this queue is empty.
	 * @see ikor.collection.PriorityQueue#peek()
	 */
	@Override
	public T peek() 
	{
		return queue.peek();
	}

	/**
	 * Retrieves and removes the head of this queue: O(log n).
	 *   
	 * @return head of this queue, null if this queue is empty.
	 * @see ikor.collection.PriorityQueue#get()
	 */
	@Override
	public T get() 
	{
		return queue.poll();
	}

	/**
	 * Returns the comparator used to order this collection, or null if this collection is sorted according to its elements natural ordering (using Comparable).
	 * 
	 * @see ikor.collection.PriorityQueue#comparator()
	 */
	@Override
	public Comparator comparator() 
	{
		return queue.comparator();
	}

}
