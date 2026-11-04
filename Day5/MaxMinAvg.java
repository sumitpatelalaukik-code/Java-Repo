class MaxMin{

    static int findMin(int arr[]){
        int min = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    static int findMax(int arr[]){
        int max = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static int average(int arr[]){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void main(String[] args){
        int[] arr = {10,7,24,3,30,11};

        int max = findMax(arr);
        int min = findMin(arr);
        int avg = average(arr);

        System.out.println("Maximum number is: "+ max);
        System.out.println("Minimum number is: "+ min);
        System.out.println("Average number is: "+ avg);
    }
}
