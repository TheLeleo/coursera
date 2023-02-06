public class ThueMorse {
    public static void main(String[] args) {
        int arg = Integer.parseInt(args[0]);
        for (int i = 0; i < arg; i++) {
            for (int j = 0; j < arg; j++) {
                int cell = i * arg + j;
                if (Integer.bitCount(cell) % 2 == 0) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }

}
