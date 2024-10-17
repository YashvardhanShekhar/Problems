class Solution {
    public int trap(int[] arr) {
        int size = arr.length ;
        int left[] = new int[size];
        int right[] = new int[size];

        left[0]=arr[0];
        right[size-1] = arr[size-1];

        for(int i=1, j=size-2; i<size; i++,j--){
        	left[i] = Math.max(arr[i], left[i-1]);
        	right[j] = Math.max(arr[j], right[j+1]);
        }

        int totalWater = 0;
        for(int i=0; i<size; i++){
        	int wtr = Math.min(left[i],right[i]) - arr[i];
        	totalWater = totalWater + wtr ;
        }
        return totalWater;
    }
}