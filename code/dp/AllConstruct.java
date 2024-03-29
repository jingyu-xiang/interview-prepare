/**
 * Given a string s and an array wordDict
 * return all possible ways as a 2d list if s can be COMPLETELY 
 * segmented into space-seperated sequence of one or more 
 * words in wordDict.
 * runtime: O(len(wordDict)^len(s))
 * 
 * NOTE: don't take out elements in the middle of the string
 */

package code.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AllConstruct {

  public List<List<String>> allConstructMemo(
      final String s,
      final String[] wordDict,
      final Map<String, List<List<String>>> memo) {
    if (memo.containsKey(s))
      return memo.get(s);

    if (s.isEmpty()) {
      final List<List<String>> leaf = new ArrayList<>();
      leaf.add(new ArrayList<>());
      return leaf;
    }

    final List<List<String>> result = new ArrayList<>();

    for (final String word : wordDict) {
      if (s.indexOf(word) == 0) {
        final String suffix = s.substring(word.length());
        final List<List<String>> subPaths = allConstructMemo(
            suffix, wordDict, memo);

        final List<List<String>> newSubPaths = new ArrayList<>();
        subPaths.forEach(subPath -> {
          final List<String> newSubPath = new ArrayList<>();
          newSubPath.add(word);
          newSubPath.addAll(subPath);
          newSubPaths.add(newSubPath);
        });
        result.addAll(newSubPaths);
      }
    }

    memo.put(s, result);
    return memo.get(s);
  }

  public static void main(final String args) {
    final AllConstruct solution = new AllConstruct();
    System.out.println(
        solution.allConstructMemo(
            "purple",
            new String[] { "purp", "p", "ur", "le", "purpl" },
            new HashMap<>()));

    System.out.println(
        solution.allConstructMemo(
            "abcdef",
            new String[] { "ab", "abc", "cd", "def", "abcd", "ef", "c" },
            new HashMap<>()));

    System.out.println(
        solution.allConstructMemo(
            "skateboard",
            new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" },
            new HashMap<>()));

    System.out.println(
        solution.allConstructMemo(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaz",
            new String[] { "a", "aa", "aaa", "aaaa", "aaaaa" },
            new HashMap<>()));
  }

}
