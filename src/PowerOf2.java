public class PowerOf2 {

    //Function to check for multiple of 2 power n
    public static int isMul2n(int n){

        //Using bit manipulation to check
        if((n&(n-1))==0){
            return 1;
        }
        return 0;
    }
}
