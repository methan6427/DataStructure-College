package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	private ArrayList<Family> families;

	public Manager() {
		families = new ArrayList<>();
	}

	public boolean addFamily(Family family) {
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).equals(family)) {
				return false;
			}
		}
		families.add(family);
		return true;
	}

	public boolean updateFamily(String familyname, Family family) {
		Family temp = seachByName(familyname);
		if (temp == null)
			return false;
		else {
			families.remove(temp);
			families.add(family);
			return true;
		}
	}

	public boolean deleteFamily(String familyname) {
		Family temp = seachByName(familyname);
		if (temp == null)
			return false;
		else {
			families.remove(temp);
			return true;
		}
	}

	public Family seachByName(String familyname) {
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyname().equals(familyname)) {
				return families.get(i);
			}
		}
		return null;
	}

	public Person searchPersonByID(String personid) {
		for (int i = 0; i < families.size(); i++) {
			for (int j = 0; j < families.get(i).getMembers().size(); j++) {
				if (families.get(i).getMembers().get(j).getId().equals(personid)) {
					return families.get(i).getMembers().get(j);
				}
			}
			for (int j = 0; j < families.get(i).getParents().size(); j++) {
				if (families.get(i).getParents().get(j).getId().equals(personid)) {
					return families.get(i).getParents().get(j);
				}
			}
		}
		return null;
	}

	public int calculateTotalMartyrs() {
		int count = 0;
		for (int i = 0; i < families.size(); i++) {
			count += calculateTotalMartyrs(families.get(i).getFamilyname());
		}
		return count;
	}

	public int calculateTotalMartyrs(String familyname) {
		int count = 0;
		Family temp = seachByName(familyname);
		if (temp != null) {
			for (int j = 0; j < temp.getMembers().size(); j++)
				if (temp.getMembers().get(j) instanceof Martyr)
					count++;
			for (int j = 0; j < temp.getParents().size(); j++)
				if (temp.getParents().get(j) instanceof Martyr)
					count++;
			return count;
		}
		return 0;

	}

	public int calculateTotalOrphans() {
		int sum = 0;
		for (int i = 0; i < families.size(); i++) {
			sum += calculateTotalOrphans(families.get(i).getFamilyname());
		}
		return sum;

	}

	public int calculateTotalOrphans(String familyname) {
		int sum = 0;
		int livecount = 0;
		Family temp = seachByName(familyname);
		if (temp != null) {
			if (temp.getFamilyname().equalsIgnoreCase(familyname)) {
				for (int j = 0; j < temp.getParents().size(); j++)
					if (temp.getParents().get(j) instanceof LivePerson)
						livecount++;
				if (livecount == 0)
					sum += temp.getMembers().size();
				return sum;
			}
		}
		return 0;
	}

	public int calculateTotalLivePersons() {
		int livecount = 0;
		for (int i = 0; i < families.size(); i++) {
			livecount += calculateTotalLivePersons(families.get(i).getFamilyname());
		}
		return livecount;

	}

	public int calculateTotalLivePersons(String familyname) {
		int livecount = 0;
		Family temp = seachByName(familyname);
		if (temp != null) {
			for (int j = 0; j < temp.getParents().size(); j++)
				if (temp.getParents().get(j) instanceof LivePerson)
					livecount++;
			for (int j = 0; j < temp.getMembers().size(); j++)
				if (temp.getMembers().get(j) instanceof LivePerson)
					livecount++;
			return livecount;
		}

		return 0;

	}

	public ArrayList<Integer> calculateFamilyStatistics(String familyname) {
		ArrayList<Integer> arr = new ArrayList<>();
		int orphans = calculateTotalOrphans(familyname);
		int martyrs = calculateTotalMartyrs(familyname);
		int live = calculateTotalLivePersons(familyname);
		arr.add(orphans);
		arr.add(martyrs);
		arr.add(live);
		return arr;

	}

	public ArrayList<Integer> calculateGlobalStatistics() {
		ArrayList<Integer> arr = new ArrayList<>();
		int orphans = calculateTotalOrphans();
		int martyrs = calculateTotalMartyrs();
		int live = calculateTotalLivePersons();
		arr.add(orphans);
		arr.add(martyrs);
		arr.add(live);
		return arr;

	}

	public void ReadFile() {
		File file = new File("manager.txt");
		try {
			Scanner in = new Scanner(file);
			Family family = new Family("Temp");
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (line.contains("Family")) {
					if (!family.getFamilyname().equals("Temp")) {
						this.families.add(family);
					}
					family = new Family(line.split(" ")[1]);
					continue;
				}
				if (line.contains("Martyr")) {
					String[] split = line.split(",");
					family.addMembers(new Martyr(split[1], split[2], Integer.parseInt(split[3]), split[4], split[5],
							split[6], split[7], split[8], split[9]), split[10]);
					continue;
				}
				if (line.contains("LivePerson")) {
					String[] split = line.split(",");
					family.addMembers(new LivePerson(split[1], split[2], Integer.parseInt(split[3]), split[4], split[5],
							split[6]), split[7]);
					continue;
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeFile() {
		File file = new File("manager.txt");
		try {
			FileWriter write = new FileWriter(file);
			Sortable.sortByMartyrs(families);
			for (int i = 0; i < this.families.size(); i++) {
				Family print = this.families.get(i);
				write.write(print.toString() + "\n");
			}
			write.close();
		} catch (IOException e) {
		}

	}

	@Override
	public String toString() {
		return "Manager [families=" + families + "]";
	}
}
