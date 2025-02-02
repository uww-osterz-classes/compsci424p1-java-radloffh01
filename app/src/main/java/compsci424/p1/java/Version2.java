/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;
import java.util.LinkedList;

/** 
 * Implements the process creation hierarchy for Version 2, which does
 * not use linked lists.
 * 
 * This is a template. Program1.java *must* contain the main class
 * for this program. Otherwise, feel free to edit these files, even
 * these pre-written comments or my provided code. You can add any
 * classes, methods, and data structures that you need to solve the
 * problem and display your solution in the correct format.
 */
public class Version2 {
    // Declare any class/instance variables that you need here.
    Version2PCB pcb[] = new Version2PCB[15];

    /**
     * Default constructor. Use this to allocate (if needed) and
     * initialize the PCB array, create the PCB for process 0, and do
     * any other initialization that is needed. 
     */
    public Version2() {
        pcb[0] = new Version2PCB(-1);
        for(int i = 1; i < pcb.length; i++){
            pcb[i] = null;
        }
    }
    
    /**
     * Creates a new child process of the process with ID parentPid. 
     * @param parentPid the PID of the new process's parent
     * @return 0 if successful, not 0 if unsuccessful
     */
    int create(int parentPid) {
        // If parentPid is not in the process hierarchy, do nothing; 
        // your code may return an error code or message in this case,
        // but it should not halt
        if(pcb[parentPid] == null){
            System.out.println("Error: That parent process doesn't exist'");
        }else

        // Assuming you've found the PCB for parentPid in the PCB array:
        // 1. Allocate and initialize a free PCB object from the array
        //    of PCB objects
        if(firstFreeIndex() == -1){
            System.out.println("Error: The are no free PCBs'");
        }else{
            int childIndex = firstFreeIndex();
            pcb[childIndex] = new Version2PCB(parentPid);
            int firstChild = pcb[parentPid].getFirstChild();

            if(firstChild == -1){
                pcb[parentPid].setFirstChild(childIndex);
            }else{
                setYoungestSib(firstChild, childIndex);
            }
        }

        // 2. Connect the new PCB object to its parent, its older
        //    sibling (if any), and its younger sibling (if any)

        // You can decide what the return value(s), if any, should be.
        // If you change the return type/value(s), update the Javadoc.
        return 0; // often means "success" or "terminated normally"
    }

    /**
     * Recursively destroys the process with ID parentPid and all of
     * its descendant processes (child, grandchild, etc.).
     * @param targetPid the PID of the process to be destroyed
     * @return 0 if successful, not 0 if unsuccessful
     */

    int destroy(int targetPid){
        if(pcb[targetPid] == null){
            System.out.println("Error: That process isn't running");
        }else{
            if(pcb[targetPid].getFirstChild() != -1){
                destroy(pcb[targetPid].getFirstChild());
                pcb[targetPid].setFirstChild(-1);
            }else if(pcb[targetPid].getYoungSib() != -1){
                destroy(pcb[targetPid].getYoungSib());
                pcb[targetPid].setYoungSib(-1);
                //pcb[targetPid] = null;
            }
            //pcb[targetPid].setFirstChild(-1);
            //pcb[targetPid].setYoungSib(-1);
            //int p = pcb[targetPid].getParent();

            //if targetPid has and older and younger sibling
            if(pcb[targetPid].getOldSib() != -1 && pcb[targetPid].getYoungSib() != -1){
                int os = pcb[targetPid].getOldSib();
                int ys = pcb[targetPid].getYoungSib();
                pcb[os].setYoungSib(ys);
                pcb[ys].setOldSib(os);

            //if targetPid has an older sibling
            }else if(pcb[targetPid].getOldSib() != -1 && pcb[targetPid].getYoungSib() == -1){
                int os = pcb[targetPid].getOldSib();
                pcb[os].setYoungSib(-1);

                //if targetPid has a younger sibling
            }else if(pcb[targetPid].getOldSib() == -1 && pcb[targetPid].getYoungSib() != -1){
                int ys = pcb[targetPid].getYoungSib();
                int p = pcb[targetPid].getParent();
                pcb[p].setFirstChild(ys);
            }else{ //if targetPid is only child of parent
                int p = pcb[targetPid].getParent();
                pcb[p].setFirstChild(-1);
            }
            pcb[targetPid] = null;
        }



        return 0;
    }


        
    
    

//         // Assuming you've found the PCB for targetPid in the PCB array:
//         // 1. Recursively destroy all descendants of targetPid, if it
//         //    has any, and mark their PCBs as "free" in the PCB array 
//         //    (i.e., deallocate them)

//         // 2. Adjust connections within the hierarchy graph as needed to
//         //    re-connect the graph

//         // 3. Deallocate targetPid's PCB and mark its PCB array entry
//         //    as "free"

//         // You can decide what the return value(s), if any, should be.
//         // If you change the return type/value(s), update the Javadoc.
//        return 0; // often means "success" or "terminated normally"
//    }

   /**
    * Traverse the process creation hierarchy graph, printing
    * information about each process as you go. See Canvas for the
    * *required* output format. 
    *         
    * You can directly use "System.out.println" statements (or
    * similar) to send the required output to stdout, or you can
    * change the return type of this function to return the text to
    * the main program for printing. It's your choice. 
    */
   void showProcessInfo() {
        for(int i = 0; i < pcb.length-1; i++){
            if(pcb[i] != null){
                
            System.out.print("Process " + i + ": parent is " + pcb[i].getParent());
            if(pcb[i].getFirstChild() == -1){
                System.out.println(" and has no children");
            }else{
                int c = pcb[i].getFirstChild();
                System.out.print(" and children are ");
                while(c != -1){
                    System.out.print(c + " ");
                    c = pcb[c].getYoungSib();
                }
                System.out.println("");
            }
            //System.out.println("");
        }
    }
   }

   /* If you need or want more methods, feel free to add them. */
   int firstFreeIndex(){
        for(int i = 0; i < pcb.length; i++){
            if(pcb[i] == null){
                return i;
            }
        }
        return -1;
    }

    void setYoungestSib(int olderChild, int youngestChild){
        if(pcb[olderChild].getYoungSib() != -1){//if the first/oldest sib doesn't have a youngest sib
            setYoungestSib(pcb[olderChild].getYoungSib(), youngestChild);

        }else if(pcb[olderChild].getOldSib() != -1){
            pcb[olderChild].setYoungSib(youngestChild);
            pcb[youngestChild].setOldSib(olderChild);

        }else if(pcb[olderChild].getOldSib() == -1){
            pcb[olderChild].setYoungSib(youngestChild);
        }
    }


}
