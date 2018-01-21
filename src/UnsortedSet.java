// CS307 STUDENTS: PLACE YOUR NAMES ON THE NEXT LINE
// Student name(s): Emil Dides and Bryan Vuong

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */

public class UnsortedSet<E> extends AbstractSet<E> {

	private ArrayList<E> myCon;
	
	public UnsortedSet(){
		myCon = new ArrayList<E>();
	}
	
	// O(N)
	// Method that adds an item to the end of the set if it isn't already present
    // Pre: None
    // Post: None
	public boolean add(E item) {
		boolean bool = false;
		for(int i = 0; i < myCon.size(); i++)
			if(myCon.get(i).equals(item))
				bool = true;
		if(!bool)
			return myCon.add(item);
		else
			return bool;
	}

	// O(N^2)
	// Method adds all elements already not part of calling set to calling set
	// Return true if set is altered.
	// Pre: otherSet != null
	// Post: Calling Set has all of its original elements + otherSet's elements
	public boolean addAll(ISet<E> otherSet) {
		assert otherSet != null;
		
		Iterator <E> it = otherSet.iterator();
		boolean result = false;
		int index = 0;
		if(this.isEmpty())
		{
			while(it.hasNext())
				myCon.add(it.next());
			return true;
		}
		else
		{
			while(it.hasNext())
			{
				E item = it.next();
				index = 0;
				while(index < myCon.size())
				{
					if (!(item.equals(myCon.get(index))))
					{
						myCon.add(item);
						result = true;
					}
					index++;
				}
			}
			return result;
		}
	}
	
	
	// O(1)
	// Method that returns the iterator being used for the constructor.
	// Pre: None
	// Post: None
	public Iterator<E> iterator() {	
		return myCon.iterator();
	}
	
	// Method that removes everything from myCon.
	// Pre: None
	// Post: Set is empty
    public void clear() {
    	myCon.clear();
    }

	// O(N)
    // Method that removes all instances of an element, given by the parameter.
    // Pre: None
    // Post: Parameter element is removed.
	public boolean remove(E item) {
		boolean bool = false;
		for(int i = 0; i < size(); i++)
		{
			if(item.equals(myCon.get(i)))
			{
				myCon.remove(i);
				bool = true;
			}
		}
		return bool;
	}

	
	// O(1)
	// Method returns the size of the set.
	// Pre: None
	// Post: None
	public int size() {
		return myCon.size();
	}
	
	
	// O(N^2)
	// Method that returns the Set Theory difference of the calling set and parameter set.
	// Pre: otherSet != null
	// Post: ISet<E> that is returned is difference of parameter.
	public ISet<E> difference(ISet<E> otherSet) {
		assert otherSet != null;
		
		ISet<E> output = new UnsortedSet<E>();
		Iterator<E> it = otherSet.iterator();
		for(int i = 0; i<myCon.size(); i++)
		{
			if(!output.contains(myCon.get(i)) && !otherSet.contains(myCon.get(i)))
				output.add(myCon.get(i));
		}
		while(it.hasNext())
		{
			E data = it.next();
			if(!output.contains(data) && !this.contains(data))
				output.add(data);
		}
		return output;
	}
	
	
	// O(N^2)
	// Method that returns the intersection of the calling set and parameter set
	// Pre: otherSet != null
	// Post: ISet<E> that is returned is intersection of parameter.
	public ISet<E> intersection(ISet<E> otherSet) {
		assert otherSet != null;
		
		ISet<E> result = new UnsortedSet<E>();
		Iterator<E> it = this.iterator();
		while(it.hasNext())
		{
			E data = it.next();
			if(otherSet.contains(data) && !result.contains(data));
				result.add(data);
		}
		return result;
	}

}
