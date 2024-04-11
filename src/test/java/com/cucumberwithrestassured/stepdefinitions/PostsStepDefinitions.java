package test.java.com.cucumberwithrestassured.stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.mapper.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import test.java.com.cucumberwithrestassured.datamodels.jsonserver.DbJsonServerGetResponseDataModel;
import test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.ProfileGetResponseDataModel;
import test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.posts.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static test.java.com.cucumberwithrestassured.requestspecification.PostsRequestSpecValidations.createJsonString;
import static test.java.com.cucumberwithrestassured.requestspecification.PostsRequestSpecValidations.getRequestSpecForPosts;
import static test.java.com.cucumberwithrestassured.responsespecifications.PostsResponseStatusCodesValidations.postsStatus200Ok;
import static test.java.com.cucumberwithrestassured.responsespecifications.PostsResponseStatusCodesValidations.postsStatus201Created;

public class PostsStepDefinitions {

    RequestSpecification requestSpecification;
    //   GET
    PostsGetResponseDataModel[] postsGetResponseDataModel;
    List<PostsGetResponseDataModel> postsList;
    DbJsonServerGetResponseDataModel dbJsonServerGetResponseDataModel;
    ProfileGetResponseDataModel profileGetResponseDataModel;

    //POST
    PostsPostResponseDataModel postsPostResponseDataModel;
    PostsPostRequestDataModel postsPostRequestDataModel;
    //PUT
    PostsPutRequestData postsPutRequest;
    PostsPutResponseData postsPutResponse;

    @Given("There are Posts")
    public void thereArePosts() throws Throwable{
        requestSpecification = given()
                                .spec(getRequestSpecForPosts())
//                                .log().all()
        ;
    }

    @When("I fetch all Posts as Json Array")
    public void iFetchAllPosts() throws Throwable{
        postsGetResponseDataModel = requestSpecification.when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .spec(postsStatus200Ok())
                .extract()
                .response()
                .as(PostsGetResponseDataModel[].class)
                ;
    }

    @When("I fetch all Posts as List using jsonpath")
    public void iFetchAllPostsJsonPath() throws  Throwable{
        postsList = requestSpecification.when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .spec(postsStatus200Ok())
                .extract()
                .body()
                .jsonPath()
                .getList(".", PostsGetResponseDataModel.class)
        ;
    }

    @Then("all the Posts are listed")
    public void allThePostsAreListed() throws Throwable {
        assertThat(Arrays.asList( postsGetResponseDataModel).get(2).getId(), is(equalTo("dd48")));
        assertThat(postsList.get(2).getId(), is(equalTo("dd48")));
    }


    @When("I create a new post")
    public void iCreateANewPost() throws Throwable{
        postsPostRequestDataModel = PostsPostRequestDataModel.builder()
                .title("New Post")
                .views(120)
                .build();

        postsPostResponseDataModel = requestSpecification
                .body(createJsonString(postsPostRequestDataModel))
                .when()
                .post()
                .then()
                .assertThat()
                .spec(postsStatus201Created())
                .log()
                .all()
                .extract()
                .response()
                .as(PostsPostResponseDataModel.class);
    }

    @Then("the Post is created")
    public void thePostIsCreated() throws Throwable{
        assertThat(postsPostResponseDataModel.getTitle(), is(equalTo("New Post")) );
    }

    @Then("the Post is updated")
    public void thePostIsUpdated() {
        assertThat(postsPutResponse.getViews(), is(equalTo(postsPutRequest.getViews())));
        assertThat(postsPutResponse.getTitle(), is(equalTo("New Post")));
    }

    @When("I create/update a post with id {string} and {int} views")
    public void iCreateOrUpdateAPost(String id, int views) throws JsonProcessingException {
        postsPutRequest = PostsPutRequestData.builder()
                .title("New Post")
                .views(views)
                .build();

        postsPutResponse = requestSpecification
                .when()
                .body(createJsonString(postsPutRequest))
                .put("/"+id)
                .then()
                .assertThat()
                .spec(postsStatus200Ok())
                .log()
                .all()
                .extract()
                .response()
                .as(PostsPutResponseData.class)

                ;
    }

    @When("I create a new post with {string} and {int}")
    public void iCreateANewPostWithAnd(String title, int views) throws JsonProcessingException {
        postsPostRequestDataModel = PostsPostRequestDataModel.builder()
                .title(title)
                .views(views)
                .build();

        postsPostResponseDataModel = requestSpecification
                .when()
                .body(createJsonString(postsPostRequestDataModel))
                .post()
                .then()
                .assertThat()
                .spec(postsStatus201Created())
                .log()
                .all()
                .extract()
                .response()
                .as(PostsPostResponseDataModel.class)
                ;
    }

    @Then("the Post with {string} is created")
    public void thePostWithIsCreated(String title) {
        assertThat(postsPostResponseDataModel.getTitle(), is(equalTo(title)));
    }

    @When("I create a new post with the following:")
    public void iCreateANewPostWithTheFollowing(Map<String, Integer> postsData) throws JsonProcessingException {
            for(Map.Entry<String, Integer> tileViews: postsData.entrySet())
                iCreateANewPostWithAnd(tileViews.getKey(),tileViews.getValue());
    }

    @Then("the Post with given titles is created")
    public void thePostWithGivenTitlesIsCreated() {
        assertThat(postsPostResponseDataModel.getTitle(), is(equalTo(postsPostRequestDataModel.getTitle())));
    }

    @When("I create a new post with the following table:")
    public void iCreateANewPostWithTheFollowingTable(List<Map> posts) throws JsonProcessingException {
        for(Map postMap: posts){
            iCreateANewPostWithAnd(String.valueOf(postMap.get("title")),  Integer.valueOf((String) postMap.get("views")));
        }

    }
}
