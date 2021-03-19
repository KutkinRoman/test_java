package DemoArray_HW_02;

public class SumArray {

    private static String[][] arr = {{"1","test","3","4"},{"11","12","13","14"},
            {"21","22","23","24"},{"31","32","33","34",}};


    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        System.out.println(readArray(arr));
    }



    private static String readArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

               for (int i = 0; i < arr.length; i++) {

                   for (int j = 0; j < arr[i].length; j++) {
                       if (arr.length != 4 || arr[i].length != 4) throw new MyArraySizeException();

                       try {
                       sum += Integer.parseInt(arr[i][j]);

                   } catch (NumberFormatException e){
                         throw new MyArrayDataException(i , j, arr[i][j]);
                       }
                   }
               }

        return "Sum array = " + sum;
    }
}
