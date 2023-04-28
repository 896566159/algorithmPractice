package ltcd.dynamicProgrammingExercise;

public class _1105_填充书架 {

    public static void main(String[] args) {
        _1105_填充书架 v = new _1105_填充书架();
        v.minHeightShelves(new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4);
    }

    int[][] books;
    int shelfWidth;
    int height = 0;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shelfWidth = shelfWidth;
        dfs(0, books[0][1]);
        return height;
    }

    private void dfs(int index, int curHeight) {
        if (index == books.length) {
            return;
        }

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {

            }
        }
        
//        return height;
    }

}
