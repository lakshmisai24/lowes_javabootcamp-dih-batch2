package Day2;

public class Demo6 {
    public static void main(String[] args) {
        int score = 70;
        if (score == 90)
            System.out.println("A grade");
        else if (score < 90 && score > 75) {
            System.out.println("B grade");
        } else if (score < 75 && score > 60) {
            System.out.println("C grade");
        }
    }

}
