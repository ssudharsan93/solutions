import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    int target = 0;

    for ( int i = 0; i < arr.length; i++ ){
        List<List<Integer>> pairs = TwoSum( target - arr[i],  i, arr);
        for ( List<Integer> potentialTriplet : pairs ) {
            potentialTriplet.add( arr[i] );
            Collections.sort( potentialTriplet );
            if ( triplets.contains(potentialTriplet) )
                continue;
            else
                triplets.add(potentialTriplet);
        }
    }

    return triplets;
  }

  public static List<List<Integer>> TwoSum(int key, int index, int[] arr) {
      List<List<Integer>> pairs = new ArrayList<>();
      Map<Integer, Integer> pairMap = new HashMap<Integer, Integer>();

      for ( int i = 0; i < arr.length; i++ ){
          if ( i == index )
              continue;

          if ( pairMap.containsKey( key - arr[i] ) ) {
              List<Integer> newPair = new ArrayList<>( Arrays.asList( arr[i], arr[ pairMap.get( key - arr[i] ) ] ) );
              Collections.sort( newPair );
              pairs.add( newPair );
          } else
              pairMap.put(arr[i], i);

      }

      return pairs; 
  }

}
