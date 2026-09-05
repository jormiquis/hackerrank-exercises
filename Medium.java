/*Merge and Sort Intervals
Given an array of intervals [startTime, endTime], merge all overlapping intervals and return a sorted array of non-overlapping intervals.

Example

Input

intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
Output

[[1, 6], [8, 10], [15, 18]]
Explanation

- Step 1: Sort intervals by start time (already sorted).
- Step 2: Initialize merged list with first interval [1,3].
- Step 3: Compare [2,6] with last merged [1,3]. They overlap (2 ≤ 3), so merge into [1,6]. Step 4: Compare [8,10] with last merged [1,6]. No overlap (8 > 6), append [8,10].
- Step 5: Compare [15,18] with last merged [8,10]. No overlap (15 > 10), append [15,18].

Result: [[1,6],[8,10],[15,18]].
Input Format

The first line contains an integer denoting the number of intervals.
The second line contains an integer denoting the length of individual interval array.
Each of the next N lines contains two space-separated integers startTime and endTime
Intervals may be provided in any order; duplicates and fully contained intervals are allowed.
Example

4
2
1 3
2 6
8 10
15 18
here, 4 is the number of intervals, 2 is the length of individual interval array, followed by the intervals.

Constraints

0 <= intervals.length <= 100000
intervals[i].length == 2 for all 0 <= i < intervals.length
0 <= intervals[i][0] < intervals[i][1] <= 10^9 for all 0 <= i < intervals.length
Output Format

Return a 2D array of two space-separated integers start and end, representing the merged intervals sorted by increasing start time.
Sample Input 0

0
0
Sample Input 1

1
2
5 10
Sample Output 1

5 10
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Medium {
    public static void main(String[] args) {
        List<List<Integer>> data  = new ArrayList<>();
        data.add(Arrays.asList(0, 0));

        System.out.println(mergeIntervals(data));
    }

    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        if (intervals.size() == 1
            || intervals == null
            || intervals.isEmpty()
           ) return intervals;

        //ordering
        intervals.sort((previous, current) -> {
            //compare first element
            int result = Integer.compare(previous.get(0), current.get(0));

            //if first elements are equal is order by second
            if (result == 0) {
                 return Integer.compare(previous.get(1), current.get(1));
            }
            return result;
        });

        List<List<Integer>> result = new ArrayList<>();
        result.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> previous = result.get(result.size() - 1);  //podria coger el i -1?
            List<Integer> current = intervals.get(i);

            if (current.get(0) <= previous.get(1)) {
                int max = Math.max(current.get(1), previous.get(1));
                List<Integer> merged = Arrays.asList(previous.get(0), max);
                result.set(result.size() - 1, merged);

                continue;
            }

            result.add(current);
        }

        return result;
    }
}
