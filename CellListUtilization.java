
/*Names and IDs:    Kennan Hoa (27199112), Tiffany Zeng (40063115)
 * COMP249
 * Assignment #4
 * Due Date: 01-12-2018
 * -----------------------------------------------------------------------
 * Assignment #4
 * PART 2
 * Written by: Kennan Hoa (27199112), Tiffany Zeng (40063115)
 *  -----------------------------------------------------------------------
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class CellListUtilization {
	/**
	 * Main method that will execute the reading of the Cell_info.txt and insert
	 * each phone to a list Test all methods in the CellList class with a second
	 * list Ask the user to input a serial number to search for a phone
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Creating empty list
		CellList c1 = new CellList();
		CellList c2 = new CellList();

		// Creating new phone objects
		CellPhone p1 = new CellPhone(525289, "Huawei", 670, 2018);
		CellPhone p2 = new CellPhone(7362629, "OnePlus", 621, 2015);
		CellPhone p3 = new CellPhone(5275292, "Huawei", 525, 2017);
		CellPhone p4 = new CellPhone(5282952, "Samsung", 858, 1998);
		CellPhone p5 = new CellPhone(124198, "Google", 1414, 3490);
		CellPhone p6 = new CellPhone(6369802, "Apple", 636, 1310);

		// Creating new phone object using copy constructor
		CellPhone p7 = new CellPhone(p3, 114242);

		// Testing the set method
		p7.setprice(450);
		p7.setbrand("Apple");
		p7.setyear(2018);
		p7.setSerialNum(8989824);

		// Testing addToStart()
		c2.addToStart(p1);
		c2.addToStart(p2);
		c2.addToStart(p4);
		c2.addToStart(p5);
		c2.addToStart(p6);
		c2.addToStart(p7);
		c2.addToStart(p7);

		try {
		// Testing insertAtIndex() method
		System.out.println("Testing insert at index: ");
		c2.insertAtIndex(p3, 3);

		// Testing deleteFromIndex() method
		System.out.println("\nTesting delete from index: ");
		c2.deleteFromIndex(9);

		// Testing deleteFromStart() method
		System.out.println("\nTesting delete from start: ");
		c2.deleteFromStart();

		// Testing replaceAtIndex() method
		System.out.println("\nTesting replace at index: ");
		c2.replaceAtIndex(p2, 4);
		
		// Testing equals() method
		System.out.println("Testing equal method: ");
		if (c1.equals(c2))
			System.out.println("List c1 and c2 are equal");
		else
			System.out.println("List c1 and c2 are not equal");

		long snUser;
		long sn;
		String brand;
		int year;
		double price;

		Scanner keyboard = new Scanner(System.in);
		Scanner sc = null;

		
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));

			// Creating a list from the file
			while (sc.hasNextLine()) {
				sn = sc.nextLong();
				brand = sc.next();
				price = sc.nextDouble();
				year = sc.nextInt();

				CellPhone c = new CellPhone(sn, brand, price, year);

				if (!c1.Contains(sn)) {
					c1.addToStart(c);
				}
			}

			// Showing the contents of the list
			System.out.println("Showing list from self-made list c2");
			c2.showListContents();
			
			System.out.println("Showing list from Cell_Info.txt");
			c1.showListContents();

			// User enters serial number to search
			while (true) {
				System.out.print("\nPlease enter the serial number you'd like to search in the main list (type -1 to terminate): ");
				snUser = keyboard.nextLong();
				if (snUser == -1)
					break;
				c1.find(snUser);
			}

			sc.close();
			keyboard.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: no file found!");
			System.exit(0);
		} catch (NoSuchElementException e) {
			System.out.println("Error: no such element found! The program will now exit.");
			System.exit(0);
		}

	}

}
