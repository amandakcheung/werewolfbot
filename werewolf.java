import java.io.File;
import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import java.util.Random;
/**
 * Outline of the python code with Java
 *
 * @author Amanda Cheung
 * @version 3/15/21
 */
public class Werewolf{
    // declaring instance variables
    private LinkedList<String> listofPlayers;
    private LinkedList<String> listofRoles;
    private int numOfPlayers;
    String[] assignedPlayers;
    public Werewolf(){
        // Scanner scan = new Scanner(System.in);
        // System.out.println("How many players are playing?");
        // numOfPlayers = scan.nextInt();
        this.listofPlayers = new LinkedList<String>();
        this.listofRoles = new LinkedList<String>();
    }

    public int numPlayers(){
        return numOfPlayers;
    }

    /**
     * adds all the players into a list
     */
    public void addPlayers(){
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= numPlayers(); i++){
            System.out.println("Who is Player " + (i) + "? (enter game number)");
            listofPlayers.add(scan.next());
        }
        scan.close();
    }

    /**
     * once dead, player is removed
     */
    public void removePlayers(int num){
        int i = 0;
        while (i < numPlayers()) {
            if (listofPlayers.get(i).equals(num)){
                listofPlayers.remove(i);
            }
            else i++;
        }

    }

    /**
     * assign roles
     */
    public String createRoles(){
        if (numPlayers() < 8){
            System.out.println("Sorry, there are not enough people to play");
        } 
        // games of 8 players- (3 wolves: random snow or king, 2 baby; 3 special: random doctor, seer, knight, hunter; 2 town)
        else if (numPlayers() == 8){
            String[] wolves = {"Snow Wolf", "King Wolf"};
            Random ran = new Random();
            int numW = ran.nextInt(2);

            listofRoles.add(wolves[numW]);
            listofRoles.add("wolf");
            listofRoles.add("wolf");

            LinkedList<String> special = new LinkedList<String>();
            special.add("Doctor/Witch");
            special.add("Seer");
            special.add("Knight/Rider");
            special.add("Hunter");
            int i= 4;
            while (i > 1)
            {
                int numS = ran.nextInt(i);
                listofRoles.add(special.get(numS));
                special.remove(numS);
                i--;
            }

            listofRoles.add("town");
            listofRoles.add("town");

        }
        // games of 9 players- (3 wolves: random snow or king, 2 baby; 3 special: random doctor, seer, knight, hunter; 3 town)
        else if (numPlayers() == 9){
            String[] wolves = {"Snow Wolf", "King Wolf"};
            Random ran = new Random();
            int numW = ran.nextInt(2);

            listofRoles.add(wolves[numW]);
            listofRoles.add("wolf");
            listofRoles.add("wolf");

            LinkedList<String> special = new LinkedList<String>();
            special.add("Doctor/Witch");
            special.add("Seer");
            special.add("Knight/Rider");
            special.add("Hunter");
            int i= 4;
            while (i > 1)
            {
                int numS = ran.nextInt(i);
                listofRoles.add(special.get(numS));
                special.remove(numS);
                i--;
            }

            listofRoles.add("town");
            listofRoles.add("town");
            listofRoles.add("town");

        }
        // games of 10 players- (3 wolves: random snow or king, 2 baby; 4 special: doctor, seer, knight, hunter; 3 town)
        else if (numPlayers() == 10){
            String[] wolves = {"Snow Wolf", "King Wolf"};
            Random ran = new Random();
            int numW = ran.nextInt(2);

            listofRoles.add(wolves[numW]);
            listofRoles.add("wolf");
            listofRoles.add("wolf");

            LinkedList<String> special = new LinkedList<String>();
            special.add("Doctor/Witch");
            special.add("Seer");
            special.add("Knight/Rider");
            special.add("Hunter");
            int i= 4;
            while (i > 0)
            {
                int numS = ran.nextInt(i);
                listofRoles.add(special.get(numS));
                special.remove(numS);
                i--;
            }

            listofRoles.add("town");
            listofRoles.add("town");
            listofRoles.add("town");

        }
        // games of 11 players- (3 wolves: snow, king, and baby; 4 special: doctor, seer, knight, hunter; 4 town)
        else if (numPlayers() == 11){
            String[] wolves = {"Snow Wolf", "King Wolf"};
            Random ran = new Random();
            int numW = ran.nextInt(2);

            listofRoles.add("Snow Wolf");
            listofRoles.add("King Wolf");
            listofRoles.add("wolf");

            LinkedList<String> special = new LinkedList<String>();
            special.add("Doctor/Witch");
            special.add("Seer");
            special.add("Knight/Rider");
            special.add("Hunter");
            int i= 4;
            while (i > 0)
            {
                int numS = ran.nextInt(i);
                listofRoles.add(special.get(numS));
                special.remove(numS);
                i--;
            }

            listofRoles.add("town");
            listofRoles.add("town");
            listofRoles.add("town");
            listofRoles.add("town");
        }
        // games of 12 players- (4 wolves: snow, king, 2 baby; 4 special: doctor, seer, knight, hunter; 4 town)
        else if (numPlayers() == 12){
            String[] wolves = {"Snow Wolf", "King Wolf"};
            Random ran = new Random();
            int numW = ran.nextInt(2);

            listofRoles.add("Snow Wolf");
            listofRoles.add("King Wolf");
            listofRoles.add("wolf");
            listofRoles.add("wolf");

            LinkedList<String> special = new LinkedList<String>();
            special.add("Doctor/Witch");
            special.add("Seer");
            special.add("Knight/Rider");
            special.add("Hunter");
            int i= 4;
            while (i > 0)
            {
                int numS = ran.nextInt(i);
                listofRoles.add(special.get(numS));
                special.remove(numS);
                i--;
            }

            listofRoles.add("town");
            listofRoles.add("town");
            listofRoles.add("town");
            listofRoles.add("town");
        }
        return null;
    }

    /**
     * randomly assigns roles
     */
    public void assignRoles(){
        Random ran = new Random();
        int i = 0;
        int totalPlayers = numPlayers();
        assignedPlayers = new String[numPlayers()];
        while (totalPlayers > 0){
            int numRole = ran.nextInt(totalPlayers);
            int numPlayer = ran.nextInt(totalPlayers);
            assignedPlayers[i] = ("Player " + listofPlayers.get(numPlayer) + " has the role " + listofRoles.get(numRole) + "\n");
            listofPlayers.remove(numPlayer);
            listofRoles.remove(numRole);
            i++;
            totalPlayers--;
        }
    }

    /**
     * play game method (inside the while loop)
     */
    public void playGame(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players are playing?");
        numOfPlayers = (scan.nextInt());
        scan.close();
        addPlayers();
        createRoles();
        assignRoles();
        System.out.println("Here are the roles:");
    }

    /**
     * toString method
     */

    public String toString(){
        String s = " ";
        for (int i = 0; i < numPlayers(); i++)
        {
            System.out.println(assignedPlayers[i]);
        }
        return s;
    }

    public static void main(String[] args){
        Werewolf newGame = new Werewolf();
        newGame.playGame();
        System.out.println(newGame);
    }
}
