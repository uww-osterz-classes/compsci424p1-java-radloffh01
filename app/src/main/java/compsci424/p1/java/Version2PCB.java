/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;

/**
 * The process control block structure that is used to track a
 * process's parent, first child, younger sibling, and older sibling
 * (if they exist) in Version 2.
 */
public class Version2PCB {
    private int youngSib, oldSib, parent, firstChild;

    public Version2PCB(){
        youngSib = -1;
        oldSib = -1;
        parent = -1;
        firstChild = -1;
    }

    public Version2PCB(int p){
        youngSib = -1;
        oldSib = -1;
        parent = p;
        firstChild = -1;
    }

    public void setYoungSib(int ys){
        youngSib = ys;
    }

    public void setOldSib(int os){
        oldSib = os;
    }

    public void setFirstChild(int fc){
        firstChild = fc;
    }

    public int getYoungSib(){
        return youngSib;
    }

    public int getOldSib(){
        return oldSib;
    }

    public int getFirstChild(){
        return firstChild;
    }

    public int getParent(){
        return parent;
    }
}
