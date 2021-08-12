import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SquareShift {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Getting user input as String
        String seatInputs = sc.nextLine();
        String passId = sc.nextLine();

        //Parsing the input string into the required array format
        //Creating 2D array
        int[][] seatingGroups = ParseInputs.parseSeatSizeString(seatInputs);

        //Making Passenger ID's into a 1D array
        int[] passIdArray = ParseInputs.parsePassengerId(passId);

        //Print to Check the 2d-Array Fromat
//        for(int i[] : seatingGroups){
//            for (int j : i){
//                System.out.print(j+" ");
//            }
//            System.out.println("");
//        }

        //Making the passenger ID's Array by their Priority wise order
        passIdArray = PriorityCheck.SeatingOrder(passIdArray);
//        for (int i : passIdArray){
//            System.out.print(i+" ");
//        }
//        System.out.println();

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for(int[] block : seatingGroups){
            rows.add(block[1]);
            cols.add(block[0]);

        }
        int maxRows = Collections.max(rows);
        int maxCols = Collections.max(cols);

        FillSeats fillSeats = new FillSeats(seatingGroups,passIdArray,maxRows,maxCols);
        fillSeats.SeatCreation(seatingGroups);



        int index = fillSeats.fillAisleSeats(passIdArray);
        if(index< passIdArray.length)
            index = fillSeats.fillWindowSeats(passIdArray,index);
//        else{
//            System.out.println("Seats already filled");
//        }
        if(index< passIdArray.length)
            index = fillSeats.fillMiddleSeats(passIdArray,index);
//        else{
//            System.out.println("Seats already filled");
//        }
        fillSeats.printSeats();
        if(index < passIdArray.length){
            System.out.println("Seats already filled");
            //System.out.println(passIdArray.length - index+" Passengers");
        }
    }
}
