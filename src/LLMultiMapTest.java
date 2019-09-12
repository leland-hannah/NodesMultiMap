/**
 * 
 * @author hannahleland
 * @version 2018.11.18
 * @param <K> is key
 * @param <V> is value
 */

public class LLMultiMapTest<K, V> extends student.TestCase {
    
    private LLMultimap<String, Double> ll;
    
    /**
     * creates the value node
     */
    public void setUp() {
        ll = new LLMultimap<String, Double>();
    }
    
    /**
     * tests put
     */
   
    public void testPut() {
        ll.put("Seattle", 2.9);
        ll.put("Seattle", 3.7);
        ll.put("Bethlehem", 2.9);
        Exception thrown = null;
        //works through null pointer exception
        try
        {
            ll.put(null, 2.9);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        //works through if value is already there  
        try
        {
            ll.put("Seattle", 2.9);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        
        assertEquals(3.7, ll.put("Seattle", 3.0), 0.1);
        
        //assertEquals(2.9, ll.put("Bethlehem", 6.7), 0.1);
    }
    
    /**
     * tests isEmpty
     */
    public void testIsEmpty() {
        assertTrue(ll.isEmpty());
    }
    
    /**
     * tests get
     */
    public void testGet() {
        ll.put("Seattle", 2.9);
        ll.put("Seattle", 3.7);
        ll.put("Bethlehem", 2.9);
        Exception thrown = null;
        //works through IllegalState
        try
        {
            ll.get("Bellevue");
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        
        //works through IllegalArg
        try
        {
            ll.get(null);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        
        assertEquals(2.9, ll.get("Bethlehem").getValue(), 0.1);
        assertEquals(3.7, ll.get("Seattle").getValue(), 0.1);
        assertEquals(2.9, ll.get("Seattle").getNext().getValue(), 0.1);
        
    }
    
    /**
     * tests replace
     */
    @SuppressWarnings("unchecked")
    public void testReplace() {
        ll.put("Seattle", 2.9);
        ll.put("Seattle", 3.7);
        ll.put("Bethlehem", 2.9);
        Exception thrown = null;
        //works through IllegalState
        try
        {
            ll.replace("Bellevue", 2.9, 4.5);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        
        //works through IllegalArg
        try
        {
            ll.replace(null, null, null);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertTrue(ll.replace("Seattle", 2.9, 5.4));
        
    }
    
    /**
     * tests remove 1
     */
    public void testRemove() {
        ll.put("Seattle", 2.9);
        ll.put("Seattle", 3.7);
        ll.put("Bethlehem", 2.9);
        Exception thrown = null;
        //works through IllegalState
        try
        {
            ll.remove(null);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        try
        {
            ll.remove("Bellevue");
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        
        ll.remove("Seattle");
        assertEquals(1, ll.size());
        
        assertEquals(2.9, ll.remove("Bethlehem").getValue(), 0.1);
        
        
        
        LLMultimap<String, Double> map = new LLMultimap<String, Double>();
        
        map.put("Jodie", 85.5);
        map.put("Jodie", 90.5);
        map.put("Alex", 75.0);
        map.put("Tina", 75.0);
        assertEquals(3, map.size());
        map.remove("Tina");
        assertEquals(2, map.size());

        ValueNode<Double> res = map.remove("Jodie");
        assertEquals(
            "Method remove return the right value.",
            90.5,
            res.getValue(),
            0.01);
        assertEquals(
            "Method remove return the right value.",
            85.5,
            res.getNext().getValue(),
            0.01);
        assertEquals("There is a problem with method remove.", 1, map.size());
    }
    
    /**
     * tests remove2
     */
    public void testRemove2() {
        ll.put("Seattle", 2.9);
        ll.put("Seattle", 3.7);
        ll.put("Bethlehem", 2.9);
        Exception thrown = null;
        try
        {
            ll.remove(null, null);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        try
        {
            ll.remove("Bellevue", "2.3");
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalStateException);
        
        
        assertTrue(ll.remove("Bethlehem", 2.9));
        
        LLMultimap<String, Double> map = new LLMultimap<String, Double>();
        map.put("Jodie", 85.5);
        map.put("Jodie", 90.5);
        map.put("Jodie", 91.5);
        map.put("Alex", 75.0);
        map.put("Tina", 75.0);
        assertEquals(3, map.size());
        map.remove("Tina");
        assertEquals(2, map.size());
        
        map.remove("Jodie", 90.5);
        map.remove("Jodie", 85.5);
        map.remove("Jodie", 91.5);
        
    }
    
    /**
     * test toString
     */
    public void testToString() {
        assertEquals("[{}]", ll.toString());
        
        ll.put("Seattle", 2.9);
        ll.put("Seattle", 3.7);
        ll.put("Bethlehem", 2.9);
        assertEquals("[{Bethlehem: [2.9]}, {Seattle: [3.7, 2.9]}]", 
                ll.toString());
        
        LLMultimap<String, Double> map = new LLMultimap<String, Double>();
        
        map.put("Jodie", 85.5);
        map.put("Jodie", 91.5);
        map.put("Jodie", 90.5);
        map.put("Tina", 75.0);
        map.remove("Tina");
        map.remove("Jodie", 85.5);
        
        assertEquals("[{Jodie: [90.5, 91.5]}]", map.toString());
        
    }
    
}















