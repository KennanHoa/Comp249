
/*Names and IDs:    Kennan Hoa (27199112), Tiffany Zeng (40063115)
 * COMP249
 * Assignment #4
 * Due Date: 01-12-2018
 * -----------------------------------------------------------------------
 * Assignment #4
 * PART 1
 * Written by: Kennan Hoa (27199112), Tiffany Zeng (40063115)
 *  -----------------------------------------------------------------------
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Driver {
	/**
	 * Main method that will execute the reading of the text file entered by the user
	 * and sort the text 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		Scanner key = new Scanner(System.in);
		String word;
		int token = 0;
		int rank = 1;
		int happax = 0;
		int StopWord = 0;

		System.out.println("Please enter the name of the file: ");

		String str = key.next();

		try {
			sc = new Scanner(new FileInputStream(str));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open/cjokes.txtreate the" + str + ".\n"
					+ "Program will termindate after closing any opened files.");
		}

		ArrayList<WordCount> list = new ArrayList<WordCount>();

		// sc.nextLine(); // skip first line

		// loop to add word in the Arraylist
		while (sc.hasNext()) {
			word = sc.next();
			if (!word.matches(".*[^A-Za-z].*")) { // check if there's non-alphabet in the word
				list.add(new WordCount(word)); // add to array if good
				token++;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).word.equals(list.get(j).word)) {
					list.get(i).incFreq();
					list.remove(j);
				}
			}
		}

		// sorting the list (Name + Frequency)
		Sorting sort = new Sorting(list);
		sort.SortingFreq(list);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).freq == 1)
				happax++;
			if (list.get(i).word.length() <= 4 && list.get(i).freq >= 10)
				StopWord++;
		}

		DecimalFormat df = new DecimalFormat("0.00");

		// printing the ouput
		System.out.println("\nNb of Tokens: " + token + "\nNb of word types: " + list.size() + "\n\nNb of Happax: "
				+ happax + "\n% of Happax: " + df.format((double) happax * 100 / list.size()) + "\nHappax account for: "
				+ df.format((double) happax * 100 / token) + "% of the text." + "\n\nNb of Stop Word: " + StopWord
				+ "\n% of Stop Word: " + df.format((double) StopWord * 100 / list.size()) + "%"
				+ "\nStop Words account for: " + df.format((double) StopWord * 100 / token) + "% of the text.\n");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("RANK\t\tFREQ\t\tWORD");
		System.out.println("-----------------------------------------------------------------");

		for (WordCount c : list) {
			System.out.print(rank + "\t\t");
			System.out.println(c);
			rank++;
		}
	}
}
