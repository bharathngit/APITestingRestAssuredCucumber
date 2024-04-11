package test.java.com.cucumberwithrestassured.datamodels.jsonserver.objectmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileGetResponseDataModel {
    /*
    *  "profile": {
    "name": "Bharath"
  }
    * */
    private Object name;
//    private String name;


}
