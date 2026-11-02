class MarksCalculator{
    public static void main(String[] args){
        int physics = 90;
        int chemistry = 85;
        int maths = 80;
        int total = physics + chemistry + maths;
        float percentage = (total * 100) / 300;
        System.out.println("Total marks: " + total);
        System.out.println("Percentage: " + percentage + "%");

        if(percentage >= 90){
            System.out.println("Grade: A");
        }else if(percentage >= 80){
            System.out.println("Grade: B");
        }else if(percentage >= 70){
            System.out.println("Grade: C");
        }else if(percentage >= 60){
            System.out.println("Grade: D");
        }else{
            System.out.println("Grade: F");
        }
    }
}