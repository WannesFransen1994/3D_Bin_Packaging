package Controllers;

import com.bin.packaging.Model.OnlyTwoTypes;
import com.bin.packaging.PackagingFacade;
import com.bin.packaging.Model.TertiaryTreeAlgorithm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.GET, value ="/api/containersetup")
    public String containerSetup(
            @RequestParam("box1Length") int box1Length,
            @RequestParam("box1Width") int box1Width,
            @RequestParam("box1Height") int box1Height,
            @RequestParam("box2Length") int box2Length,
            @RequestParam("box2Width") int box2Width,
            @RequestParam("box2Height") int box2Height,
            @RequestParam("columnLength") int columnLength,
            @RequestParam("columnWidth") int columnWidth,
            @RequestParam("columnHeight") int columnHeight,
            @RequestParam("columnAmount") int columnAmount,
            @RequestParam("pocketsNumber") int pocketsNumber){
        facade.setBoxSize(box1Length,box1Width,box1Height,box2Length,box2Width,box2Height);
        return gson.toJson(
                facade.getTranslatedSetup(
                        columnLength, columnWidth, columnHeight, columnAmount, pocketsNumber));
    }
}
