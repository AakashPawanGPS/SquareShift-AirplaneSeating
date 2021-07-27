public class Prime {

    //function to check for prime number
    public static int isPrime(int n){
        //This function will return 1 if n is prime and 0 otherwise

        //base case 1
        if(n==0){
            return 0;
        }

        //base case 2
        else if(n==1){
            return 1;
        }

        //Prime check
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return 0;
            }
        }
        return 1;
    }
}
