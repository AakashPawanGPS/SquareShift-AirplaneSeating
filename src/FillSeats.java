import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FillSeats {

    private int[][] seatingGroups;
    private int[] passIdArray;
    List<String[][]> seats = new ArrayList<>();
    ArrayList<Integer> rows = new ArrayList<>();
    private int filled=0;

    public FillSeats(int[][] seatingGroups , int[] passIdArray){
        this.seatingGroups = seatingGroups;
        this.passIdArray = passIdArray;
    }

    public void SeatCreation(int[][] seatingGroups){
        for(int block[] : seatingGroups){
            int noOfRows = block[1];
            int noOfCols = block[0];
            String[][] matrix = new String[noOfRows][noOfCols];
            this.rows.add(noOfRows);
            String[] row = new String[noOfCols];
            Arrays.fill(row,"XX");
            Arrays.fill(matrix,row);
            seats.add(matrix);
        }
    }



    public void fillAisleSeats(int[] passIdArray){

        int block = this.seatingGroups.length;
        int AisleCol;
        for(int row=0; row < Collections.max(this.rows);row++){
            for(int i=0 ; i<block; i++){
                //System.out.println(filled);
                //Checking if the row is available in the current block
                if(this.seatingGroups[i][1] > row){
                    if(((i==0) || (i==block-1)) && (this.seatingGroups[i][0]>1)){
                        if(i==0)
                            AisleCol = this.seatingGroups[i][0]-1;

                        else
                            AisleCol=0;
//                        System.out.println(filled);
                        this.seats.get(i)[row][AisleCol] = Integer.toString(this.passIdArray[this.filled++]);
                    }
                    else{
                        AisleCol =0;
                        this.seats.get(i)[row][AisleCol] = Integer.toString(this.passIdArray[this.filled++]);
                        if(filled>= this.passIdArray.length)
                            break;
                        if(this.seatingGroups[i][0] > 1){
                            AisleCol = this.seatingGroups[i][0]-1;
                            System.out.println(filled);
                            this.seats.get(i)[row][AisleCol] = Integer.toString(this.passIdArray[this.filled++]);
                        }
                    }
                    if(this.filled == this.passIdArray.length)
                        break;
                }
            }
        }
    }

    public void fillWindowSeats(int[] passIdArray){
        int block = passIdArray.length;
        for(int row=0 ; row<Collections.max(this.rows);row++){
            if(this.seatingGroups[0][1]>row){
                this.seats.get(0)[row][0] = Integer.toString(this.passIdArray[this.filled++]);
                if(this.filled>= passIdArray.length)
                    break;
            }
            if(seatingGroups[block-1][1]>row){
                int window = this.seatingGroups[block-1][0]-1;
                this.seats.get(block-1)[row][window] = Integer.toString(this.passIdArray[this.filled++]);
                if(this.filled>= passIdArray.length)
                    break;
            }
        }
    }

    public void fillMiddleSeats(int[] passIdArray){
        int block = this.seatingGroups.length;
        for(int row = 0;row<Collections.max(this.rows);row++){
            for(int i=0;i<block;i++){
                if((this.seatingGroups[i][1] > row) && (this.seatingGroups[i][0]>2)){
                    for(int col=1;col<this.seatingGroups[i][0]-1;col++){
                        this.seats.get(i)[row][col] = Integer.toString(this.passIdArray[this.filled++]);
                        if(this.filled >= passIdArray.length)
                            break;
                    }
                }
                if(this.filled >= passIdArray.length)
                    break;
            }
            if(this.filled >= passIdArray.length)
                break;
        }
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

