package Homeworks.S5Hw1;

public class MapPrinter {

    public MapPrinter() {
    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int[] ints : map) {
            for (int anInt : ints) {
                sb.append(String.format("%5d", anInt));
            }
            sb.append("\n");
        }
        sb.append("\n".repeat(3));

        return sb.toString();
    }

    public String visualData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int[] ints : map) {
            for (int anInt : ints) {
                switch (anInt) {
                    case -1 -> sb.append(String.format("%2s", "#"));
                    case 1 -> sb.append(String.format("%2s", "X"));
                    case -3 -> sb.append(String.format("%2s", "0"));
                    case 88 -> sb.append(String.format("%2s", "."));
                    default -> sb.append(String.format("%2s", " "));
                }
                sb.append(String.format("%2s", " "));
            } sb.append("\n");
        }
        sb.append("\n".repeat(3));
        return sb.toString();
    }
}
