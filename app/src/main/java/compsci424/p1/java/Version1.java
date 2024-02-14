/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;

/** 
 * Implements the process creation hierarchy for Version 1, which uses
 * linked lists.
 * 
 * This is a template. Program1.java *must* contain the main class
 * for this program. Otherwise, feel free to edit these files, even
 * these pre-written comments or my provided code. You can add any
 * classes, methods, and data structures that you need to solve the
 * problem and display your solution in the correct format.
 */
public class Version1 {
    // Declare any class/instance variables that you need here.
    Version1PCB pcb[] = new Version1PCB[15];

    /**
     * Default constructor. Use this to allocate (if needed) and
     * initialize the PCB array, create the PCB for process 0, and do
     * any other initialization that is needed. 
     */
    public Version1() {
        pcb[0] = new Version1PCB(-1);
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
            pcb[parentPid].addChild(childIndex);
            pcb[childIndex] = new Version1PCB(parentPid);
        }


        // 2. Insert the newly allocated PCB object into parentPid's
        //    list of children

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
    int destroy (int targetPid) {
         // If targetPid is not in the process hierarchy, do nothing; 
         // your code may return an error code or message in this case,
         // but it should not halt
         if(pcb[targetPid] == null){
            System.out.println("Error: That process isn't running");
        }else{
            destroy(targetPid, targetPid);
            // while(pcb[targetPid].getChildren().size() > 0){
            //     for(int i = 0; i < pcb[targetPid].getChildren().size(); i++){
            //         pcb[targetPid].getChildren().removeFirst();
            //     }
            // }
            // int parent = pcb[targetPid].getParent();
            // int index = pcb[parent].getChildren().indexOf(targetPid);
            // pcb[parent].getChildren().remove(index);
            // pcb[targetPid] = null;
        }

         // Assuming you've found the PCB for targetPid in the PCB array:
         // 1. Recursively destroy all descendants of targetPid, if it
         //    has any, and mark their PCBs as "free" in the PCB array 
         //    (i.e., deallocate them)

         // 2. Remove targetPid from its parent's list of children

         // 3. Deallocate targetPid's PCB and mark its PCB array entry
         //    as "free"

         // You can decide what the return value(s), if any, should be.
         // If you change the return type/value(s), update the Javadoc.
        return 0; // often means "success" or "terminated normally"
    }

    int destroy(int index, int parent){
        do //finds and deallocates all of the children/ decendents from memory of given parent node
		{
			if (pcb[index].getChildren().size() == 0) {
				if (index != parent) {
					pcb[pcb[index].getParent()].getChildren().removeFirst(); //delete node off of parent's children linked list 
					//delete?
					pcb[index] = null;
					break;
				}
			}
			else{
                int c = pcb[index].getFirstChild();
				destroy(c, parent);
            }

		} while (pcb[index].getChildren().size() > 0);
    
        return 0;
    }

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
            for(int i = 0; i < pcb.length; i++){
                if(pcb[i] == null){
                    break;
                }
                System.out.print("Process " + i + ": parent is " + pcb[i].getParent());
                if(pcb[i].getChildren().size() == 0){
                    System.out.println(" and has no children");
                }else{
                    System.out.print(" and children are ");
                
                    for(int j = 0; j < pcb[i].getChildren().size(); j++){
                        System.out.print(pcb[i].getChildren().get(j) +  " ");
                    }
                    System.out.println("");
                }
                //System.out.println("");
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
    
}
