import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Iris doubly linked list class which inherits
 *  from DLList<Iris>.
 *
 *  David John
 *  January 2017
 */
public class IrisDLL extends DLList<Iris> { //IrisDLL inherts from DLList<Iris>

    // holds sum of all Iris numerical information
    // in the doubly linked list
    private Iris irisSum;

    // constructor
    public IrisDLL(){
        irisSum = new Iris();
    }

    // insert and update irisSum
    public void insert( Iris temp){
        //System.out.println("get here\n");
        insertAtFront(temp);
        irisSum = new Iris (0,irisSum.getSL()+temp.getSL(),irisSum.getSW()+temp.getSW(), irisSum.getPL()+temp.getPL(),
                +irisSum.getPW()+temp.getPW(), "");

    }

    // carefully remove and update irisSum if appropriate
    public void remove(){
        Iris temp=getFront();
        if(temp==null){return;}

        new Iris(0, irisSum.getSL()-temp.getSL(),irisSum.getSW()-temp.getSW(), irisSum.getPL()-temp.getPL(),
                +irisSum.getPW()-temp.getPW(), "");
        removeAtFront();

    }

    // getter for irisSum
    public Iris getSum()
    {
        return irisSum;
    }

    // getter for average of Iris values in list
    public Iris average()
    {
        return new Iris(0,irisSum.getSL()/census,
                irisSum.getSW()/census,
                irisSum.getPL()/census,
                irisSum.getPW()/census,"");
    }

    // print the entire list (for debugging purposes)
    public void Print()
    {
    int size=DLListSize();
    for(int i = 0;i<size;i++){
        System.out.println(getFront().toString());
        insertAtRear(getFront());
        removeAtFront();
    }

    }

    // returns true iff all entries in DLL are unique
    public boolean isUnique(int maxIndex) {
        int unique[] = new int[maxIndex];
        Arrays.fill(unique, 0);
        for(DNode<Iris> current = Head; current!= null; current=current.getNext()){
            unique[current.getElement().getId()]++;

            if(unique[current.getElement().getId()]>1)
                return false;
        }
        return true;
    }























}
