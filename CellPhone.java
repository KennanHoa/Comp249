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

public class CellPhone {

	private long serialNum;
	private String brand;
	private int year;
	private double price;

    /**
     * Parameterized constructor
     * @param sn = serial number
     * @param b = brand name
     * @param p = price
     * @param y = year of creation
     */
	public CellPhone(long sn, String b, double p,  int y) {
		serialNum = sn;
		brand = b;
		year = y;
		price = p;
	}

	/** Copy constructor
	 * 
	 * @param c an object of CellPhone class
	 * @param sn a serial number prompted by the user
	 */
	public CellPhone(CellPhone c, long sn) {
		serialNum = sn;
		year = c.year;
		price = c.price;
		brand = c.brand;
	}
	
	/** Copy constructor
	 * 
	 * @param c an object of CellPhone class
	 * @param sn a serial number prompted by the user
	 */
	public CellPhone(CellPhone c) {
		serialNum = c.serialNum;
		year = c.year;
		price = c.price;
		brand = c.brand;
	}
	
	/**
	 * Method that clones a CellPhone object which prompts the user to write a serial number
	 */
	public CellPhone clone() {
		//Scanner kb = new Scanner(System.in);
		//long sn = kb.nextLong();
		return new CellPhone(this);
	}

	//Get/Set Methods
	public void setSerialNum(long sn) {
		serialNum = sn;
	}

	public long getSerialNum() {
		return serialNum;
	}

	public void setbrand(String b) {
		brand = b;
	}

	public String getbrand() {
		return brand;
	}

	public void setyear(int y) {
		year = y;
	}

	public int getyear() {
		return year;
	}

	public void setprice(double p) {
		price = p;
	}

	public double getprice() {
		return price;
	}

	public String toString() {
		return ("[" + serialNum + ": " + brand + " " + price + "$ " + year + "]");
	}

	/**
	 * Method that compares two objects to see if they are equal or not 
	 * @return true if the two are equal
	 * @return false if the two are not equal
	 */
	public boolean equals(Object M) {
		if (M == null || this.getClass() != M.getClass())
			return false;
		CellPhone c = (CellPhone) M;
		return (super.equals(c) && this.year == c.year && this.price == c.price && this.brand == c.brand);
	}
}