package ltcd.arrayExercise.matrixExercise;

public class _832_翻转图像 {

    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length - 1;
        int column = image[0].length - 1;

        while (row-- >= 0) {
            column = image[0].length - 1;
            while (column-- >= 0) {
                image[row][column] = image[row][column] == 0 ? 1 : 0;
            }
        }

        return image;
    }

}
