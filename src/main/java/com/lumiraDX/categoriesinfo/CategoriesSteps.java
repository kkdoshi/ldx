package com.lumiraDX.categoriesinfo;

import com.lumiraDX.constants.EndPoints;
import com.lumiraDX.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

public class CategoriesSteps {

    public ValidatableResponse createNewCategory(String name){
        CategoriesPojo categoriesPojo = CategoriesPojo.getCategoryPojo(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post(EndPoints.CATEGORIES)
                .then();
    }

    public ValidatableResponse getAllCategories(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.CATEGORIES)
                .then();
    }

    public ValidatableResponse getCategoryById(int iD){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", iD)
                .when()
                .get(EndPoints.GETID)
                .then();
    }
}
