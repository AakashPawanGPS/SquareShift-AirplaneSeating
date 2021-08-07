import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillSeats {

    private int[][] seatingGroups;
    private int[] passIdArray;
    private int index;

    List<String[][]> seats = new ArrayList<>();
    ArrayList<Integer> rows = new ArrayList<>();

    public FillSeats(int[][] seatingGroups , int[] passIdArray){
        this.seatingGroups = seatingGroups;
        this.passIdArray = passIdArray;
    }

    public void SeatCreation(int[][] seatingGroups){
        for(int i = 0; i < this.passIdArray.length;i++){
            System.out.print(this.passIdArray[i]+" ");
        }
        System.out.println();
        for(int block[] : seatingGroups){
            int noOfRows = block[1];
            int noOfCols = block[0];
            String[][] matrix = new String[noOfRows][noOfCols];
            this.rows.add(noOfRows);
            String[] row = new String[noOfCols];
            Arrays.fill(row,"XX");
            Arrays.fill(matrix,row);
            this.seats.add(matrix);
        }
    }

    public int fillAisleSeats(int[] passIdArray){
        int index = 0;
        int i=0;
        int j=0;
        int k = this.seatingGroups[i][0]-1;
        int n = passIdArray.length * 2;
        for(int p=0; p<n;p++){
            try{
                if(this.seatingGroups[i][0]>1){
                    String[][] matrix = this.seats.get(i);
                    matrix[j][k] = Integer.toString(this.passIdArray[index++]);
                    this.seats.set(i,matrix);
                }
            }
            catch (Exception e){
            }
            if(k == this.seatingGroups[i][0]-1){
                i++;
                k=0;
            }
            else{
                k = this.seatingGroups[i][0]-1;
                if(i == this.seatingGroups.length - 1){
                    i=0;
                    j++;
                }
            }
        }
        return index;
    }

    public int fillWindowSeats(int[] passIdArray , int index){
        int i = 0;
        int j = 0;
        int k = 0;
        int n = this.seatingGroups[i][0]-1;
        for(int p=0;p<n;p++){
            try{
                String[][] matrix = this.seats.get(i);
                matrix[j][k] = Integer.toString(this.passIdArray[index++]);
                this.seats.set(i,matrix);
            }
            catch (Exception e){}
            if(i == 0){
                i = this.seatingGroups.length - 1;
                k = this.seatingGroups[i][0]-1;
            }
            else {
                k = 0;
                i = 0;
                j++;
            }
        }
        return index;
    }

    public int fillMiddleSeats(int[] passIdArray ,int index){
        int i = 0;
        int j = 0;
        int k = 1;
        int n = passIdArray.length * 2;
        for(int p=0;p<n;p++){
            try{
                String[][] matrix = this.seats.get(i);
                matrix[j][k] = Integer.toString(this.passIdArray[index++]);
                this.seats.set(i,matrix);
                k++;
            }
            catch (Exception e){}
            if(k == this.seatingGroups[i][0]-1){
                i++;
                k=1;
            }
            if(i == this.seatingGroups.length-1){
                i = 0;
                j++;
            }
        }
        return index;
    }


    public void printSeats(){
        for(String block[][] : this.seats){
            for(String rows[] : block){
                for(String seat : rows){
                    System.out.print(seat+" ");
                }
                System.out.println(" | ");
            }
            System.out.println("------------");
        }
    }
}

