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
