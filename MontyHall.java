import java.util.Scanner;

public class MontyHall{

  private String[] doors;
  private int size;
  private int doorChosen;
  private int carDoor;
  private int random;

  public MontyHall(int s){
    size = s;
    doors = new String[size];
  }

  public void fill(){

    for (int i = 0; i < size; i++){
      doors[i] = "goat";

    }
    carDoor = (int)(Math.random() * size);
    doors[carDoor] = "car";
  }

  public void filterDoors(){
    random = ((int) (Math.random() * size)) ;
    while (random == carDoor){
      random = ((int) (Math.random() * size));
    }
    if (doorChosen == carDoor){
      for (int i = 0; i < size; i++){
        if(i != random && i != carDoor){
          doors[i] = "X";
        }
      }
    }
    else{

      for (int j = 0; j < size; j++){
        if(!(doorChosen == j || carDoor == j)){
          doors[j] = "X";
        }

      }
    }
  }

  public void switchChoice(String answer){
    if (answer.equalsIgnoreCase("Y")){
      if(doorChosen == carDoor){
        doorChosen = random;
      }
      else{
        doorChosen = carDoor;
      }
    }
  }

  public void displayDoors(){
    int temp = size;
    while (temp != 0){
      for (int i = 0; i < 3; i++){
        if (temp == 0){
          return;
        }
        if(doors[size - temp].equalsIgnoreCase("X")){
          System.out.print("goat ");
        }
        else{
          System.out.print("Door " + ((size + 1) - temp) + " ");
        }
        temp--;
      }
      System.out.println();
    }
  }

  public static void main(String [] args){
    if (args.length == 0){
      System.out.println("Enter the number of Doors you'd like to play with on the same line.");
      System.exit(0);
    }
    MontyHall mh = new MontyHall(Integer.parseInt(args[0]));
    Scanner s = new Scanner(System.in);
    mh.fill();
    mh.displayDoors();
    System.out.print("Pick a door: (Ex. 1, 2, 3, 4, 5, etc...) ");
    mh.doorChosen = (Integer.parseInt(s.nextLine())) - 1;
    System.out.println();
    System.out.println();
    System.out.println("Revealing the goat(s)");
    System.out.println();
    System.out.println();
    mh.filterDoors();
    mh.displayDoors();
    if(mh.carDoor == mh.doorChosen){
      System.out.print("Would you like to switch your choice to Door " + (mh.random + 1) + "? Y/N ");
    }
    else{
      System.out.print("Would you like to switch your choice to Door " + (mh.carDoor + 1) + "? Y/N ");
    }
    String a = s.nextLine();
    mh.switchChoice(a);
    System.out.println();
    System.out.println();
    System.out.println("Your final answer was...." + mh.doors[mh.doorChosen] + "!");
    if(mh.doors[mh.doorChosen].equals("car")){
      System.out.println("Congratulations!");
    }
    else{
      System.out.println("Better luck next time...");
    }

  }
}
