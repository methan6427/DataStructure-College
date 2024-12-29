package application;

public class SNode<T> {

    private Student data;
    private SNode<T> next;
  //  private SNode<Student> previous; // Only for the doubly linked list

    // Constructor
    public SNode(Student data) {
        this.data = data;
    }

    // Getter and Setter for data
    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    // Getter and Setter for next node
    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }

    // Getter and Setter for previous node (used only in doubly linked lists)
  /*  public SNode<Student> getPrevious() {
        return previous;
    }

    public void setPrevious(SNode<Student> previous) {
        this.previous = previous;
    }
*/
    // toString method to display node data
    @Override
    public String toString() {
        return "[" + data + "] <=>";
    }
}


