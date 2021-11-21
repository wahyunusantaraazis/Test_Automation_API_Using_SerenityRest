package starter.store.getallbooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GetAllBooksSteps {

    @Steps
    GetAllBooks getallbooks;

    @Given("I am ready see all books in bookstore")
    public void i_am_ready_see_all_books_in_bookstore() {

    }

    @When("I want to see list in bookstore by ISBN")
    public void i_want_to_see_list_in_bookstore_by_ISBN() {
        getallbooks.hitEndpointGetAllBooks();
    }

    @Then("status code {int} and correct JSONScema")
    public void status_code_and_correct_JSONScema(Integer int1) {
        getallbooks.validateJSONSchemaGetAllBooks();
    }
}
