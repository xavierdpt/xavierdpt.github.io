<?php

include_once __DIR__.'/../includes/functions.php';

class LoginPage extends Page {

    public function validateGet() {
        return TRUE;
    }

    public function writeGet() {
        $this->writeForm();
    }

    public function validatePost() {
        return TRUE;
    }

    public function setLogin($login) {
        $_SESSION['LOGIN'] = $login;
    }

    public function writePost() {
        $login = postParam('login');
        $password = postParam('password');
        if($login && $password) {
            $this->setLogin($login);
?>
    <p>Hello <?=htmlspecialchars($login)?>.</p>
<?php
        } else {
?>
    <p>Invalid login or password. You may try again.</p>
<?php
            $this->writeForm();
        }
    }

    public function writeForm() {
?>
    <form action="login" method="POST">
        <div><label>Login</label><input type="text" name="login"/></div>
        <div><label>Password</label><input type="password" name="password"/></div>
        <input type="submit" value="Submit"/>
    </form>
<?php
    }
}
?>