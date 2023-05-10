public class Main {

        public static void main(String[] args) {
            double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            double[][] orthoMatrix = gramSchmidt(matrix);
            for (int i = 0; i < orthoMatrix.length; i++) {
                for (int j = 0; j < orthoMatrix[0].length; j++) {
                    System.out.print(orthoMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static double[][] gramSchmidt(double[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            double[][] orthoMatrix = new double[rows][cols];
            double[] u = new double[rows];

            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {
                    u[i] = matrix[i][j];
                }
                for (int k = 0; k < j; k++) {
                    double dotProduct = 0;
                    for (int i = 0; i < rows; i++) {
                        dotProduct += orthoMatrix[i][k] * matrix[i][j];
                    }
                    for (int i = 0; i < rows; i++) {
                        u[i] -= dotProduct * orthoMatrix[i][k];
                    }
                }
                double norm = 0;
                for (int i = 0; i < rows; i++) {
                    norm += u[i] * u[i];
                }
                norm = Math.sqrt(norm);
                for (int i = 0; i < rows; i++) {
                    orthoMatrix[i][j] = u[i] / norm;
                }
            }
            return orthoMatrix;
        }
    }
