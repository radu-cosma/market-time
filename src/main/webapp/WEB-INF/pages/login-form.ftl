<div class="modal fade" id="user-login" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" id="close-button" class="close-btn close" data-dismiss="modal">&times;</button>
                <h2 class="mod-title">Existing User</h2>
            </div>
            <div class="modal-body">
                <div id="modal-header">
                    <p>Have a MarketTime Account?</p>
                    <p>Sign in to manage your products.</p>
                    <br>
                </div>
                <label id="general-error-message" class="error-message alert-danger log-message hidden""></label>
                <div id="email-div">
                    <@createInputSection 'login-email' 'EMAIL'/>
                </div>
                <div id="password-div">
                    <@createInputSection 'login-password' 'PASSWORD' 'password'/>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox">Remember me</label>
                </div>
                <p>Not a member? <a href="/market-time/register">Register now</a></p>
                <button id="login-button" type="submit" class="stylish-pz-p-btn btn button-default">Submit</button>
            </div>
        </div>
    </div>
</div>

<#macro createInputSection fieldName fieldKey fieldType='text'>
    <div class="form-group">
        <label class=""><@spring.message '${fieldKey}.LABEL'/></label>
        <input class="form-control" id="${fieldName}" type="${fieldType}" placeholder="<@spring.message '${fieldKey}.PLACEHOLDER'/>" autocomplete="off" >
        <label id="${fieldName}-error-message" class="error-message hidden"></label>
    </div>
</#macro>