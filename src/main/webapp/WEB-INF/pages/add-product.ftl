<#include "commons.ftl">

<section class="content-header">
    <h1><@spring.message 'ADD.PRODUCT.PAGE.TITLE'/></h1>
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAV.HOME'/></a></li>
        <li class="active">
            <@spring.message 'ADD.PRODUCT.NAV.PAGE'/>
        </li>
    </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
        <form name="addProduct" action="add" method="POST">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-xs-10 col-sm-10 col-md-10">
                     <div id="success-message" class="success-message alert alert-success<#if !successMessage??> hidden</#if>">
                        <a href="#" class="close-message close">&times;</a>
                        <span class="message"><#if successMessage??><@spring.message successMessage/></#if><span>
                    </div>
                     <div id="general-error-message" class="error-message alert alert-danger<#if !generalErrorMessage??> hidden</#if>">
                        <a href="#" class="close-message close">&times;</a>
                        <span class="message"><#if generalErrorMessage??>${generalErrorMessage}</#if><span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-1"></div>
                <#if addProductSessionId??>
                   <input id="add-product-session" name="addProductSessionId" type="hidden" value="${addProductSessionId}"/> 
                </#if>
                <div class="col-md-5 col-sm-12">
                    <@createLeftColumn />
                </div>
                <div class="col-md-5 col-sm-12">
                    <@createRightColumn />
                </div>
            </div>
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10 col-sm-12">
                    <div>
                        <label>Add images*</label>
                        <div id="file-box" class="form-group col-md-12 col-sm-12">
                            <div id="file-box-input">
                                <input id="file-box-file" type="file" name="files[]" data-multiple-caption="{count} files selected" multiple />
                                <div id="file-box-dragndrop">
                                    <h4>Drag&amp;Drop files here</h4>
                                    <span>or</span>
                                </div>
                                <div>
                                    <label id="browse-files-button" for="file-box-file"><strong>Browse Files</strong></label>
                                </div>
                                <span>or</span>
                                <div id="file-box-url">
                                    <input id="add-image-url-input" class="form-control" placeholder="Type the URL of an image of your product"></input>
                                    <div class="tooltip-wrapper">
                                        <span id="add-image-url-input-tooltip" class="error-tooltip"></span>
                                    </div>
                                    <a id="add-image-url-button"></a>
                                </div>
                            </div>
                        </div>
                        <a id="add-image-info-icon" class="info-icon" data-toggle="tooltip" title="You can specify one or more additional images. We accept JPEG, PNG or GIF format. Images should be at least 100 x 100 pixels in size"><span class="ion-ios-information-outline"></span></a>
                        <div id="product-images-container"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10 col-sm-12">
                    <@spring.message 'ADD.PRODUCT.OPTION.LABEL'/>
                    <br>
                    <input type="radio" id="publish-checkbox" name="action" value="publish" checked="checked" />
                    <@spring.message 'ADD.PRODUCT.OPTION.PUBLISH'/>
                    <br>
                    <input type="radio" id="unpublish-checkbox" name="action" value="unpublish" />
                    <@spring.message 'ADD.PRODUCT.OPTION.UNPUBLISH'/>
                    <br>
                    <button type="submit" class="btn btn-default">
                        <@spring.message 'ADD.PRODUCT.SUBMIT.BUTTON'/>
                    </button>
                </div>
            </div>
        </form>
    </div>
</section>

<#macro createLeftColumn>
    <@createInputSection 'name' />
    <@createInputSection 'description' />
    <@createInputSection 'tags' />
    <@createInputSection 'shipping' />
    <@createInputSection 'shipping-time' false />
    <@createInputSection 'color' false />
</#macro>

<#macro createRightColumn>
    <@createInputSection 'size' false />
    <@createInputSection 'inventory' />
    <@createInputSection 'price' />
    <@createInputSection 'brand' false />
    <@createInputSection 'presentation-page-url' false />
    <@createInputSection 'upc' false />
</#macro>

<#macro createInputSection fieldId mandatory=true>
    <#local fieldName = buildName(fieldId) >
    <#local fieldKey = buildKey(fieldId) >
    <#assign hasError=false/>
    <#if validationErrors?? && validationErrors["${fieldName}"]??>
        <#assign hasError=true/>
    </#if>
    <#if addProduct??>
        <@'<#assign fieldValue = ${"addProduct." + "${fieldName}"}!"">'?interpret />
    </#if>
    <div class="form-group form-icon-poz">
        <label for="${fieldId}"><@spring.message 'ADD.PRODUCT.${fieldKey}.LABEL' /><#if mandatory>*</#if></label>
        <input <#if !hasError && fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> class="form-control<#if hasError> has-error</#if>" name="${fieldName}" id="${fieldId}" type="text" placeholder="<@spring.message 'ADD.PRODUCT.${fieldKey}.PLACEHOLDER'/>">
        <div class="tooltip-wrapper">
            <span id="${fieldId}-tooltip" class="error-tooltip"><#if hasError><@spring.message '${validationErrors["${fieldName}"]}'/></#if></span>
        </div>
        <a class="info-icon" data-toggle="tooltip" title="<@spring.message 'ADD.PRODUCT.${fieldKey}.INFO'/>">
            <span class="ion-ios-information-outline"></span>
        </a>
    </div>
</#macro>
