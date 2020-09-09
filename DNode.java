/**
 * Created by davidjohn on 1/17/17.
 */
public class DNode<T> {

    private T element;
    private DNode next;
    private DNode previous;

    // constructors
    public DNode(){next = null; previous = null;}
    public DNode(T XXX){
        next = null;
        previous = null;
        element = XXX;
    }

    // getters and setters for next and previous
    public void setNext(DNode link){next = link;}
    public DNode getNext() { return next;}
    public void setPrevious(DNode link){previous = link;}
    public DNode getPrevious() {return previous;}
    public T getElement(){ return element;}
}
