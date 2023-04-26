package mainTestComponents;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class gettersAndSetters extends deriveValues {


    public ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());


    public deriveValues mainT() throws Exception {
        File file = new File(  System.getProperty("user.dir") + "/src/main/java/resources/data.yaml");
        deriveValues values=objectMapper.readValue(file,deriveValues.class);
        System.out.println(values.getValidEmail());
        System.out.println(values.getDriverKey());
        return values;
    }


    public deriveValues mainS() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/java/resources/secrets.yaml");
        deriveValues secrets =objectMapper.readValue(file,deriveValues.class);
        System.out.println(secrets.getDriverKey());
        System.out.println(secrets.getValidEmail());
        return secrets;

    }

}



