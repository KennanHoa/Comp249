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
import java.util.NoSuchElementException;

public class CellList {

	private class CellNode {
		private CellPhone phone;
		private CellNode next;

		/**
		 * Default Constructor
		 */
		public CellNode() {
			phone = null;
			next = null;
			size++;
		}

		/**
		 * Parameterized constructor
		 * @param phone an object of CellPhone class
		 * @param node an object of CellNode class
		 */
		public CellNode(CellPhone phone, CellNode node) {
			this.phone = phone;
			next = node;
			size++;
		}

		/**
		 * Copy constructor
		 * @param node object of CellNode
		 */
		public CellNode(CellNode node) {
			phone = node.phone.clone();
		}

		/**
		 * Method that clones a deep copy of the passed CellNode object
		 */
		public CellNode clone() {
			return new CellNode(this);
		}

		public void setNode(CellNode n) {
			next = n;
		}

		public CellNode getNode() {
			return next;
		}

		public void setPhone(CellPhone p) {
			phone = p;
		}

		public CellPhone getPhone() {
			return phone;
		}

	}

	private CellNode head;
	private int size;

	/**
	 * Default constructor which creates an empty list
	 */
	public CellList() {
		head = null;
	}

	public int getSize() {
		return size;
	}

	/**
	 * Copy constructor which makes a deep copy of the passed CellList object
	 * @param cl passed CellList object
	 */
	public CellList(CellList cl) {
		if (cl.head == null)
			head = null;
		else {
			CellNode t = cl.head;
			CellNode t2 = null, t3 = head = null;
			while (t != null) {
				//t3 = new CellNode(t.phone.clone(), null);
				t3 = t.clone();
				if (head == null)
					head = t2 = t3;
				else {
					t2.next = t3;
					t2 = t3;
				}
				t = t.next;
			}
			t2 = t3 = null;
		}
	}

	/**
	 * Method that adds a node at the start of the list
	 * @param c passed CellPhone object
	 */
	public void addToStart(CellPhone c) {
		head = new CellNode(c, head);
	}

//may result privacy leak
	
	/**
	 * Method that loops through the list to find the given serial number
	 * @param x  a given serial number 
	 * @returns a pointer to the node of which the serial number belongs to 
	 */
	public CellNode find(long x) {
		int count = 0;
		CellNode t = head;
		while (t != null && t.phone.getSerialNum() != x) {
			if (t.phone.getSerialNum() != x)
				t = t.next;
			count++;
		}
		if (t == null) {
			System.out.println("No such Serial Number");
			return null;
		}
		System.out.println("The number of iteraation is: " + count);
		System.out.println(t.phone.toString());
		return t;
	}

	/**
	 * Method that tells us if the list contains the given serial number
	 * @param x  given serial number
	 * @return true if the passed serial number is found
	 */
	public Boolean Contains(long x) {
		CellNode t = head;
		while (t != null && t.phone.getSerialNum() != x) {
			if (t.phone.getSerialNum() != x)
				t = t.next;
		}
		if (t == null) {
			return false;
		}
		return true;
	}

	/**
	 * Method that prints the contents of the list 
	 */
	public void showContents() {
		CellNode t = head;
		while (t.next != null) {
			System.out.println(t.phone + " ");
			//
		}
	}

	/**
	 * Method which deletes a node at the given index
	 * @param index index of the list
	 * @throws NoSuchElementException
	 */
	
	public void deleteFromIndex(int index) throws NoSuchElementException {
		if (index > size - 1 || size == 0 || index < 0) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}
		int i = 0;
		CellNode temp = head;

		// Handle the special case when list has only one node
		if (size == 1) {
			System.out.println("\nDeleting the only node of the list at index # " + 0 + ".");

			head = null;
			size--;
			return;
		}

		// Handle the special cases when deletion on head or tail
		if (index == 0) {
			deleteFromStart();
		} else {
			while (i != index - 1) // Stop at the node that precedes index
			{
				temp = temp.next;
				i++;
			}
			// Now we are pointing at the node preceding index where deletion should take
			// place
			System.out.println("Deleting node with phone" + temp.next.phone + " from index # " + index + ".");
			temp.next = temp.next.next;
		}
		size--;
	}

	/**
	 * Method which deletes the a node at the start of the list
	 * @return true if deleted, false otherwise
	 */
	public boolean deleteFromStart() {
		if (head == null)
			return false;
		head = head.next;
		System.out.println("The first node has been deleted from the list");
		size--;
		return true;
	}

	/**
	 * Method which replaces a CellNode object at a given index
	 * @param cell  object of CellNode
	 * @param index  index of the list
	 */
	public void replaceAtIndex(CellPhone cell, int index) {
		if (index > size - 1 || head == null || index < 0) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			return;
		}

		int i = 0;
		CellNode temp = head;
		while (i != index) {
			temp = temp.next;
			i++;
		}
		System.out.println("Replacing phone at index # " + index + " from " + temp.phone + " to " + cell + ". \n");
		temp.phone = cell;
	}

	/**
	 * Method which inserts an object of CellPhone class into the list at a given index
	 * @param c  object of CellPhone class that will be inserted
	 * @param index  index of the list
	 * @return true if correctlt inserted, otherwise false
	 */
	public boolean insertAtIndex(CellPhone c, int index) {
		if (head == null || index >= (size) || index < 0) {
			throw new NoSuchElementException();
		}

		CellNode node;
		CellNode t = head;
		int count = 0;

		// insert into the start
		if (index == 0) {
			addToStart(c);
			return true;
		}
		// If the index is within the linkedlist
		else if (index > 0 && index < size) {
			count = 0;
			t = head;

			while (t.next != null && count < size) {

				if (count == index - 1) {
					break;
				}
				t = t.next;
				count++;
			}
			// Create new node and point next to n-1's next
			node = new CellNode(c, t.next);

			// Set n-1th node's next to this node (effectively putting it in position n)
			t.next = node;
			System.out.println("A phone has been inserted at index # " + index);
			return true;
		}
		return false;
		
	}

	/**
	 * Method which compares two CellList objects 
	 * @param M passed CellList object
	 * @return true if two lists are equal, otherwise returns false 
	 */
	public boolean equals(CellList M) {
		if (M == null || head == null || this.size != M.size)
			return false;

		CellNode t1 = this.head;
		CellNode t2 = M.head;

		while (t1 != null && t2 != null) {
			if (!t1.phone.equals(t2.phone)) {
				return false;
			}
			t1 = t1.next;
			t2 = t2.next;
		}
		return true;
	}

	/**
	 * Method that shows the contents of a list
	 */
	public void showListContents() {
		int count = 0;
		CellNode temp = head;
		if (temp == null)
			System.out.println("There is nothing to display; list is empty.");
		else
			System.out.println("Here are the contents of the list: ");
		while (temp != null) {
			count++;
			System.out.print("" + temp.phone.toString() + " ---> ");
			temp = temp.next;
			if (count % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println("X\n"); // Just show "X" indicating the end of the list (null)
	}
}
