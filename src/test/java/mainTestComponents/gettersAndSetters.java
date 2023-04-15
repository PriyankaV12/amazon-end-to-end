package mainTestComponents;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class gettersAndSetters {

    public ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());

    public deriveValues mainT() throws Exception {
        File file = new File("/Users/priyankaverma/amazonFramework/src/main/java/resources/data.yaml");
        deriveValues values=objectMapper.readValue(file,deriveValues.class);
        System.out.println(values.getValidEmail());
        System.out.println(values.getDriverKey());
        return values;
    }


    public deriveValues mainS() throws IOException {
        File file = new File("/Users/priyankaverma/amazonFramework/src/main/java/resources/secrets.yaml");
        deriveValues secrets =objectMapper.readValue(file,deriveValues.class);
        System.out.println(secrets.getDriverKey());
        System.out.println(secrets.getValidEmail());
        return secrets;

    }

}


//public class gettersAndSetters<deriveValues,secretValues> {
//    public final deriveValues values;
//    public final secretValues secrets;
//    ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
//
////    public List<object>  ghgjhj mainT() throws Exception {
////        File file = new File("/Users/priyankaverma/amazonFramework/src/main/java/resources/data.yaml");
////        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
////
////        deriveValues values=objectMapper.readValue(file,deriveValues.class);
////     //   System.out.println("Application config info " + values.getBrowser());
////
////        File sfile = new File("/Users/priyankaverma/amazonFramework/src/main/java/resources/secrets.yaml");
////        secretValues secrets =objectMapper.readValue(file,secretValues.class);
////
////        return values, secrets;
////    }
//
//    public gettersAndSetters(deriveValues values, secretValues secrets) {
//
//        this.values = values;
//        this.secrets = secrets;
//    }
//
////    public secretValues mainS() throws IOException {
////        File file = new File("/Users/priyankaverma/amazonFramework/src/main/java/resources/secrets.yaml");
////        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
////        secretValues secrets =objectMapper.readValue(file,secretValues.class);
////        return secrets;
////
////    }
//
//}

