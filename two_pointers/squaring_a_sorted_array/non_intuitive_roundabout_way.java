class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int right = 0, left = 0;

    while ( arr[right] < 0 ) {
            right++;
    }
    left = right - 1;

    System.out.println(Arrays.toString(arr));
    System.out.println("Right: " + right + " Left: " + left);
    for ( int i = 0; i < arr.length; i++ ) {
        if ( ( left >= 0 ) && ( right < arr.length ) ) {
            int leftSquared = arr[left] * arr[left];
            int rightSquared = arr[right] * arr[right];

            System.out.print("Right: " + right + " Left: " + left);
            System.out.println(" RightSquared: " + rightSquared + " LeftSquared: " + leftSquared);

            if ( rightSquared < leftSquared ) {
                squares[i] = rightSquared;
                right++;
            } else if ( leftSquared < rightSquared ) {
                squares[i] = leftSquared;
                left--;
            } else {
                squares[i] = leftSquared;
                i += 1;
                squares[i] = leftSquared;
                left--;
                right++;
            }
        } else if ( ( left >= 0 ) || ( right < arr.length ) ) {
              if (left >= 0) {
                  int leftSquared = arr[left] * arr[left];
                  squares[i] = leftSquared;
                  left--;
              }
              else if (right < arr.length) {
                  int rightSquared = arr[right] * arr[right];
                  squares[i] = rightSquared;
                  right++;
              }
          }

        if ( ( left < 0 ) && ( right > arr.length - 1) )
            break;
    }

    return squares;
  }
}
