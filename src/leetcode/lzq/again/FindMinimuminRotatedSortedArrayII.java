/**
 * 
 */
package leetcode.lzq.again;

/**
 * @author Administrator
 * 
 */
public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] num) {
		if (num.length <= 0) {
			throw new RuntimeException("num length <= 0");
		}
		int length = num.length;
		for (int i = 1; i < length; i++) {
			if (num[i] < num[i - 1]) {
				return num[i];
			}
		}
		return num[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimuminRotatedSortedArrayII f = new FindMinimuminRotatedSortedArrayII();
		System.out.println(f.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(f.findMin(new int[] { 0, 1, 2, 3, 4, 5, 6 }));
		System.out.println(f.findMin(new int[] { 1, 2, 3, 4, 5, 6, 0 }));
	}

}
