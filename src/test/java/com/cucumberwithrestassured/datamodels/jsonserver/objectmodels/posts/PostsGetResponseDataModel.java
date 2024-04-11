package test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.posts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.StreamReadFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class PostsGetResponseDataModel {
    /*
    *[ {
      "id": "1",
      "title": "a title",
      "views": 100
    }]
    * */

//    private List<PostsObjectData> posts;
    private String id;
    private String title;
    private int views;

}
