package test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsPostResponseDataModel {
    /*
    *
    * {
    "id": "75f3",
    "postsTitle": "New Post",
    "postsViews": 120
}
    *
    * */
    private String id;
    private String title;
    private int views;

}
