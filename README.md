# FreeRobot
Simulation of a robot roaming free on a specified board
FreeRobot is a command line Java application that simulates a robot which roams freely (randomly) on a specified board of size nxn. 
There are no obstacles on the board and the robot is prevented from falling from the board. 
The application starts by placing the robot on the board at random coordinates X, Y, F, where X, Y are the positions on the board (0,0 is the South-West corner and 0,1 is the position above) and F is where the robot is facing (North, South, East, West).
The robot moves randomly on the board performing following actions: 'move' will advance the robot one square on the board in the direction is facing, 'left' rotates the robot 90 degrees to the left and 'right' rotates the robot 90 degrees to the right. 
The robot stops when the entire board is covered (the robot has moved to all the squares at least once). 
The output of the application lists the original position of the robot and all the subsequential actions which performs until it stops.
The application needs two parameters in the command line: 
 - the size of the board n
 - a random number which will seed the pseudo-random number generator needed to decide robot's roaming.

The code is compiled with java compiler, javac. In command line, in the directory where you will download the java file, set the path to the javac (on my computer it is the following): 

>set path=C:\Program Files (x86)\Java\jdk1.8.0_92\bin

To Compile
>javac FreeRobot.java

Example to run the robot application on a 3x3 board
>java FreeRobot 3 33

The expected output is:

Hi, I am a free robot!

Starting at the coordinates 0 0 facing West

Turning left at the coordinates 0 0 facing South

Turning left at the coordinates 0 0 facing East

Turning right at the coordinates 0 0 facing South

Turning left at the coordinates 0 0 facing East

Moving at the coordinates 1 0 facing East

Moving at the coordinates 2 0 facing East

Turning left at the coordinates 2 0 facing North

Moving at the coordinates 2 1 facing North

Turning left at the coordinates 2 1 facing West

Turning right at the coordinates 2 1 facing North

Turning right at the coordinates 2 1 facing East

Turning right at the coordinates 2 1 facing South

Turning left at the coordinates 2 1 facing East

Turning left at the coordinates 2 1 facing North

Moving at the coordinates 2 2 facing North

Turning right at the coordinates 2 2 facing East

Turning left at the coordinates 2 2 facing North

Turning left at the coordinates 2 2 facing West

Moving at the coordinates 1 2 facing West

Turning right at the coordinates 1 2 facing North

Turning left at the coordinates 1 2 facing West

Turning left at the coordinates 1 2 facing South

Turning left at the coordinates 1 2 facing East

Turning right at the coordinates 1 2 facing South

Moving at the coordinates 1 1 facing South

Turning left at the coordinates 1 1 facing East

Moving at the coordinates 2 1 facing East

Turning right at the coordinates 2 1 facing South

Turning left at the coordinates 2 1 facing East

Turning left at the coordinates 2 1 facing North

Turning left at the coordinates 2 1 facing West

Turning left at the coordinates 2 1 facing South

Turning right at the coordinates 2 1 facing West

Moving at the coordinates 1 1 facing West

Moving at the coordinates 0 1 facing West

Turning right at the coordinates 0 1 facing North

Moving at the coordinates 0 2 facing North


The board has been covered in 37 actions
