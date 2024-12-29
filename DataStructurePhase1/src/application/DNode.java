package application;

public class DNode<Student> {

	private Student data;
	private DNode<Student> next;
	private DNode<Student> previous; // Only for the doubly linked list

	// Constructor
	public DNode(Student data) {
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
	public DNode<Student> getNext() {
		return next;
	}

	public void setNext(DNode<Student> next) {
		this.next = next;
	}

	// Getter and Setter for previous node (used only in doubly linked lists)
	public DNode<Student> getPrevious() {
		return previous;
	}

	public void setPrevious(DNode<Student> previous) {
		this.previous = previous;
	}

	// toString method to display node data
	@Override
	public String toString() {
		return "[" + data + "] <=>";
	}
}
