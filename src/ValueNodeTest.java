/**
 * 
 * @author hannahleland
 * @version 2018.21.11
 * @param <E>
 */
public class ValueNodeTest<E> extends student.TestCase {

    private ValueNode<E> v;
    private ValueNode<E> vn;
    
    /**
     * creates the value node
     */
    public void setUp() {
        v = new ValueNode<E>((E) "A");
        vn = new ValueNode(new ValueNode<E>((E) "B"));
    }
    
    /**
     * tests getnext 
     */
    public void testGetNext() {
        assertNull(v.getNext());
        v.setNext(new ValueNode<E>((E) "B"));
        assertEquals("B", v.getNext().getValue().toString());
    }
    
    /**
     * tests set next
     */
    public void testSetNext() {
        v.setNext(new ValueNode<E>((E) "B"));
        assertEquals("B", v.getNext().getValue());
    }
    
    /**
     * tests get value
     */
    public void testGetValue() {
        assertEquals("A", v.getValue());
        assertEquals("B", vn.getNext().getValue());
    }
    /**
     * tests setvalue 
     */
    public void testSetValue() {
        v.setValue((E) "C");
        assertEquals("C", v.getValue());
    }
}
