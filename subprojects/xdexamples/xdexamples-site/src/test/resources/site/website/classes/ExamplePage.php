<?php
class ExamplePage extends Page {

    private $urlFragment = NULL;
    private $project = NULL;
    private $package = NULL;
    private $class = NULL;
    private $example = NULL;

    public function __construct($urlFragment) {
        $this->urlFragment = $urlFragment;
    }

    public function validateGet() {

        if(!$this->urlFragment) {
            return FALSE;
        }
        $parts = explode("/",$this->urlFragment);
        if(count($parts)!=4) {
            return FALSE;
        }
        $project = $parts[0];
        $package = $parts[1];
        $class = $parts[2];
        $example = $parts[3];
        if(!$project||!$package||!$class||!$example) {
            return FALSE;
        }
        $this->project = $project;
        $this->package = $package;
        $this->class = $class;
        $this->example = $example;
        return TRUE;
    }

    public function validatePost() {
        return FALSE;
    }

    public function writeGet() {
?>
    <p>You want to look at the following example</p>
    <p>Project: <?=htmlspecialchars($this->project)?></p>
    <p>Package: <?=htmlspecialchars($this->package)?></p>
    <p>Class: <?=htmlspecialchars($this->class)?></p>
    <p>Example: <?=htmlspecialchars($this->example)?></p>
<?php
        $path = __DIR__.'/../java/examples/'.($this->project).'/'.($this->package).'/'.($this->class).'/'.($this->example);
        if(is_file($path)) {
?>
    <div class="sourcecode">
<?php
            readfile($path);
?>
    </div>
<?php
        } else {
            // TODO: file not found (error)
        }
    }

}
?>