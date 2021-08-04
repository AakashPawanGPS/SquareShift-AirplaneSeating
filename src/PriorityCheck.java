public class PriorityCheck {

    public static boolean isPrime(int num){
        if(num == 0){
            return false;
        }
        else if (num == 1){
            return false;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static boolean isMul2n(int num){
        if((num & (num-1)) == 0 ){
            return true;
        }
        return false;
    }


    public static int[] SeatingOrder(int[] passIdArray){
        int p=0;
        int q=0;
        int r=0;
        int[] Prime = new int[passIdArray.length];
        int[] PowerOf2 = new int[passIdArray.length];
        int[] Others = new int[passIdArray.length];

        for(int i:passIdArray){
            if(isPrime(i)){
                Prime[p++] = i;
            }
            else if(isMul2n(i)){
                PowerOf2[q++] = i;
            }
            else{
                Others[r++] = i;
            }
        }

        int idx=0;
        for(int i=0;i< p;i++){
            passIdArray[idx++] = Prime[i];
        }
        for(int i=0;i< q;i++){
            passIdArray[idx++] = PowerOf2[i];
        }
        for(int i=0;i< r;i++){
            passIdArray[idx++] = Others[i];
        }

        return passIdArray;
    }
}
