package step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import requestPojo.Order;
import utils.APIResources;
import utils.SpecBuilder;
import utils.TestDataBuild;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class MyStepdefsAPI {

    private RequestSpecification requestSpec;
    SessionFilter sessionFilter = new SessionFilter();
    private Response response;
    APIResources apiResource;
    Order order = new Order();
    TestDataBuild data = new TestDataBuild();
    public static long newOrderId;
    public static long code;

    @Given("The Swagger Pet API is running")
    public void theSwaggerPetAPIIsRunning(){
        // No Code Needed
    }

    @When("I create a new order with the following given pet {string} {string}")
    public void iCreateANewOrderWithTheFollowingGivenPet(String id, String petId) throws IOException {
        int sId =Integer.parseInt(id);
        int sPetId =Integer.parseInt(petId);

        requestSpec = given().spec(SpecBuilder.requestSpecification())
                .body(data.createPetStoreIdPayload(sId,sPetId)).filter(sessionFilter);
    }

    @Then("The API should respond for {string} API with a new order ID")
    public void theAPIShouldRespondForAPIWithANewOrderID(String resource) {

        apiResource =  APIResources.valueOf(resource);
        response = requestSpec.when().post(apiResource.getResource());
        newOrderId = response.jsonPath().getInt("id");

    }

    @And("The API should respond with a status code of {int}")
    public void theAPIShouldRespondWithAStatusCodeOf(int statusCode) {
        int statusCodeActual= response.statusCode();
        Assert.assertEquals(statusCode,statusCodeActual);
    }

    @And("An order with ID {string} exists")
    public void anOrderWithIDExists(String orderId) {
        int iOrderId = Integer.parseInt(orderId);
        order = response.then().extract().response().as(Order.class);
        Assert.assertEquals(order.getId(),iOrderId,"** The oder ID exists **");
    }

    @When("I retrieve the details from with given order id")
    public void iRetrieveTheDetailsFromWithGivenOrderId() throws IOException {
        requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter)
                .pathParam("orderId",newOrderId);
    }

    @Then("The {string} API should respond with the order details")
    public void theAPIShouldRespondWithTheOrderDetails(String resource) {
        apiResource =  APIResources.valueOf(resource);
        response = requestSpec.when().get(apiResource.getResource());

    }


    @When("I delete the order with ID {string}")
    public void iDeleteTheOrderWithID(String orderId) throws IOException {
        requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter)
                .filter(sessionFilter).pathParam("orderId",orderId);
    }

    @Then("The order should be deleted from the system using {string} API")
    public void theOrderShouldBeDeletedFromTheSystemUsingAPI(String resource) {
        apiResource =  APIResources.valueOf(resource);
        response = requestSpec.when().delete(apiResource.getResource());
    }

    @When("I add a new pet with the following given pet details {string} {string} {string}")
    public void iAddANewPetWithTheFollowingGivenPetDetails(String categoryId, String categoryName, String petName) throws IOException {
        requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter)
                .body(data.addPetPayload(0,categoryId,categoryName,petName,""));
    }

    @Then("The API should respond for {string} API with a new added pet ID")
    public void theAPIShouldRespondForAPIWithANewAddedPetID(String resource) {
        apiResource =  APIResources.valueOf(resource);

        response = requestSpec.when().post(apiResource.getResource());

        if(resource.equalsIgnoreCase("ADDPET")) {
            code = response.jsonPath().get("id");
        }
        if(resource.equalsIgnoreCase("UPLOADIMAGE")) {
            code = response.jsonPath().getInt("code");
            Assert.assertEquals(code,200,"** The pet image is uploaded **");
        }
    }

    @When("I upload the pet image with {string} and {string}")
    public void iUploadThePetImageWithAnd(String petId, String filePath) throws IOException {

        requestSpec = given().spec(SpecBuilder.requestSpecificationWithMultipart())
                .pathParam("petId",petId)
                .multiPart("file", new java.io.File(filePath));

    }

    @And("Now I update the pet details with new details {string}")
    public void nowIUpdateThePetDetailsWithNewDetails(String newPetName) throws IOException {
        requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter)
                .body(data.addPetPayload(code,"0","dogs",newPetName,"")).filter(sessionFilter);

    }

    @Then("The API should respond for {string} API with updated details {string}")
    public void theAPIShouldRespondForAPIWithUpdatedDetails(String resource, String newNameExpected) {
        apiResource =  APIResources.valueOf(resource);
        response = requestSpec.when().put(apiResource.getResource());
        String NewNameActual = response.jsonPath().getString("name");
        Assert.assertEquals(newNameExpected,NewNameActual," ** The New name for pet is updated **");
    }

}
