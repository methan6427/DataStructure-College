package application;

class StudentList<T>  {
	private SNode<T> head;
	/*
	 * public void insertStudent(Student newStudent) { Node<T> freshNode =
	 * null; Node<T> prev = null; Node<T> current = head; if (head ==
	 * null || head.getData().compareTo(newStudent) > 0) { freshNode.setNext(head);
	 * head = freshNode; } else { while (current != null &&
	 * (newStudent.compareTo(current.getData()) > 0)) { prev = current; current =
	 * current.getNext(); } freshNode.setNext(current); if (prev != null) {
	 * prev.setNext(freshNode); } }
	 * 
	 * }
	 */
	
	
	// method to insert new student node into the single linked list
	public void insertStudent(Student newStudent) {
	    SNode<T> freshNode = new SNode<>(newStudent);
	    SNode<T> prev = null;
	    SNode<T> current = head;
	    

		// insert at head node is null or mark is higher than the previous student
	    if (head == null || newStudent.getAdmissionMark() > head.getData().getAdmissionMark()) {
	        freshNode.setNext(head);
	        head = freshNode;
	        return;
	    }

	    while (current != null && newStudent.getAdmissionMark() <= current.getData().getAdmissionMark()) {
	        prev = current;
	        current = current.getNext();
	    }

		// insert at correct position
	    freshNode.setNext(current);
	    if (prev != null) {
	        prev.setNext(freshNode);
	    }
	}
	/*
	 * public void printList() { Node<T> current = head; while (current !=
	 * null) { System.out.print(current.getData().toString() + " <=> "); current =
	 * current.getNext(); } System.out.println("null"); }
	 * 
	 */

	public SNode<T> getHead() {
		return head;
	}

	public void setHead(SNode<T> head) {
		this.head = head;
	}

	/*
	 * i printed it like this to make it easier to read for me and the instructor in
	 * discussion
	 */
	// method to print the student list
	public void printList() {
		SNode<T> temp = head;
		while (temp != null) {
			System.out.println("Student ID: " + temp.getData().getId() + ", Name: " + temp.getData().getName()
					+ ", Tawjihi Grade: " + temp.getData().getTawjihiGrade() + ", Placement Test Grade: "
					+ temp.getData().getPlacementTestGrade() + ", Chosen Major: " + temp.getData().getChosenMajor()
					+ ", Admission Mark: " + temp.getData().getAdmissionMark());
			temp = temp.getNext();
			if (temp != null) {
				System.out.println(" -> ");
			}
		}
		System.out.println("End of List");
	}

	// locate student by id
	public Student searchStudent(int id) {
		SNode<T> start = head;
		while (start != null) {
			if (start.getData().getId() == id) {
				return start.getData();
			}
			start = start.getNext();
		}
		return null;
	}

	//method to delete student by his\her id
	public boolean deleteStudent(int id) {
		SNode<T> current = head;
		SNode<T> previous = null;

		// finding the student by his id
		while (current != null && current.getData().getId() != id) {
			previous = current;
			current = current.getNext();
		}

		if (current == null) {
			System.out.println("Student with ID " + id + " not found.");
			return false;
		}

		if (previous == null) {
			head = current.getNext();
		} else {
			previous.setNext(current.getNext());
		}

		System.out.println("Student" + id + " has been removed.");
		return true;
	}

	//method to update student details
	public boolean updateStudent(int id, String newName, double newTawjihiGrade, double newPlacementTestGrade) {
		SNode<T> current = head;

		//locate student
		while (current != null) {
			if (current.getData().getId() == id) {
				if (newTawjihiGrade < 0 || newTawjihiGrade > 100 || newPlacementTestGrade < 0
						|| newPlacementTestGrade > 100) {
					System.out.println("grades should be between 0 and 100.");
					return false;
				}

				// Update 
				current.getData().setName(newName);
				current.getData().setTawjihiGrade(newTawjihiGrade);
				current.getData().setPlacementTestGrade(newPlacementTestGrade);

				System.out.println(id + " Student is updated.");
				return true;
			}
			current = current.getNext();
		}

		System.out.println("Student not found" + id);
		return false;
	}
	
	
	@Override
	public String toString() {
		return "StudentList [head=" + head + "]";
	}
	
	
}
