/**
 * Generic simple doubly linked list
 *
 * David John
 * January 2017
 */
public class DLList<T> {

    // header to the nodes and a count of the
    // number of nodes in the list
    protected DNode<T> Head; //protected members: if class is inherited the the provate members are avaliable
    protected DNode<T> Tail;
    protected int census;

    // constructor
    public DLList(){ Head = null; Tail = null;census=0;}

    // getter for size of list
    public int DLListSize() {return census;}

    // return is empty list
    public boolean isEmpty() {return census == 0;}

    // getter for front
    public T getFront(){
        if (census==0)
        {
            return null;
        }
        return Head.getElement();
    }

    // getter for rear
    public T getTail(){
        if (census==0)
        {
            return null;
        }
        return Tail.getElement();
    }

    // insert at front of list
    public void insertAtFront(T NewOne){

        // create node to contain NewOne, and set
        // its Next member to be what the Head
        // refers to


        DNode<T> newNode = new DNode<T>(NewOne);
        newNode.setNext(Head);

        // if this is the first node, just set Tail
        if (census==0)
        {
            Tail = newNode;
        }
        // not the first node so link current first node
        // back to newNode
        else
        {
            Head.setPrevious(newNode);
        }

        // now set header to the newNode
        Head = newNode;
        census++;


    }

    // (private) method to remove a list of size 1
    private void zapSingle(){
        Tail = null;
        Head = null;
        census = 0;
        return;
    }

    public void removeAtFront(){

        // if list is empty just return
        if (isEmpty()){
            return;
        }

        // if list is one size one, take care of it
        if (census == 1){
            zapSingle();
            return;
        }

        // at least two elements, do the easy remove
        Head = Head.getNext();
        Head.setPrevious(null);
        census--;
    }

    // insert at rear of list
    public void insertAtRear(T NewOne){

        // create node and set its previous member
        DNode<T> newNode = new DNode<T>(NewOne);
        newNode.setPrevious(Tail);

        // if first insertion, set Header
        if (census==0){
            Head = newNode;
        }
        else
        // otherwise set next member of current last
        // node to refer to newNode
        {
            Tail.setNext(newNode);
        }

        // have Tail refer to newNode
        Tail = newNode;
        census++;


    }

    public void removeAtRear(){

        // if list is empty just return
        if (this.isEmpty()){
            return;
        }

        // if list consists of exactly one node, remove it
        if (census == 1){
            zapSingle();
            return;
        }

        // at least two node, general case
        Tail = Tail.getPrevious();
        Tail.setNext(null);
        census--;
        return;

    }

}
