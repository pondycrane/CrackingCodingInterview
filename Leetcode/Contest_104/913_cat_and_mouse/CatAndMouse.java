import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class CatAndMouse {
    public static int catMouseGame(int[][] graph) {
        Map<Integer, int[]> map = buildMap(graph);
        int[][] catHistory = generateHistory(graph.length);
        int[][] mouseHistory = generateHistory(graph.length);
        return catMouseGame(2, -1, 1, -1, true, map, catHistory, mouseHistory);
    }
    
    public static int[][] generateHistory(int width) {
        int[][] history = new int[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                history[i][j] = -1;
            }
        }
        return history;
    }

    public static int catMouseGame(int cat, int catPrev, int mouse, int mousePrev, boolean mouseMove, Map<Integer, int[]> map, int[][] catHistory, int[][] mouseHistory) {
        //System.out.println(cat + ", " + catPrev + ", " + mouse + ", " + mousePrev + ", " + mouseMove);
        if ((mouseMove && mouseHistory[cat][mouse] != -1) || (!mouseMove && catHistory[cat][mouse] != -1)) {
            if (mouseMove && mouseHistory[cat][mouse] == 1) {
                return mouseHistory[cat][mouse];
            } else if (!mouseMove && catHistory[cat][mouse] == 2) {
                return catHistory[cat][mouse];
            }
        }
        if (mouse == cat) {
            return 2;
        }
        if (mouse == 0) {
            return 1;
        }
        int[] moves = null;
        if (mouseMove) {
            moves = map.get(mouse);
            int best = -1;
            for (int move: moves) {
                int temp;
                if (move == mousePrev) {
                    temp = 0;
                } else {
                    temp = catMouseGame(cat, catPrev, move, mouse, false, map, catHistory, mouseHistory);
                }
                if (temp == 1) {
                    return 1;
                }
                best = findBest(best, temp, mouseMove);
                mouseHistory[cat][mouse] = findBest(mouseHistory[cat][mouse], best, mouseMove);
            }
            return best;
        } else {
            moves = map.get(cat);
            int best = -1;
            for (int move: moves) {
                int temp;
                if (move == 0) {
                    continue;
                }
                if (move == catPrev) {
                    temp = 0;
                } else {
                    temp = catMouseGame(move, cat, mouse, mousePrev, true, map, catHistory, mouseHistory);
                }
                if (temp == 2) {
                    return 2;
                }
                best = findBest(best, temp, mouseMove);
                catHistory[cat][mouse] = findBest(catHistory[cat][mouse], best, mouseMove);
            }
            return best;
        }
    }

    public static int findBest(int first, int second, boolean mouseMove) {
        if (mouseMove && second == 1) {
            return 1;
        } else if (!mouseMove && second == 2) {
            return 2;
        }
        if (first == -1 || second == 0) {
            return second;
        }
        return first;
    }

    public static Map<Integer, int[]> buildMap(int[][] graph) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, graph[i]);
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] case1 = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
        System.out.println(Arrays.toString(case1));
        System.out.println(catMouseGame(case1));

        int[][] case2 = {{3,4},{3,5},{3,6},{0,1,2},{0,5,6},{1,4},{2,4}};
        System.out.println(Arrays.toString(case2));
        System.out.println(catMouseGame(case2));
    }
}
