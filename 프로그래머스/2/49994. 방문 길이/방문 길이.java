import java.util.*;

class Solution {
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4]; // 0-U, 1-D, 2-R, 3-L

        Map<String, int[]> map = new HashMap<>();

        map.put("U", new int[] {0, 1});
        map.put("D", new int[] {0, -1});
        map.put("R", new int[] {1, 0});
        map.put("L", new int[] {-1, 0});

        String[] dir = dirs.split("");

        int curX = 0;
        int curY = 0;
        int answer = 0;

        for (int i = 0; i < dir.length; i++) {
            int[] curDir = map.get(dir[i]);

            int x = curX + curDir[0];
            int y = curY + curDir[1];

            if (x > 5 || x < -5 || y > 5 || y < -5) {
                continue;
            }

            // 현재 위치에서 해당 방향으로 이미 지나간 길인지 확인
            boolean isVisited = false;

            if (dir[i].equals("U")) {
                isVisited = visited[curX + 5][curY + 5][0];
            }
            else if (dir[i].equals("D")) {
                isVisited = visited[curX + 5][curY + 5][1];
            }
            else if (dir[i].equals("R")) {
                isVisited = visited[curX + 5][curY + 5][2];
            }
            else {
                isVisited = visited[curX + 5][curY + 5][3];
            }

            // 처음 지나가는 길이라면
            if (!isVisited) {

                if (dir[i].equals("U")) {
                    visited[curX + 5][curY + 5][0] = true;
                    visited[x + 5][y + 5][1] = true;
                }
                else if (dir[i].equals("D")) {
                    visited[curX + 5][curY + 5][1] = true;
                    visited[x + 5][y + 5][0] = true;
                }
                else if (dir[i].equals("R")) {
                    visited[curX + 5][curY + 5][2] = true;
                    visited[x + 5][y + 5][3] = true;
                }
                else {
                    visited[curX + 5][curY + 5][3] = true;
                    visited[x + 5][y + 5][2] = true;
                }

                answer++;
            }

            curX = x;
            curY = y;
        }

        return answer;
    }
}