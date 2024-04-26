package core;

public class PercentageOffer implements OfferType{
	 private double percentage;

	    public PercentageOffer(double percentage) {
	        this.percentage = percentage;
	    }

	    @Override
	    public String applyOffer(double originalPrice) {
	        double discountedPrice = originalPrice - (originalPrice * percentage / 100);
	        return String.format("%.2f%% off: $%.2f", percentage, discountedPrice);
	    }
}