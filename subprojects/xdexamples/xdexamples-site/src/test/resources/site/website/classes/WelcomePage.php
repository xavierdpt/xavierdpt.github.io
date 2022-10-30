<?php
class WelcomePage extends Page {

    public function validateGet() {
        return TRUE;
    }

    public function validatePost() {
        return FALSE;
    }

    public function writeGet() {
        $examples = ExampleService::getAllExamples();
?>
        <p>Welcome to XD Examples</p>
        <ul>
<?php
        foreach($examples as $example) {
?>
            <li>
                <a href="e/<?=$example->project?>/<?=$example->package?>/<?=$example->class?>/<?=$example->example?>" target="_blank"/><?=$example->project?> <?=$example->package?>.<?=$example->class?> <?=$example->example?></a>
            </li>
<?php
        }
?>
        </ul>
<?php
    }
}
?>