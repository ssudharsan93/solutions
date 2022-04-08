const shortest_window_sort = function(arr) {
    var leftIndex = arr.length - 1;
    var rightIndex = 0;
    var numElementsNeedingToBeSorted = -1;

    console.log("Input : " + JSON.stringify(arr));

    var leftUnsortedElementFound = false;
    var rightUnsortedElementFound = false;


    for ( i = 0; i < arr.length; i++ ){
        for ( j = i + 1; j < arr.length; j++) {
            if ( arr[i] > arr[j] ) {
                leftIndex = Math.min(leftIndex, i);
                leftUnsortedElementFound = true;
            }
        }
    }

    for ( i = arr.length - 1; i >= 0 ; i-- ){
        for ( j = i - 1; j >= 0 ; j--) {
            if ( arr[i] < arr[j] ) {
                rightIndex = Math.max(rightIndex, i);
                rightUnsortedElementFound = true;
            }
        }
    }

    if ( ( ! rightUnsortedElementFound ) && ( ! leftUnsortedElementFound ) ) { return 0; }

    numElementsNeedingToBeSorted = rightIndex - leftIndex + 1;
    
    return numElementsNeedingToBeSorted;
};
