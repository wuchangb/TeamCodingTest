package level0;

public class exam01 {
    // 분수의 덧셈
    public static void main(String[] args) {
        public int[] exam01(int denum1, int num1, int denum2, int num2 ) {
            int denum = denum1 * num2 + denum2 * num1;
            int num = num1 * num2;
            int ged = getGCD(denum, num);

            return new int[]{denum/gcd, num/gcd};
        }
    } public int getGCD(int a, int b) {
        if(a%b ==0) {
            return b;
        } return getGCD(b, a%b);
    }

}
