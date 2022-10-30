<?php
class ExampleService {
    public static function getAllExamples() {
        $examples = array();
        $cf = ConnectionFactory::getInstance();
        $conn = $cf->getConnection();
        $query = "select * from examples";
        if($conn->real_query($query)) {
            $result = $conn->use_result();
            foreach($result as $row) {
                $example = new Example($row['project'],$row['package'],$row['class'],$row['example']);
                array_push($examples,$example);
            }
        }
        return $examples;
    }
}
?>