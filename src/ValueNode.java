
/**
 * @author hannahleland
 *@version 2018.11.18
 * @param <E> generic
 */
public class ValueNode<E>
{


    // Singly linked list node class
    private E  value;    // Value for this node
    
    private ValueNode<E> next;   // Point to next node in list


    /**
     * @param value new data
     */
    public ValueNode(E value)
    {

        this.setValue(value);
        this.next = null;
    }


    /**
     * @param next the next node
     */
    public ValueNode(ValueNode<E> next)
    {
        
        setValue(null);
        this.next = next;
    }


    /**
     * @return the next value node
     */
    public ValueNode<E> getNext()
    {
        return next;
    } // Return next link

    /**
     * @param inn the new next
     */
    public void setNext(ValueNode<E> inn)
    {
        next = inn;
    } // Set next link


  
    /**
     * @return the value
     */
    public E getValue()
    {
        return value;
    }


    /**
     * @param value the value to set
     */
    public void setValue(E value)
    {
        this.value = value;
    }

}



