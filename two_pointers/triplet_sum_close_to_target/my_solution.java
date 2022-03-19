import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    // TODO: Write your code here
    Arrays.sort(arr);
    int minTripletSumCloseToTarget = Integer.MAX_VALUE;
    int minDisplacementFromSum = Integer.MAX_VALUE;
    System.out.println("Target: " + targetSum + "\t\t" + Arrays.toString(arr));
    for (int i = 0; i < arr.length; i++) {
        if ( ( i > 0 ) && ( arr[i] == arr[i-1] ) )
            continue;

        int currentTripletSum =  arr[i] + closestTwoSum(arr, targetSum - arr[i], i);
        int currentDisplacementFromSum = Math.abs( targetSum - currentTripletSum  );
        if ( currentDisplacementFromSum < minDisplacementFromSum ) {
            minTripletSumCloseToTarget = currentTripletSum;
            minDisplacementFromSum = currentDisplacementFromSum;
        } else if ( currentDisplacementFromSum == minDisplacementFromSum ) {
            minTripletSumCloseToTarget = Math.min( 
                minTripletSumCloseToTarget, 
                currentTripletSum
            );
        }
        System.out.print("currentTripletSum: " + currentTripletSum);
        System.out.print(" currentDisplacement: " + currentDisplacementFromSum);
        System.out.println(" minTripletSum: " + minTripletSumCloseToTarget);
    }
    return minTripletSumCloseToTarget;
  }

  public static int closestTwoSum(int[] arr, int targetSum, int index) {
      int left = 0;
      int right = arr.length - 1;
      int minDisplacementFromSum = Integer.MAX_VALUE;
      int closestTwoSum = Integer.MAX_VALUE;

      while ( left < right ) {
          if ( left == index )
              left += 1;
          if ( right == index )
              right -= 1;

          System.out.print("\t\tTwoSumTarget: " + targetSum + " Left: " + left + " Right: " + right);
          System.out.println(" minDisplacement: " + minDisplacementFromSum + " minTwoSum: " + closestTwoSum);

          int currentSum = arr[right] + arr[left];
          int currentDisplacementFromSum = Math.abs( targetSum - ( arr[right] + arr[left] ) );
          if ( currentDisplacementFromSum < minDisplacementFromSum ) {
              closestTwoSum = currentSum;
              minDisplacementFromSum = currentDisplacementFromSum;
          }

          if ( currentSum > targetSum )
              right--;
          else
              left++;

          System.out.print("\t\tTwoSumTarget: " + targetSum + " Left: " + left + " Right: " + right);
          System.out.println(" minDisplacement: " + minDisplacementFromSum + " minTwoSum: " + closestTwoSum);
      }

      System.out.println("\t\tResult: \t\tTarget: " + targetSum + " currentMinTwoSum: " + closestTwoSum);

      return closestTwoSum;
  }
}
