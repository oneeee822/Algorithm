import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int board[][];
    static int copyBoard[][];
    static int output[] = new int[5];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        copyBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == 5) {
            // copyBoard 초기화
            for (int i = 0; i < N; i++) {
                System.arraycopy(board[i], 0, copyBoard[i], 0, N);
            }

            // 방향에 따라 이동
            for (int i = 0; i < 5; i++) {
                move(output[i]);
            }

            // 최대값 확인
            check();
            return;
        }

        for (int i = 0; i < 4; i++) {
            output[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void move(int direction) {
        if (direction == 0) { // 위로 이동
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                boolean[] merged = new boolean[N];
                int idx = 0;

                // 숫자들을 위로 몰기
                for (int i = 0; i < N; i++) {
                    if (copyBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == copyBoard[i][j] && !merged[idx - 1]) {
                            temp[idx - 1] *= 2;
                            merged[idx - 1] = true;
                        } else {
                            temp[idx++] = copyBoard[i][j];
                        }
                    }
                }

                // 결과를 다시 copyBoard에 적용
                for (int i = 0; i < N; i++) {
                    if (i < idx) copyBoard[i][j] = temp[i];
                    else copyBoard[i][j] = 0;
                }
            }
        } else if (direction == 1) { // 아래로 이동
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                boolean[] merged = new boolean[N];
                int idx = 0;

                // 숫자들을 아래로 몰기
                for (int i = N - 1; i >= 0; i--) {
                    if (copyBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == copyBoard[i][j] && !merged[idx - 1]) {
                            temp[idx - 1] *= 2;
                            merged[idx - 1] = true;
                        } else {
                            temp[idx++] = copyBoard[i][j];
                        }
                    }
                }

                // 결과를 다시 copyBoard에 적용
                idx = N - 1;
                for (int i = 0; i < N; i++) {
                    if (i < temp.length && temp[i] != 0) {
                        copyBoard[idx--][j] = temp[i];
                    } else {
                        copyBoard[idx--][j] = 0;
                    }
                }
            }
        } else if (direction == 2) { // 왼쪽으로 이동
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                boolean[] merged = new boolean[N];
                int idx = 0;

                // 숫자들을 왼쪽으로 몰기
                for (int j = 0; j < N; j++) {
                    if (copyBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == copyBoard[i][j] && !merged[idx - 1]) {
                            temp[idx - 1] *= 2;
                            merged[idx - 1] = true;
                        } else {
                            temp[idx++] = copyBoard[i][j];
                        }
                    }
                }

                // 결과를 다시 copyBoard에 적용
                for (int j = 0; j < N; j++) {
                    if (j < idx) copyBoard[i][j] = temp[j];
                    else copyBoard[i][j] = 0;
                }
            }
        } else if (direction == 3) { // 오른쪽으로 이동
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                boolean[] merged = new boolean[N];
                int idx = 0;

                // 숫자들을 오른쪽으로 몰기
                for (int j = N - 1; j >= 0; j--) {
                    if (copyBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == copyBoard[i][j] && !merged[idx - 1]) {
                            temp[idx - 1] *= 2;
                            merged[idx - 1] = true;
                        } else {
                            temp[idx++] = copyBoard[i][j];
                        }
                    }
                }

                // 결과를 다시 copyBoard에 적용
                idx = N - 1;
                for (int j = 0; j < N; j++) {
                    if (j < temp.length && temp[j] != 0) {
                        copyBoard[i][idx--] = temp[j];
                    } else {
                        copyBoard[i][idx--] = 0;
                    }
                }
            }
        }
    }

    public static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, copyBoard[i][j]);
            }
        }
    }
}