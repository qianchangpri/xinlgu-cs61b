public class Triangle{
	public static void main (String[] args) {
		int col=1;
		while (col<=5) {
			int i=1;
			while(i<=col){
				System.out.print("*");
				i=i+1;
			}
			System.out.println();
			col=col+1;
		}
	}
}