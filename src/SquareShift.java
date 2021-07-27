import java.util.Scanner;

public class SquareShift {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Getting user input as String
        String input = sc.nextLine();

        //Input: [[3,4],[1,2]]
        //Taking Integers from the input and appending them into the integer array called intArray
        //intArray = [3 , 4 , 1 , 2]
        int[] intArray = new int[input.length()];
        int index=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)>='0' && input.charAt(i)<='9'){
                intArray[index] = input.charAt(i);
                index++;
            }
        }

        int len = intArray.length;

        //Creating the seat grid using 2d array
        int[][] grid = new int[1][len/2];
        int idx=0;
        for(int i=0;i<len/2;i++){
            for(int j=0;j<2;j++){
                grid[i][j] = intArray[idx];
                idx++;
            }
        }

        //Creating a 3d array --> An array containing number of 2d arrays  (e.g) [[3,2],[4,3]]
        int gridLen = grid.length;
        int l=0;
        int[][][] seats = new int[gridLen][1][2];
        for(int i=0;i<gridLen;i++){
            for(int j=0;j<1;j++){
                for(int k=0;k<2;k++){
                    seats[i][j][k] = intArray[l];
                    l++;
                }
            }
        }

        //Input = [29,39,1,4,12,5,2]
        //Taking input for Passenger number
        String pass = sc.nextLine();

        //Getting the numbers from the passengers Id input and adding to to the PassengerArray
        int[] PassengerArray = new int[pass.length()];
        //PassengerArray = [29,39,1,4,12,5,2]
        index = 0;
        for(int i=0;i<pass.length();i++){
            if(pass.charAt(i)>='0' && pass.charAt(i)<='9') {
                PassengerArray[index] = pass.charAt(i);
            }
        }

        AirplaneSeating.AirplaneSeating(PassengerArray);

        //Calling FillSeats functions in their Respective order
        FillSeats.fillAisleSeats(seats,PassengerArray);
        FillSeats.fillMWindowSeats(seats,PassengerArray);
        FillSeats.fillMiddleSeats(seats,PassengerArray);

        

    }
}
