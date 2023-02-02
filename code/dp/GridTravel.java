package code.dp;

import java.util.HashMap;
import java.util.Map;

// memo (top-down)
// how many ways travel from mxn top left to bottom right
// if move only left and botton?
//    c
// *  *  * 
// *  *  *   r
// *  *  *
// runtime: O(c+r)
class GridTravel {

  public long gridTravelWays(int r, int c, Map<String, Long> memo) {
    String key = r + "," + c;
    String reversedKey = c + "," + r;

    if (memo.containsKey(key) || memo.containsKey(reversedKey)) {
      return memo.getOrDefault(key, memo.get(reversedKey));
    }

    if (r == 0 || c == 0)
      return 0; // trivial
    if (r == 1 || c == 1)
      return 1; // nopn-trivial

    long value = gridTravelWays(r - 1, c, memo) + gridTravelWays(r, c - 1, memo); // D + L
    memo.put(key, value);

    return memo.get(key);
  }

  public static void main(String[] args) {
    GridTravel solution = new GridTravel();
    System.out.println(
        solution.gridTravelWays(18, 18, new HashMap<String, Long>()));
  }

}