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
                v1.create(0);
                v1.showProcessInfo();
                v2.create(0);
                v2.showProcessInfo();
                break;
            }
            userNum = sc.nextInt();
            System.out.println(userNum);

            //if create
            if(userIn.equals("create")){
                // System.out.println("Enter an Integer N, where N is an intger between 0 and 15");
                // userNum = sc.nextInt();
                // while(userNum < 0 || userNum > 15){
                //     System.out.println("Invalid Integer, try again");
                //     System.out.println("Enter an Integer N, where N is an intger between 0 and 15");
                //     userNum = sc.nextInt();
                // }

                //Version1 v1 = new Version1();
                v1.create(userNum);
                //Version2 v2 = new Version2();
                v2.create(userNum);
                userNum = 0;

            }else

            //if destroy
            if(userIn.equals("destroy")){
                // System.out.println("Enter an Integer N, where N is an intger between 0 and 15");
                // userNum = sc.nextInt();
                // while(userNum < 0 || userNum > 15){
                //     System.out.println("Invalid Integer, try again");
                //     System.out.println("Enter an Integer N, where N is an intger between 0 and 15");
                //     userNum = sc.nextInt();
                // }

                //Version1 v1 = new Version1();
                v1.destroy(userNum);
                //Version2 v2 = new Version2();
                v2.destroy(userNum);
                userNum = 0;
            }
        }

        //time complexity
        // long startTime = System.currentTimeMillis();
        // //Version1 v1 = new Version1();
        // for(int i = 0; i <= 200; i++){
        //     int method = (int)Math.random() * 2;
        //     int number = (int)Math.random() * 15;
        //     if(method == 0){
        //         v1.create(number);
        //     }
        //     if(method == 1 || method == 2){
        //         v1.destroy(number);
        //     }
        // }
        // long stopTime = System.currentTimeMillis();
        // long runTime = stopTime-startTime;
        // System.out.println("Version 1 Run Time: " + runTime);


        // startTime = System.currentTimeMillis();
        // //Version1 v2 = new Version1();
        // for(int i = 0; i <= 200; i++){
        //     int method = (int)Math.random() * 2;
        //     int number = (int)Math.random() * 15;
        //     if(method == 0){
        //         v2.create(number);
        //     }
        //     if(method == 1 || method == 2){
        //         v2.destroy(number);
        //     }
        // }
        // stopTime = System.currentTimeMillis();
        // runTime = stopTime-startTime;
        // System.out.println("Version 2 Run Time: " + runTime);
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
