import org.jetbrains.annotations.NotNull;

public class FillSeats {


    public static void fillAisleSeats(int[][][] seats , int @NotNull [] PassengerArray) {
        int i = 0, j = 0, k = -1;
        int index = 0;
        for (int l : PassengerArray) {
            seats[i][j][k] = PassengerArray[index];
        }
        if (k == -1) {
            i = i + 1;
            k = 0;
        } else {
            k = -1;
            if (i == (seats.length - 1)) {
                i = 0;
                j = j + 1;
            }
        }
    }

    public static void fillMWindowSeats(int[][][] seats , int[] PassengerArray) {
        int i = 0, j = 0, k = 0;
        int index = 0;
        for (int l : PassengerArray) {
            seats[i][j][k] = PassengerArray[index];
            index += 1;
        }
        if (i==0) {
            i=k=-1;
        }
        else if (i ==  - 1) {
            i = k = 0;
            j = j + 1;
        }
    }

    public static void fillMiddleSeats(int[][][] seats , int[] PassengerArray) {
        int i = 0, j = 0, k = 1;
        int index = 0;
        for (int l : PassengerArray) {
            seats[i][j][k] = PassengerArray[index];
            k += 1;
            index += 1;
        }
        if (k == (seats[i][j].length - 1)) {
            i = i + 1;
            k = 1;
        }
        if (i == (seats.length - 1)) {
            i = 0;
            j = j + 1;
        }
    }
}
