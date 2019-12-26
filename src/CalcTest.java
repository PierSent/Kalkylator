import java.util.Scanner;
public class CalcTest {
    public static void main(String[] args) throws Exception {
        Calc c = new Calc();
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("Введите математическое выражение:");
            str = sc.nextLine();
            c.compile(str.toCharArray());
        }
    }
}
