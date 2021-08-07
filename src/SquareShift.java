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

//        List<Integer> rows = new ArrayList<>();
//        List<Integer> cols = new ArrayList<>();
//        for(int[] block : seatingGroups){
//            rows.add(block[1]);
//            cols.add(block[0]);
//
//        }
        //FillSeats fillSeats = new FillSeats(seatingGroups,passIdArray,rows,cols);
        FillSeats fillSeats = new FillSeats(seatingGroups,passIdArray);
        fillSeats.SeatCreation(seatingGroups);

        int index = fillSeats.fillAisleSeats(passIdArray);
        index = fillSeats.fillWindowSeats(passIdArray,index);
        index = fillSeats.fillMiddleSeats(passIdArray,index);
        fillSeats.printSeats();

    }
}
