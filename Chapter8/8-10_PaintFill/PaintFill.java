/**
 * Implement a function that fill the surrounding color to our speficied color.
 * @author ecodi
 * @lastmodified 20180207
 */

public class PaintFill {
    
    public static void main(String[] args) {
        PaintFill pf = new PaintFill();
        Color[][] case1 = canvasBuilder(10, 10);
        pf.solution(case1, 4, 4, Color.RED);
        pf.solution(case1, 0, 0, Color.RED);
    }
    
    public void solution(Color[][] canvas, int x, int y, Color ncolor) {
        System.out.println("x: " + x + ", y: " + y + ", ncolor: " + ncolor);
        System.out.println("ocolor: " + canvas[x][y]);
        System.out.println("Before: ");
        printCanvas(canvas);
        if (canvas[x][y] == ncolor) return;
        else BFS(canvas, x, y, canvas[x][y], ncolor);
        System.out.println("After: ");
        printCanvas(canvas);
    }
    
    private static Color[][] canvasBuilder(int row, int col) {
        Color[][] newCanvas = new Color[row][col];
        for (int i = 0; i < newCanvas.length; i++) {
            for (int j = 0; j < newCanvas[0].length; j++) {
                newCanvas[i][j] = Color.randomColor();
            }
        }
        return newCanvas;
    }
    
    private static void printCanvas(Color[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                System.out.printf("%10s", canvas[i][j]);
            }
            System.out.println();
        }
    }
    
    private void BFS(Color[][] canvas, int x, int y, Color ocolor, Color ncolor) {
        if (x >= canvas.length || x < 0 || y >= canvas[0].length || y < 0) return;
        if (canvas[x][y] != ocolor) return;
        else {
            canvas[x][y] = ncolor;
            BFS(canvas, x + 1, y, ocolor, ncolor);
            BFS(canvas, x - 1, y, ocolor, ncolor);
            BFS(canvas, x, y + 1, ocolor, ncolor);
            BFS(canvas, x, y - 1, ocolor, ncolor);
        }
    }
}
