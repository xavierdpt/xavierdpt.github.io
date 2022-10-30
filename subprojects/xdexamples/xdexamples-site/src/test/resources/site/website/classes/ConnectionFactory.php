<?php
class ConnectionFactory {

  private $connection = NULL;

  private static $instance = NULL;

  protected function __construct() {}

  public static function getInstance() {
    if(is_null(self::$instance)) {
        self::$instance = new ConnectionFactory();
    }
    return self::$instance;
  }

  public function getConnection() {
    if(is_null($this->connection)) {
      $this->connection = new mysqli('localhost','user','user','xdexamples');
    }
    return $this->connection;
  }

  public function findUsers() {
    $conn = $this->getConnection();
    $conn->real_query('select * from users');
    $result = $conn->use_result();
    foreach($result as $row) {
      echo $row['email'] . "\n";
    }
  }
}
?>