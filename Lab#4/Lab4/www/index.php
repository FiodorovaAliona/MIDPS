<html>

<head>

<meta http-equiv="Content-Type" content="text/html;
 Charset=UTF-8">

<title>News!</title>

</head>

<body style="background-image:url(../images/3.jpg)">


<h1>Chisinau news</h1>
<p style="background-color:#ff9900" align="center">Свежие новости</p>
<p style="background-color:#417ed0" align="center">Только у нас</p>



<?php 
echo '<p style="text-align: center">Мы приветствуем Вас на нашем сайте</p>';
 
echo '<p style="text-align: center">Нажмите на кнопку для просмотра новостей</p>';

?>

<form action="index.php" method="get" style="text-align: center">

<style type="text/css">
ul
 li {list-style:none;
 display:inline;
 background-color:#99ccff;
 padding:2px}

</style>


<input type="submit" name="button" value="Больше новостей!" />

</form>
<?php
if (isset($_GET['button'])) {
 echo '<meta http-equiv="refresh" content="0; midps.php">'; // перенаправление на нужную страницу
exit();
}
?>
</body>
</html>
