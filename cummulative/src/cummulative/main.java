package cummulative;

import java.util.ArrayList;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		ArrayList<staffMember> staff = new ArrayList<>();

		staff.add(new SalariedEmployee("Adam", "khabisa", new Date(), "0593639342", "adam@gmail.com", "AK@gmail.com",
				"it", new Department("it", 5, "birzeit"), 420));
		staff.add(new SalariedEmployee("Ahmad", "yaseen", new Date(), "0593639342", "adam@gmail.com", "AK@gmail.com",
				"it", new Department("it", 5, "birzeit"), 320));
		staff.add(new ContractEmployee("jadallah", "baragitha", new Date(), "0599552221", "jad@gmail.com",
				"JB@gmail.com", "5", new Department("it", 5, "birzeit"), 5, (byte) 6));
		staff.add(new ContractEmployee("hasoon", "yousef", new Date(), "0599552221", "hasoon@gmail.com", "HY@gmail.com",
				"5", new Department("it", 5, "birzeit"), 5, (byte) 6));
		staff.add(new CommessionEmployee("ali", "awwad", new Date(), "0599552221", "ali@gmail.com",
				"AA@gmail.com", "5", new Department("it", 5, "birzeit"),5));
		staff.add(new CommessionEmployee("mousa", "maher", new Date(), "0599552221", "mousa@gmail.com",
				"MM@gmail.com", "5", new Department("it", 5, "birzeit"),5));

		staff.add(new HourlyEmployee("yazan", "yaseen", new Date(), "0599552221", "yazan@gmail.com",
				"YY@gmail.com", "5", new Department("it", 5, "birzeit"),(short) 5,5));
		staff.add(new HourlyEmployee("mohanad", "idrees", new Date(), "0599552221", "mohanad@gmail.com",
				"MI@gmail.com", "5", new Department("it", 5, "birzeit"),(short) 5,5));

		staff.add(new WeeklyEmployee("nizar", "flayan", new Date(), "0599552221", "nizar@gmail.com",
				"NF@gmail.com", "5", new Department("it", 5, "birzeit"),(byte)5,5));
		staff.add(new WeeklyEmployee("mohammad", "awwad", new Date(), "0599552221", "mohammad@gmail.com",
				"MA@gmail.com", "5", new Department("it", 5, "birzeit"),(byte)5,5));

		staff.add(
				new volunteer("khaled", "khaled", new Date(), "0592627282", "adam@gmail.com", "AK@gmail.com", "bzu"));
		staff.add(
				new volunteer("ayham", "khaled", new Date(), "0592627282", "adam@gmail.com", "AK@gmail.com", "bzu"));

		printList(staff);
		System.out.println("\ntotal payment is :" + totalPayments(staff));
		System.out.println("\naverage payments is:" + averagePayments(staff));
		System.out.println("\nEmployees with above average payment :");
		ArrayList<staffMember> aboveAverage = getAboveAveragePayments(staff);
		printList(aboveAverage);

	}

	public static void printList(ArrayList<staffMember> staff) {
		for (staffMember member : staff) {
			System.out.println(member);
		}
	}

	public static double totalPayments(ArrayList<staffMember> staff) {
		double total = 0;
		for (staffMember member : staff) {
			total += member.pay();
		}

		return total;
	}

	public static double averagePayments(ArrayList<staffMember> staff) {
		double totalpayments = totalPayments(staff);
		return totalpayments / staff.size();
	}

	public static ArrayList<staffMember> getAboveAveragePayments(ArrayList<staffMember> staff) {
		ArrayList<staffMember> aboveAverage = new ArrayList<>();
		double average = averagePayments(staff);
		for (staffMember member : staff) {
			if (member.pay()>average)
			aboveAverage.add(member);
		}
		return aboveAverage;
	}

}
