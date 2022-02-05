package February;

public class P476 {
    public void printDesc() {
        System.out.println("You are given an array of length n + 1 whose elements belong to the set {1, 2, ..., n}. By the pigeonhole principle, there must be a duplicate. Find it in linear time and space.");
    }

    public static void main (String[] args) {
        new P476().printDesc();

        int[] exampleArr = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 2, 10, 11};
        int n = 11;
    }

    public int findRepeated() {
        return 0;
    }
}
