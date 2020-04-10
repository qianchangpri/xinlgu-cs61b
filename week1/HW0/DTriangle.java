public class DTriangle {
	public static void DrawTriangle(int N){
		int col=1;
		while (col<=N) {
			int i=1;
			while(i<=col){
				System.out.print("*");
				i=i+1;
			}
			System.out.println();
			col=col+1;
		}
	}
   public static void main(String[] args) {
      DrawTriangle(10);
   }
}