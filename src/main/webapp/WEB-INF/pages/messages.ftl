<#include "commons.ftl">

<section class="content-header">
      <h1><@spring.message 'MESSAGES.PAGE.TITLE'/></h1>
      <ol class="breadcrumb">
          <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
      </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
        <div class="row-style row">
            <div class="padding-5 col-xs-12 col-sm-offset-1 col-sm-10">
                <div class="messages-head">
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
                            <li id="outbox-tab"><a data-toggle="tab" href="#outbox"><@spring.message 'MESSAGES.OUTBOX.TAB'/></a></li>
                            <li id="compose-tab"><a data-toggle="tab" href="#compose"><@spring.message 'MESSAGES.COMPOSE.TAB'/></a></li>
                        </ul>                        
                        <@createMessagesSection sectionId='inbox' isActive=true/>               
                        <@createMessagesSection sectionId='outbox'/>                       
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

<#macro createMessagesSection sectionId isActive=false>
    <div id="${sectionId}" class="tab-pane<#if isActive> active</#if>">
        <div class="panel-body">
            <div>
                <label><input id="select-all-${sectionId}" class="select-all panel-message-check" type="checkbox" name="select all" value="check messages"> <@spring.message 'MESSAGE.COMPOSE.SELECT.ALL.EMAIL'/></label>
                <div class="btn form-btn delete-btn display-btn"><@spring.message 'MESSAGE.COMPOSE.DELETE.EMAIL.BUTTON'/></div>
            </div>                                                  
            <#if messages??>
                <ul class="messages-list">
                    <#list messages as message>
                        <li>
                            <div class="panel message-details">
                                <div class="panel-heading message">
                                    <aside class="message-check">
                                        <input class="check" type="checkbox" name="select message" value="check message" />
                                    </aside>      
                                    <div class="message-title title-align <#if message.read??>read</#if>">
                                        <#if message.title??>
                                            ${message.title}
                                        </#if>
                                    </div>
                                    <aside class="message-date <#if message.read??>read</#if>">
                                        <span class="glyphicon-mob pull-right clickable"><i class="glyphicon glyphicon-chevron-down"></i></span>
                                        <#if message.date??>
                                            <span class="date-poz">${message.date}</span>
                                        </#if>
                                    </aside>
                                </div>
                                <div class="panel-collapse collapse">
                                    <div class="product-panel-body">
                                        <#if message.content??>
                                            ${message.content}
                                        </#if>
                                    </div>
                                </div>
                            </div>                                   
                        </li> 
                    </#list>
                </ul>
            </#if>                                                      
        </div>
    </div>      
</#macro>
