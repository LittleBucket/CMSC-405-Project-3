/*
Rashid Imtiaz
4/1/22
CMCS 405
Project 2
 */

//Creates the object using arrays for both vertices and faces
class Shapes {

    static Shapes shape1 =
            new Shapes(
                    new double[][]{
                            {.5,0,0},{.25,1,0},{.75,1,0},
                            {.5,0,1},{.25,1,1},{.75,1,1}},
                    new int[][]{
                            {0, 1, 2},{3,4,5},{0,3,1,4},
                            {0,3,2,5}
                    }
            );
    static Shapes shape2 =
            new Shapes(
                    new double[][]{
                            {.25,0,0},{0,.25,0},{0,.75,0},
                            {.25,1,0},{.75,1,0},{.75,.75,0},
                            {.75,.25,0},{.75,0,0},{.5,.5,1}
                    },
                    new int[][]{
                            {0,8},{1,8},{2,8},{3,8},
                            {4,8},{5,8},{6,8},{0,1},
                            {1,2},{2,3},{3,4},{4,5},
                            {5,6},{6,7},}
            );
    static Shapes shape3 =
            new Shapes(
                    new double[][]{
                            {0,0,0},{1,0,0},{1,1,0},{0,1,0},
                            {0,0,1},{1,0,1},{1,1,1},{0,1,1}},
                    new int[][]{
                            {0,1,2,3},{4,5,6,7},{0,4,7,3},
                            {1,5,6,2}}
            );
    static Shapes shape4 =
            new Shapes(
                    new double[][]{
                            {-0.5, -0.5, 0.25}, {0.5, -0.5, 0.25}, {0, 0.5, 0.25},
                            {-0.75, -0.75, 0}, {0.75, -0.75, 0}, {0, 0.75, 0},
                            {-0.5, -0.5, -0.25}, {0.5, -0.5, -0.25}, {0, 0.5, -0.25}
                    },
                    new int[][]{
                            {0, 1, 2}, {0, 1, 4, 3}, {1, 2, 5, 4},
                            {2, 0, 3, 5}, {6, 7, 8}, {6, 7, 4, 3},
                            {7, 8, 5, 4}, {8, 6, 3, 5}}
            );
    static Shapes shape5 =
            new Shapes(new double[][]{
                    {.5,.5,-1},{.25,.25,0},{.25,.75,0},
                    {.75,.75,0},{.75,.25,0},{0,0,0},
                    {1,0,0},{1,1,0},{0,1,0},
                    {0,0,1},{1,0,1}, {1,1,1},
                    {0,1,1},{.5,.5,2},{.25,.25,1},
                    {.25,.75,1},{.75,.75,1},{.75,.25,1}
            },
                    new int[][]{
                            {0,1},{0,1},{0,2},
                            {0,3},{0,4},{5,6,7,8},
                            {9,10,11,12},{5,9,12,8},{6,10,11,7},
                            {14,13},{15,13},{16,13},
                            {17,13},{1,14},{15,1},
                            {16,2},{17,3}}

            );

    static Shapes shape6 =
            new Shapes(
                    new double[][]{
                            {1,-0.5,1}, {1,-.5,-1}, {1,.5,-1},
                            {1,.5,1}, {.75,.75,0},{-.75,.75,0},
                            {-1,-.5,1}, {-1,.5,1}, {-1,.5,-1},
                            {-1,-.5,-1}
                    },
                    new int[][]{
                            {0,1,2,3}, {3,2,4}, {7,3,4,5}, {2,8,5,4},
                            {5,8,7}, {0,3,7,6}, {0,6,9,1},
                            {2,1,9,8}, {6,7,8,9}}
            );

    //Defines arrays
    double[][] vertices;
    int[][] faces;

    //Constructs arrays
    private Shapes(double[][] vertices, int[][] faces) {
        this.vertices = vertices;
        this.faces = faces;
    }
}