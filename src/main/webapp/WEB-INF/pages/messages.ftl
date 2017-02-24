<#include "commons.ftl">

<section class="content-header">
      <h1><@spring.message 'MESSAGES.PAGE.TITLE'/></h1>
      <ol class="breadcrumb">
          <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
          <li class="active"><@spring.message 'NAVIGATION.MESSAGES.PAGE'/></li>
      </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
        <div class="row-style row">
            <div class="padding-5 col-xs-12 col-sm-offset-1 col-sm-10">
                <div class="inbox-head">
                    <form action="#" class="pull-right position">
                        <div class="input-append">
                            <input type="text" class="search-input" placeholder="<@spring.message 'MESSAGES.SEARCH.PLACEHOLDER'/>">
                            <button class="btn search-btn" type="button"><i class="fa fa-search"></i></button>
                        </div>
                    </form>
                </div>            
                <div class="col-sm-12 container">
                    <div class="tab-content">
                        <ul class="nav nav-tabs">
                            <li id="inbox-tab" class="active"><a data-toggle="tab" href="#inbox"><@spring.message 'MESSAGES.INBOX.TAB'/></a></li>
                            <li id="compose-tab"><a data-toggle="tab" href="#outbox"><@spring.message 'MESSAGES.SENT.TAB'/></a></li>
                            <li id="compose-tab"><a data-toggle="tab" href="#compose"><@spring.message 'MESSAGES.COMPOSE.TAB'/></a></li>
                        </ul>                        
                        <div id="inbox" class="tab-pane active">
                            <div class="panel-body">
                                <div>
                                    <label><input id="select-all-inbox" class="select-all panel-heading-check" type="checkbox" name="select all" value=""> <@spring.message 'MESSAGE.COMPOSE.SELECT.ALL.EMAIL'/></label>
                                    <div class="btn form-btn delete-btn"><@spring.message 'MESSAGE.COMPOSE.DELETE.EMAIL.BUTTON'/></div>
                                </div>                                                    
                                <#if messages??>
                                    <ul class="event-list">                                            
                                          <@createMail />
                                    </ul>
                                </#if>                                                        
                            </div>
                        </div>                
                        <div id="outbox" class="tab-pane fade">
                            <div class="panel-body">
                                <div>
                                    <label><input id="select-all-outbox" class="select-all panel-heading-check" type="checkbox" name="select all" value=""> <@spring.message 'MESSAGE.COMPOSE.SELECT.ALL.EMAIL'/></label>
                                    <div class="btn form-btn delete-btn"><@spring.message 'MESSAGE.COMPOSE.DELETE.EMAIL.BUTTON'/></div>                                
                                </div>
                                <#if messages??>
                                    <ul class="event-list">                                         
                                        <@createMail />
                                    </ul>
                                </#if>     
                            </div>
                        </div>                        
                        <div id="compose" class="tab-pane fade">
                            <div class="panel-body">
                                <p><@spring.message 'MESSAGE.COMPOSE.TEXT'/></p>
                                <div class="contact-form col-md-6 col-xs-12">
                                    <form>
                                        <div class="form-group">
                                            <div class="form-control message-form" disabled>To: Market Time</div>
                                            <@createInputSection 'subject' />
                                            <textarea class="form-control message-form" id="comment" name="comment" placeholder="comment" rows="10"></textarea>
                                            <div class="textarea-tooltip tooltip-wrapper">
                                                <span id="comment-tooltip" class="error-tooltip"></span>
                                            </div>
                                            <button type="submit" id="message-btn" class="btn btn-default"><@spring.message 'MESSAGE.COMPOSE.SEND.BUTTON'/></button> 
                                        </div>
                                    </form>
                                </div> 
                            </div>
                        </div>
                    </div> 
                </div> 
            </div>
        </div>
    </div>
</section>

<#macro createInputSection fieldId>
    <#local fieldName = buildName(fieldId) >
    <#local fieldKey = buildKey(fieldId) >
    <#assign hasError=false/>
    <#if validationErrors?? && validationErrors["${fieldName}"]??>
        <#assign hasError=true/>
    </#if>  
        <div>
            <input <#if !hasError && fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> class="form-control message-form <#if hasError>has-error</#if>" name="${fieldName}" id="${fieldId}" type="text" placeholder="${fieldName}">
            <div class="tooltip-wrapper">
                <span id="${fieldId}-tooltip" class="error-tooltip"><#if hasError><@spring.message '${validationErrors["${fieldName}"]}'/></#if></span>
            </div>
        </div>   
</#macro>

<#macro createMail>
    <#list messages as receivedMessage>
        <li>
            <div class="details-container">                                         
                <div class="panel message-details">
                    <div class="panel-heading email-hover">
                        <aside class="heading-check">
                            <input class="mail-check" type="checkbox" name="message" value="" />
                        </aside>
                        <#if receivedMessage.read??>        
                            <div class="heading-title title-align read">
                        <#else>
                            <div class="heading-title title-align">
                        </#if>
                        <#if receivedMessage.title??>
                            ${receivedMessage.title}
                        </#if>
                        </div>  
                        <#if receivedMessage.read??>
                            <aside class="heading-date read">
                        <#else>
                            <aside class="heading-date">
                        </#if>
                        <span class="glyphicon-mob pull-right clickable"><i class="glyphicon glyphicon-chevron-down"></i></span>
                        <#if receivedMessage.date??>
                            <span class="date-poz">${receivedMessage.date}</span>
                        </#if>
                        </aside>
                    </div>
                    <div class="panel-collapse collapse">
                        <div class="product-panel-body">
                            <#if receivedMessage.content??>
                                ${receivedMessage.content}
                            </#if>
                        </div>
                    </div>
                </div>                                   
            </div>
        </li> 
    </#list>
</#macro>
