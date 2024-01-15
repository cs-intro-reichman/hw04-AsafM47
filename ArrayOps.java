public class ArrayOps {
    public static void main(String[] args) {
        boolean a = containsTheSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3});
        boolean b = containsTheSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3});
        boolean c = containsTheSameElements(new int[] {1, 2, 3}, new int[] {1, 2, 3}); 
        boolean d = containsTheSameElements(new int[]{3, -4, 1, 2, 5}, new int[]{1, 3, -4, 5});
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }
    
    public static int findMissingInt (int [] array) {
        int[] newArray = SortArray(array);
        int missing = 0;
        if(newArray.length == 1){
            if(newArray[0] != 1){
                missing = 1;
                return missing;
            }
        }
        for(int i = 0; i <= newArray.length-2;i++){
            if(newArray[i] + 1 != newArray[i+1]){
                missing = newArray[i]+1;
            }
        }

        return missing;

    }

    public static int secondMaxValue(int [] array) {
        int[] newarray = SortArray(array);
        int n = newarray.length; 
        int secondmax = newarray[n-2];
        return secondmax;
    
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int[] reduced1 = ReducedArray(array1);
        int [] reduced2 = ReducedArray(array2);
        boolean contains = true; 
        if(reduced1.length != reduced2.length){
            contains = false; 
        }
        else{
            for(int i = 0; i<reduced1.length-1; i++){
                if(reduced1[i] != reduced2[i])
                {
                    contains = false;
                }
            }
        }
        return contains;

    }
    public static boolean isSorted(int [] array) {
        boolean isSorted = true;
        int lastValue = array[0];
        // check if the array ascending
        for(int i = 0; i < array.length; i++){
            if(array[i] < lastValue){
                isSorted = false;
            }
            lastValue = array[i];
        }
        if (!isSorted) {
             // check if the array descending
            isSorted = true;
            lastValue = array[0];
            for(int i = 0; i < array.length; i++){
                if(array[i] > lastValue){
                    isSorted = false;
                }
                lastValue = array[i];
            }  
        }

        return isSorted;
    }
    
    public static int[] SortArray(int [] originalArray){
        int[] newArray = originalArray.clone();
        int n = newArray.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (newArray[j] >newArray[j+1]) {
                    // Swap array[j+1] and array[j]
                    int temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                }
            }
        }
        return newArray;
    }
    public static int[] ReducedArray(int[] array){
           // Temporary array to store unique elements
    int[] sortArr = SortArray(array);
    int[] tempArray = new int[sortArr.length];
    int size = 0;

    for (int i = 0; i < sortArr.length; i++) {
        boolean isDuplicate = false;
        for (int j = 0; j < size; j++) {
            if (sortArr[i] == tempArray[j]) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            tempArray[size++] = sortArr[i];
        }
    }

    // Copying the unique elements to a new array of the correct size
    int[] uniqueArray = new int[size];
    for (int i = 0; i < size; i++) {
        uniqueArray[i] = tempArray[i];
    }

    return uniqueArray;


    }
}
