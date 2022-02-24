package com.lumiraDX.cucumber.steps;


import com.lumiraDX.categoriesinfo.CategoriesSteps;
import com.lumiraDX.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasValue;

public class CategoriesStepDefs extends TestUtils {

    static ValidatableResponse response;
    //static String name = TestUtils.getRandomText();
    static String catName = "TeamPostman";
    static List<Integer> newIdList;
    static List<String> newNameList;
    static List<Integer> oldIdList;
    static List<String> oldNameList;
    static int id;



    @Steps
    CategoriesSteps categoriesSteps;


    @When("^I create a new category$")
    public void iCreateANewCategory() {
        response = categoriesSteps.getAllCategories();
        oldIdList = response.extract().path("id");
        System.out.println("Old id list is : " + oldIdList);
        response = categoriesSteps.createNewCategory(catName);
        response.statusCode(201).log().ifValidationFails();
    }

    @And("^I extract the ID of the newly created category$")
    public void iExtractTheIDOfTheNewlyCreatedCategory() {

        response = categoriesSteps.getAllCategories();
        response.log().ifValidationFails();
        //idList = response.extract().path("response.findAll{it.name==" + name + "}.id");
        //idList = (List<Integer>) response.body(hasItem(hasValue("id")));
        //idList = response.extract().path("findAll{it.name=='" + name + "'}.id");

      newIdList = response.extract().path("id");
        System.out.println("The id list is : " + newIdList);
        newIdList.removeAll(oldIdList);
        System.out.println(newIdList);
        id = newIdList.get(0);
        System.out.println("The id is : " + id);
//        newIdList = response.extract().path("name");
//        System.out.println("The id list is : " + newNameList);
//        newNameList.removeAll(oldNameList);
//        System.out.println(newNameList);
//        catName = newNameList.get(0);
//        System.out.println("The name is : " + catName);
    }

    @Then("^I verifies the new category has been created successfully by ID$")
    public void iVerifiesTheNewCategoryHasBeenCreatedSuccessfullyByID() {
        response = categoriesSteps.getCategoryById(id);
        response.statusCode(200).log().ifValidationFails();
        System.out.println("The response is: " + response);
    }

    @When("^I read the newly created category by ID$")
    public void iReadTheNewlyCreatedCategoryByID() {
       response = categoriesSteps.getCategoryById(id);
       response.statusCode(200).log().all();
    }

    @Then("^I verify the new category has been created successfully$")
    public void iVerifyTheNewCategoryHasBeenCreatedSuccessfully() {
        //Bug!!
        System.out.println("Expected name is : " + catName);
        System.out.println("Actual name is : " + response.extract().path("name"));
        Assert.assertThat(response.extract().path("name"), hasValue(catName));
    }

    @And("^I ensure no duplicate records have been created$")
    public void iEnsureNoDuplicateRecordsHaveBeenCreated() {
    }

    @And("^I ensure that the new category name has no spelling errors$")
    public void iEnsureThatTheNewCategoryNameHasNoSpellingErrors() {
    }

    @When("^I update the newly created category \"([^\"]*)\"$")
    public void iUpdateTheNewlyCreatedCategory(String arg0) {

    }

    @Then("^I should verify that the update has been performed successfully$")
    public void iShouldVerifyThatTheUpdateHasBeenPerformedSuccessfully() {
    }

    @And("^I ensure that the updated category name has no spelling errors$")
    public void iEnsureThatTheUpdatedCategoryNameHasNoSpellingErrors() {
    }

    @When("^I delete the newly created category by ID$")
    public void iDeleteTheNewlyCreatedCategoryByID() {
    }

    @Then("^I should verify that the deletion has been performed successfully$")
    public void iShouldVerifyThatTheDeletionHasBeenPerformedSuccessfully() {
    }


}
