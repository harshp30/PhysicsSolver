# PhysicsSolver

January 7, 2021

Computer Science 20 Final Project

To run code:

CS50_FinalProject/src/main/java/CS50_FinalProject

**Do not exit the program after running it, simply use the logout feature so it saves login data.

**All Login IDs are designed to be 4 digits. Teacher login ID is “1111” Program exit code is “9999”

Three different modes:

##Homework Mode:

The user is asked for which unit they are doing the homework. Once the unit is selected they are asked for all possible variables seen on formulas for that unit from the official formula sheet. If that variable is not used the user can input “0”. The code then runs through possibilities for which formulas are used and then presents all possible answers to the user. 

This mode would be used as a “calculator” when doing homework as a convenient way to check answers and effectively do homework.

Possible improvements to the system could be the integration of specific units and also the possibility of accounting for manipulated formulas. For this code we assume standard unit conversions are completed and that the formulas do not need to be manipulated.

##Test Mode:

User selects which test they want to do.
Provides the user with 5 questions from a randomized test bank
Marked out of 5.

##Teacher Mode:

An array is displayed showing the login ID and test marks of nay given student.
This mode can only be accessed using a special login.
