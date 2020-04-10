public class FindMax {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
    	int max_n=m[0];
    	int i=1;
    	while (i<=m.length-1){
    		if (m[i]>max_n)
    		max_n=m[i];
    		i=i+1;
    	}
    	return max_n;
    }
    public static void main (String[] args) {
    	int[] numbers = new int[]{9,2,15,2,22,10,6};
    	System.out.println(max(numbers));
    }
}