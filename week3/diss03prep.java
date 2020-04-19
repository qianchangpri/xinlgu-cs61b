public class diss03prep {
  public static int[] flatten(int[][] x) {
    int totalLength = 0;
    for(int i = 0; i < x.length; i++) {
      totalLength += x[i].length;
    }
    int[] a = new int[totalLength];
    int aIndex = 0;
    for(int i = 0; i < x.length; i++) {
      System.arraycopy(x[i], 0, a, aIndex, x[i].length);
      aIndex += x[i].length;
    }
    return a;
  }
  public static void main(String[] args) {
    int[][] x = {{1,2,3},{},{7,8}};
    int[] a = flatten(x);
    System.out.println(a[0]+" "+a[1]+" "+a[2]+" "+a[3]+" "+a[4]);
  }
}
