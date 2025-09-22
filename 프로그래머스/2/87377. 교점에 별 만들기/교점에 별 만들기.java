import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public String[] solution(int[][] line) {
        Set<long[]> points = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0], B = line[i][1], E = line[i][2];
                long C = line[j][0], D = line[j][1], F = line[j][2];

                long denominator = A * D - B * C;
                if (denominator == 0) continue; 
                
                double x = (double)(B * F - E * D) / denominator;
                double y = (double)(E * C - A * F) / denominator;

                if (x % 1 == 0 && y % 1 == 0) {
                    points.add(new long[]{(long)x, (long)y});
                }
            }
        }

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        for (long[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }

        int rows = (int)(maxY - minY + 1);
        int cols = (int)(maxX - minX + 1);
        char[][] grid = new char[rows][cols];

        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        for (long[] p : points) {
            int r = (int)(maxY - p[1]); 
            int c = (int)(p[0] - minX); 
            grid[r][c] = '*';
        }

        String[] answer = new String[rows];
        for (int i = 0; i < rows; i++) {
            answer[i] = new String(grid[i]);
        }

        return answer;
    }
}
