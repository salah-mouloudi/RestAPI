package posts;

import base.TypicodeAPIClient;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PostsAPIClient extends TypicodeAPIClient {

    private String POSTS_ENDPOINT = "/posts";

    public ValidatableResponse getAllPosts() {
        return when().get(this.baseUri + POSTS_ENDPOINT).then();
    }

    public ValidatableResponse createPost(Object json) {
        return given().header("Content-Type", "application/json")
                      .body(json)
                      .when()
                      .post(this.baseUri + POSTS_ENDPOINT)
                      .then();
    }

}
