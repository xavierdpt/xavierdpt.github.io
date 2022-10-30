<?php
$configFile=__DIR__.'/config.php';
if(!is_file($configFile)) {
  echo "Error, config file not found";
} else {
  include $configFile;
}
spl_autoload_register(function ($classname) {
  include __DIR__.'/../classes/'.$classname.'.php';
});
$cf = ConnectionFactory::getInstance();
session_start();
//$cf->findUsers();
?>