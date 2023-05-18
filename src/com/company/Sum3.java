package com.company;

import java.util.*;

public class Sum3 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();

            for(int i = 0; i < nums.length; i++) {
                int target = 0 - nums[i];
                binarySearch(nums, target, i, set);
            }
            return new ArrayList<>(set);
        }
        private void binarySearch(int[] nums, int target, int i, Set<List<Integer>> set) {
            int left = 0, right = nums.length - 1;

            while(left < right) {
                int sum = nums[left] + nums[right];

                if(sum < target) {
                    left++;
                } else if(sum > target) {
                    right--;
                } else {
                    if(left != i && right != i) {
                        List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                        Collections.sort(list);
                        if(!set.contains(list)) {
                            set.add(list);
                        }
                    }
                    left++; right--;
                }
            }
        }
    }
}
