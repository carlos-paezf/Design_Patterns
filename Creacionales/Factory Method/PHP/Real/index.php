<?php

abstract class SocialNetworkPoster
{
    abstract public function getSocialNetwork(): SocialNetworkConnector;

    public function post($content): void
    {
        $network = $this->getSocialNetwork();
        $network->logIn();
        $network->createPost($content);
        $network->logout();
    }
}


class FacebookPoster extends SocialNetworkPoster {
    private $login, $password;

    public function __construct(string $login, string $password) {
        $this->login = $login;
        $this->password = $password;
    }

    public function getSocialNetwork(): SocialNetworkConnector
    {
        return new FacebookConnector($this->login, $this->password);
    }
}


class LinkedInPoster extends SocialNetworkPoster {
    private $email, $password;

    public function __construct(string $email, string $password) 
    {
        $this->email = $email;
        $this->password = $password;
    }

    public function getSocialNetwork(): SocialNetworkConnector
    {
        return new LinkedInConnector($this->email, $this->password);
    }
}


interface SocialNetworkConnector {
    public function logIn(): void;
    public function logOut(): void;
    public function createPost($content): void;
}


class FacebookConnector implements SocialNetworkConnector {
    private $login, $password;

    public function __construct(string $login, string $password)
    {
        $this->login = $login;
        $this->password = $password;
    }

    public function logIn(): void {
        echo "Send HTTP API request to log in user $this->login with password $this->password<br>";
    }

    public function logOut(): void {
        echo "Send HTTP API request to log out user $this->login<br>";
    }

    public function createPost($content): void {
        echo "Send HTTP API request to create a post in Facebook timeline.<br>";
    }
}


class LinkedInConnector implements SocialNetworkConnector {
    private $email, $password;

    public function __construct(string $email, string $password)
    {
        $this->email = $email;
        $this->password = $password;
    }

    public function logIn(): void {
        echo "Send HTTP API request lo log in user $this->email with password $this->password<br>";
    }

    public function logOut(): void {
        echo "Send HTTP API request lo log out user $this->email<br>";
    }

    public function createPost($content): void {
        echo "Send HTTP API request to create a post in LinkedIn timeline.<br>";
    }
}


function clientCode(SocialNetworkPoster $creator) {
    $creator->post("Hello world!");
    $creator->post("I had a large hamburger this morning!");
}


echo "Testing ConcreteCreator1: (Facebook)<br>";
clientCode(new FacebookPoster("david_ferrer", "david***"));
echo "<br><br>";

echo "Testing ConcreteCreator2: (LinkedIn)<br>";
clientCode(new LinkedInPoster("davidferrer@mail.com", "***password***"));