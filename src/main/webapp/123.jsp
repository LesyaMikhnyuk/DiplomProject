
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Интерактивная карта</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/send.js"></script>
</head>

<body>
<div class="container" style=" margin-left: 30%; width: 1050px;">
    <object data="my.svg" type="image/svg+xml" id="imap">
        <p>К сожалению, вы используете устаревшую версию браузера, который не поддерживает интерактивную карту.</p>
    </object>
</div>

<script type="text/javascript" src="js/script.js"></script>
<div class="container">
        <table id="cssTable" class="table table-sm table-bordered">
            <tbody>
            <tr style="background: black; color: white">
                <td>№ комнаты</td>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
            </tr>
            <tr>
                <td>Температура</td>
                <td><input class="textChange1" id="t1" maxlength="3" value="0" size="5" onchange="Sending(1,1,'t1')"></td>
                <td><input class="textChange1" id="t2" maxlength="3" value="0" size="5" onchange="Sending(2,1,'t2')"></td>
                <td><input class="textChange1" id="t3" maxlength="3" value="0" size="5" onchange="Sending(3,1,'t3')"></td>
                <td><input class="textChange1" id="t4" maxlength="3" value="0" size="5" onchange="Sending(4,1,'t4')"></td>
            </tr>
            <tr>
                <td>Влажность</td>
                <td><input class="textChange2" id="t5" maxlength="3" value="0" size="5" onchange="Sending(1,2,'t5')"></td>
                <td><input class="textChange2" id="t6" maxlength="3" value="0" size="5" onchange="Sending(2,2,'t6')"></td>
                <td><input class="textChange2" id="t7" maxlength="3" value="0" size="5" onchange="Sending(3,2,'t7')"></td>
                <td><input class="textChange2" id="t8" maxlength="3" value="0" size="5" onchange="Sending(4,2,'t8')"></td>
            </tr>
            <tr>
                <td>Освещение</td>
                <td><input class="textChange3" id="t9" maxlength="3" value="0" size="5" onchange="Sending(1,3,'t9')"></td>
                <td><input class="textChange3" id="t10" maxlength="3" value="0" size="5" onchange="Sending(2,3,'t10')"></td>
                <td><input class="textChange3" id="t11" maxlength="3" value="0" size="5" onchange="Sending(3,3,'t11')"></td>
                <td><input class="textChange3" id="t12" maxlength="3" value="0" size="5" onchange="Sending(4,3,'t12')"></td>
            </tr>
            </tbody>
        </table>
</div>
</body>
</html>

