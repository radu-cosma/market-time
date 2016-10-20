<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a href="/market-time/home"><img class="logo-lg" src="/market-time/images/marketime_logo_i_icon_white.svg" alt="marketime logo" /></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/market-time/home#about-us">ABOUT US</a></li>
                <li><a href="/market-time/integration">INTEGRATION</a></li>
                <li><a id="log-in" href="#user-login" data-toggle="modal">LOGIN</a></li>
                <li><a href="/market-time/contact">CONTACT</a></li>
                <li class="dropdown language">
                    <a id="flag" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="images/united-kingdom.png" alt="English" class="country-flag">
                    </a>
                    <ul class="dropdown-menu dropdown-menu-ul" role="menu">
                        <li>
                            <a href="#">
                            <span class="country-mob-name">English</span>
                                <img src="images/united-kingdom.png" class="country-flag" alt="English">  
                            </a>
                            <a href="#">
                            <span class="country-mob-name">Romana</span>
                                <img src="images/romania.png" class="country-flag" alt="Romania">  
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<#include "login-form.ftl">
