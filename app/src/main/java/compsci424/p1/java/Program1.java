/* COMPSCI 424 Program 1
 * Name:
 * 
 * This is a template. Program1.java *must* contain the main class
 * for this program. Otherwise, feel free to edit these files, even
 * these pre-written comments or my provided code. You can add any
 * classes, methods, and data structures that you need to solve the
 * problem and display your solution in the correct format.
 */
package compsci424.p1.java;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Main class for this program. The required steps have been copied
 * into the main method as comments. Feel free to add more comments to
 * help you understand your code, or for any other reason. Also feel
 * free to edit this comment to be more helpful for you.
 */
public class Program1 {
    // Declare any class/instance variables that you need here.
    //Version1PCB v1pcb = new Version1PCB();
    //Version2PCB v2pcb = new Version2PCB();
    /**
     * @param args command-line arguments, which can be ignored
     */
    public static void main(String[] args) {

        // 1. Ask the user to enter commands of the form "create N",
        //    "destroy N", or "end", where N is an integer between 0 
        //    and 15.
        Scanner sc = new Scanner(System.in);
        String userIn = "";
        int userNum = 0;
        Version1 v1 = new Version1();
        Version2 v2 = new Version2();
        ArrayList<String> commands = new ArrayList<>();
        ArrayList<Integer> commandInts = new ArrayList<>();

        //System.out.println("Create, Destroy or End, where N is an integer between 0 and 15");
        //userIn = sc.nextLine();

        // 2. While the user has not typed "end", continue accepting
        //    commands. Add each command to a list of actions to take 
        //    while you run the simulation.

        while(!userIn.equals("end")){
            System.out.println("Do you want to create N, destroy N, or end, where N is an integer between 0 and 15");
            userIn = sc.next();

            //if end is typed
            if(userIn.equals("end")){
                // Version1 v1 = new Version1();
                // Version2 v2 = new Version2();

                // for(int i = 0; i < 1; i++){
                //     v1.create(i);
                //     v1.showProcessInfo();
                //     v2.create(i);
                //     v2.showProcessInfo();
                //     v1.destroy(i);
                //     v1.showProcessInfo();
                //     v2.destroy(i);
                //     v2.showProcessInfo();
                // }
                //v1.create(0);
                for(int i = 0; i < commands.size(); i++){
                    String com = commands.get(i);
                    if(com.equals("create")){
                        v1.create(commandInts.get(i));
                        v1.showProcessInfo();
                    }else{
                        v1.destroy(commandInts.get(i));
                        v1.showProcessInfo();
                    }
                }
                //v1.showProcessInfo();
                //v2.create(0);

                for(int j = 0; j < commands.size(); j++){
                    String com = commands.get(j);
                    if(com.equals("create")){
                        v2.create(commandInts.get(j));
                        v2.showProcessInfo();
                    }else{
                        v2.destroy(commandInts.get(j));
                        v2.showProcessInfo();
                    }
                }
                v2.showProcessInfo();
                break;
            }
            //userNum = sc.nextInt();
            //System.out.println(userNum);

            //if create
            if(userIn.equals("create")){
                userNum = sc.nextInt();
                commands.add("create");
                commandInts.add(userNum);

                System.out.println(userIn + userNum);
                userNum = 0;

            }else

            //if destroy
            if(userIn.equals("destroy")){
                userNum = sc.nextInt();

                commands.add("destroy");
                commandInts.add(userNum);

                System.out.println(userIn + userNum);
                userNum = 0;
            }
            //System.out.println(userIn + userNum);
        }

        //time complexity
        //version 1
        long startTime = System.currentTimeMillis();
        if(commands.size() < 2){
            for(int i = 0; i < 200; i++){
                v1.create(0);
                v1.destroy(1);
            }
        }else{
            for(int i = 0; i < 200; i++){
                for(int j = 0; j < commands.size(); j++){
                    String com = commands.get(j);
                    if(com.equals("create")){
                        v1.create(commandInts.get(j));
                    }else{
                        v1.destroy(commandInts.get(j));
                    }
                }
            }
        }
        long stopTime = System.currentTimeMillis();
        long runTime = stopTime-startTime;
        System.out.println("Version 1 Run Time: " + runTime + "/n");

        //version 2
        startTime = System.currentTimeMillis();
        if(commands.size() < 2){
            for(int i = 0; i < 200; i++){
                v2.create(0);
                v2.destroy(1);
            }
        }else{
            for(int i = 0; i < 200; i++){
                for(int j = 0; j < commands.size(); j++){
                    String com = commands.get(j);
                    if(com.equals("create")){
                        v2.create(commandInts.get(j));
                    }else{
                        v2.destroy(commandInts.get(j));
                    }
                }
            }
        }

        stopTime = System.currentTimeMillis();
        runTime = stopTime-startTime;
        System.out.println("Version 2 Run Time: " + runTime);
        // 3. When the user types "end" (or optionally any word that 
        //    is not "create" or "destroy"), stop accepting commands 
        //    and complete the following steps.
        //
        // Hint: Steps 2 and 3 refer to the same loop. ;-)

        // 4. Create an object of the Version 1 class and an object of
        //    the Version 2 class.

        // 5. Run the command sequence once with the Version 1 object, 
        //    calling its showProcessTree method after each command to
        //    show the changes in the tree after each command.

        // 6. Repeat step 5, but with the Version 2 object.

        // 7. Store the current system time in a variable

        // ... then run the command sequence 200 times with Version 1.

        // ... After this, store the new current system time in a
        //     second variable. Subtract the start time from the end 
        //     time to get the Version 1 running time, then display 
        //     the Version 1 running time.

        // 8. Repeat step 7, but with the Version 2 object.

        // This line is here just to test the Gradle build procedure.
        // You can delete it.
        sc.close();
        System.out.println("Builds without errors and runs to completion.");
    }
}
