$.getJSON('http://localhost:8080/api/testsetup',$("form").serialize(),function (data) {
    $("div").empty();
    generateContainerLayers(data);
});

function submitform() {
    $.getJSON('http://localhost:8080/api/containersetup',$("form").serialize(),function (data) {
        $("div").empty();
        generateContainerLayers(data);
    });
}


var renderer, stage, layers, rect, counter;

function generateContainerLayers(obj) {
    obj.forEach(function (entry) {
        counter = 1;
        var locations = entry[0].items;
        layers = calculateZvalues(locations);
        var header = $("<h1>Container " + entry[0].length + " x " + entry[0].width + " x " + entry[0].height + "</h1>");
        var intro = $("<p>This container has to be filled " + entry[1] + " times and will contain " + locations.length + " items.</p>");
        $("#visualisation").append(header);
        $("#visualisation").append(intro);

        var divtag= $("<div id=\"containerdiv\" style='float'>");
        $("#visualisation").append(divtag);
        layers.sort();
        layers.forEach(function (zvalue) {
            divtag = $("<div id=\"layer"+counter+"\">");
            var layertekst = $("<i>Layer " + counter + "</i><br>");
            $("#visualisation").append(divtag);
            $("#visualisation").append(layertekst);
            counter++;
            renderer = PIXI.autoDetectRenderer(entry[0].length, entry[0].width, {
                transparent: false, //create tranparent
                backgroundColor: '0x86D0F2' //create backgroundColor
            });

            $("#visualisation").append(renderer.view);// 2. Append canvas element to the body
            stage = new PIXI.Container();// 3. Create a container that will hold your scene

            for (var i = 0; i < locations.length; i++) {
                rect = new PIXI.Graphics();
                rect.beginFill(0x709FE9, 1);// define fill and rectangle size
                var object = locations[i];
                if (object[0].coordinate_z == zvalue) {
                    rect.lineStyle(1, 0x00000);
                    rect.drawRect(object[0].coordinate_x, object[0].coordinate_y,
                        object[1].length, object[1].width);// x, y, width, height
                    rect.endFill();
                    stage.addChild(rect);
                }
            }
            render();// add stage to the canvas
            $("#visualisation").append("</div>");
        })
        $("#visualisation").append("</div>");
    })
}


function calculateZvalues(locations) {
    layers = [];
    for (var i = 0; i < locations.length; i++) {
        if ($.inArray(locations[i][0].coordinate_z, layers) < 0) {
            layers.push(locations[i][0].coordinate_z);
        }
    }
    return layers;
}

function render() {
    renderer.render(stage);
}


