<div id="contact-container" class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <div class="md-title">
                Contact
            </div>
            <div class="xs-title">
                Contact us and we'll get back to you within 24 hours.
            </div>
        </div>
        <div class="contact-message col-md-5 col-md-offset-1 col-xs-12">
            <p><span class="glyphicon glyphicon-map-marker"></span> Cluj-Napoca, RO</p>
            <p><span class="glyphicon glyphicon-phone"></span> 0040 747123123</p>
            <p><span class="glyphicon glyphicon-envelope"></span> office@markettime.com</p>      
        </div>
       
        <form name="contact" action="contact" method="POST">
            <div class="col-md-5 col-sx-12">
                <input class="form-control" id="companyName" name="companyName" placeholder="Company name" type="text" required> 
                <input class="form-control" id="email" name="email" placeholder="Email address" type="email" required>
                <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
                <button id="contact-us-button" type="submit" class="btn stylish-pz-p-btn">Send</button>
            </div>  
        </form>
    </div>
    
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <div id="google-map"/>
        </div>
    </div>
</div>
