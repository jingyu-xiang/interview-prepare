/**
Given n boxes with Lengths, Widths and heights.
Box(Li, Wi, Hi) can be placed on top of Box(Lj, Wj, Hj)
if Li < Lj; Wi < Wj 

Find the stacked box height
Subproblem: largest height of stack with box 
(Li, Wi, Hi) at bottom
 */

package code.dp;

import java.util.*;

class BoxStacking {
    public boolean canBeStacked(final int[] top, final int[] bottom) {
        return top[0] < bottom[0] && top[1] < bottom[1];
    }

    public int boxStacking(final int[][] boxes) {
        final Map<Integer, Integer> heights = new HashMap<>();
        for (int i = 0; i < boxes.length; i++) {
            heights.put(i, boxes[i][2]);
        }

        for (int i = 1; i < boxes.length; i++) {
            final int[] box = boxes[i];
            final List<Integer> choices = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                final int[] top = boxes[j];
                if (canBeStacked(top, box))
                    choices.add(heights.get(j));
            }
            if (choices.size() > 0)
                heights.put(i, box[2] + Collections.max(choices));
        }

        return Collections.max(heights.values());
    }

    public static void main(final String[] args) {
        final int[][] matrix = {
                { 1, 2, 2 }, { 2, 3, 2 },
                { 1, 5, 4 }, { 2, 4, 1 },
                { 3, 6, 2 }, { 4, 5, 3 }
        };
        final BoxStacking sol = new BoxStacking();
        final int maxHeight = sol.boxStacking(matrix);
        System.out.println(maxHeight);
    }
}