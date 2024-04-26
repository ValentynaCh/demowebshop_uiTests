package ui.enums;


import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public enum HeaderMenuItems {
    BOOKS("BOOKS", "Books", "/books"),
    COMPUTERS("COMPUTERS", "Computers", "/computers", "Desktops", "Notebooks", "Accessories"),
    ELECTRONICS("ELECTRONICS", "Electronics", "/electronics", "Camera, photo", "Cell phones"),
    APPAREL_AND_SHOES("APPAREL&SHOES", "Apparel & Shoes", "/apparel-shoes"),
    DIGITAL_DOWNLOADS("DIGITAL DOWNLOADS", "Digital downloads", "/digital-downloads"),
    JEWELRY("JEWELRY", "Jewelry", "/jewelry"),
    GIFT_CARDS("GIFT CARDS", "Gift Cards", "/gift-cards");

    private String itemUIName;
    private String itemTagTextName;
    private String pageUrl;
    private final ArrayList<String> subcategories;


    HeaderMenuItems(String itemUIName, String itemTagTextName, String pageUrl, String... subcategories) {
        this.itemTagTextName = itemTagTextName;
        this.itemUIName = itemUIName;
        this.pageUrl = pageUrl;
        this.subcategories = new ArrayList<>(Arrays.asList(subcategories));
    }

    public static HeaderMenuItems getTagNameByTextItem(String tagTextName) {
        return Arrays.stream(HeaderMenuItems.values())
                .filter(value -> value.itemTagTextName.equalsIgnoreCase(tagTextName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such enum with provided tagTextName"));
    }
}
