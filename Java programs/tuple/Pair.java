package TupleCollection;

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K first, V second) {
        this.key = first;
        this.value = second;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    
    @Override
    public String toString()
    {
    	return "( "+key+" , "+value+" )";
    }
}
