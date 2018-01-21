// CS307 STUDENTS: PLACE YOUR NAMES ON THE NEXT LINE
// Student name(s): Emil Dides and Bryan Vuong

import java.util.Iterator;

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E>{
    
	// O(N)
	// Method creates a string of the sets
	// Pre: None
	// Post: None
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
                result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
    
    // Unsorted Set:
    // O(N^2)
    // Sorted Set:
    // O(N)
    // Method checks to see if 2 sets are equal disregarding duplicates
    // Pre: this != null
    // Post: None
    public boolean equals(Object o){
    	assert this != null;
    	
    	if ( !(o instanceof ISet))
    		return false;
    	return this.containsAll((ISet<E>) o);
      }
    
    // O(N)
    // Method adds all items from the parameter to the called set
    // Pre: items != null
    // Post: The Calling Set's contents consists of it's original + parameter set items
    public boolean addAll(ISet<E> items) {
    	assert items != null;
    	
    	boolean result = false;
    	Iterator<E> it = items.iterator();
    	while (it.hasNext())
    	{
    	  if (add(it.next()))
    	   result = true;
    	}
    	return result;
    }
    
    // O(N)
    // Method clears/removes the entire contents of the set
    // Pre: None
    // Post: Calling Set is empty
    public void clear() {
	  Iterator<E> it = iterator();
	  while (it.hasNext())
	  {
		  it.next();
		  it.remove();
	  }
	 }

	// O(N)
    // Method checks the set if it contains the object
    // Pre: parameter != null
    // Post: None
	public boolean contains(E item) {
	  Iterator<E> it = iterator();
	  if (item != null)
	  {
		  while (it.hasNext())
		  {
			  if (item.equals(it.next()))
				  return true;
		  }
	  } 
	  else {
		  while (it.hasNext())
		  {
			  if (it.next() == null)
				  return true;
		  }
	  }
	  return false;
 }
	
	// O(N^2)
	// Method checks to see if the calling set contains all of the same things as the parameter set
	// Pre: items != null
	// Post: None
	public boolean containsAll(ISet<E> items) {
		assert items != null;
		
		Iterator<E> it = items.iterator();
		boolean bool = true;
		while (it.hasNext()) 
		{
			E item = it.next();
			if (!(this.contains(item)))
				bool = false;
		}
		return bool;
	}

	// O(1)
	// Method checks if the set is empty
	// Pre: None
	// Post: None
	public boolean isEmpty() {
		return size() == 0;
	}

	// Unsorted Set:
	// O(N^2)
	// Sorted Set:
	// O(N)
	// Method finds the union between the calling set and parameter set
	// Pre: items != null'
	// Post: None
	public ISet<E> union(ISet<E> items) {
		assert items != null;
		
		ISet<E> temp = this.difference(items);
		ISet<E> temp2 = this.intersection(items);
		temp.addAll(temp2);
		return temp;
	}

	// Method returns iterator being used.
	// Pre: None
	// Post: None
	public Iterator<E> iterator() {
		return this.iterator();
	}

}
