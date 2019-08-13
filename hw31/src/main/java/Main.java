import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int[] array = createArray(20);
        System.out.println(Arrays.toString(array));
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j>0 && array[j] < array[j-1]; j--){
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
        }
    }

    private static int[] createArray(int volume) {
        int[] array = new int[volume];
        for (int j = 0; j < volume; j++) {
            array[j] = ThreadLocalRandom.current().nextInt(0, volume + 1);
        }
        return array;
    }
}
