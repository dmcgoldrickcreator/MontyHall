import java.util.Scanner;

public class MontyHallSimul {

  private int simulations;
  private String switchInput;
  private String[] doors;
  private int size;
  private int doorChosen;
  private int carDoor;
  private int random;
  private double count;

  public MontyHallSimul(int sim, int d, String s){
    size = d;
    doors = new String[size];
    switchInput = s;
    simulations = sim;
    count = 0.0;

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

  }

  public void switchChoice(){
      if(doorChosen == carDoor){
        doorChosen = random;
      }
      else{
        doorChosen = carDoor;
      }
  }
  public static void main(String [] args){
    if(args.length == 0){
      System.out.println("Please enter three args, [# of Simulations], [# of Doors], [Y to switch, else N]");
      System.exit(0);
    }
    MontyHallSimul s = new MontyHallSimul(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
    if(s.switchInput.equalsIgnoreCase("Y")){
      for(int i = 0; i < s.simulations; i++){
        s.fill();
        s.filterDoors();
        s.switchChoice();
        if(s.doors[s.doorChosen].equals("car")){
          System.out.print("car ");
          s.count++;
        }
        else{
          System.out.print("goat ");
        }
      }
    }
    else{
      for(int i = 0; i < s.simulations; i++){
        s.fill();
        s.filterDoors();
        if(s.doors[s.doorChosen].equals("car")){
          System.out.print("car ");
          s.count++;
        }
        else{
          System.out.print("goat ");
        }

      }
    }
  System.out.println();
  System.out.println();
  System.out.println("Percentage won: " + ((s.count/s.simulations)* 100) + "%");
  }

}
