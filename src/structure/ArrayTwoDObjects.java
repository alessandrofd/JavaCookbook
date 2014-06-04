package structure;

/**
 * Created by Alessandro on 20/03/2014.
 */
public class ArrayTwoDObjects {

    // Return list of subscript names (unrealistic; just for demo)
    public static String[][] getArrayInfo() {
        String info[][];
        info = new String[10][10];
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                info[i][j] = "String[" + i + "][" + j + "]";
            }
        }
        return info;
    }

    // Return list of allowable parameters (Applet method)
    public static String[][] getParameterInfo() {
        String param_info[][] = {
            { "fontsize", "9-18", "size of font"},
            { "URL", "-", "where to download"}
        };
        return param_info;
    }

    // Run both initialization methods and print part of the results.
    public static void main(String[] args) {
        print("from getArrayInfo", getArrayInfo());
        print("from getParameterInfo", getParameterInfo());
    }

    // Print selected elements form the 2D array
    public static void print(String tag, String[][] array) {
        System.out.println("Array " + tag + " is " + array.length + " X " + array[0].length);
        System.out.println("Array[0][0] = " + array[0][0]);
        System.out.println("Array[0][1] = " + array[0][1]);
        System.out.println("Array[1][0] = " + array[1][0]);
        System.out.println("Array[0][0] = " + array[0][0]);
        System.out.println("Array[1][1] = " + array[1][1]);
    }
}
