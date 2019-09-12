/**
 * @version 2018.11.03
 * @author ericfouh An object that maps keys to values. A map cannot contain
 *         duplicate keys. Each key can map to MORE THAN ONE value.
 * @param <K>
 *            - the type of keys maintained by this map
 * @param <V>
 *            - the type of mapped values
 */
public interface Multimap<K, V>
{
    /**
     * Associates the specified value with the specified key in this map. If the
     * multimap previously contained a mapping for the key, the new value is
     * appended to the list of old values. Throws: IllegalArgumentException - if
     * the specified key or value is null IllegalStateException - if the value
     * is already associated with key (no duplicate values)
     * 
     * @param key
     *            key with which the specified value is to be associated
     * @param value
     *            value to be associated with the specified key
     * @return The last (added) previous value associated with key, or null if
     *         there was no mapping for key
     */
    public V put(K key, V value);


    /**
     * @return Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty();


    /**
     * Returns a list of values to which the specified key is mapped, or null if
     * this map contains no mapping for the key. Throws:
     * IllegalArgumentException - if the specified key is
     * null.IllegalStateException - if the key is not in the multimap.
     * 
     * @param key
     *            - the key whose associated value is to be returned
     * @return the list of values mapped to the key or null if the map contained
     *         no mapping for the key
     */
    public ValueNode<V> get(Object key);


    /**
     * Replaces the entry for the specified key only if currently mapped to the
     * specified value. Throws: IllegalArgumentException - if the specified key
     * or oldValue or newValue is null. Or if oldValue and newValue are the
     * same.IllegalStateException - if the key is not in the multimap, or
     * oldValue is not already associated with key.
     * 
     * @param key
     *            - key with which the specified value is associated
     * @param oldValue
     *            - value expected to be associated with the specified key
     * @param newValue
     *            - value to be associated with the specified key
     * @return true if the value was replaced
     */
    public boolean replace(K key, V oldValue, V newValue);


    /**
     * Removes the mapping for a key from this map if it is present. The key and
     * its associated values are removed. Throws: IllegalArgumentException - if
     * the specified key is null. IllegalStateException - if key is not in the
     * multimap
     * 
     * @param key
     *            - key whose mapping is to be removed from the multimap
     * @return the list of values mapped to the key or
     */
    public ValueNode<V> remove(Object key);


    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. value is removed from the list of values. If value
     * is the only value associated with key, then key is also removed. Throws:
     * IllegalArgumentException - if the specified key or value is null.
     * IllegalStateException - if key is not in the multimap. key is not removed
     * if it is not mapped with value
     * 
     * @param key
     *            - key with which the specified value is associated
     * @param value
     *            - value expected to be associated with the specified key
     * @return true if the value was removed.
     */
    public boolean remove(Object key, Object value);


    /**
     * @return the number of keys mappings in this multimap
     */
    public int size();


    /**
     * @return a string representation of the multimap in the format [{key1:
     *         [value1, value2]}, {key2: [value3]}] an empty map returns "[{}]"
     */
    public String toString();

}
