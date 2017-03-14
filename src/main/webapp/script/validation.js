var validator = {
    validationConfig: {},
        
    validateForm : function(fields, validationConfig) {
        var inputId, 
            valid = true,
            validationResponse;
        
        this.validationConfig = validationConfig;

        for (var i in fields) {
            inputId = fields[i];
            if (validationConfig[inputId] !== undefined) {
                validationResponse = this.validateInput(inputId);
                this.markValidation(inputId, validationResponse);
                valid = valid && !!validationResponse.valid;
            }
        }
        return valid;
    },
    
    validateInput : function(inputId) {
        var inputConfig = this.validationConfig[inputId], 
            input = $('#' + inputId),
            inputValue = this.sanitizeInput(input),
            mirror,
            mirrorValue,
            validationResponse = {valid : true, reason : ''}; 

        if (!inputConfig) {
            // field doesn't exist in the validation configuration
            return null;
        }
        
        if (!!inputConfig.required && (inputValue === undefined || inputValue === '')) {
            return {valid : false, reason : 'required'};
        }
        
        if (inputConfig.exactLength !== undefined && inputValue !== '' && inputValue.length !== inputConfig.exactLength) {
            return {valid : false, reason : 'lessOrMoreThan'};
        }
        
        if (inputConfig.minLength !== undefined && inputValue !== '' && inputValue.length < inputConfig.minLength) {
            return {valid : false, reason : 'lessThan'};
        }
        
        if (inputConfig.maxLength !== undefined && inputValue !== '' && inputValue.length > inputConfig.maxLength) {
            return {valid : false, reason : 'moreThan'};
        }
        
        if (inputConfig.regexp !== undefined && inputValue !== '' && !inputValue.match(inputConfig.regexp)) {
            return {valid : false, reason : 'invalidRegexp'};
        }
        
        if (inputConfig.mirror !== undefined) {
            mirror = $('#' + inputConfig.mirror);
            mirrorValue = this.sanitizeInput(mirror);
            if (mirrorValue !== inputValue) {
                return {valid : false, reason : 'mirror'};
            }
        } 

        return validationResponse;
    },
    
    sanitizeInput : function(input) {
        return $.trim(input.val());
    },
    
    markValidation : function (inputId, validationResponse) {
        var inputConfig = this.validationConfig[inputId];
        
        $('#' + inputId).toggleClass('has-error', !validationResponse.valid);
        if (!validationResponse.valid) {
            $('#' + inputId + '-tooltip').text(inputConfig.messages[validationResponse.reason]);
        }
    }
}
