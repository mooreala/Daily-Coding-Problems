import java.util.LinkedList;
import java.util.Scanner;

public class RotateList {
    public static void main(String[] args) throws Exception {
        printProblem();

        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        getList(scanner, list);
        int k = -1;
        System.out.println("Enter index to rotate around:");
        k = scanner.nextInt();
        System.out.println("");

        LinkedList<Integer> rotList = RotateLinkedList(list, k);
        if (rotList != null) {
            System.out.println("Original list:");
            printList(list);
            System.out.println("Rotated list (" + k + "):");
            printList(rotList);
        }
    }

    private static void printProblem() {
        System.out.println("Given a linked list and a positive integer k, rotate the list to the right by k places.");
        System.out.println("For example, given the linked list 7 -> 7 -> 3 -> 5 and k = 2, it should become 3 -> 5 -> 7 -> 7.\n");
    }

    private static LinkedList<Integer> RotateLinkedList(LinkedList<Integer> list, int k) {
        if (k <= 0 || k > list.size() - 1) {
            return null;
        }

        LinkedList<Integer> newList = new LinkedList<>();
        for (int i = k; i < list.size(); i++) {
            newList.add(list.get(i));
        }

        for (int j = 0; j < k; j++) {
            newList.add(list.get(j));
        }

        return newList;
    }

    private static void getList(Scanner scanner, LinkedList<Integer> list) {
        int size = -1;
        System.out.println("How many elements in list?: ");
        size = scanner.nextInt();

        if (size > 1) {
            for (int i = 0; i < size; i++) {
                System.out.println("Enter element " + i + ":");
                list.add(scanner.nextInt());
            }
        } else {
            System.out.println("Invalid size. Exiting...");
            System.exit(-1);
        }      
    }

    private static void printList(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i));
            System.out.print(" -> ");
        }
        System.out.print(list.get(list.size() - 1));
        System.out.print("\n");
    }
}
