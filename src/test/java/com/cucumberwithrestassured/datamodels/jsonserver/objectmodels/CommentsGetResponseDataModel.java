package test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentsGetResponseDataModel {
    /*
    * {
      "id": "1",
      "text": "a comment about post 1",
      "postId": "1"
    }
    * */
    private String commentsId;
    private String commentsText;
    private String commentsPostId;


}
