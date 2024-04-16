package range_design;

public class Range<T extends Comparable<T>>
{
    private T start;
    private T end;
    
    public Range(T start, T end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end values cannot be null.");
        }
        
        if (start.compareTo(end) >= 0) {
            throw new IllegalArgumentException("Start value must be less than end value.");
        }
        
        this.start = start;
        this.end = end;
    }
    
    public static <T extends Comparable<T>> Range<T> of(T start, T end) {
    	//The 'start' must be less than 'end' value, then it is accepted as a range
        return new Range<>(start, end);
    }
    
    
    @Override
    public String toString() {
        return "[" + start + " - " + end + "]";
    }

	public boolean contains(T variable)
	{
		if(start.compareTo(variable)<=0 && end.compareTo(variable)>=0)
		{
			return true;
		}
		else
			return false;	
	}
	
	public boolean containsRange(Range<T> otherRange)
	{
		if(start.compareTo(otherRange.start)<=0 && 
				end.compareTo(otherRange.start)>0 && 
				start.compareTo(otherRange.end)<0 && 
				end.compareTo(otherRange.end)>=0)
			return true;
		return false;
	}

	public Range<T> merge(Range<T> otherRange) throws CannotMergeException {
    if (!containsRange(otherRange)) {
        if (!otherRange.containsRange(this)) {
            if (start.compareTo(otherRange.end) <= 0 && end.compareTo(otherRange.end)>0) {
                return new Range<>(otherRange.start, end);
            } else if (end.compareTo(otherRange.start) >= 0) {
                return new Range<>(start, otherRange.end);
            } else {
                throw new CannotMergeException("Given range does not have common point to merge");
            }
        } else {
            return otherRange;
        }
    } else {
        return new Range<>(start, end);
    }
}

	public Range<T> intersection(Range<T> otherRange) throws NoIntersectionException
	{
		 if (!containsRange(otherRange)) {
			 if (!otherRange.containsRange(this)) {
				 if(start.compareTo(otherRange.start)>0 && start.compareTo(otherRange.end)<=0 && end.compareTo(otherRange.start)>0)
					 return Range.of(start, otherRange.end);
				 else if(end.compareTo(otherRange.start)>=0)
					 return Range.of(otherRange.start, end);
				 else
					 throw new NoIntersectionException("No common point found");
			 }
			 else {
				 return this;
			 }
			 
		 }
		 else
			 return otherRange;
	}
	
	public T fit(T element)
	{
		if(contains(element))
			return element;
		else if(start.compareTo(element)>0)
			return start;
		else if(end.compareTo(element)<0)
			return end;
		else
			return null;
	}
}
