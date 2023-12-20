# Object-Oriented-Programming
Computer Science: Object Oriented Programming

# This practical aims to familiarise you with Multi-Threaded applications.
The project manager of the Milky Way Space Communication Board (MWSCB)2 has requested you
to build a library that will be used to complete a couple of tasks. 

They would love these tasks to
run in parallel, and once completed, the program should proceed to print the results. You have
been provided with a Main.java class to test your application.
Note: Do not edit or change this file.

## You need to create a Multi-Threaded application that will use the provided class. You will therefore have to implement the following:
• Create a AdditionTask class that implements Runnable.
• The AdditionTask constructor takes an ArrayList of integers as a paramater
• The AdditionTask adds each number of the arraylist to the next number (next index value)
and stores the total at that current index. Note: The last number has no right hand value
and therefore remains the same.
• The MultiplicationTask class that implements Runnable.
• The MultiplicationTask constructor takes an ArrayList of integers as a paramater
• The MultiplicationTask multiplies each number of the arraylist with the next number
(next index value) and stores the product at that current index. Note: The last number has
no right hand value and therefore is multiplied by the initial first value.
• The SubtractionTask class that implements Runnable.
• The SubtractionTask constructor takes an ArrayList of integers as a paramater
• The SubtractionTask subtracts each number of the arraylist from the previous number
(previous index value) and stores the remainder at that current index. Note: The first
number has no left hand value (previous) and therefore is subtracted from itself.
• Create a TaskExecutor class that creates instances of each of the Tasks.
• The TaskExecutor should have getters to return each Task instance.
• The Main must then run.
