package test.java.com.cucumberwithrestassured.datamodels.jsonserver;

import lombok.Builder;
import lombok.Data;
import test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.CommentsGetResponseDataModel;
import test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.ProfileGetResponseDataModel;
import test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.posts.PostsGetResponseDataModel;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class DbJsonServerGetResponseDataModel {
    /*
    *{
  "posts": [
    {
      "id": "1",
      "title": "a title",
      "views": 100
    },
    {
      "id": "2",
      "title": "another title",
      "views": 200
    },
    {
      "id": "f990",
      "title": "Bharath Nadukatla SDET",
      "views": 350
    }
  ],
  "comments": [
    {
      "id": "1",
      "text": "a comment about post 1",
      "postId": "1"
    },
    {
      "id": "2",
      "text": "another comment about post 1",
      "postId": "1"
    }
  ],
  "profile": {
    "name": "Bharath"
  }
}
    * */
    private List<PostsGetResponseDataModel> postsData;
    private List<CommentsGetResponseDataModel> commentsData;
    private String profileData;


}
