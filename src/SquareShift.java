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

        FillSeats fillSeats = new FillSeats(seatingGroups,passIdArray);
        fillSeats.SeatCreation(seatingGroups);
        fillSeats.fillAisleSeats(passIdArray);
        fillSeats.fillWindowSeats(passIdArray);
        fillSeats.fillMiddleSeats(passIdArray);
        fillSeats.printSeats();

    }
}
