/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;
import java.util.LinkedList;



/**
 * The process control block structure that is used to track a
 * process's parent and children (if any) in Version 1.
 */
public class Version1PCB {
    private int parent = -1;
    private LinkedList<Integer> children = new LinkedList<Integer>();

    public Version1PCB(int p){
        parent = p;
    }

    public Version1PCB(){
        
    }

    public int getParent(){
        return parent;
    }

    public int getFirstChild(){
        return children.getFirst();
    }

    public LinkedList<Integer> getChildren(){
        return children;
    }
}
