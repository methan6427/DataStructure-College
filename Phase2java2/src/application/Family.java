package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Family implements Sortable {
	private String familyname;
	private ArrayList<Person> members;
	private ArrayList<Person> parents;

	public Family(String familyname) {
		members = new ArrayList<>();
		parents = new ArrayList<>();
		this.familyname = familyname;
	}

	public boolean addMembers(Person member, String role) {// add condition to dermin false, add familyname value
		if (role.trim().equalsIgnoreCase("Dad") || role.trim().equalsIgnoreCase("Mom")) {
			if (parents.size() == 2) {
				return false;
			}
			for (int i = 0; i < parents.size(); i++) {
				if (parents.get(i).equals(member)) {
					return false;
				}
			}
			parents.add(member);
			return true;
		} else {
			members.add(member);
			return true;
		}
	}

	public boolean removeMember(Person member) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).equals(member)) {
				members.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean removeParent(Person member) {
		for (int i = 0; i < parents.size(); i++) {
			if (parents.get(i).equals(member)) {
				parents.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Person> getMembers() {
		return members;
	}

	public ArrayList<Person> getParents() {
		return parents;
	}

	public void addParent(Person parent) {
		if (parent.getGender().equals("F"))
			addMembers(parent, "Mom");
		else
			addMembers(parent, "Dad");
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	@Override
	public String toString() {
		String allFamily = new String();
		allFamily += "Family " + familyname + "\n";
		allFamily += "..............\n";
		for (int i = 0; i < members.size(); i++) {
			allFamily+=members.get(i).toString()+",Role\n";
		}
		for (int i = 0; i < parents.size(); i++) {
			allFamily+=parents.get(i).toString()+"Dad"+"\n";
		}
		return allFamily;
	}

	public Family deepCopy() {
		Family copied = new Family(familyname);
		for (Person person : members) {
			copied.addMembers(person.copy(), "Child");
		}
		for (Person person : parents) {
			copied.addMembers(person.copy(), "Dad");

		}
		return copied;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.familyname.equals(((Family) obj).getFamilyname())) {
			int count = 0;
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i) instanceof Martyr) {
					count++;
				}
			}
			for (int i = 0; i < parents.size(); i++) {
				if (parents.get(i) instanceof Martyr) {
					count++;
				}
			}

			int count2 = 0;
			for (int i = 0; i < ((Family) obj).getMembers().size(); i++) {
				if (((Family) obj).getMembers().get(i) instanceof Martyr) {
					count2++;
				}
			}
			for (int i = 0; i < ((Family) obj).getParents().size(); i++) {
				if (((Family) obj).getParents().get(i) instanceof Martyr) {
					count2++;
				}
			}
			if (count == count2) {
				return true;
			}
		}
		return false;
	}

	public int getMartyrsCount() {
		int count = 0;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i) instanceof Martyr) {
				count++;
			}
		}
		for (int i = 0; i < parents.size(); i++) {
			if (parents.get(i) instanceof Martyr) {
				count++;
			}
		}
		return count;
	}

	public int getOrphansCount() {
		int count = 0;
		for (int i = 0; i < parents.size(); i++) {
			if (parents.get(i) instanceof Martyr) {
				count++;
			}
		}
		return count;
	}

}
