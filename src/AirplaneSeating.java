public class AirplaneSeating {
    public static void AirplaneSeating(int[] PassengerArray) {
        int passLen = PassengerArray.length;

        //Creating separate arrays for prime numbers , Multiple of 2 power n numbers and others
        int[] prime = new int[passLen];
        int[] Mul2n = new int[passLen];
        int[] others = new int[passLen];

        int j=0;
        int k=0;
        int l=0;

        //Traversing through the Passenger Array and appending it to their respective arrays
        for(int i=0;i<passLen;i++) {
            if (Prime.isPrime(PassengerArray[i]) == 1) {
                prime[j] = PassengerArray[i];
                j++;
            }
            else if (PowerOf2.isMul2n(PassengerArray[i]) == 1) {
                Mul2n[k] = PassengerArray[i];
                k++;
            }
            else{
                others[l] = PassengerArray[i];
                l++;
            }
        }
        int[] Passengers_Id = new int[passLen];
        int p=0;
        int q=0;
        int r=0;
        int i;
        for(i=0;i<passLen;i++){
            Passengers_Id[i] = prime[p];
            p++;
        }
        for(i = prime.length-1;i<passLen;q++){
            Passengers_Id[i] = Mul2n[q];
            q++;
        }
        for(i = others.length- Mul2n.length;i<passLen;r++){
            Passengers_Id[i] = Mul2n[q];
            r++;
        }
    }
}
