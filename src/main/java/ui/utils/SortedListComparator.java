package ui.utils;

import ui.enums.SortByItems;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedListComparator implements Comparator<List<String>> {
    private SortByItems order;

    public SortedListComparator(SortByItems order) {
        this.order = order;
    }

    @Override
    public int compare(List<String> actualSortedList, List<String> listToBeSorted) {

        System.out.printf("The actual list is - %s%n", actualSortedList);
        if (order.equals(SortByItems.NAME_A_TO_Z)) {
            listToBeSorted = sortAscending(actualSortedList);
            System.out.printf("Sorted list by ascending is - %s%n", listToBeSorted);
            return listToBeSorted.equals(actualSortedList) ? 0 : -1;
        } else if (order.equals(SortByItems.NAME_Z_TO_A)) {
            listToBeSorted = sortDescending(actualSortedList);
            System.out.printf("Sorted list by descending is - %s%n", listToBeSorted);
            return listToBeSorted.equals(actualSortedList) ? 0 : -1;
        }
        return -1;
    }

    private List<String> sortAscending(List<String> listToBeSorted) {
        return listToBeSorted.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());
    }

    private List<String> sortDescending(List<String> listToBeSorted) {
        return listToBeSorted.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
