package Controllers;

import com.bin.packaging.Model.OnlyTwoTypes;
import com.bin.packaging.PackagingFacade;
import com.bin.packaging.Model.TertiaryTreeAlgorithm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wannes Fransen.
 */
@RestController
public class ContainerSetupController {
    GsonBuilder builder = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting();
    Gson gson = builder.create();
    PackagingFacade facade = new PackagingFacade(new TertiaryTreeAlgorithm(), new OnlyTwoTypes());

    @RequestMapping("/api/testsetup")
    public String testSetup(){
        return gson.toJson(facade.getTranslatedSetup(20,50,45,38, 9));
    }

    @RequestMapping("/api/containersetup")
    public String containerSetup(@RequestParam("boxlength") int boxlength,@RequestParam("boxwidth") int boxwidth,@RequestParam("boxheight") int boxheight,@RequestParam("boxamount") int boxamount,@RequestParam("numberpockets") int pockets){
        return gson.toJson(facade.getTranslatedSetup(boxlength, boxwidth, boxheight, boxamount, pockets));
    }
}
