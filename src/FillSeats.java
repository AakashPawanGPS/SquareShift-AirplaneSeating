import java.util.ArrayList;

public class FillSeats {

    private int[][] seatingGroups;
    private int[] passIdArray;
    private int index;
    private int maxRows;
    private int maxCols;
    private String[][][] seats;
    ArrayList<Integer> rows = new ArrayList<>();

    public FillSeats(int[][] seatingGroups , int[] passIdArray , int maxRows , int maxCols){
        this.seatingGroups = seatingGroups;
        this.passIdArray = passIdArray;
        this.maxRows = maxRows;
        this.maxCols = maxCols;
        this.seats = new String[seatingGroups.length][maxRows][maxCols];
    }

    public void SeatCreation(int[][] seatingGroups){
        for(int i = 0; i < this.passIdArray.length;i++){
            System.out.print(this.passIdArray[i]+" ");
        }
        System.out.println();
        for(int i=0;i<seatingGroups.length;i++){
            for(int j=0;j<maxRows;j++){
                for(int k=0;k<maxCols;k++){
                    seats[i][j][k] = "XX";
                }
            }
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
                    seats[i][j][k] = Integer.toString(this.passIdArray[index]);
                    index++;
                }
            }
            catch (Exception e){}
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
                seats[i][j][k] = Integer.toString(this.passIdArray[index]);
                index++;
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
                seats[i][j][k] = Integer.toString(this.passIdArray[index]);
                index++;
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
        for(int i=0;i<seatingGroups.length;i++){
            for(int j=0;j<seatingGroups[i][1];j++){
                for(int k=0;k<seatingGroups[i][0];k++){
                    System.out.print(seats[i][j][k]+" ");
                }
                System.out.println(" ");
            }
            System.out.println("--------------");
        }
    }
}

