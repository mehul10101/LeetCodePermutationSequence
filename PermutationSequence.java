import java.util.*;

//https://leetcode.com/problems/permutation-sequence/submissions/
class PermutationSequence {
    public static void main(String[] args) {
        int n = 3, k = 3, i;
        k--;
        List<Integer> list = new ArrayList<>();
        // adding the number of characters(integers) in the list, so we can get and remove the from list.
        for(i = 1; i<=n; i++){
            list.add(i);
        }
        
        // this array will define the number of possible permutations till n different numbers. Ex. for a number x, 
        // the factorial will be on x-1 index and the value will be x!.
        int[] factNum = factorial(n);
//        System.out.println(fact);

        //defining a empty string 
        StringBuilder ans = new StringBuilder();
        int a, numberOfElementsForEachPermutations;

        /**
         * till list is empty we will do certain operations
         *  1. for x numbers there are x! ways, so a number at index 0 can have x!/x ways(for 1234, there will be 4!/4 ways in which you can place 1 or 2 or 3 or 4 any of the number at index 1)
         *  2. So above we did k--, which tells there are total permutations 0 to n!
         *  3. Now, taking the first condition we can get which number will be taken at index 0. 0 -> 1, 1 -> 2 and so on.
         *  4. Finally we add that to string and remove that element from the list.
         *  5. now the new k will be the remaining of permutations which we already handled.
         *  
          */
        while(!list.isEmpty()){
            numberOfElementsForEachPermutations = factNum[n-1] / n;
            a = k / numberOfElementsForEachPermutations;
            ans.append(list.get(a).toString());
            list.remove(a);
            k = k % numberOfElementsForEachPermutations;
            n--;

        }
        System.out.println(ans.toString());

    }

    /**
     * This function calculates the factorials will n and store it in array
     * @param n
     * @return
     */
    private static int[] factorial(int n) {
        int x = 1, fact = 1, i = 0;
        int[] factNum = new int[n];
        while (x != n+1){
            fact = x*fact;
            factNum[i] = fact;
            i++;
            x++;
        }
        return factNum;
    }


}

