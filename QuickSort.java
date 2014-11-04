public class QuickSort {
	public static void main(String[] args) {
		int[] data = {8, 13, 7, 9, 6, 2, 15, 4, 7, 9};
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + ",");
		}
		System.out.println();
		quickSort(data, 0, data.length-1);
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + ",");
		}
		System.out.println();
	}

	public static void quickSort(int[] data, int low, int high) {
		if(low < high) {
			int k = partition(data, low, high);
			quickSort(data, low, k);
			quickSort(data, k+1, high);
		}
	}

	public static int partition(int[] data, int low, int high) {
		int key = data[low];
		int left = low-1;
		int right = high+1;
		while(true) {
			do{
				right--;
			} while(data[right] > key);
			do{
				left++;
			} while(data[left] < key);

			if(left < right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
			} else {
				return right;
			}
		}
	}
}