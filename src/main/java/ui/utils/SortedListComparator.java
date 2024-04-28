package ui.utils;


import java.util.Comparator;

public class SortedListComparator implements Comparator<String> {


    @Override
    public int compare(String listElement1, String listElement2) {
        if (sortOrder == SortOrder.ASCENDING) {
            return listElement1.compareTo(listElement2);
        } else if (sortOrder == SortOrder.DESCENDING) {
            return listElement2.compareTo(listElement1);
        }
        return -1;
    }

    public enum SortOrder {ASCENDING, DESCENDING}

    private SortOrder sortOrder;

    public SortedListComparator(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }
}


