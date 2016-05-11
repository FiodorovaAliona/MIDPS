<?php
$servername = "Lab4";
$username = "Aliona";
$password = "Alionamidps";
$str1="";
$str2="";

$al_arr = array();
$link = mysql_connect($servername, $username, $password);
if (!$link) {
die('Could not connect: ' . mysql_error());
}
mysql_select_db('lab4');
$sql1 = mysql_query("SELECT `id`, `link` FROM `lab4` WHERE id = '".rand(1,30)."'");
while ($result1 = mysql_fetch_array($sql1)) {
$row['id'] = $result1['id'];
$row['link'] = $result1['link'];
array_push($al_arr,$row);
}
$sql2 = mysql_query("SELECT `id`, `link` FROM `lab4` WHERE id = '".rand(1,30)."'");
while ($result2 = mysql_fetch_array($sql2)) {
$row['id'] = $result2['id'];
$row['link'] = $result2['link'];
array_push($al_arr,$row);

}
if(isset($_GET['z'])) {
echo json_encode($al_arr);
}
//rand()
?>
