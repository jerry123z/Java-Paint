/*Author: Jerry Zheng
 *Last Edited: Apr 20th 2016
 *Description class that creats list node objects with data values, and has variables which point to the next and 
 * previous list nodes
 *
 */
public class ListNode<T> {
    private T data;
    private ListNode next;
    private ListNode previous;
     
    // Constructor: No reference to next node provided so make it null 
    public ListNode( T nodeData ) {
        this( nodeData, null, null);
    }
     
    // Constructor: Set data and reference to next node.
    public ListNode( T nodeData, ListNode nodeNext, ListNode nodePrevious ) {
        data = nodeData;
        next = nodeNext;
        previous = nodePrevious;
    }
     
    // Accessor: Return the data for current ListNode object
    public T getData() {
        return data;
    }
     
    // Accessor: Return reference to next ListNode object
    public ListNode getNext() {
        return next;
    }
     
    // Accessor: Return reference to previous ListNode object
    public ListNode getPrevious() {
        return previous;
    }
    
    // Mutator: Set new data for current ListNode object
    public void setData( T newData ) {
        data = newData;
    }
     
     
    // Mutator: Set new reference to the next node object
    public void setNext( ListNode newNext ) {
        next = newNext;
    }
    
    // Mutator: Set new reference to the previous node object
    public void setPrevious( ListNode newPrevious ) {
        previous = newPrevious;
    }
}