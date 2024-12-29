
package application;


import javafx.scene.control.TableView;

class MajorDoubleLList {
	private DNode<Major> head,tail;

	public DNode<Major> getHead() {
		return head;
	}

	public void setHead(DNode<Major> head) {
		this.head = head;
	}
	  public void addFirst(Major data) {
	        DNode<Major> newNode = new DNode<>(data);
	        if (head == null) {
	            head =tail= newNode;
	            
	        } else {
	            newNode.setNext(head);;
	            head.setPrevious(newNode);
	            head = newNode;
	        }
	    }
	// method to insert new major node into the double linked list
	  public void insertMajor(Major newMajor) {
		    DNode<Major> freshNode = new DNode<>(newMajor);
		    DNode<Major> current = head;
		    DNode<Major> previous = null;

			// insert at head node is null or to sort major node
		    if (head == null || newMajor.getName().compareTo(head.getData().getName()) < 0) {
		        addFirst(newMajor);
		        return;
		    }

		    while (current != null && newMajor.getName().compareTo(current.getData().getName()) >= 0) {
		        previous = current;
		        current = current.getNext();
		    }

			// insert at correct position
		    if (current == null) {
		        previous.setNext(freshNode);
		        freshNode.setPrevious(previous);
		        tail = freshNode; // Update the tail to point to the new last node
		        return;
		    }

		    freshNode.setNext(current);
		    freshNode.setPrevious(previous);
		    previous.setNext(freshNode);
		    current.setPrevious(freshNode);
		}

	// method to print the major list
	public void printList() {
		DNode<Major> current = head;
		while (current != null) {
			System.out.println("Major Name: " + current.getData().getName() + ", Acceptance Grade: "
					+ current.getData().getAcceptanceGrade());
			current = current.getNext();
			if (current != null) {
				System.out.println(" <=> ");
			}
		}
		System.out.println("End of Major List");
	}

	// locate major by name
	public Major searchMajor(String name) {
		DNode<Major> current = head;
		while (current != null) {
			if (current.getData().getName().equals(name)) {
				return current.getData();
			}
			current = current.getNext();
		}
		return null;
	}
	public StudentList<Student> fillAllStudents() {
		StudentList<Student> list=new StudentList<Student>();
		DNode<Major> current=this.getHead();
		while(current!=null) {
			SNode<Student> currentS=current.getData().getSlist().getHead();
			while(currentS!=null) {
				list.insertStudent(currentS.getData());
				currentS=currentS.getNext();
			}
			current=current.getNext();
		}
		return list;
	}
	public void fillTableStudents(TableView<Student> tableView) {
		tableView.getItems().clear();
		DNode<Major> current=this.getHead();
		while(current!=null) {
			SNode<Student> currentS=current.getData().getSlist().getHead();
			while(currentS!=null) {
				tableView.getItems().add(currentS.getData());
				currentS=currentS.getNext();
			}
			current=current.getNext();
		}
		tableView.refresh();
	}
	// method to delete major by it's name
	public boolean deleteMajor(String name) {
		DNode<Major> current = head;
		DNode<Major> previous = null;

		// locate major
		while (current != null && !current.getData().getName().equals(name)) {
			previous = current;
			current = current.getNext();
		}

		if (current == null) {
			System.out.println("Major " + name + " not found.");
			return false;
		}

		if (previous == null) {
			head = current.getNext();
		} else {
			previous.setNext(current.getNext());
		}

		System.out.println("Major " + name + " has been removed.");
		return true;
	}

	// method to update the major details
	public boolean updateMajor(String currentName, String newName, double newAcceptanceGrade, double newTawjihiWeight,
			double newPlacementTestWeight) {
		DNode<Major> current = head;

		// locate major
		while (current != null) {
			if (current.getData().getName().equals(currentName)) {
				if (newAcceptanceGrade < 0 || newAcceptanceGrade > 100) {
					System.out.println("acceptance grade should  be between 0 and 100.");
					return false;
				}
				if (newTawjihiWeight + newPlacementTestWeight != 1.0) {
					System.out.println("Invalid weights");
					return false;
				}

				// Update
				current.getData().setName(newName);
				current.getData().setAcceptanceGrade(newAcceptanceGrade);
				current.getData().setTawjihiWeight(newTawjihiWeight);
				current.getData().setPlacementTestWeight(newPlacementTestWeight);

				System.out.println(currentName + "Major is updated");
				return true;
			}
			current = current.getNext();
		}

		System.out.println(currentName + "Major not found.");
		return false;
	}

	 // Method to convert linked list to ObservableList for TableView
    public void fillTable(TableView<Student> table,String major) {
    	table.getItems().clear();
        SNode<Student> current = this.searchMajor(major).getSlist().getHead();
        while(current!=null) {
        	table.getItems().add(current.getData());
        		current=current.getNext();
        }
        
        table.refresh();
    }
	
	
	@Override
	public String toString() {
		return "MajorList [head=" + head + "]";
	}

}
