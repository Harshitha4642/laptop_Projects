package TupleCollection;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;

public class Tuple1<K, V> extends AbstractCollection<Pair<K, V>> {
    private final Collection<Pair<K, V>> pairs = new ArrayList<>();

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return pairs.iterator();
    }

    @Override
    public int size() {
        return pairs.size();
    }

    @Override
    public boolean add(Pair<K, V> pair) {
        return pairs.add(pair);
    }

    public static void main(String[] args) {
        Tuple1<String, Integer> pairCollection = new Tuple1<>();
        pairCollection.add(new Pair<>("One", 1));
        pairCollection.add(new Pair<>("Two", 2));

        for (Pair<String, Integer> pair : pairCollection) {
            System.out.println(pair.toString());
        }
        
        System.out.println("Size: "+pairCollection.size());
        
    }
}
