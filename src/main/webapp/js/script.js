// Начинаем работу когда страница полностью загружена (включая графику)
$(window).load(function () {
    // Получаем доступ к SVG DOM
    var svgobject = document.getElementById('imap');
    if ('contentDocument' in svgobject)
        var svgdom = svgobject.contentDocument;

    // Хак для WebKit (чтобы правильно масштабировал нашу карту)
    var viewBox = svgdom.rootElement.getAttribute("viewBox").split(" ");
    var aspectRatio = viewBox[2] / viewBox[3];
    svgobject.height = parseInt(svgobject.offsetWidth / aspectRatio);


    // Подсвечиваем строку в таблице при наведении мыши на соотв. регион на карте
    $(svgdom.getElementsByClassName("input")).hover(
        function () {
            var id = $(this).attr("id");
            $("#inputs #"+id).css({background: "orange"});
            $("#"+id, svgdom).css({ fill: "orange" });
        },
        function () {
            var id = $(this).attr("id");
            $("#inputs #"+id).css({background: "white"});
            $("#"+id, svgdom).css({ fill: "black" });
        }
    );
}
)

