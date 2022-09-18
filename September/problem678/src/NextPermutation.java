import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) throws Exception {
        NextPermutation np = new NextPermutation();
        np.printProblem();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value: ");
        int value = Integer.parseInt(scanner.nextLine());
        int[] solution = np.nextPermutation(value);

        System.out.println("Next permutation of " + value + "is: ");
        np.printIntArray(solution);

        scanner.close();
    }

    public void printProblem() {
        System.out.println("Given an integer, find the next permutation of it in absolute order. For example, given 48975, the next permutation would be 49578.");
    }

    public int[] nextPermutation(int value) {
        // turn integer into an array of integers
        int[] arr = intToDigits(value);
        if (arr.length < 2) {
            return arr;
        } else {
            int decIdx = -1;

            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] < arr[i+1]) {
                    decIdx = i;
                    break;
                }
            }

            if (decIdx != -1) {
                int nextLargest = -1;

                for (int j = decIdx + 1; j < arr.length; j++) {
                    if (arr[j] <= arr[decIdx]) {
                        nextLargest = j - 1;
                        break;
                    }
                }

                if (nextLargest == -1) {
                    nextLargest = arr[arr.length - 1];
                }

                swap(arr, decIdx, nextLargest);
                Arrays.sort(arr, decIdx + 1, arr.length);
                return arr;
            } else {
                return arr;
            }
        }
        // find all permutations

        // get the next in absolute order
    }

    public int[] intToDigits(int value) {
        String str = Integer.toString(value);
        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i ++) {
            digits[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        return digits;
    }

    public void swap (int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
