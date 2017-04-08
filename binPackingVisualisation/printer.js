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
        $("div").append(header);
        $("div").append(intro);


        layers.sort();
        layers.forEach(function (zvalue) {
            var layertekst = $("<br><i>Layer " + counter + "</i><br>");
            counter++;
            $("div").append(layertekst);
            renderer = PIXI.autoDetectRenderer(entry[0].length * 3, entry[0].width * 3, {
                transparent: false, //create tranparent
                backgroundColor: '0x86D0F2' //create backgroundColor
            });

            $("div").append(renderer.view);// 2. Append canvas element to the body
            stage = new PIXI.Container();// 3. Create a container that will hold your scene

            for (var i = 0; i < locations.length; i++) {
                rect = new PIXI.Graphics();
                rect.beginFill(0x709FE9, 1);// define fill and rectangle size
                var object = locations[i];
                if (object[0].coordinate_z == zvalue) {
                    //console.log(object);
                    rect.lineStyle(1, 0xFF000);
                    rect.drawRect(object[0].coordinate_x * 3, object[0].coordinate_y * 3,
                        object[1].length * 3, object[1].width * 3);// x, y, width, height
                    rect.endFill();
                    stage.addChild(rect);
                }
            }
            render();// add stage to the canvas
        })
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


