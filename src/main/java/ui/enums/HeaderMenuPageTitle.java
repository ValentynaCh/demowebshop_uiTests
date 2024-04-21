package ui.enums;


import lombok.Getter;

import java.util.Arrays;

@Getter
public enum HeaderMenuPageTitle {
    BOOKS("BOOKS", "Books", "https://demowebshop.tricentis.com/books"),
    COMPUTERS("COMPUTERS", "Computers", "https://demowebshop.tricentis.com/computers"),
    ELECTRONICS("ELECTRONICS", "Electronics", "https://demowebshop.tricentis.com/electronics"),
    APPAREL_AND_SHOES("APPAREL&SHOES", "Apparel & Shoes", "https://demowebshop.tricentis.com/apparel-shoes"),
    DIGITAL_DOWNLOADS("DIGITAL DOWNLOADS", "Digital downloads", "https://demowebshop.tricentis.com/digital-downloads"),
    JEWELRY("JEWELRY", "Jewelry", "https://demowebshop.tricentis.com/jewelry"),
    GIFT_CARDS("GIFT CARDS", "Gift Cards", "https://demowebshop.tricentis.com/gift-cards");

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
