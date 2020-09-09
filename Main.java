import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;


public class Main {
    private static IrisDLL[] currentDLL;
    public static void main(String[] args) {

        currentDLL = new IrisDLL[2];        //instantiated the array with two things in it
        currentDLL[0] = new IrisDLL();      //instantiates the array of DLLs and then instantiates each of the lists
        currentDLL[1] = new IrisDLL();

        readintdata("iris.dat");    //reads in the data file


        kmeans();                           //calls kmeans function
        for(int i=0; i<2;i++){              //checks for and prints whether the list is unique or not
            System.out.println("List "+i+" is unique:  "+currentDLL[i].isUnique(151));
        }
    }
    public static boolean readintdata(String fileName) {    //reads data from file
        Scanner infile;                                     //scanner to read the data
        int id;
        double sepal_length, sepal_width, petal_length, petal_width;    //initializes each characteristic of type double
        String species_name;

        Random rand = new Random();                                    //creates random object named rand
        try {
            infile = new Scanner(new FileReader(fileName));           //goes here is successful, this opens the file to be read
        } catch (Exception ex_open) {
            System.out.println("Bad news: <" + fileName + "> did not open"); //goes here if this step fails
            return false;
        }

        while (infile.hasNext()) {              //Input info
            try {                              //goes here if it is successful in reading the file
                id = infile.nextInt();
                sepal_length = infile.nextDouble();
                sepal_width = infile.nextDouble();
                petal_length = infile.nextDouble();
                petal_width = infile.nextDouble();

                species_name = infile.next() + infile.next();

                Iris temp = new Iris(id, sepal_length, sepal_width, petal_length, petal_width, species_name);
                int indexofList = rand.nextInt(2);
                currentDLL[indexofList].insert(temp);      //inserts the elements into the temp


            } catch (Exception ex_read) {                  //goes here if not successful in reading
                System.out.println("Worse news: read error from input stream");
                return false;
            }

        }
            try {

                infile.close();                            //closing file

            } catch (Exception ex_close) {                 //catches error in case of file does not close
                System.out.println("unable to close file" + "iris.dat" + "");

                return false;
            }


        return true;
    }

    public static boolean kmeans() {
        IrisDLL newDLL[] = new IrisDLL[2];              //initializes array of size two of type irisDLL
        Iris newavg[] = new Iris[2];
        double dist[] = new double[2];
        boolean done = false;
        int count = 0;                                  //counter
        int newindex;
        while (!done) {                                 //while not finished
            count++;                                     //increment
            System.out.println("Round: " + count);
            done = true;
            newDLL[0] = new IrisDLL();                   //doubly linked list index one
            newDLL[1] = new IrisDLL();

            if (!(currentDLL[0].isEmpty() && currentDLL[1].isEmpty())) { //if arrays have elements in them calculate the average of those elements
                newavg[0] = currentDLL[0].average();
                newavg[1] = currentDLL[1].average();

            }
            for (int i = 0; i < 2; i++) {
                while (!currentDLL[i].isEmpty()) {
                    dist[0] = currentDLL[i].getFront().Distance(newavg[0]); //gets the head of the first array and calculates the distance between first elements and the average
                    dist[1] = currentDLL[i].getFront().Distance(newavg[1]); //gets the first element(head) & it calculates the distance between that and the average

                    if (dist[0] < dist[1]) { //if the first list's distance to the avg is less than the distance of the other list
                        newindex = 0;      //index zero in newDLL  points to the first templist
                    } else {
                        newindex = 1;
                    }
                    newDLL[newindex].insert(currentDLL[i].getFront()); //newDLL points to one of the indexes specified and the insert function
                    //inserts the elements into the temp list that is being pointed to
                    currentDLL[i].removeAtFront();                  //after the elements are inserted they are deleted
                    if (newindex != i) {
                        done = false;
                    }

                }
            }
            currentDLL[0] = newDLL[0];
            currentDLL[1] = newDLL[1];
            newDLL[0] = null;
            newDLL[1] = null;


        }

        return true;
    }


}




