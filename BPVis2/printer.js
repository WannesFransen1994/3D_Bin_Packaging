function submitform() {
    $.getJSON('http://localhost:8080/api/containersetup', $("form").serialize(), function (data) {
        $("div").empty();
        generateContainerLayers(data);
    });
}






var renderer, stage, layers, rect, layerCounter, containerCounter;

function generateContainerLayers(obj) {

    containerCounter = 0;
    var totalAmount = 0;
    var mHeader = $("<div id=\"hMb\" class = header-wrapper>");
    var sC = $("<div id=\"hSc\" class = site-name>");
    var cont = $("<div id=\"cont\" class = container>");
    var divtag2 = $("<div id=\"bl\" class = block>");

    $("#visualisation").append(Main);
    $("#visualisation").append(Menu);
    $("#visualisation").append(cont);


    var mainHeader = $("<h1>BOX VISUALIZATION</h1>");
    var subHeader = $("<h2>Storeganizer</h2>");






    $("#Main").append(sC);
    $("#hSc").append(mainHeader);
    $("#hSc").append(subHeader);




    obj.forEach(function (entry) {
        layerCounter = 0;
        containerCounter++;

        console.log(entry[0])
        var locations = entry[0].items;
        var volumeContainer=entry[0].length*entry[0].width*entry[0].height;
        var volumeObject = locations[0][1].height*locations[0][1].width*locations[0][1].length;
        var itemsamount = locations.length;

        totalAmount += itemsamount;

        layers = calculateZvalues(locations);



        var infoInput = $("<sarah_h2> Length: "+locations[0][1].length+"&emsp; Width: "+locations[0][1].width+ "&emsp; Height: "+locations[0][1].height+ "&emsp; Amount: "+totalAmount+"</sarah_h2>");
        $("#Menu").html(infoInput);





        var divtag = $("<div id=\"containerdiv" + containerCounter + "\" class=featured-item>");

        $("#cont").append(divtag);

        var header = $("<sarah2>Container " + entry[0].length + " x " + entry[0].width + " x " + entry[0].height + "</sarah2><br><br>");
        var intro = $("<sarah3>This container has to be filled <b>" +entry[1] + " </b>times and will contain <b>" + locations.length + "</b> items.</sarah3><br>");
        var volume = $("<sarah3>Volume utilization: <b>"+ roundToTwo(((volumeObject*itemsamount)/(volumeContainer))*100)+"\%</b></sarah3><br>");
        $("#containerdiv" + containerCounter).append(header);
        $("#containerdiv" + containerCounter).append(intro);
        $("#containerdiv" + containerCounter).append(volume);

        layers.sort(sortNumber);
        layers.forEach(function (zvalue) {
            layerCounter++;
            divtag = $("<div id=\"layer" + containerCounter + "" + layerCounter + "\"style=\'float: left\' class=layer>");
            var layertekst = $("<sarah3>Layer " + layerCounter + "  height: " + zvalue + "</sarah3><br>");
            $("#containerdiv" + containerCounter).append(divtag);
            $("#layer" + containerCounter + "" + layerCounter).append(layertekst);
            renderer = PIXI.autoDetectRenderer(entry[0].length, entry[0].width, {
                transparent: false, //create tranparent
                backgroundColor: '0x86D0F2' //create backgroundColor
            });

            $("#layer" + containerCounter + "" + layerCounter).append(renderer.view); // 2. Append canvas element to the body
            stage = new PIXI.Container(); // 3. Create a container that will hold your scene

            for (var i = 0; i < locations.length; i++) {
                rect = new PIXI.Graphics();
                rect.beginFill(0x709FE9, 1); // define fill and rectangle size
                var object = locations[i];
                if (object[0].coordinate_z == zvalue) {
                    rect.lineStyle(1, 0x00000);
                    rect.drawRect(object[0].coordinate_x, object[0].coordinate_y,
                        object[1].length, object[1].width); // x, y, width, height
                    rect.endFill();
                    stage.addChild(rect);
                }
            }
            render(); // add stage to the canvas

        })


    })


}


function calculateZvalues(locations) {
    layers = [];
    for (var i = 0; i < locations.length; i++) {
        if ($.inArray(locations[i][0].coordinate_z, layers) < 0) {
            layers.push(parseInt(locations[i][0].coordinate_z));
        }
    }
    return layers;
}

function sortNumber(a,b) {
    return a - b;
}

function render() {
    renderer.render(stage);
}

function roundToTwo(num) {
    return +(Math.round(num + "e+2")  + "e-2");
}