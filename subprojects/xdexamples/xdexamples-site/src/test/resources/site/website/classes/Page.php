<?php
class Page {

    public function writeHeader() {
?>
<!DOCTYPE html>
<html>
<head>
    <title>XD Examples / Java</title>
    <link rel="stylesheet" href="/css/jhighlight.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<?php
    }

    public function writeFooter() {
?>
</body>
</html>
<?php
    }

    public function writeGet() {
    }

    public function writePost() {
    }

    public function validateGet() {
        return TRUE;
    }

    public function validatePost() {
        return FALSE;
    }

    public function write() {
        $method = $_SERVER['REQUEST_METHOD'];
        if($method == 'GET' && $this->validateGet()) {
            $this->writeHeader();
            $this->writeGet();
            $this->writeFooter();
        } else if($method == 'POST' && $this->validatePost()) {
            $this->writeHeader();
            $this->writePost();
            $this->writeFooter();
        } else {
            $this->notFound();
        }
    }

    public function notFound() {
        http_response_code(404);
        include(__DIR__.'/../error.php');
    }
}
?>