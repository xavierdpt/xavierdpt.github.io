<?php
function getParam($name) {
  if(isset($_GET[$name])) {
    return $_GET[$name];
  }
  return '';
}

function postParam($name) {
  if(isset($_POST[$name])) {
    return $_POST[$name];
  }
  return '';
}

function sessionParam($name) {
  if(isset($_SESSION[$name])) {
    return $_SESSION[$name];
  }
  return '';
}
?>