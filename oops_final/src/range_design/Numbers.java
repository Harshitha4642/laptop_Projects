package range_design;

public class Numbers {
	
	public static void main(String[] args) throws CannotMergeException, NoIntersectionException
	{
		Range<Integer> range = Range.of(6, 29);
		System.out.println(range.toString());
		System.out.println(range.contains(12));
		System.out.println(range.containsRange(Range.of(10, 15)));
		System.out.println(range.fit(10));
		System.out.println(range.fit(0));
		System.out.println(range.fit(182));
		System.out.println(range.merge(Range.of(23, 53)));
		System.out.println(range.intersection(Range.of(21,48)));
		 
		Range<Character> alpa = Range.of('e', 'p');
		System.out.println(alpa.toString());
		System.out.println(alpa.contains('g'));
		System.out.println(alpa.containsRange(Range.of('f', 'h')));
		System.out.println(alpa.fit('q'));
		System.out.println(alpa.merge(Range.of('i', 'r')));
		System.out.println(alpa.intersection(Range.of('o', 'z')));
		
	}

}
