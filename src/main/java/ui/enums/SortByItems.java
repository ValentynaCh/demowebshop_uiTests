package ui.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SortByItems {
    POSITION("Position", "Position"),
    NAME_A_TO_Z("Name: A to Z", "Name: A to Z"),
    NAME_Z_TO_A("Name: Z to A", "Name: Z to A"),
    PRICE_LOW_TO_HIGH("Price: Low to High", "Price: Low to High"),
    PRICE_HIGH_TO_LOW("Price: High to Low", "Price: High to Low"),
    CREATED_ON("Created on", "Created on");
    private String itemUIName;
    private String itemTagTextName;

    SortByItems(String itemUIName, String itemTagTextName) {
        this.itemUIName = itemUIName;
        this.itemTagTextName = itemTagTextName;
    }

    public static SortByItems getTagNameByTextItem(String tagTextName) {
        return Arrays.stream(SortByItems.values())
                .filter(value -> value.itemTagTextName.equalsIgnoreCase(tagTextName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such enum with provided tagTextName"));
    }
}
