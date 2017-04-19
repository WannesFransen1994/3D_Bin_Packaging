function submitform() {
    $.getJSON('http://localhost:8080/api/containersetup', $("form").serialize(), function (data) {
        $("div").empty();
        generateContainerLayers(data);
    });
}


var renderer, stage, layers, rect, layerCounter, containerCounter;

function generateContainerLayers(obj) {
    containerCounter = 0;
    obj.forEach(function (entry) {
        layerCounter = 0;
        containerCounter++;
        console.log(entry[0])
        var locations = entry[0].items;
        var volumeContainer=entry[0].length*entry[0].width*entry[0].height;
        var volumeObject = locations[0][1].height*locations[0][1].width*locations[0][1].length;
        var itemsamount = locations.length;

        layers = calculateZvalues(locations);

        var divtag = $("<div id=\"containerdiv" + containerCounter + "\" class=container>");
        $("#visualisation").append(divtag);

        var header = $("<h1>Container " + entry[0].length + " x " + entry[0].width + " x " + entry[0].height + "</h1>");
        var intro = $("<p>This container has to be filled " + entry[1] + " times and will contain " + locations.length + " items.</p>");
        var volume = $("<p>Volume utilization: "+ volumeContainer/1000+"\/"+(volumeObject*itemsamount/1000)+"</p>");
        $("#containerdiv" + containerCounter).append(header);
        $("#containerdiv" + containerCounter).append(intro);
        $("#containerdiv" + containerCounter).append(volume);

        layers.sort(sortNumber);
        layers.forEach(function (zvalue) {
            layerCounter++;
            divtag = $("<div id=\"layer" + containerCounter + "" + layerCounter + "\"style=\'float: left\' class=layer>");
            var layertekst = $("<i>Layer " + layerCounter + "  height: " + zvalue + "</i><br>");
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