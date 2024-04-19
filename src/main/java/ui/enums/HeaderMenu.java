package ui.enums;

public enum HeaderMenu {
    BOOKS("Books"),
    COMPUTERS("Computers"),
    ELECTRONICS("Electronics"),
    APPAREL_AND_SHOES("Apparel & Shoes"),
    DIGITAL_DOWNLOADS("Digital Downloads"),
    JEWELRY("Jewelry"),
    GIFT_CARDS("Gift Cards");

    private String headerName;

    HeaderMenu(String headerName) {
        this.headerName = headerName;
    }

    public String getHeaderName() {
        return this.headerName;
    }
}


