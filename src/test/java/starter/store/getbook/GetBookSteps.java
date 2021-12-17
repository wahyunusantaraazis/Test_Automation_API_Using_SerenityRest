package starter.store.getbook;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GetBookSteps {
    //comment
    @Steps
    GetBook getBook;

    @Given("I have ISBN for see details book")
    public void i_have_ISBN_for_see_details_book() {

    }

    @When("I want to see certain book by ISBN")
    public void i_want_to_see_certain_book_by_ISBN() {
        getBook.hitEndpointGetBook();
    }

    @Then("status code {int} and correct Response Body")
    public void status_code_and_correct_Response_Body(Integer int1) {
       //getBook.validateJSONSchemaGetBook();
    }
}
