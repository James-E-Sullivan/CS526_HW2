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

    public static void main(String[] args) {
        int testProduct = recursiveProduct(-3, 2);
        System.out.println(testProduct);
    }
}
