public class RecursionPractice {

    private static int recursiveProduct(int m, int n){
        int product;
        if (m > 0){                                         // if m positive
            product = recursiveProduct(m-1, n) + n;     // add previous product to n
            return product;
        }else if (m < 0){                                  // if m is negative
            product = recursiveProduct(m+1, n) - n;    // subtract n from previous product
            return product;
        }
        return 0;       // base case
    }

    // This method is not recursive
    private static void findFixedSumPairs(int[] a, int k){
        int index = 0;
        if (index < a.length-2){
            recursiveFixedSumPairs(a, k, index, index+1);
        }
    }

    // This method is recursive
    private static void recursiveFixedSumPairs(int[] a, int k, int i, int j){
        int sum;
        sum = a[i] + a[j];      // need to rearrange to avoid index out of bounds at start
        if (sum == k) {         // add more under this if statement. Currently it ends after one print.
            System.out.println("a[" + i + "] = " + a[i] + ", a[" + j + "] = " + a[j]);
        }else if(sum < k){
            if (j < a.length - 1){
                recursiveFixedSumPairs(a, k, i, j+1);
            }else if (i < a.length -2){
                recursiveFixedSumPairs(a, k, i+1, i+2);
            }
        }
    }


    public static void main(String[] args) {
        System.out.print("\nRecursive product: ");
        int m, n, p;
        m = 10; n = -20;
        p = recursiveProduct(m, n);
        System.out.println(m + " times " + n + " is " + p);

        System.out.println("\nFixed sum pairs: ");
        int[] a = {1, 5, 8, 11, 12, 14, 15, 20, 21, 22, 23, 25, 28, 30, 34, 36};
        int k;
        k = 13;
        System.out.print("k = " + k + "\na = [");
        for (int i=0; i<a.length-1; i++){
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length-1] + "]\n");
        findFixedSumPairs(a, k);
        System.out.println();
    }
}
