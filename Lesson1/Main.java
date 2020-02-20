package GeekBrains.Lesson4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1={1,2,3,4,5};
        asList(arr1);
        mas(arr1,1,2);

        System.out.println(Arrays.toString(arr1));

        String[] arr2={"A","B","C","D"};
        asList(arr2);
        mas(arr2,0,2);
        System.out.println(Arrays.toString(arr2));
    }




    public static  <T> void mas(T[] arr, int i, int j){
        T a=arr[i];
        arr[i]=arr[j];
        arr[j]=a;
    }
    public static <T> void asList(T[]arr){
        ArrayList <T> list= new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
    }
}
