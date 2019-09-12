
/**
 * @author hannahleland
 * @version 2018.11.18
 * @param <K> the key
 * @param <V> the value
 */
public class MapNode<K, V>
{
    // Singly linked list node class
    private K             key;    // Value for this node
    private ValueNode<V>  values; // Point to head of list values
    private MapNode<K, V> next;   // Point to next node in list


    /**
     * @param key the new key
     * @param value the new value
     * @param next the next mapnode
     */
    public MapNode(K key, ValueNode<V> value, MapNode<K, V> next)
    {
        this.setKey(key);
        this.setValues(value);
        this.setNext(next);
    }


    /**
     * @return the key
     */
    public K getKey()
    {
        return key;
    }


    /**
     * @param key
     *            the key to set
     */
    public void setKey(K key)
    {
        this.key = key;
    }


    /**
     * @return the values
     */
    public ValueNode<V> getValues()
    {
        return values;
    }


    /**
     * @param values
     *            the values to set
     */
    public void setValues(ValueNode<V> values)
    {
        this.values = values;
    }


    /**
     * @return the next
     */
    public MapNode<K, V> getNext()
    {
        return next;
    }


    /**
     * @param next
     *            the next to set
     */
    public void setNext(MapNode<K, V> next)
    {
        this.next = next;
    }

    /**
     * @return true if it equals
     * @param o is the checked equals
     */
    public boolean equals(Object o)
    {
        if (o instanceof MapNode) {
            return this.key.equals(((MapNode<?, ?>)o).getKey());
        }
        return false;
    }
}
