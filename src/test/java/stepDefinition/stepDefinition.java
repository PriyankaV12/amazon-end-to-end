package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainTestComponents.BaseTest;
import pageObjects.landingPage;

import java.io.IOException;

public class stepDefinition extends BaseTest {

    public landingPage lp;

    public stepDefinition() throws Exception {
    }

    @Given("^Land on Amazon website$")
    public void Land_on_Amazon_website() throws IOException, InterruptedException {
        lp = launchApplication();
    }

    @Given("^click on SignIn button and navigate back to home page$")
    public void clicked_on_SignIn_button_and_navigate_back_to_home_page()
    {
        lp.signInHover();
        lp.signIn();
    }

    @When("^try to click on footer links and get the titles$")
    public void try_to_click_on_footer_links_and_get_the_titles() throws InterruptedException {
     //   lp.prime();
        lp.footerLinkCount();
        lp.firstColumnTitles();
        lp.secondColumnTitles();
    }

    @And("^Hover on other functional tabs and send keys (.+) to text box$")
    public void Hover_on_other_functional_tabs_and_send_keys_to_text_box(String keys) throws InterruptedException {
        lp.textBox(keys);
        lp.languageHover();
        lp.amazonLogo();
        lp.setCopyrightSection();
        lp.setSecureSignIn();

    }

    @Then("^get the count of top rated product links$")
    public void get_the_count_of_top_rated_product_links()
    {
        lp.topRatedProductLinks();
        driver.close();
    }











}
