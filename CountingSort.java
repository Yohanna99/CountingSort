// Java implementation of Counting Sort
import java.util.Random;

public class CountingSort {
    void sort(int nums[]) {
        int s = nums.length; //s = size of sorted array
        int sorted[] = new int[s]; //array to be sorted

        int count[] = new int[1000000]; //size of array: max 1,000,000
        for (int i = 0; i < 1000000; ++i) {
            count[i] = 0;
           }
        for (int i = 0; i < s; ++i) {
            ++count[nums[i]];
          }
        for (int i = 1; i <= 999999; ++i) {
            count[i] += count[i - 1];
          }
          //start sorting
        for (int i = s - 1; i >= 0; i--) {
            sorted[count[nums[i]] - 1] = nums[i];
            --count[nums[i]];
        }
        for (int i = 0; i < s; ++i) {
            nums[i] = sorted[i];
          }
    }

  //psuedo-random number generator with restricted range
	public static int rand(int min, int max)
	{
		if (min < max || (max - min + 1 <= Integer.MAX_VALUE)) {
      return new Random().nextInt(max - min + 1) + min;
		}
    else{
      throw new IllegalArgumentException("invalid int");
    }
	}

    // Driver method
    public static void main(String args[])
    {
        CountingSort ob = new CountingSort();
        int[] size = {100, 1000, 100000, 1000000};
        for(int i = 0; i < size.length; i++){
          int[] nums = new int[size[i]];

          for (int j = 0; j < nums.length; j++) {
            nums[j] = rand(0, 999999);
          }
        long startTime = System.currentTimeMillis();
        ob.sort(nums);
        long stopTime = System.currentTimeMillis();
        System.out.println("Elapsed time for " + size[i] +" elements was " + (stopTime - startTime) + " miliseconds.");
        }
    }
}
