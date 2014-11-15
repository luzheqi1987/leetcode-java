/**
 * 
 */
package leetcode.lzq.again;

/**
 * @author Administrator
 * 
 */
public class ReverseWordsinaString {

	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder(s.trim());
		StringBuilder news = new StringBuilder("");
		StringBuilder tmps = new StringBuilder("");
		sb.reverse();
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == ' ') {
				if (tmps.length() > 0) {
					news.append(tmps.reverse());
					news.append(' ');
					tmps.delete(0, tmps.length());
				}
			} else {
				tmps.append(sb.charAt(i));
			}

		}
		return news.append(tmps.reverse()).toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordsinaString r = new ReverseWordsinaString();
		System.out.println(r.reverseWords("hi!"));
		System.out.println(r.reverseWords(" 1"));
	}

}
