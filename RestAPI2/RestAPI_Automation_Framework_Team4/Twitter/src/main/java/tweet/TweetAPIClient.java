package tweet;

import base.TwitterAPIClient;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class TweetAPIClient  extends TwitterAPIClient {
    // https://developer.twitter.com/en/docs/tweets/timelines/api-reference/get-statuses-user_timeline
    // Tweet Client class that consists of all the different API's of Twitter's Tweet
    // POST: Retrieve and engage with tweets....

    private final String CREATE_TWEET_ENDPOINT="/statuses/update.json";
    private final String DELETE_TWEET_ENDPOINT="/statuses/destroy.json";
    private final String GET_USER_TWEETS_ENDPOINT="statuses/user_timeline.json";
    private final String SEARCH_TWEETS_ENDPOINT = "/search/tweets.json";
    private final String ADD_FAVORITES_ENDPOINT = "/search/tweets.json";
    private final String GET_PLACES_NEAR_ENDPOINT = "/geo/reverse_geocode.json";

    public ValidatableResponse getUserTimelineTweets(){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUri+this.GET_USER_TWEETS_ENDPOINT)
                .then();
    }

// Create a tweet from user's twitter
    public ValidatableResponse createTweet(String tweet){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status",tweet)
                .when().post(this.baseUri+this.CREATE_TWEET_ENDPOINT)
                .then();
    }

    // Delete a tweet from the user's twitter
    public ValidatableResponse deleteTweet( Long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUri+this.DELETE_TWEET_ENDPOINT)
                .then();
    }
    public ValidatableResponse searchTweets(String atUsername){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("q", atUsername)
                .when().get(this.baseUri+this.SEARCH_TWEETS_ENDPOINT)
                .then(); }

    public ValidatableResponse ADDFAVORITESENDPOINT(String atUsername){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("q", atUsername)
                .when().get(this.baseUri+this.ADD_FAVORITES_ENDPOINT)
                .then(); }
    public ValidatableResponse GETPLACESNEARENDPOINT(String atUsername){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("q", atUsername)
                .when().get(this.baseUri+this.GET_USER_TWEETS_ENDPOINT)
                .then(); }


}
