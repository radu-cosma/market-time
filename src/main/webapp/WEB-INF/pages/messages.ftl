<#include "commons.ftl">

<section class="content-header">
      <h1><@spring.message 'MESSAGES.PAGE.TITLE'/></h1>
      <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'MESSAGES.NAV.HOME'/></a></li>
        <li class="active"><@spring.message 'MESSAGES.NAV.PAGE'/></li>
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
							<li id="compose-tab"><a data-toggle="tab" href="#compose"><@spring.message 'MESSAGES.COMPOSE.TAB'/></a></li>
						</ul>
						
						<div id="inbox" class="tab-pane active">
						    <div class="panel-body">
						    	<div id="select-check">
			                    	<label><input  id="select-all" class="panel-heading-check" type="checkbox" name="select all" value="">   <@spring.message 'MESSAGE.COMPOSE.SELECT.ALL.EMAIL'/></label>
                                    <div id="delete-mail" class="btn form-btn delete-btn"><@spring.message 'MESSAGE.COMPOSE.DELETE.EMAIL.BTN'/></div>						    	</div>						    					    
							    <ul class="event-list">
		                            <li>
		                                <div class="details-container">		                                	
		                                	<div class="panel message-details">
	                            	            <div class="panel-heading email-hover">
	                            	            	<aside class="heading-check">
		                                        		<input class="mail-check" type="checkbox" name="message" value="" />
		                                            </aside>
		                                            <div class="heading-title">
		                                            	test1
		                                            </div>	
	                                            	<aside class="heading-date">
		                                            	<span class="glyphicon-mob pull-right clickable"><i class="glyphicon glyphicon-chevron-down"></i></span>
		                                        	    <span class="date-poz">Jan 15</span>
		                                        	</aside>
		                                        </div>
		                                        <div class="panel-collapse collapse">
		                                            <div class="product-panel-body">
		                                                test 1
		                                            </div>
		                                        </div>
		                                    </div>
	                          		
		                                    <div class="panel message-details">
	                            	            <div class="panel-heading email-hover">
	                            	            	<aside class="heading-check">
		                                        		<input class="mail-check" type="checkbox" name="message" value="" />
		                                            </aside>
		                                            <div class="heading-title">
		                                            	test2 fsdjfhjkdsh sdfjdfjdslkjflkds sdjflksdjfsdljf lkdsjflksdfjdssdjfk fsdfdf fdsfsdf
		                                            	dsfsdf f ddsfsdf fdsfsdf sdfdsf fsdfsdfsdf sdfsdfsdf fdsfsdfsdf dsfsdfsdf fdsfsdfdsfsd
		                                            </div>	
	                                            	<aside class="heading-date">
		                                            	<span class="glyphicon-mob pull-right clickable"><i class="glyphicon glyphicon-chevron-down"></i></span>
		                                        	    <span class="date-poz">12/09/2016</span>
		                                        	</aside>
		                                        </div>
		                                        <div class="panel-collapse collapse">
		                                            <div class="product-panel-body">
		                                                test 1
		                                            </div>
		                                        </div>
		                                    </div>  
		                                     
		                                </div>
		                            </li>
		                        </ul>					    							    
						    </div>
						</div>
				
		                
		                <div id="compose" class="tab-pane fade">
		                    <div class="panel-body">
		                    	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                   Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                    <div class="contact-form col-md-6 col-xs-12">
							        <form>
								    	<div class="form-group">
								    		<input class="form-control message-form" type="text" value="To: Market Time" disabled>
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
