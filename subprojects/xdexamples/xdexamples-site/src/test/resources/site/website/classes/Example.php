<?php
class Example {
    public $project;
    public $package;
    public $class;
    public $example;
    public function __construct($project,$package,$class,$example) {
        $this->project=$project;
        $this->package=$package;
        $this->class=$class;
        $this->example=$example;
    }
}
?>