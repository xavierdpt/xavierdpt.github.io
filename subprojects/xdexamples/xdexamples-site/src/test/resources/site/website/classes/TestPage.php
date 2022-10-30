<?php
class TestPage extends Page {

    public function validateGet() {
        return TRUE;
    }

    public function validatePost() {
        return FALSE;
    }

    public function writeGet() {
        $examples = ExampleService::getAllExamples();
        foreach($examples as $example) {
            echo $example->project;
            echo $example->package;
            echo $example->class;
            echo $example->example;
        }

    }
}
?>