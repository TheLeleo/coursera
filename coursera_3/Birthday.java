public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int attempts = Integer.parseInt(args[1]);

        int[] guestsEntered = new int[attempts];
        for (int i = 0; i < attempts; i++) {
            int[] birthdays = {-1};
            boolean unique = true;
            int people = 1;


            while (unique) {
                int bday = (int) (Math.random() * (n - 1));
                for (int j = 0; j < birthdays.length; j++) {
                    if (birthdays[j] == bday) {
                        guestsEntered[i] = people;
                        unique = false;
                        break;
                    }
                }
                int[] bdaysCopy = new int[birthdays.length + 1];
                for (int j = 0; j < birthdays.length; j++) {
                    bdaysCopy[j] = birthdays[j];
                }
                bdaysCopy[birthdays.length] = bday;
                birthdays = bdaysCopy;
                ++people;
            }
        }
        double chance = 0.0;
        double attempts_double = attempts;
        int guestCount = 1;
        while (chance < 0.5) {
            System.out.print(guestCount + "    ");
            int CountGuests = 0;
            for (int i = 0; i < guestsEntered.length; i++) {
                if (guestsEntered[i] == guestCount) {
                    ++CountGuests;
                }
            }
            System.out.print(CountGuests + "    ");
            chance += CountGuests / attempts_double;
            System.out.print(chance);
            System.out.println();
            ++guestCount;
        }

    }
}
