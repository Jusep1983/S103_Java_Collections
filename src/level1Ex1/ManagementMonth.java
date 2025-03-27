package level1Ex1;

import java.util.*;

public class ManagementMonth {
    public static void start() {
        Month january = new Month("January");
        Month february = new Month("February");
        Month march = new Month("March");
        Month april = new Month("April");
        Month may = new Month("May");
        Month june = new Month("June");
        Month july = new Month("July");
        Month august = new Month("August");
        Month september = new Month("September");
        Month october = new Month("October");
        Month november = new Month("November");
        Month december = new Month("December");

        List<Month> list = Arrays.asList(january, february, march, april, may, june, july, september, october, november, december);
        ArrayList<Month> months = new ArrayList<>(list);
        System.out.println("\nImpresión ArrayList: ");


        for (Month value : months) {
            System.out.print(value.getName() + " ");
        }

        System.out.println("\nImpresión ArrayList con agosto: ");
        months.add(7, august);

        for (Month value : months) {
            System.out.print(value.getName() + " ");
        }

        Set<Month> monthsHashSet = new HashSet<>(months);

        monthsHashSet.add(august);
        monthsHashSet.add(may);
        monthsHashSet.add(january);

        System.out.println("\nImpresión HahSet: ");
        for (Month month : monthsHashSet) {
            System.out.print(month.getName() + " ");
        }

        Iterator<Month> iteratorMonthsHashSet = monthsHashSet.iterator();

        System.out.println("\nImpresión HahSet comprobando que no ha añadido duplicados: ");
        while (iteratorMonthsHashSet.hasNext()) {
            Month month = iteratorMonthsHashSet.next();
            System.out.print(month.getName() + " ");
        }
    }
}
