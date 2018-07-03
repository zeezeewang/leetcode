package Construct.Graph;

public class Graph {
    private int vertexSize;
    private int[] vertex;
    private int[][] matrix;
    private static int MAX_WEIGHT;

    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        vertex = new int[vertexSize];
        for (int i = 0;i < vertexSize;i++) {
            vertex[i] = i;
        }
    }
    public int getOutDegree(int index) {
        int degree = 0;
        for (int j = 0;j < matrix[index].length;j++) {
            int weight = matrix[index][j];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    public void setVertex(int[] vertex) {
        this.vertex = vertex;
    }

    public int[] getVertex() {
        return vertex;
    }

    public static void main(String[] args){
        Graph graph = new Graph(5);

        int[] a1 = new int[]{0,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,6};
        int[] a2 = new int[]{9,0,3,MAX_WEIGHT,MAX_WEIGHT};
        int[] a3 = new int[]{2,MAX_WEIGHT,0,5,MAX_WEIGHT};
        int[] a4 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0,1};
        int[] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};
        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;

        int degree = graph.getOutDegree(0);
        System.out.println(degree);
    }
}
