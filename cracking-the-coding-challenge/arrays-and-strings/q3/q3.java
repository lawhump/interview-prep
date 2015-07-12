import java.io.*;

class q3 {

	// O(n) running-time
	// Pass through all of the data once.

	public static boolean arePermutations(String s1, String s2) {
		// They aren't the same length — excluding whitespace
		// i.e. spaces and trailing space.
		s1 = s1.replace(" ", "");
		s2 = s2.replace(" ", "");

		if(s1.length() != s2.length()) {
			return false;
		}

		s1.toLowerCase();
		s2.toLowerCase();

		int[] freq1 = new int[26];
		int[] freq2 = new int[26];

		for(int i=0; i< s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			freq1[c1 % 26]++;
			freq2[c2 % 26]++;
		}

		for (int i=0; i<freq1.length; i++) {
			if(freq1[i] != freq2[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		boolean result1 = arePermutations("lawrence", "ecnerwal");
		boolean result2 = arePermutations("lawrence", "i am cool");
		boolean result3 = arePermutations("lawrence", "humphrey");
		boolean result4 = arePermutations("lawrence", "wal nerce");

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}

}