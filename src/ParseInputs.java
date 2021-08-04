import java.util.ArrayList;
import java.util.List;

public class ParseInputs {
    public static int[][] parseSeatSizeString(String seatInputs){
        String[] splittedString = seatInputs.split("[,\\[\\]]");
        List values = new ArrayList();
        for(String value : splittedString){
            try{
                Integer i = Integer.parseInt(value);
                values.add(i);
            }
            catch (Exception e){

            }
        }
        int seatArray[] = new int[2];
        int seatingGroups[][] = new int[values.size()/2][];

        for(int i=0,j=0;i<values.size();i++){
            int index = i%2;

            seatArray[index] = (int)values.get(i);
            if(index==1){
                seatingGroups[j++] = seatArray;
                seatArray = new int[2];
            }
        }
        return seatingGroups;
    }

    public static int[] parsePassengerId(String passId){
        passId = passId.substring(1,passId.length()-1);
        String splitString[] = passId.split(",");
        int passIdArray[] = new int[splitString.length];
        for(int i=0;i<splitString.length;i++){
            passIdArray[i] = Integer.parseInt(splitString[i]);
        }
        return passIdArray;
    }
}
