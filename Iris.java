/**
 * Created by davidjohn on 1/17/17.
 */
public class Iris {
    private int id;
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String name;

    public Iris() {
        id = 0;
        sepalLength = 0.0;
        sepalWidth = 0.0;
        petalLength = 0.0;
        petalWidth = 0.0;
        name = null;
    }

    public Iris(int myID, double SL, double SW, double PL, double PW, String nm){
        id = myID;
        sepalLength = SL;
        sepalWidth = SW;
        petalLength = PL;
        petalWidth = PW;
        name = nm;
    }

    // getters
    public int getId(){return id;}
    public double getSL(){return sepalLength;}
    public double getSW(){return sepalWidth;}
    public double getPL(){return petalLength;}
    public double getPW(){return petalWidth;}
    public String getName(){return name;}

    // method to compute and return the Euclidean distance between
    // two Iris objects
    public double Distance( Iris Other)
    {
        return Math.sqrt(Math.pow(getPL()-Other.getPL(),2)+Math.pow(getPW()-Other.getPW(),2)+Math.pow(getSL()-Other.getSL(), 2)
                +Math.pow(getSW()-Other.getSW(),2));
    }



    public String toString(){
        return "("+id+","+sepalLength+","+sepalWidth+","+
                petalLength+","+petalWidth+")" +
                " " + name;
    }



}
