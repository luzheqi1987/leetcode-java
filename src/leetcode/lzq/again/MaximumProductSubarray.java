/**
 * 
 */
package leetcode.lzq.again;

/**
 * @author Administrator
 * 
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		int start = 0;
		int end = 0;
		int max = A[0];

		while (start < A.length) {
			while (start < A.length && A[start] == 0) {
				start++;
				if (max < 0) {
					max = 0;
				}
			}
			if (start >= A.length) {
				return max;
			}
			end = start + 1;

			while (end < A.length && A[end] != 0) {
				end++;
			}
			int numM = 0;
			int[] forward = new int[end - start + 1];
			forward[0] = 1;
			for (int i = start; i < end; i++) {
				if (A[i] < 0) {
					numM++;
				}
				forward[i - start + 1] = A[i] * forward[i - start];
			}
			if (numM % 2 == 0 && forward[end - start] >= max) {
				max = forward[end - start];
			} else {
				int[] backward = new int[end - start + 1];
				backward[0] = 1;
				for (int i = start; i < end; i++) {
					if (A[i] < 0) {
						numM++;
					}
					backward[i - start + 1] = A[end - (i - start) - 1]
							* backward[i - start];
				}
				for (int i = start + 1; i < end - 1; i++) {
					if (A[i] < 0) {
						max = Math.max(Math.max(max, (forward[i - start])),
								backward[end - start - (i - start) - 1]);
					}
				}
				if (end - start > 1) {
					max = Math.max(Math.max(max, (forward[end - start - 1])),
							backward[end - start - 1]);
				}
			}
			start = end;

		}
		return max;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductSubarray m = new MaximumProductSubarray();
		System.out.println(m.maxProduct(new int[] { -2, 0, -1 }));
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4, 4 }));
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4, 4, -1 }));
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4, 4, -1, 100,
				100 }));
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4, 4, -1, 100,
				100, -1 }));
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4, 4, -1, 2, 5,
				-100, 100, 100, -1 }));

		System.out.println(m.maxProduct(new int[] { 0, 2 }));
		System.out.println(m.maxProduct(new int[] { 2, -5, -2, -4, 3 }));

		System.out.println(m.maxProduct(new int[] { 1, 0, -1, 2, 3, -5, -2 }));
	}

}
