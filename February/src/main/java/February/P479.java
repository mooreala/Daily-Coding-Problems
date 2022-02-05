package February;

import java.util.ArrayList;
import java.util.List;

public class P479 {
    public void printDesc() {
        System.out.println("Given a number in the form of a list of digits, return all possible permutations.");
    }

    public static void main(String args[]) {
        int[] example = {1, 2, 3};
        List<List<Integer>> solution = new ArrayList<>();
        solution = new P479().permute(example);

        new P479().printDesc();
        System.out.println("Permutations:");

        for (int i = 0; i < solution.size(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < example.length; j++) {
                System.out.print(solution.get(i).get(j) + " ");
            }
            System.out.print("]\n");
        }
    }

    public List<List<Integer>> permute (int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> solutionList = new ArrayList<>();
        permuteRecur(nums, solutionList, new ArrayList<>(), new boolean[nums.length]);
        return solutionList;
    }

    private void permuteRecur(int[] nums, List<List<Integer>> solutionList, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            solutionList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, solutionList, tempList, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
