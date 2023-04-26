package tests;

import mainTestComponents.BaseTest;
import mainTestComponents.deriveValues;
import mainTestComponents.retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.productDetailsPage;


public class productDetails extends BaseTest {

    public deriveValues values;
    public productDetailsPage details;

    public productDetails() throws Exception {
        this.values= mainT();
    }


    @Test
    public void verifyImage() {

        details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
        boolean image = details.imageDisplay();
        Assert.assertTrue(image, values.getPresent());
    }

    @Test
    public void verifyPrice() throws InterruptedException {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
        String price = details.setPriceDisplay();
       Assert.assertTrue(price.equalsIgnoreCase(values.getPriceOfProduct()));
    }

    @Test
    public void productReviews()
    {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
        boolean reviewText = details.verifyReview();
        Assert.assertTrue(reviewText, values.getPresent());

    }

    @Test
    public void productSpecifications()
    {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch());
        boolean specifications = details.verifyProductSpecifications();
        Assert.assertTrue(specifications, values.getPresent());
    }

    @Test
    public void stockInfo()
    {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
        String availability = details.verifyStock();
        Assert.assertTrue(availability.equalsIgnoreCase(values.getStock()));
    }

    @Test(retryAnalyzer = retry.class)
    public void productSellerRating()
    {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
        boolean sellerRating = details.verifySellerRating();
        Assert.assertTrue(sellerRating, values.getPresent());
    }

    @Test
    public void productDescription()
    {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
       boolean description = details.verifyProductDescription();
       Assert.assertTrue(description, values.getPresent());

    }

    @Test
    public void productSuggestions()
    {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
       boolean suggestions = details.verifyProductSuggestions();
       Assert.assertTrue(suggestions, values.getPresent());
    }

    @Test
    public void shippingInfo()
    {
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
       boolean shipping = details.verifyShippingInformation();
       Assert.assertTrue(shipping, values.getPresent());
    }

}
