import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int volume = 20;
        int array[] = new int[volume];

        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < volume; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        System.out.println(Arrays.toString(array));
    }
}
