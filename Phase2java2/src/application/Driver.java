package application;

import java.util.Scanner;

public class Driver {
	public static Manager manager = new Manager();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		printMenu();
		try {
		int choice = in.nextInt();
		in.nextLine();
		while (choice != 8) {
			switch (choice) {
			case 8:
				manager.ReadFile();
				break;
			case 9:
				manager.writeFile();
				break;
			case 1:
				Family newF = add();
				manager.addFamily(newF);
				System.out.println("Family Added!");
				break;
			case 2:
				System.out.println("Enter Family name to find it");
				String name = in.nextLine();
				Family flag = manager.seachByName(name);
				if (flag != null) {
					System.out.println("Enter the new Data");
					Family editFamily = add();
					manager.updateFamily(name, editFamily);
					System.out.println("Family Updated");
				} else {
					System.out.println("Family not found");
				}
				break;
			case 3:
				System.out.println("Enter Family name to find it");
				String named = in.nextLine();
				boolean flagd = manager.deleteFamily(named);
				if (flagd)
					System.out.println("Family deleted");
				else
					System.out.println("Family not found");
				break;
			case 4:
				System.out.println("Enter Family name to find it");
				String names = in.nextLine();
				Family x = manager.seachByName(names);
				if (x == null) {
					System.out.println("Family not found");
				} else {
					System.out.println("Found!!");
					System.out.println(x.toString());
				}
				break;
			case 5:
				System.out.println("Enter Person ID to find it");
				String id = in.nextLine();
				Person p = manager.searchPersonByID(id);
				if (p == null) {
					System.out.println("Ohhh nooo");
				} else {
					System.out.println("Person is found ");
					System.out.println(p.toString());
				}
				break;
			case 6:
				in = new Scanner(System.in);
				System.out.println("Enter Family name to find it");
				String nameFs = in.nextLine();
				Family xFs = manager.seachByName(nameFs);
				if (xFs == null) {
					System.out.println("Family not found");
				} else {
					System.out.println("Found!!");
					System.out.println("[Orphans , Martyrs , Live People");
					System.out.println(manager.calculateFamilyStatistics(nameFs));
				}
				break;
			case 7:
				System.out.println("[Orphans , Martyrs , Live People");
				System.out.println(manager.calculateGlobalStatistics().toString());
				break;
			case 11:
				System.out.println("Byyyeyeyeyeyeye");
			}
			printMenu();
			choice = in.nextInt();
			in.nextLine();
		}}catch(Exception E) {
			System.out.println("Enter a number nit a string");
		}
	}

	public static Family add() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Family Name");
		String name = in.nextLine();
		Family newFamily = new Family(name);
		System.out.println("if you want to add a member write 1. if not write 0");
		int temp = in.nextInt();
		Martyr m = null;
		while (temp != 0) {
			try {

			System.out.println("1. Martyr \n 2. Live Person \n 3.Deep copy a martyr");
			int temp2 = in.nextInt();
			in.nextLine();
			System.out.println("Enter Id");
			String id = in.nextLine();
			System.out.println("Enter name");
			String namem = in.nextLine();
			System.out.println("Enter age");
			int age = in.nextInt();
			System.out.println("Enter gender");
			in.nextLine();
			String gender = in.nextLine();
			System.out.println("Enter address");
			String address = in.nextLine();
			System.out.println("Enter contact");
			String contact = in.nextLine();
			System.out.println("Enter his role (Dad/Mom) or else");
			String role = in.nextLine();
			switch (temp2) {
			case 3:
				if(m!=null) {
				Martyr m2 = m.copy();
				System.out.println("Martyr copied");
				System.out.println(m2);
				Scanner upda = new Scanner(System.in);
				System.out.println("Enter new Id");
				 id=in.nextLine();
				 m2.setId(id);
				 System.out.println(m);
				 System.out.println(m2);
				}else {
					System.out.println("No martyr in this family");
				}
				break;
			case 1:
				System.out.println("Enter dateofDeath");
				String dateofDeath = in.nextLine();
				System.out.println("Enter causeofDeath");
				String causeofDeath = in.nextLine();
				System.out.println("Enter place");
				String place = in.nextLine();
				m = new Martyr(id, namem, age, gender, address, contact, dateofDeath, causeofDeath, place);
				newFamily.addMembers(m, role);
				break;
			case 2:
				LivePerson pl = new LivePerson(id, namem, age, gender, address, contact);
				newFamily.addMembers(pl, role);
				break;
			default:
				System.out.println("choose a number between 1-3 please");
				break;
			}
			System.out.println("if you want to add a member write 1. if not write 0");
			temp = in.nextInt();
			}catch(Exception e) {
				System.out.println("Enter a number not a string");
			}
		}
		
		return newFamily;
	}

	public static void printMenu() {
		System.out.println("Choose from the following :");
		System.out.println("1. Add A Family.");// Add member/remove
		System.out.println("2. Update A Family.");
		System.out.println("3. Delete A Family.");
		System.out.println("4. Search A Family By Name.");
		System.out.println("5. Search A Person By ID Number.");
		System.out.println("6. Calculate Family Stats.");
		System.out.println("7. Calculate Global Stats.");
		System.out.println("8. ReadFile.");
		System.out.println("9. Write File.");
		System.out.println("10. Deep copy Martyr object.");
		System.out.println("11. Exit.");
	}
}
