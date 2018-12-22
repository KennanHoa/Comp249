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

public class WordCount {
	int freq = 1;
	String word;

	public WordCount() {
		word = null;
	}

	public WordCount(String w) {
		word = w;
	}

	public void incFreq() {
		this.freq++;
	}

	public int getFreq() {
		return freq;
	}

	public String getWord() {
		return word;
	}

	public String toString() {
		return freq + "\t\t" + word;
	}

	/**
	 * Method that compares two objects 
	 * @return true if they are equal, false otherwiese
	 */
	public boolean equals(Object M) {
		if (M == null || this.getClass() != M.getClass())
			return false;
		WordCount c = (WordCount) M;
		return this.word == c.word;
	}
}
