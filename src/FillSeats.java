import java.util.ArrayList;

public class FillSeats {

    private int[][] seatingGroups;
    private int[] passIdArray;
    private int maxRows;
    private int maxCols;
    private int index =0;
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
        int block = this.seatingGroups.length;
        int AisleCol;
        for(int row=0; row < maxRows;row++){
            for(int i=0 ; i<block; i++) {
                if (this.seatingGroups[i][1] > row) {
                    if ((i == 0) || (i == block - 1) && this.seatingGroups[i][0] > 1) {
                        if(this.seatingGroups[i][0] > 1){
                            if (i == 0) {
                                AisleCol = this.seatingGroups[i][0] - 1;
                                try {
                                    seats[i][row][AisleCol] = Integer.toString(passIdArray[index]);
                                    index++;
                                }
                                catch (Exception e){
                                    //System.out.println("Index: "+index);
                                }
                            } else {
                                AisleCol = 0;
                                try {
                                    seats[i][row][AisleCol] = Integer.toString(passIdArray[index]);
                                    index++;
                                }
                                catch (Exception e){
                                    //System.out.println("Index : " + index);
                                }
                            }
                        }
                    }
                    else {
                        AisleCol = 0;
                        try {
                            seats[i][row][AisleCol] = Integer.toString(passIdArray[index]);
                            index++;
                        }
                        catch (Exception e){
                            //System.out.println("Index : "+index);
                        }
                        if (this.seatingGroups[i][0] > 1) {
                            AisleCol = this.seatingGroups[i][0]-1;
                            try {
                                seats[i][row][AisleCol] = Integer.toString(passIdArray[index]);
                                index++;
                            }
                            catch (Exception e){
                                //System.out.println("Index : " + index);
                            }
                        if (index >= passIdArray.length)
                            break;
                        }
                    }
                    if (index == passIdArray.length)
                        break;
                }
            }
        }
        return index;
    }

    public int fillWindowSeats(int[] passIdArray , int index){
        int block = this.seatingGroups.length - 1;
        for(int row=0 ; row<maxRows;row++){
            if(this.seatingGroups[0][1]>row){
                seats[0][row][0] = Integer.toString(passIdArray[index]);
                index++;
                if(index >=  passIdArray.length)
                    break;
            }
            if(this.seatingGroups[block][1] > row){
                int window = this.seatingGroups[block][0]-1;
                try {
                    seats[this.seatingGroups.length - 1][row][window] = Integer.toString(this.passIdArray[index]);
                    index++;
                }
                catch (Exception e){
                    //System.out.println("Index : " + index);
                }
                if(index>= passIdArray.length)
                    break;
            }
        }
        return index;
    }

    public int fillMiddleSeats(int[] passIdArray ,int index){
        int block = this.seatingGroups.length;
        int j=0;
        for(int row = 0; row<maxRows; row++){
            for(int i=0;i<block;i++,j++){
                if((this.seatingGroups[i][1] > row) && (this.seatingGroups[i][0]>2)){
                    for(int col=1;col<this.seatingGroups[i][0]-1;col++){
                        if (this.seatingGroups[i][1] > row)
                            try{
                                seats[i][row][col] = Integer.toString(passIdArray[index]);
                                index++;
                            }
                            catch (Exception e) {
                                //System.out.println("Index : " + index);
                            }
                        if(index >= passIdArray.length)
                            break;
                    }
                }
                if(index == passIdArray.length)
                    break;
            }
            if(index == passIdArray.length)
                break;
        }
        return index;
    }


    public void printSeats(){
        for(int i=0;i<seatingGroups.length;i++){
            for(int j=0;j<seatingGroups[i][1];j++){
                for(int k=0;k<seatingGroups[i][0];k++){
                    System.out.print(seats[i][j][k]+" ");
                }
                System.out.println(" | ");
            }
            System.out.println("--------------");
        }
    }
}

