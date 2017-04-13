var loadingScreen = {
        
    isDisplayed: false,
    
    display: function() {
        var loadingScreenHtml =     
            '<div id="loading-screen" class="loading-background">' + 
                '<div class="spinner-container">' + 
                    '<img src="./images/spinner.svg">' + 
                    '<p>Please wait...</p>' +
                '</div>' +
            '</div>';
        if (!this.isDisplayed) {
            this.isDisplayed = true;
            $('body').append(loadingScreenHtml);
        }
    },
    
    destroy: function() {
        if (this.isDisplayed) {
            this.isDisplayed = false;
            $('#loading-screen').remove();
        }
    }

};