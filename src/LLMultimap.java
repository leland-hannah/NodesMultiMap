/**
 * 
 * @author hannahleland
 * @version 2018.15.11
 * @param <K> is the key
 * @param <V> is the value
 */
public class LLMultimap<K, V> implements Multimap<K, V> {

    private MapNode<K, V> head;
    private int size;
    
    /**
     * creates head and size 
     */
    public LLMultimap() {
        head = new MapNode<K, V>(null, null, null);
        size = 0;
    }
    
    @Override
    public V put(K key, V value) {
        if (value == null || key == null) {
            throw new IllegalArgumentException();
        }
        
        if (isEmpty()) {
            head = new MapNode<K, V>((K) key, 
                    new ValueNode<V>((V) value), null);
            size++;
            return null;
        }
        
        if (findMapNode((K) key) == null) {
            
            MapNode<K, V> mNode = new MapNode<K, V>((K) key, 
                    new ValueNode<V>((V) value), null);
            mNode.setNext(head);
            head = mNode;
            size++;
            return null;
        }
        
        if (findValue(findMapNode((K) key), (V) value)) {
            throw new IllegalStateException();
        }
        
        ValueNode<V> track = new ValueNode<V>(value);
        track.setNext(findMapNode((K) key).getValues());
        findMapNode((K) key).setValues(track);
        return track.getNext().getValue();
        
        
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public ValueNode<V> get(Object key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        
        if (findMapNode((K) key) == null) {
            throw new IllegalStateException();
        }
        MapNode<K, V> curr = head;
        while (curr != null) {
            if (curr.getKey().equals(key)) {
                break;
            }
            curr = curr.getNext();
        }
        
        if (curr.getValues() == null) {
            return null;
        }
        
        return curr.getValues();
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if (key == null || oldValue == null || newValue == null) {
            throw new IllegalArgumentException();
        }
        
        if (oldValue == newValue) {
            throw new IllegalArgumentException();
        }
        //MapNode<K, V> curr = head;
        
        if (findMapNode((K) key) == null 
                || findValue(findMapNode((K) key), newValue)) {
            throw new IllegalStateException();
        }
        
        ValueNode<V> t = findMapNode((K)key).getValues();
        while (!t.getValue().equals(oldValue)) {
            t = t.getNext();
        }
        t.setValue(newValue);
        return true;
        
        
    }

    @Override
    /**

     * Removes the mapping for a key from this map if it is present. The key and

     * its associated values are removed. Throws: IllegalArgumentException - if

     * the specified key is null. IllegalStateException - if key is not in the

     * multimap 

     * @param key

     *            - key whose mapping is to be removed from the multimap

     * @return the list (linked nodes) of values mapped to the key or

     */
    public ValueNode<V> remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        
        if (isEmpty() || findMapNode((K) key) == null) {
            throw new IllegalStateException();
        }
        
        MapNode<K, V> temp = head;
        MapNode<K, V> remove = findMapNode((K) key);
        
        if (remove != null) {
            if (head.equals(remove)) {
                head = temp.getNext();
                temp.setNext(null);
                size--;
                return temp.getValues();
            }
        }
        
        while (temp.getNext() != null) {
            if (temp.getNext().equals(remove)) {
                temp.setNext(temp.getNext().getNext());
                remove.setNext(null);
                size--;
                return remove.getValues();
            }
            temp = temp.getNext();
        }
        throw new IllegalStateException();
        
    }

    @Override
    public boolean remove(Object key, Object value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        
        MapNode<K, V> foundNode = this.findMapNode((K) key);
        if (foundNode != null) {
            if (findValue(foundNode, (V) value)) {
                ValueNode<V> temp = foundNode.getValues();
                if (temp.getNext() == null) {
                    this.remove((K) key);
                    return true;
                }
                if (temp.getValue().equals(value)) {
                    foundNode.setValues(temp.getNext());
                    temp.setNext(null);
                    return true;
                }
                
                while (temp != null) {
                    if (temp.getNext().getValue().equals(value)) {
                        ValueNode<V> remove = temp.getNext();
                        temp.setNext(remove.getNext());
                        remove.setNext(null);
                        return true;
                    }
                    temp = temp.getNext();
                }
            }
            return false;
        }
        throw new IllegalStateException();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }
    
    /**
     * 
     * @param target
     * @return 
     */
    private MapNode<K, V> findMapNode(K target) {
        MapNode<K, V> curr = head;
        while (curr != null && !curr.getKey().equals(target)) {
            curr = curr.getNext();
        }
        return curr;
    }
    /**
     * 
     * @param n
     * @param value
     * @return true if it is in it 
     */
    private boolean findValue(MapNode<K, V> n, V value) {
        ValueNode<V> curr = n.getValues();
        while (curr != null) {
            if (curr.getValue().equals(value)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }
    
    /**
     * @return a string representation of the multimap in the format [{key1:
     *[value1, value2]}, {key2: [value3]}] an empty map returns "[{}]"
     */
    public String toString() {
        if (isEmpty()) {
            return "[{}]";
        }
        
        String ans = "[{";
        MapNode<K, V> curr = head;
        
        while (curr.getNext() != null) {
            
            ans += curr.getKey() + ": [";
            ValueNode<V> temp = curr.getValues();
            
            while (temp.getNext() != null) {
                ans += temp.getValue() + ", ";
                temp = temp.getNext();
            }
            ans += temp.getValue() + "]}, {";
            curr = curr.getNext();
        }
        
        ans += curr.getKey() + ": [";
        ValueNode<V> temp = curr.getValues();
        while (temp.getNext() != null) {
            ans += temp.getValue() + ", ";
            temp = temp.getNext();
        }
        
        ans += temp.getValue() + "]}]";
        return ans;
    }

}
