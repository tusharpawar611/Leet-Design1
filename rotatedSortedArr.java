class Solution {
    public int search(int[] nums, int target) {
        
        int mid;
        int l = 0, r=nums.length-1;

        while(l<=r){
            mid = (l+r)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]>=nums[l]){
                if(nums[mid]>=target && target>=nums[l]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }

            }
            else{
                if(nums[mid]<=target && target <= nums[r]){
                    l =mid+1;
                }
                else{
                    r=mid-1;
                }
            }

        }

        return -1;
    }
}
