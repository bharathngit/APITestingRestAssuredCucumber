package test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsPutRequestData {
    /*
    *
    * {"title":"Bharath Nadukatla SDET","views":350}
    *
    * */
    private String title;
    private int views;


}
