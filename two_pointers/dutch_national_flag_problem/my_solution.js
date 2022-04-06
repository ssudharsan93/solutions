const dutch_flag_sort = function(arr) {
  var right = arr.length - 1;
  var left = 0;

  var condition = true;

  while( condition ) {
      if ( arr[left] != 0 && arr[right] != 2) {
          var tmp = arr[left];
          arr[left] = arr[right];
          arr[right] = tmp;
      }
      while ( arr[left] === 0 ) {
          left += 1;
      }
      while ( arr[right] === 2 ) {
          right -= 1;
      }

      if ( right - left <= 1 ) {
          if ( arr[right] === 2 && arr[left] === 1) {
              condition = false;
          }

          if ( arr[right] === 1 && arr[left] === 0) {
              condition = false;
          }

          if ( arr[right] === 1 && arr[left] === 1) {
              condition = false;
          }
      }
  }

  return arr;
};
