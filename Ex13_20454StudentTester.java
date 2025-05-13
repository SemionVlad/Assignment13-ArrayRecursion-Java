/**
 * 20454
 * 2025B
 * StudentTester Ex13_20454 
 */
public class Ex13_20454StudentTester
 {
     public static void main(String[] args)
     {
         System.out.println ("********** Question 1 **********\n");
         int[] a= {1,2,0,3,-1};
         int diff = 3;
         System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(a)+" and diff = " + diff);      
         int studentResult1A = Ex13_20454.countEqualDiff(a,diff);
         System.out.println("Result is: "+ studentResult1A+" must be: 2");
         System.out.println();
 
         diff = 5;
         System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(a)+" and diff = " + diff);      
         studentResult1A = Ex13_20454.countEqualDiff(a,diff);
         System.out.println("Result is: "+ studentResult1A+" must be: 2");
         System.out.println();
 
         diff = 1;
         System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(a)+" and diff = " + diff);      
         studentResult1A = Ex13_20454.countEqualDiff(a,diff);
         System.out.println("Result is: "+ studentResult1A+" must be: 8");
         System.out.println();
 
         int[] b= {1,2,0,4,-1};
         diff = 3;
         System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(b)+" and diff = " + diff);      
         int studentResult1B = Ex13_20454.countEqualDiff(b,diff);
         System.out.println("Result is: "+ studentResult1B+" must be: 0");
         System.out.println();
 
         diff = 5;
         System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(b)+" and diff = " + diff);      
         studentResult1B = Ex13_20454.countEqualDiff(b,diff);
         System.out.println("Result is: "+ studentResult1B+" must be: 0");
         System.out.println();
 
         diff = 1;
         System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(b)+" and diff = " + diff);      
         studentResult1B = Ex13_20454.countEqualDiff(b,diff);
         System.out.println("Result is: "+ studentResult1B+" must be: 0");
         System.out.println();
 
         System.out.println ("********** Question 2 **********\n");
         int[][] mat ={
                 {-2, -3, 3},
                 {-5,-10,1},
                 {10,30,-5}                
             };
         System.out.println("Checking method 'minPoints(int[][] m)' on array\n"+toString(mat));      
         int studentResult2 = Ex13_20454.minPoints(mat);
         System.out.println("Result is: "+ studentResult2+" must be: 6");
         System.out.println();
         System.out.println("Array after the operation is performed:\n" + toString(mat));
 
     }
 
     private static String toString(int[] arr)
     {
         String s = "{";
         for(int i=0; i<arr.length-1; i++)
             s+=arr[i]+", ";
         return s+arr[arr.length-1]+"}";
     }
 
     private static String toString(int[][] arr)
     {
         String s="";
         for(int i=0; i<arr.length; i++)
         {
             s+="\t";
             for(int j=0; j<arr[i].length; j++)
                 s+=arr[i][j]+"\t";
             s+="\n";
         }
         return s;
     }
}
 
