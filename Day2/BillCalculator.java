import java.util.Scanner;
class BillCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Units Consumed:");
        int units = sc.nextInt();

        double billAmount = 0;

        if(units <= 100){
            billAmount = units * 3;
        } else if(units <= 200){
            billAmount = (100 * 3) + ((units - 100) * 5);
        } else if(units <= 300){
            billAmount = (100 * 3) + (100 * 5) + ((units - 200) * 7);
        } else {
            billAmount = (100 * 3) + (100 * 5) + (100 * 7) + ((units - 300) * 10);
        }

        System.out.println("Bill Amount: " + billAmount);
    }
}