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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {

	/**
	 * Method that sorts the words of the ArrayList in descending order
	 * @param list given array 
	 */
	public Sorting(ArrayList<WordCount> list) {

		Collections.sort(list, new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {
				return wc1.getWord().compareTo(wc2.getWord());
			}
		});

	}

	/**
	 * Method that sorts the frequency of the ArrayList in descending order
	 * @param list
	 */
	public static void SortingFreq(ArrayList<WordCount> list) {

		Collections.sort(list, new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {
				Long freq1 = new Long(wc1.getFreq());
				Long freq2 = new Long(wc2.getFreq());

				return freq2.compareTo(freq1);
			}
		});

	}
}
