const search_quadruplets = function(arr, target) {
  quadruplets = [];
  // TODO: Write your code here
  arr.sort( (a, b) => a - b );

  console.log(arr);
  console.log(target);

  for ( let i = 0; i < arr.length - 3; i++ ) {
      for ( let j = i + 1; j < arr.length - 2; j++) {
          quadruplets = two_sum(arr, j+1, target, arr[i], arr[j], quadruplets);
      }
  }
  return quadruplets;
};ii

const two_sum = function(arr, start, target, firstNum, secondNum, solutions) {
  var right = arr.length - 1;
  var left = start;

  console.log( "firstNum : " + firstNum  + " secondNum : " + secondNum );

  while ( left < right ) {
      console.log( "\t\tLeft - " + left + " : " + arr[left]);
      console.log( "\t\tRight - " + right + " : " + arr[right]);

      var current_sum = arr[left] + arr[right] + firstNum + secondNum;
      console.log("\t\tSum: " + current_sum);
      
      if ( current_sum === target ) {
          
          potential_array = [ firstNum, secondNum, arr[left], arr[right] ];
          existsAt = solutions.findIndex( function(elem, index) {
            return equals(elem, potential_array);
          });
          if ( existsAt === -1 ){  
              solutions.push( [ firstNum, secondNum, arr[left], arr[right] ] );
          }
          left += 1;

      } 
      else if ( current_sum < target ) { left += 1; } 
      else { right -= 1; }

      console.log( "\t\tLeft - " + left + " : " + arr[left]);
      console.log( "\t\tRight - " + right + " : " + arr[right]);

  }

  return solutions;
}

const equals = (a, b) => { 
  return JSON.stringify(a) === JSON.stringify(b); 
}
