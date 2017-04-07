package Controllers;

import com.bin.packaging.Model.OnlyTwoTypes;
import com.bin.packaging.PackagingFacade;
import com.bin.packaging.Model.TertiaryTreeAlgorithm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by erowan on 07/04/2017.
 */
@RestController
public class ContainerSetupController {
    GsonBuilder builder = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting();
    Gson gson = builder.create();
    PackagingFacade facade = new PackagingFacade(new TertiaryTreeAlgorithm(), new OnlyTwoTypes());

    @RequestMapping("/api/testsetup")
    public String containerSetup(){
        return gson.toJson(facade.getTranslatedSetup(20,50,45,38));
    }
}
