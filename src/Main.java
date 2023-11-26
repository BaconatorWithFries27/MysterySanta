import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    private static int option = -1;
    private static ArrayList<Person> people = new ArrayList<>();


    public static void main(String[] args) {
        while (true) {
            printOptions();
            option = scn.nextInt();

            switch (option) {
                case 1:
                    newPerson();
                    break;
                case 2:
                    editPerson();
                    break;
                case 3:
                    restrictions();
                    break;
                case 4:
                    createList();
                    break;
                case 5:
                    exportList();
                    break;
                case 6:
                    sendList();
                    break;
                case 7:
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }

    }

    public static void printOptions(){
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("1: Create new person");
        System.out.println("2: View/Edit Person");
        System.out.println("3: Create/Edit Restrictions");
        System.out.println("4: Generate List");
        System.out.println("5: Export List");
        System.out.println("6: Send List");
        System.out.println("7: Exit");
        System.out.println("---------------------------");
        System.out.println("Enter Option:");
    }

    public static void printPeople(){
        System.out.println();
        System.out.println("People:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(i + 1 + ": " + people.get(i).toString());
        }
    }
    public static void newPerson(){
        System.out.println();
        System.out.print("Enter Name: ");
        String name = scn.next();
        System.out.print("Enter Email: ");
        String email = scn.next();
        people.add(new Person(name,email));
        System.out.println(people.get(people.size() - 1).toString());
    }

    public static void editPerson(){
        printPeople();
        System.out.print("Enter number of person to edit or -1 to exit:");
        int edit = scn.nextInt();
        if (edit == -1){return;}
        System.out.println();
        System.out.println("Current name: " + people.get(edit - 1).getName());
        System.out.print("New name: ");
        people.get(edit - 1).setName(scn.next());
        System.out.println();
        System.out.println("Current email: " + people.get(edit - 1).getEmail());
        System.out.print("New email: ");
        people.get(edit - 1).setEmail(scn.next());
    }

    public static void restrictions(){
        printPeople();
        System.out.println("Enter number of restricted giver: ");
        int restrictedGiver = scn.nextInt() - 1;
        System.out.println("Enter number of restricted receiver, or -1 to remove all: ");
        int restrictedReceiver = scn.nextInt() - 1;
        if (restrictedReceiver == -2){
            people.get(restrictedGiver).removeRestrictedGift();
            return;
        }
        people.get(restrictedGiver).setRestrictedGift(people.get(restrictedReceiver));

    }

    public static void createList(){
        Random random = new Random();
        ArrayList<Person> assigned = new ArrayList<>();
        int tries = 0;
        for (int i = 0; i < people.size(); i++) {
            Person setRec = people.get(random.nextInt(people.size()));
            while (people.get(i).restrictedGift.contains(setRec) || assigned.contains(setRec) || Objects.equals(people.get(i), setRec)){
                setRec = people.get(random.nextInt(people.size()));
                tries++;
                if (tries > 15){
                    System.out.println("There was an error creating the list, try again.");
                    return;
                }
            }
            people.get(i).setReceiver(setRec);
            assigned.add(setRec);

        }
    }

    public static void sendList(){}

    public static void exportList(){
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).printSanta());
        }
    }



}