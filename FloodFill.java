import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    int m, n;
    int[][] dirs;

    public int[][] floodFillWithBFS(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : dirs) {
                int nr = current[0] + dir[0];
                int nc = current[1] + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    queue.add(new int[] { nr, nc });
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }

    public int[][] floodFillWithDFS(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        m = image.length;
        n = image[0].length;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        // base case
        if (sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != oldColor) {
            return;
        }

        // logic
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, oldColor);
        }
    }
}
