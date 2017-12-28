/*
	the length of ranks and map is fixed to 13, so it is O(1) space
	O(n) time. n is the length of StringA or StringB.
 */

import java.util.*;

class CardsWar {
	private static char[] ranks = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', 
								   '6', '5', '4', '3', '2'};
	public static int solution (String A, String B) {
		// add card ranks to a map<card, rank>
		// small number means highier rank
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < ranks.length; i++) {
			map.put(ranks[i], i);
		}


		// compare strings char by char
		int result = 0; // count win turns of A
		for (int i = 0; i < A.length(); i++) {
			char x = A.charAt(i);
			char y = B.charAt(i);
			if (map.get(x) < map.get(y)) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution("A586QK", "JJ653K"));
		System.out.println(solution("23A84Q", "K2Q25J"));
	}
}