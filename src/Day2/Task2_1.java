package Day2;

/*
 *1. The Arithmetic Operators
 *2. if-else-if
 *3. switch
 *4. Logical operators
 */
public class Task2_1 {
    public static void main(String[] args) {

        int a = 10;
        System.out.println("a=" + a);
        int b = 4;
        System.out.println("b=" + b);

        System.out.println("a+b=" + (a + b));
        System.out.println("a-b=" + (a - b));
        System.out.println("a*b=" + (a * b));
        System.out.println("a/b=" + (double) (a / b));//Typecast chenq ancel. Zut vor jisht output unenanq :)
        System.out.println("a%b=" + (a % b));

        if (a > b) {
            System.out.println("a>b");
        } else if (a == b) {
            System.out.println("a=b");
        } else if (a < b) {
            System.out.println("a<b");
        }

        int i = 4;
        switch (i) {
            case 1: {
                System.out.println("i=1 :)");
                break;
            }
            case 2: {
                System.out.println("i=2 :)");
                break;
            }
            default: {
                System.out.println("i<>1 and i<>2");
                break;
            }
        }

        System.out.println(i >= 0 ? "i is positive or 0" : "i is negative");

        System.out.println(false ^ true);
        System.out.println(false && true);
        System.out.println(true || false);


    }
}
