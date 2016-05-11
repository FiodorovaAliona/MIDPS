<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>News!</title>
<script type="text/javascript" src="jquery.js"></script>
</head>
<body style="background-image:url(../images/3.jpg)">
<h1>Chisinau news</h1>

<?php
echo '<p style="text-align: center">Больше новостей!</p>';

?>
<style>
.center { 
text-align: center; 
}
</style>
<div class = "center">
<button id="Change" onclick="loadLog();">Ещё</button>
</div>
<div class = "center" id="result"></div><br /><br />
<?php
echo '';
?>

<script type="text/javascript">
$( document ).ready(function() {
loadLog();
});
function SendPost() {
//отправляю POST запрос и получаю ответ
$$a({
type:'post',//тип запроса: get,post либо head
url:'ajax.php',//url адрес файла обработчика
data:{'z':'1'},//параметры запроса
response:'json',//тип возвращаемого ответа text либо xml
success:function (data) {//возвращаемый результат от сервера
$$('result','<br />'+data);
}
});
}

	
function loadLog(){ 
$.ajax({ 
type: 'GET', 
url: 'ajax.php', 
data: { z: '1' }, 
dataType: 'json', 
success: function (data) { 
var html='<br><br><table id="myTableId" border=`1` align="center">'; 
$.each(data, function(index, element) { 
html += '<tr>'; 
html += "<td><img src='"+element.link+"' style='width:800px;height:240px;'></td>"; 
html += '</tr>'; 
}); 
html += '</table>'; 
$('#result').html(html); 
} 
}); 
}

</script>
</body>
