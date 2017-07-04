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

    @RequestMapping("/api/containersetup")
    public String containerSetup(
            @RequestParam("columnLength") int columnLength,
            @RequestParam("columnWidth") int columnWidth,
            @RequestParam("columnHeight") int columnHeight,
            @RequestParam("columnAmount") int columnAmount,
            @RequestParam("pocketsNumber") int pocketsNumber){
        return gson.toJson(
                facade.getTranslatedSetup(
                        columnLength, columnWidth, columnHeight, columnAmount, pocketsNumber));
    }
}
