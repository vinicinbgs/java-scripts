import java.util.*;

public class ChallengerOne {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Give an integer number: ");

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        sc.close();

        if(k <= 0) {
            System.out.println("Give an integer number bigger then 0");
            return;
        }

        ArrayList<String> result = returnPairs(k, input);

        System.out.println("Input: " + k);
        System.out.println("Result Array: " + Arrays.toString(result.toArray()));
        System.out.println("Main Array: " + Arrays.toString(input));
    }

    public static ArrayList<String> returnPairs(int k, int[] input) {
        // capture all numbers divisible per k and put in index the result k / input[i]
        Map<Integer, Integer> divisibleNumbers = new HashMap<Integer, Integer>();

        // convert int[] to ArrayList<Integer>
        List<Integer> inputList = convertIntArrayToArrayList(input);
        
        // to check if the position already have in result
        Map<Integer, Integer> alreadyHave = new HashMap<Integer, Integer>();

        // result array with position x X y
        ArrayList<String> result = new ArrayList<String>();

        // O(n)
        for(int i = 0; i < input.length; i++) {
            if(k % input[i] == 0 && input[i] > 0) {
                divisibleNumbers.put(k / input[i], i); // O(1)
            }
        }

        // O(n)
        for(int j = 0; j < inputList.size(); j++) {
            Object idx = divisibleNumbers.get(inputList.get(j)); // O(1)
            
            if(idx != null && alreadyHave.get(idx) == null) {  // O(1)
                alreadyHave.put((Integer) idx, (Integer) idx); // O(1)
                alreadyHave.put(j, j); // O(1)
                result.add(Integer.toString(j) + " x " + idx); // O(1)
            }
        }

        return result;
    }

    public static List<Integer> convertIntArrayToArrayList(int[] input) {
        List<Integer> inputList = new ArrayList<>(input.length);

        for (int i: input) {
            inputList.add(Integer.valueOf(i));
        }

        return inputList;
    }
}