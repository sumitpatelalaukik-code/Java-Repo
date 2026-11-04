import java.util.Scanner;
class SortingSearching{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        boolean swapped;
        for(int i=0; i<arr.length-1; i++){
            swapped = false; 
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

        System.out.println("Sorted Array is..");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("Enter element to search: ");
        int target = sc.nextInt();
        for(int i = 0; i<n; i++){
            if(arr[i] == target){
                System.out.println("Element found at index: "+ i);
                break;
            }
        }
        sc.close();
    }
}