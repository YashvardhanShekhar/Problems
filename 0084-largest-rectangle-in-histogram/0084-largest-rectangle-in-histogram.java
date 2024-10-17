class Solution {

	public static int[] nextSmallLeft(int arr[] ){
		Stack<Integer> s = new Stack<>();
		int left[] = new int[arr.length];

		for(int i=0; i<arr.length; i++){
			while( !s.isEmpty() && arr[s.peek()]>=arr[i] ){
				s.pop();
			}
			if( s.isEmpty() ){
				left[i] = -1; // only in this case since we don't need element value else we store -1 for index
			}else{
				left[i] = s.peek() ;
			}
			s.push(i);
		}
		return left;
	}

	public static int[] nextSmallRight(int arr[] ){
		Stack<Integer> s = new Stack<>();
		int right[] = new int[arr.length];

		for(int i=arr.length-1; i>=0; i--){
			while( !s.isEmpty() && arr[s.peek()]>=arr[i] ){
				s.pop();
			}
			if( s.isEmpty() ){
				right[i] = arr.length; // only in this case since we don't need element value else we store -1 for index
			}else{
				right[i] = s.peek() ;
			}
			s.push(i);
		}
		return right;
	}

	public static int largestRectangleArea(int arr[]){
		int left[] = nextSmallLeft(arr);
		int right[] = nextSmallRight(arr);

		int area[] = new int[arr.length];
		for(int i=0; i<arr.length; i++){
			System.out.print(" left:"+ left[i] +"  right:"+ right[i] +",");
			area[i] = arr[i] * ( right[i] - left[i] - 1 ) ;
		}
		int max=0;
		System.out.println();
		for(int i=0; i<arr.length; i++){
			System.out.print(area[i]+" ");
			max = Math.max(max,area[i]);
		}
		return max;
	}

}