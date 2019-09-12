/**
 * 
 * @author hannahleland
 * @version 2018.12.11
 * @param <V> value
 * @param <K> key
 * @param <E> generic
 */
public class MapNodeTest<V, K, E> extends student.TestCase {
    
    private MapNode<K, V> m;
    
    /**
     * makes mapNode
     */
    public void setUp() {
        ValueNode<E> v = new ValueNode(2.83);
        m = new MapNode<K, V>((K)"NYC", (ValueNode<V>) v, null);
    }
    
    /**
     * tests getKey
     */
    public void testGetKey() {
        assertEquals("NYC", m.getKey().toString());
    }
    
    /**
     * tests set key
     */
    public void testSetKey() {
        m.setKey((K)"Seattle");
        assertEquals("Seattle", m.getKey().toString());
    }
    
    /**
     * tests get values 
     */
    public void testGetValues() {
        assertEquals("2.83", m.getValues().getValue().toString());
    }
    
    /**
     * tests setValues
     */
    public void testSetValues() {
        m.setValues(new ValueNode(3));
        assertEquals("3", m.getValues().getValue().toString()); 
    }
    
    /**
     * tests getNext
     */
    public void testGetNext() {
        m.setNext(new MapNode<K, V>((K)"Bethlehem", (new ValueNode(3)) , null));
        assertEquals("Bethlehem", m.getNext().getKey());
    }
    
    /**
     * public test SetNext
     */
    public void testSetNext() {
        m.setNext(new MapNode<K, V>((K)"Bethlehem", (new ValueNode(3)) , null));
        assertEquals("Bethlehem", m.getNext().getKey());
    }
    
    /**
     * test equals 
     */
    public void testEquals() {
        assertFalse(m.equals(0));
        assertTrue(m.equals(m));
    }
}
