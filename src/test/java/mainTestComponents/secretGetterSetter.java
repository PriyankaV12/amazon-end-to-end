// not used at all- deletet  this class

package mainTestComponents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class secretGetterSetter {

    public secretGetterSetter(){

    }

    public secretValues mainS() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/java/resources/secrets.yaml");
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());

        secretValues secrets =objectMapper.readValue(file,secretValues.class);
        return secrets;

    }



}
