# Cameron Paczek - Interpreter Documentation
Student ID: 921192815
Section: 413.02
Github Link: https://github.com/csc413-sp21/csc413-p2-Cpaczek

***

## 1. Introduction



### 1.1 Project Overview
This program is an interpreter of language x. The program needs to be compiled into a .cod bytecodes for this to work. This is not a compiler.

### 1.2 Technical Overview
There are three main processes that run. 

##### Virtual Machine:

This is the class the is responsible for running the program and will have the main loop and its the class that interacts with the runtime stack.
##### RunTime Stack

This class is responsible for implementing the methods that can modify the runtime stack as well as other datastructures that are used. This class is very secure
and is only ever touched by the virtual machine.

##### Byte Code Loader

This class is responsible for parsing the .cod files that needs to be ran. It loops through line by line and parses each byte code that the program needs.

### 1.3 Summary of Work Completed

Please see the classes for addtional information. Project is well commented.



 * Byte Code Loader
 * Virtual Machine
    - Dump Managment
    - Functions for interactions between ByteCode and Runtime Stack
 * Runtime Stack
    - Dumping of Runtime Stack
    - Basic Functions to view and modify runtime/return/frampointer stack
 * Return Stack
 * Frame Pointer Stack
 * Byte Code Class
   - Reference Byte Code
      - Call Byte Code
      - Goto Byte Code
      - False Branch Byte Code
   - Args Byte Code
   - Bop Byte Code
   - Dump Byte Code
   - False Branch Byte Code
   - Halt Byte Code
   - Label Byte Code
   - Lit Byte Code
   - Load Byte Code
   - Pop Byte Code
   - Read Byte Code
   - Return Byte Code
   - Store Byte Code
   - Write Byte Code
   
## 2. Development Enviroment 
 This program has been tested on the following environment.
 
 Windows 10 64 bit Java 1.8.0 Intelij IDEA
 
## 3. How to build and import your project
1: Clone the repository
2: Import the repo inside InteliJ
3: Add the .cod program you would like to run to the java command line arguments
4: Run the `Interpreter` Class

## 4. How to run your project
Press the green play button. Please note some functions may need a terminal for data input and logging.

## 5. Assumptions Made

  * The compiled program is valid and only uses the byte codes implemented as outlined in section 1.3
  * No number that enters the Runtime Stack will exceed the Java Int Limit
  * Arguments are separated by 1 or more spaces.
## 6. Implementation Discussion

This project is pretty close to the guide lines however there are a few addons that differ from the original spec.

  * There is now a RefByteCode class which allows the bytecode loader to more easily scan for ByteCodes that jump around the program.
  * Dump is dependent on if the ByteCode has a ToString Method Overridden. If there is a ToString within a byte code it will automatically start printing that to the terminal
  * The ReturnAddressStack has been moved from the VM to the RuntimeStack class. This is to promote least privilege and encapsulation.
  * The Dump Function within the Runtime Stack will always print out everything except the for the top frame. It will return the top frame as an array. This does cause the issue of dumping the stack without seeing the it in the terminal however, you can still use it to get the top frame in the form of a list.
 
### 6.1 Class Diagram

![Class Diagram](https://i.imgur.com/tWRMhTn.png)

## 7. Project Reflection
I personally loved this project a lot, it was a very unique way to learn about how interpreters work. In the past I heard about "The Stack", mainly in pentesting forums and regarding buffer overflow. I had a general idea about what it was but now I really understand how it works.

## 8. Project Conclusions/Results
I was able to complete project and added some of my own efficiencies (see section 6). As far as I am aware there are no bugs with the programs that were provided. I do wish we had a few more programs (specifically a smaller one, about 10 lines) so we could step through them line by line and have more testing.