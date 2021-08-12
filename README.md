# Airplane Seating Problem

The SquareShift class has main function
There I am getting two inputs both as Strings.
One contains a 2d array representing the seat grids and the other input has the passenger Id's.
In order to use those data I have converted them into 2d-array and an 1d array respectively.
To convert them, I have defined a class named **ParseInputs** and two methods namely **parseSeatSizeString** and **parsePassengerId** inorder to get the desired form of input.

Then in the class named **PriorityCheck** , I have get the required ordered form of PaseengerID's String.I'll be checking for prime numbers and Multiple of 2powern numbers by traversing through the Second Input
Then created a separate array to contain Prime numbers , Multiple of 2 power n numbers and others.
To check whether a number is prime or not and is multiple of 2 power n or not , I have created a separate methods namely **isPrime** , **isMul2n**.

Then I have created a class called **FillSeats**
Then I will be filling the Aisle seats followed by Window seats then Middle seats by using the methods of FillSeats class.
Atlast **PrintSeats** is used to print the seats.


**Test Cases** : 
 
**Input 1** : 

              [[3,2],[4,3],[2,3],[3,4]]
              [29,59,14,11,3,13,15,18,12,16,6,17,7,47,61,5,21,2,41,9,10,8,19,1,4]
              
**Output 1** :  

              15 10 29  | 
              12 XX 7  | 
              --------------
              59 XX XX 11  | 
              47 XX XX 61  | 
              19 XX XX 16  | 
              --------------
              3 13  | 
              5 2  | 
              8 1  | 
              --------------
              17 XX 18  | 
              41 XX 6  | 
              4 XX 21  | 
              14 XX 9  | 
              --------------
 **Got the Desired Output**
 
**Input 2** : 
 
              [[5,3],[4,2],[6,1],[1,5],[2,3]]
              [7,61,5,21,2,41,9,10,8,19,1,18,21,33,42,20,3,71,92,64,98,34,49,81,34,54,89,24,52,63,26]

**Output 2** :

                33 49 81 34 7  |
                20 XX XX XX 71  |
                98 XX XX XX 21  |
                --------------
                61 54 24 5  |
                89 XX XX 8  |
                --------------
                2 52 63 26 XX 41  |
                --------------
                19  |
                1  |
                9  |
                18  |
                21  |
                --------------
                3 42  |
                64 92  |
                10 34  |
                --------------
**Input 3** : 

              [[1,6],[4,3],[1,2],[2,1]]
              [20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,21,22,23,24,25,26]

**Output 3** : 

                15  |
                10  |
                6  |
                22  |
                25  |
                18  |
                --------------
                17 XX XX 13  |
                3 XX XX 2  |
                8 XX XX 4  |
                --------------
                11  |
                23  |
                --------------
                7 12  |
                --------------

**Input 4** : 

            [[1,2],[2,3],[1,5],[7,1]]
            [20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,21,22,23,24,25,26,31,45,63,64,29,43]

**Output 4** : 

              16  | 
              4  | 
              --------------
              19 17  | 
              7 5  | 
              2 23  | 
              --------------
              13  | 
              3  | 
              31  | 
              29  | 
              43  | 
              --------------
              11 1 64 20 18 15 8  | 
              --------------

**Input 5** : 

               [[1,2],[2,3],[1,5],[3,1],[6,5],[3,2]]
               [20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,21,22,23,24,25,26,31,45,63,64,29,43,41,91,101,81,119,190,118,121,133]

**Output 5** :  

             9  | 
             21  | 
             --------------
             19 17  | 
             23 31  | 
             16 8  | 
             --------------
             13  | 
             29  | 
             4  | 
             20  | 
             14  | 
             --------------
             11 24 7  | 
             --------------
             5 25 26 45 63 3  | 
             43 81 119 190 118 41  | 
             1 133 XX XX XX 64  | 
             18 XX XX XX XX 15  | 
             12 XX XX XX XX 10  | 
             --------------
             2 91 6  | 
             101 121 22  | 
             --------------
             
             
**Input 6** :
                
                [[2,2],[2,2]]
                [1,2,3,4,5,6,7,8,9,10]

**Output 6** :

                1 2  |
                8 5  |
                --------------
                3 4  |
                7 6  |
                --------------
                Seats already filled

**---------------------------------------------------------------------------------------------------------------------------------------------------**

I have gone through **Multiple Test cases** and got the desired result for all the inputs.
