//num - номер комнаты, i - номер датчика
//1 - температура воздуха
//2 - влажность воздуха
//3 - освещение

function StopElement(name, num) {

    var svgobject = document.getElementById('imap');
    if ('contentDocument' in svgobject)
       var svgdom = svgobject.contentDocument;

    $("#" + name + "" + num,svgdom).css({fill: "#ffffff"});
    $("#" + name + "" + num,svgdom).css({background: "#ffffff"});
}
function RunElement(name, num, color) {

    var svgobject = document.getElementById('imap');
    if ('contentDocument' in svgobject)
        var svgdom = svgobject.contentDocument;

    $("#" + name + "" + num,svgdom).css({fill: color});
    $("#" + name + "" + num,svgdom).css({background: color});
}

function Sending(num,i,id) {


    var val = $("#"+id).val();
    alert
    $.ajax({
        type : "GET",
        url : "/ajaxSend",
        data : "num=" + num + "&i=" + i + "&val=" + val,
        timeout : 100000,
        success : function(data) {
            switch (data)
            {
                case "stop":
                {
                    if(i==1 && (num==1 || num==2)) StopElement("battery",num);
                    if(i==2) StopElement("wet",num);
                    if(i==3) StopElement("light",num);
                    break;
                }
                case "runBattery":
                {
                    if(num==1 || num==2)
                    {
                        RunElement("battery",num,"#f90000");
                        StopElement("cooler",num);
                    }
                    break;
                }
                case "runCooler":
                {
                    if(num==1 || num==2)
                    {
                        StopElement("battery", num);
                    }
                    RunElement("cooler",num,"#7135F9");
                    break;
                }
                case "runWet":
                {
                    RunElement("wet",num,"#7135F9");
                    break;
                }
                case "runLight":
                {
                    RunElement("light",num,"orange");
                    break;
                }
            }
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}

