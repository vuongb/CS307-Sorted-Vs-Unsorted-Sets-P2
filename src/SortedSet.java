// CS307 STUDENTS: PLACE YOUR NAMES ON THE NEXT LINE
// Student name(s): Emil Dides and Bryan Vuong

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * The data type for E must be a type that implements Comparable.
 * 
 * Students are to implement methods that were not implemented in AbstractSet and override
 * methods that can be done more efficiently. An ArrayList must be used as the internal storage container.
 * For methods involving two set, if that method can be done more efficiently if the 
 * other set is also a SortedSet do so.
 *
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     */
    public SortedSet(){
    	myCon = new ArrayList<E>();
    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null, all elements in other implement Comparable
     * and they are mutually comparable
     */
    public SortedSet(ISet<E> other){
    	SortedSet<E> output;
    	if(other instanceof UnsortedSet)
    		output = (SortedSet<E>) shellSort((SortedSet<E>) other);
    	else
    		output = (SortedSet<E>) other;
    	Iterator<E> it = output.iterator();
    	while(it.hasNext())
    		myCon.add(it.next());
    }
    
    // Method that uses shell sort algorithm to sort objects in ascending order.
    // Pre: list != null
    // Post: set returned is sorted
	public ISet<E> shellSort(SortedSet<E> list)
	{ 
		assert list != null;
		for(int gap = list.size() / 2; gap > 0; gap /= 2)
			for(int i = gap; i < list.size(); i++)
	{ 
		E tmp = list.getT(i);
		int j = i;
		
		for( ; j >= gap && tmp.compareTo( list.getT(j - gap) ) < 0;j -= gap )
			((List<E>) list).set(j,list.getT(j - gap));
			((List<E>) list).set(j,tmp);
		}
		return list;
	}
	
	
	// Method that returns what is in myCon
	// Pre: 0 < x < myCon.size()
	// Post: None
	public E getT(int x) {
		assert x > 0 && x < myCon.size();
		
		return myCon.get(x);
		}

    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    public E first(){
    	if ( myCon.isEmpty())
    		return null;
    	return myCon.get(0);
    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    public E last(){
    	if ( myCon.isEmpty())
    		return null;
    	return myCon.get(myCon.size()-1);
    }
    
    // O(logN)
    // Method checks the set if it contains the object
    // Pre: parameter != null
    // Post: None
	public boolean contains(E item) {
		assert item != null;
		int output = bsearch(item);
		return output >= 0;
		
	 }

    // O(N)
    // Method checks to see if 2 sets are equal disregarding duplicates
    // Pre: this != null
    // Post: None
    public boolean equals(Object o){
    	assert this != null;
    	
    	boolean bool = false;
    	int index = 0;
    	E item;
    	SortedSet<E> out;
    	if ( !(o instanceof ISet))
    		return false;
    	if(o instanceof UnsortedSet)
    		out = new SortedSet<E>((ISet<E>) o);
    	else
    		out = (SortedSet<E>) o;
    	return this.containsAll(out) && out.containsAll(this);
    	
//    	if(out.size() != this.size())
//    		return false;
//    	
//	    Iterator<E> it = out.iterator();
//	    while(it.hasNext())
//	    {
//	    	item = it.next();
//	    	if(!(item.equals(myCon.get(index))))
//	    		bool = true;
//	    	index++;
//	    }
//	   	return bool;
      }
	
	private int bsearch(E target) {
		int result = -1;
		int low = 0;
		int high = myCon.size() - 1;
		int mid;
		int compare;
		while(result == -1 && low <= high)
		{
			mid = low + ((high-low)/2);
			compare = myCon.get(mid).compareTo(target);
			if(compare == 0)
			{
				result = mid;
				break;
			}
			else if( compare < 0)
				low = mid+1;
			else
				high = mid - 1;
		}
		return result;
	}
	
	// O(N)
	// Method checks to see if the calling set contains all of the same things as the parameter set
	// Pre: items != null
	// Post: None
	public boolean containsAll(ISet<E> items) {
		assert items != null;
		
		SortedSet<E> other;
		if(this.isEmpty())
			return false;
		if(!(items instanceof SortedSet))
			other = new SortedSet<E>(items);
		else
			other = (SortedSet<E>) items;
		Iterator<E> it = items.iterator();
		E item = other.first();
		int index = 0;
		boolean flag = true;
		int count = 0;
		while(it.hasNext() && index < myCon.size())
		{
			if(flag)
			{
				item = it.next();
				flag = false;
			}
			if(myCon.get(index).equals(item))
			{
				flag = true;
				count++;
			}
			index++;				
		}
		return count == items.size();
	}
    
    // O(N)
    // Method that adds an object item to a set, and inserting it in the correct position
    // Pre: item != null
    // Post: set contains parameter item if not already in set
	public boolean add(E item) {
		assert item != null;
		
		if(this.isEmpty())
			return myCon.add(item);
		int index = 0;
		boolean flag = false;
		boolean same = false;
		int foundIndex = 0;
		int compare = Integer.MIN_VALUE;
		while(index < myCon.size()) {
			compare = myCon.get(index).compareTo(item);
			if(compare > 0)
			{
				foundIndex = index;
				break;
			}
			else if(compare == 0)
				same = true;
			index++;
		}
		if(index == myCon.size() && !same)
		{
			myCon.add(item);
			flag = true;
		}
		else if (!same)
		{
			myCon.add(foundIndex, item);
			flag = true;
		}
		return flag;
	}
	public boolean addLast(E item) {
		return myCon.add(item);
	}
	
	// O(N)
	// Method that adds all of elements in parameter set if it's not already included
	// in calling set
	// Pre: otherSet != null
	// Post: None
	public boolean addAll(ISet<E> otherSet) {
		assert otherSet != null;
		
		SortedSet<E> other;
		if(otherSet instanceof UnsortedSet)
			other = new SortedSet<E>(otherSet);
		else
			other = (SortedSet<E>) otherSet;
		
		Iterator<E> it = other.iterator();
		boolean flag = false;

		if(this.isEmpty())
		{
			while(it.hasNext())
				myCon.add(it.next());
			return true;
		}
		else
		{
			int thisPos = 0;
			E item = other.first();
			E past = other.first();
			boolean bool = true;
			boolean notAdd = false;
			if(this.isEmpty())
			{
				while(it.hasNext())
					myCon.add(it.next());
			}
			else
			{
				while(it.hasNext() && thisPos < myCon.size())
				{
					if(bool)
					{
						bool = false;
						item = it.next();
						past = item;
						notAdd = false;
					}
					int compare = myCon.get(thisPos).compareTo(item);
					if(compare > 0)
					{
						myCon.add(thisPos, item);
						notAdd = true;
						flag = true;
					}
					else
						flag = true;
					thisPos++;
				}
				if(!notAdd)
					myCon.add(past);
				while(it.hasNext())
					myCon.add(it.next());
			}
			return flag;
		}		
	}

	// O(1)
	// Method that returns the iterator being used for the constructor.
	// Pre: None
	// Post: None
	public Iterator<E> iterator() {
		return myCon.iterator();
	}
	
	// O(N)
	// Method that removes everything from myCon.
	// Pre: None
	// Post: calling set is now empty
    public void clear() {
    	myCon.clear();
    }

	// O(N)
    // Method that removes all instances of item, given by the parameter.
    // Pre: None
    // Post: item is removed from set.
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

		
	// O(N)
	// Method that returns the difference of calling set and parameter set.
	// Pre: otherSet != null
	// Post: ISet<E> that is returned is difference of parameter.
	public ISet<E> difference(ISet<E> otherSet) {
		assert otherSet != null;

		SortedSet<E> output = new SortedSet<E>();	

		int index = 0;
		Iterator<E> it1 = otherSet.iterator();
		Iterator<E> it2 = this.iterator();
		
		
		if (otherSet.size() > this.size()){
			E it2Temp = it2.next();
			while (it1.hasNext()) {
				if (it1.next().compareTo(it2Temp) != 0)
					output.add(it2Temp);
				else if(it2.hasNext())
					it2Temp = it2.next();
			}
		}
		else
		{
			E it1Temp = it1.next();
			while(it2.hasNext())
			{
				if(it2.next().compareTo(it1Temp) != 0)
					output.add(it1Temp);
				else if(it1.hasNext())
					it1Temp = it1.next();
			}
		}

		return output;
	}

	// O(N)
	// Method that returns the intersection of calling set and parameter set.
	// Pre: None
	// Post: ISet<E> that is returned is intersection of parameter)
	public ISet<E> intersection(ISet<E> otherSet) {
		assert otherSet != null;
		
		SortedSet<E> result = new SortedSet<E>();
		SortedSet<E> other;
		if(otherSet instanceof SortedSet)
			other = (SortedSet<E>) otherSet;
		else
			other = new SortedSet<E>(otherSet);
		
		Iterator<E> itOther = other.iterator();
		Iterator<E> itThis = this.iterator();
		E itemThis = myCon.get(0);
		E itemOther = other.first();
		int compare;
		boolean flagThis = true;
		boolean flagOther = true;
		while(itOther.hasNext() && itThis.hasNext())
		{
			if(flagOther)
			{
				itemOther = itOther.next();
				flagOther = false;
			}
			if(flagThis)
			{
				itemThis = itThis.next();
				flagThis = false;
			}
			
			compare = itemThis.compareTo(itemOther);
			if(compare > 0)
				flagOther = true;
			else if (compare < 0)
				flagThis = true;
			else
			{
				flagThis = true;
				flagOther = true;
				result.addLast(itemThis);
			}
						
		}
		
		
		return result;
		
//		SortedSet<E> result = new SortedSet<E>();
//		Iterator<E> it = otherSet.iterator();
//		SortedSet<E> other;
//		if(otherSet instanceof SortedSet)
//			other = (SortedSet<E>) otherSet;
//		else
//			other = new SortedSet<E>(otherSet);
//		E data = other.first();
//		int index = 0;
//		boolean flag = true;
//		int compare;
//		while(it.hasNext() && index < myCon.size())
//		{
//			if(flag)
//			{
//				data = it.next();
//				flag = false;
//			}
//			compare = myCon.get(index).compareTo(data);
//			if(compare == 0)
//			{
//				result.addLast(data);
//				flag = true;
//				index++;
//			}
//			else if(compare > 0)
//				flag = true;
//			else
//				index++;
//				
//		}
//		return result;
	}
	
}
