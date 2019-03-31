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


    /**
     * Calls recursiveFixedSumPairs to print out all sum pairs within a that are equal to k
     * @param a: int array (must have >1 element, sorted in ascending order)
     * @param k: int used to compare against sum pair values within 'a'
     */
    public static void findFixedSumPairs(int[] a, int k){
        if (a.length > 1){
            recursiveFixedSumPairs(a, k, 0, 1);     // starts by comparing values at index 0 and 1
        }else{
            System.out.println("int array 'a' must contain at least 2 values. Invalid array.");
        }
    }


    /**
     * Recursively iterates through int array 'a', prints all sum pairs within 'a' equal to k
     * @param a: int array (must have >1 element, sorted in ascending order)
     * @param k: int used to compare against sum pairs within 'a'
     * @param i: int index used to represent 1st int in sum pair
     * @param j: int index used to represent 2nd int in sum pair
     */
    private static void recursiveFixedSumPairs(int[] a, int k, int i, int j){
        int sum;
        sum = a[i] + a[j];
        if (sum == k) {     // prints index and values of pair, increments i if possible
            System.out.println("a[" + i + "] = " + a[i] + ", a[" + j + "] = " + a[j]);
            if (i < a.length - 2){
                recursiveFixedSumPairs(a, k, i+1, i+2);
            }
        }else if(sum < k){
            if (j < a.length - 1){      // if there are still j values to iterate over, increment j
                recursiveFixedSumPairs(a, k, i, j+1);
            }else if (i < a.length -2){     // exhausted all combos of i+j at current i index, increment i
                recursiveFixedSumPairs(a, k, i+1, i+2);
            }
        }else if (i < a.length - 2){    // assumes sum > k, increment i
                recursiveFixedSumPairs(a, k, i+1, i+2);
        }       // base case: sum > k && i > a.length - 2
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
        k = 43;     // .zip file initially set this to 60, which had no equivalent sum pairs
        System.out.print("k = " + k + "\na = [");
        for (int i=0; i<a.length-1; i++){
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length-1] + "]\n");
        findFixedSumPairs(a, k);
        System.out.println();
    }
}
