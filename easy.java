import java.util.List;
/**
 * Given an array of positive integers, return the number of elements that are strictly greater than the average of all previous elements. Skip the first element.

Example

Input

responseTimes = [100, 200, 150,300]
Output

2
Explanation

- Day 0: 100 (no previous days, skip)
- Day 1: 200 > average(100) = 100 → count = 1
- Day 2: 150 vs average(100, 200) = 150 → not greater → count = 1
- Day 3: 300 > average(100, 200, 150) = 150 → count = 2 Return 2.
Input Format

The first line contains an integer n (0 ≤ n ≤ 1000), the number of days.
If n > 0, the next n lines contains an integer representing responseTimes[i].
If n = 0, the second line is omitted or empty.
 */

class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(0);

        System.out.println(
            Result.countResponseTimeRegressions(list)
        );
    }
}

class Result {

    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if(responseTimes.size() == 0) return 0;

        long average = responseTimes.get(0);
        long totalSum = responseTimes.get(0);
        int numberOfElementsGreatherThanAverage = 0;

        for (int i = 1; i < responseTimes.size(); i++) {
            int actualPosition = responseTimes.get(i);

            average = totalSum / i;
            totalSum += actualPosition;

            if(actualPosition > average) numberOfElementsGreatherThanAverage ++;
        }

        return numberOfElementsGreatherThanAverage;
    }
}
