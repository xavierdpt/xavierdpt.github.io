<?php

include_once __DIR__.'/../includes/functions.php';

include '../includes/init.php';
$action = getParam('action','');
$example = getParam('example','');
$pp = new Page();
if(!$action && !$example) {
  $action='welcome';
}

$found = FALSE;
$method = $_SERVER['REQUEST_METHOD'];

if($action) {
  if($action=='search') {
    $found = TRUE;
    $pp->writeHeader();
    echo '<p>You want to search</p>';
    $pp->writeFooter();
  } else if($action=='welcome') {
    $pp = new WelcomePage();
    $pp->write();
    $found=TRUE;
  } else if($action=='login') {
    $pp = new LoginPage();
    $pp->write();
    $found = TRUE;
  } else if($action=='test') {
    $pp = new TestPage();
    $pp->write();
    $found = TRUE;
  }
} else if($example) {
    $pp = new ExamplePage($example);
    $pp->write();
    $found = TRUE;
}
if(!$found) {
    // 404
    http_response_code(404);
    include(__DIR__.'/../error.php');
}
?>