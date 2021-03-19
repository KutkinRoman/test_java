package DemoArray_HW_02;

public class MyArrayDataException extends Exception{

    public MyArrayDataException(int i, int j, String s) {
        super("Index array " + i + "x" + j + " does not match format. Contains : " + s);
    }


}
