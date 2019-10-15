package textgen;

import javax.xml.soap.Node;
import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
        size=0;
        head=new LLNode<E>(null);
        tail=new LLNode<E>(null);
        head.next=tail;
        tail.prev=head;

		// TODO: Implement this method (DONE)
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element)
	{
		// TODO: Implement this method (DONE)
       this.add(this.size,element);
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method. (DONE)
        if (index>=size || index<0)
        {
            throw new IndexOutOfBoundsException();
        }

		return getNode(index).data;
	}
	public LLNode<E> getNode(int index)
    {
        LLNode<E> current = head.next;
        int CurrIndex=0;

        while(current != tail && CurrIndex < index)
        {
            current = current.next;
            CurrIndex++;
        }
        return current;
    }

	/**
	 * Add an element to the list at the specified index
	 * @param //The index where the element should be added
	 * @param  element The element to add
	 */
	public void add(int index, E element ) 
	{

        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("The index value is invalid");
        }
        if (element==null)
        {
            throw new NullPointerException("Null values are not allowed");
        }
        LLNode<E> curr = getNode(index);
        LLNode<E> newNode=  new LLNode<E>(element, curr.prev);
        size++;

		// TODO: Implement this method (DONE)
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method(DONE)
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		E data=get(index);
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("The index value is invalid");
		}
		LLNode<E> curr = getNode(index);
		LLNode<E> previousNode=curr.prev;
		previousNode.next=curr.next;
		LLNode<E> nextNode=curr.next;
		nextNode.prev=curr.prev;
		size--;
		// TODO: Implement this method(DONE)
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("The index value is invalid");
        }
        if (element==null)
        {
            throw new NullPointerException("Null values are not allowed");
        }
        LLNode curr=getNode(index);
        E oldData=get(index);
        curr.data=element;
		// TODO: Implement this method
		return oldData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
    public LLNode(E e, LLNode<E> prevNode) {
        this(e);
        if(prevNode != null)
        {
            this.next = prevNode.next;
            if(this.next!=null) {
                (this.next).prev = this;
            }
            prevNode.next = this;
            this.prev = prevNode;
        }
    }
}
