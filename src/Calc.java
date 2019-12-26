public class Calc extends Compf {
    private StackInt s;
    private static int char2int(char c) { return (int)c - (int)'0'; }
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '+':
                s.push(first + second); break;
            case '-':
                s.push(first - second); break;
            case '*':
                s.push(first * second); break;
            case '/':
                s.push(first / second); break;
            case '{':
                s.push(first*first); break;
            case '}':
                s.push(first*first); break;
        }
    }
    protected void nextOther(char c) {

        if (desatich){

            int obr = (s.pop())*10+char2int(c);
            if (obr > 3999) {
                System.out.println("Введите число, не превышающее значение 3999");
                System.exit(0);
            }
            s.push(obr);
            desatich = true;
        }
        else
        {
            s.push(char2int(c));
            desatich = true;
        }
    }
    public Calc() {
        s = new StackInt();
    }
    public final void compile(char[] str) {
        super.compile(str);
        String convert = Integer.toOctalString(s.top());
        System.out.println(convert);
        desatich = false;
    }
}
