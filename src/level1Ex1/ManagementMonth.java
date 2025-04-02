package level1Ex1;

import java.util.*;

public class ManagementMonth {
    public static void start() {
        Month january = new Month("January");
        Month may = new Month("May");
        Month august = new Month("August");

        List<Month> list = Arrays.asList(
                january, new Month("February"), new Month("March"), new Month("April"), may,
                new Month("June"), new Month("July"), new Month("September"),
                new Month("October"), new Month("November"), new Month("December"));

        ArrayList<Month> months = new ArrayList<>(list);
        System.out.println("\nArrayList Printing:");

        for (Month value : months) {
            System.out.print(value.getName() + " ");
        }

        System.out.println("\n\nArrayList printing with August:");
        months.add(7, august);

        for (Month value : months) {
            System.out.print(value.getName() + " ");
        }

        Set<Month> monthsHashSet = new HashSet<>(months);

        monthsHashSet.add(august);
        monthsHashSet.add(may);
        monthsHashSet.add(january);

        System.out.println("\n\nHahSet Printing:");
        for (Month month : monthsHashSet) {
            System.out.print(month.getName() + " ");
        }

        Iterator<Month> iteratorMonthsHashSet = monthsHashSet.iterator();

        System.out.println("\n\nPrinting the HashSet, checking that no duplicates have been added:");
        while (iteratorMonthsHashSet.hasNext()) {
            Month month = iteratorMonthsHashSet.next();
            System.out.print(month.getName() + " ");
        }
    }
}
