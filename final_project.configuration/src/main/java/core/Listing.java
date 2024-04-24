package core;

public class Listing {
	private int listing_id;
    private int city_id;
    private int category_id;
    private int agent_id;
    private int offer_id;
    private int property_type_id;
    private int documents_id;
    private int bedrooms;
    private int bathrooms;
    private double square_footage;
    private double price;

    public int getListing_id() {
        return listing_id;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getProperty_type_id() {
        return property_type_id;
    }

    public void setProperty_type_id(int property_type_id) {
        this.property_type_id = property_type_id;
    }

    public int getDocuments_id() {
        return documents_id;
    }

    public void setDocuments_id(int documents_id) {
        this.documents_id = documents_id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getSquare_footage() {
        return square_footage;
    }

    public void setSquare_footage(double square_footage) {
        this.square_footage = square_footage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}