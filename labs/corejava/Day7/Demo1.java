package Day7;

public class Demo1 {

    static void minNumber(int arrayName[]) {
        int min = arrayName[0];
        for (int i = 0; i < arrayName.length; i++) {
            if (min > arrayName[i]) {
                min = arrayName[i];
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int a[]={3,5,9,2};
        minNumber(a);
    }
}





