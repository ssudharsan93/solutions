using namespace std;

#include <algorithm>
#include <iostream>
#include <vector>
#include <unordered_map>

class TripletSumToZero {
 public:
  static vector<vector<int>> searchTriplets(vector<int> &arr) {
    vector<vector<int>> triplets;
    int target = 0;

    printVector(arr);

    for ( int i = 0; i < arr.size(); i++ ) {
        vector<vector<int>> pairs = twoSum( target - arr[i], i, arr );
        for ( vector<int> potentialTriplet : pairs ){
            potentialTriplet.push_back(arr[i]);
            sort( potentialTriplet.begin(), potentialTriplet.end() );
            if ( checkVectorExists(triplets, potentialTriplet) ){ continue; } 
            else { 
              triplets.push_back(potentialTriplet);
              printVector(potentialTriplet); 
            }
        }
    }

    return triplets;
  }

  static vector<vector<int>> twoSum(int key, int index, vector<int> &arr){
      vector<vector<int>> pairs;
      unordered_map<int, int> pairMap;
      for ( int i = 0; i < arr.size(); i++ ) {
          if ( i == index ) { continue; }

          if ( pairMap.find( key - arr[i] ) != pairMap.end() ) {
              vector<int> newPair{ arr[i], arr[ pairMap[ key - arr[i] ] ] };
              sort( newPair.begin(), newPair.end() );
              pairs.push_back(newPair);
          } else {
              pairMap[ arr[i] ] = i;
          }

      }

      return pairs;
  }

  static bool checkVectorExists(vector<vector<int>> &main, vector<int> &newElement) {
      for (int i = 0; i < main.size(); i++ ) {
          if ( main[i] == newElement ) { return true; }
      }
      return false;
  }

  static void printVector(vector<int> &input) {
      cout << "[";
      for (int i = 0; i < input.size(); i++)
          cout << " " << input[i] << " ";
      cout << "]" << endl;
  }
};
