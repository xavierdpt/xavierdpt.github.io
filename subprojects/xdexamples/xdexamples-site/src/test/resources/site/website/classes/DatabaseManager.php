<?php
class DatabaseManager {

  public static function findTables() {
    $tableNames = array();
    $cf = ConnectionFactory::getInstance();
    $conn = $cf->getConnection();
    $query = "select table_name from information_schema.tables where table_schema = 'xdexamples'";
    if($conn->real_query($query)) {
        $result = $conn->use_result();
        foreach($result as $row) {
            $tableName = $row['TABLE_NAME'];
            $tableNames[$tableName] = NULL;
        }
    }
    return $tableNames;
  }

  public static function findColumns() {
    $columnNames = array();
    $cf = ConnectionFactory::getInstance();
    $conn = $cf->getConnection();
    $query = "select table_name, column_name from information_schema.columns where table_schema = 'xdexamples'";
    if($conn->real_query($query)) {
        $result = $conn->use_result();
        foreach($result as $row) {
            $tableName = $row['TABLE_NAME'];
            $columnName = $row['COLUMN_NAME'];
            $columnNames[$tableName.'$'.$columnName] = NULL;
        }
    }
    return $columnNames;
  }

  public static function updateSchema() {
    $tables = self::findTables();
    $columns = self::findColumns();
    if(!array_key_exists('examples',$tables)) {
        if(!self::createExampleTable()) {
            // TODO: handle error
        }
    } else {
        // TODO: update example table
    }
  }

  public static function createExampleTable() {
    $cf = ConnectionFactory::getInstance();
    $conn = $cf->getConnection();
    $query = "create table examples (id bigint unsigned auto_increment, project varchar(32) not null, package varchar(255) not null, class varchar(63) not null, example varchar(63) not null, primary key (id), unique key example_key (project, package, class, example) )";
    return $conn->real_query($query);
  }

  public static function refreshExamples() {
    $cf = ConnectionFactory::getInstance();
    $conn = $cf->getConnection();
    $query = file_get_contents(__DIR__.'/../data/examples.sql');
    return $conn->real_query($query);
  }
}
?>