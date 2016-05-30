import java.util.*;

public class FreeRobot {

//the robot performs an action: moves or rotates(left,right)
public static String[] perform(int X, int Y, String F, String action){
   if(action == "Move")
   {
    switch (F){
      case "North": {Y++;break;}
      case "South": {Y--;break;}
      case "East": {X++;break;}
      case "West": {X--;break;}
    }
    System.out.println("Moving at the coordinates " + X + " " + Y + " facing " + F);
   }
   else if(action == "Left")
   {
    switch (F){
      case "North": {F="West";break;}
      case "South": {F="East";break;}
      case "East": {F="North";break;}
      case "West": {F="South";break;}
    }
    System.out.println("Turning left at the coordinates " + X + " " + Y + " facing " + F);
   }
   else
   { 
    switch (F){
      case "North": {F="East";break;}
      case "South": {F="West";break;}
      case "East": {F="South";break;}
      case "West": {F="North";break;}
    }
    System.out.println("Turning right at the coordinates " + X + " " + Y + " facing " + F);
   }
//returns the new position of the robot after the action
String[] newposition = new String[3];
newposition[0] = Integer.toString(X); 
newposition[1] = Integer.toString(Y);
newposition[2] = F;

return newposition;
}

//checks if the new position has been reached before by the //robot in order to determine when the entire board was //covered and returns how many positions were reached
public static int checkRemaining(int X, int Y, boolean[][] board, int position){
  
  if(!board[X][Y]){
   board[X][Y]= true;
   position++;
  } 

return position;
}


//main program
public static void main(String[] args)
 {
  if (args.length != 2){
  System.out.println("java FreeRobot <size of the board> <generator seed>");
  System.exit(0);
  }
  //initialise the generator for selecting the actions
  Random Generator = new Random(Integer.parseInt(args[1]));
  String axes[] = {"North","East","South","West"};
  String actions[] = {"Left","Right","Move"};
  
  //Robot is placed on the board at coordinates X,Y facing          //direction F
  int margin = Integer.parseInt(args[0]);
  int X = Generator.nextInt(margin);
  int Y = Generator.nextInt(margin);
  String F = axes[Generator.nextInt(4)];
  System.out.println("Hi, I am a free robot!");
  System.out.println("Starting at the coordinates " + X + " " + Y + " facing " + F);

  int position = 1;
  int countActions = 0;
  String[] newposition = new String[3]; 
  boolean[][] board = new boolean[margin][margin];
  //the positions which were not reached by the robot are //initialised as false
  for(int i=0; i< margin; i++)
   for(int j=0; j< margin; j++)
     board[i][j] = false;
  board[X][Y] = true;  

  //the robot will perform actions as long as there are //position on the board which have not been reached yet
//if the robot is on the side of the board facing outside of //the board, e.g X=0, facing West it will not be allowed to make //a move, therefore its actions will be restricted to left and //right rotations. Otherwise, the robot is allowed to perform //unrestricted
  boolean restricted;
  while(position < margin*margin)
  {
   restricted = false;
   if((X == 0)&(F == "West"))
      restricted = true;
   else if((X == 0)&(Y == 0)&((F == "South")|(F == "West")))  
      restricted = true;
   else if((Y == 0)&(F == "South"))
      restricted = true;
   else if((X == (margin-1))&(F == "East"))
      restricted = true;
   else if((X == (margin-1))&(Y == 0)&((F == "East")|(F == "South")))
      restricted = true;
   else if((Y == (margin-1))&(F == "North"))
      restricted = true;
   else if((X == (margin-1))&(Y == (margin-1))&((F == "North")|(F == "East")))
      restricted = true;
   else if((X == 0)&(Y == (margin-1))&((F == "North")|(F == "West")))
      restricted = true;
 
   if (restricted)
   newposition = perform(X,Y,F,actions[Generator.nextInt(2)]);
   else 
   newposition = perform(X,Y,F,actions[Generator.nextInt(3)]);

   X = Integer.parseInt(newposition[0]);
   Y = Integer.parseInt(newposition[1]);
   F = newposition[2];
   //checks if the new position has been reached before
   position = checkRemaining(X,Y,board,position);
   countActions ++;
  }
  System.out.println("\nThe board has been covered in " + countActions + " actions");
 }
}
