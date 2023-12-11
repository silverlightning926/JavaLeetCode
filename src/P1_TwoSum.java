/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
 */

public class P1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int [2];

        for (int i = 0; i < nums.length; i++)
        {
            int currentNum = nums[i];
            int diff = target - currentNum;

            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] == diff)
                {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P1_TwoSum solution = new P1_TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        assert (result[0] == 0);

        nums = new int[]{3, 2, 4};
        target = 6;
        result = solution.twoSum(nums, target);
        assert (result[0] == 1);

        nums = new int[]{3, 3};
        target = 6;
        result = solution.twoSum(nums, target);
        assert (result[0] == 0);

        System.out.println("All test passed");
    }
}
