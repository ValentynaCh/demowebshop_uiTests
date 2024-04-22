package ui.enums;


import lombok.Getter;

import java.util.Arrays;

@Getter
public enum HeaderMenuPageTitle {
    BOOKS("BOOKS", "Books", "/books"),
    COMPUTERS("COMPUTERS", "Computers", "/computers"),
    ELECTRONICS("ELECTRONICS", "Electronics", "/electronics"),
    APPAREL_AND_SHOES("APPAREL&SHOES", "Apparel & Shoes", "/apparel-shoes"),
    DIGITAL_DOWNLOADS("DIGITAL DOWNLOADS", "Digital downloads", "/digital-downloads"),
    JEWELRY("JEWELRY", "Jewelry", "/jewelry"),
    GIFT_CARDS("GIFT CARDS", "Gift Cards", "/gift-cards");

    private String itemUIName;
    private String itemTagTextName;
    private String pageUrl;

    HeaderMenuPageTitle(String itemUIName, String itemTagTextName, String pageUrl) {
        this.itemTagTextName = itemTagTextName;
        this.itemUIName = itemUIName;
        this.pageUrl = pageUrl;
    }

    public static HeaderMenuPageTitle getTagNameByTextItem(String tagTextName) {
        return Arrays.stream(HeaderMenuPageTitle.values())
                .filter(value -> value.itemTagTextName.equalsIgnoreCase(tagTextName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such enum with provided tagTextName"));
    }
}
