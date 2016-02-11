// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    // Implement this without using another data structure and copying all the elements from the Iterator to the data structure
    // Idea: Use a boolean to track whether or not we have moved the iterator
    // When we call peek(), we call next() if the boolean is not set, set boolean after
    // Otherwise we just return the value
    // When we call next(), we call next() if the boolean is not set, toggles boolean
    // If the boolean is set, we just return the appropriate value, toggles boolean
    
    // we need to interweave calls to next() and peek()
    
    boolean flag;
    Integer val;
    Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    flag = false;
	    val = null;
	    this.iterator = iterator;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(flag == false){
            val = iterator.next();
            flag = true;
        }
        
        return val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(flag == false){
            val = iterator.next();
        }
        
        else if(flag == true){
            flag = false;
        }
        
        return val;
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext() || flag == true;
	}
}