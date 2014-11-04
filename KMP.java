public class KMP {
	public static void main(String[] args) {
		String input = "DCABCABCABEDC";
		String pattern = "ABCABE";
		System.out.println(findMatch(input, pattern));
	}

	public static int findMatch(String input, String pattern) {
		if(input == null || pattern == null) {
			return -1;
		}
		char[] inputChs = input.toCharArray();
		char[] patternChs = pattern.toCharArray();
		int[] next = initNext(patternChs);
		int i = 0;
		int j = 0;
		while(i < inputChs.length && j < patternChs.length) {
			if(j == -1 || inputChs[i] == patternChs[j]) {
				i ++;
				j ++;
			} else {
				j = next[j];
			}
		}
		if(j == patternChs.length) {
			return i - j;
		} else {
			return -1;
		}
	}

	public static int[] initNext(char[] patternChs) {
		int[] next = new int[patternChs.length];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < patternChs.length-1) {
			if(k == -1 || patternChs[k] == patternChs[j]) {
				next[++j] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}
}