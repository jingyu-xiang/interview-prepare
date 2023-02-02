// memo (top-down)
// canSum(7, [5,4,3,7]) => true
// runtime: O(tartgetSum^2*len(numbers))
package code.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CanSum {
  public boolean canSumMemo(
      int targetSum,
      List<Integer> numbers,
      Map<Integer, Boolean> memo) {
    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }

    if (targetSum == 0)
      return true;
    if (targetSum < 0)
      return false;

    for (int candidate : numbers) {
      int reminder = targetSum - candidate;
      if (canSumMemo(reminder, numbers, memo) == true) {
        memo.put(targetSum, true);
        return memo.get(targetSum);
      }
    }

    // any non-negative reminders
    memo.put(targetSum, false);

    // return if targetSum can't be substracted without reminders
    return false;
  }

  public static void main(String[] args) {
    CanSum solution = new CanSum();
    System.out.println(
        solution.canSumMemo(
            300,
            new ArrayList<>(List.of(7, 14)),
            new HashMap<>()));
  }
}