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
        <div class="box-header with-border"> </div>
        <form name="addProduct" action="add" method="POST">
            <div class="row">
                <div class="col-md-1"></div>
                <#if successMessage??>
                    <div class="col-xs-10 col-sm-10 col-md-10">
                         <div id="success-message" class="success-message alert alert-success">
                            <a href="#" class="close-message close">&times;</a>
                            <strong>!</strong>
                            <@spring.message successMessage/>
                        </div>
                    </div>
                </#if>
                <#if generalErrorMessage??>
                    <div class="col-xs-10 col-sm-10 col-md-10">
                         <div id="general-error-message" class="error-message alert alert-danger">
                            <a href="#" class="close-message close">&times;</a>
                            <strong>!</strong>
                            ${generalErrorMessage}
                        </div>
                    </div>
                </#if>
            </div>
            <div class="row">
                <div class="col-md-1"></div>
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
                    <div id="add-link" class="form-group form-icon-poz">
                        <label for="text">Add images*</label>
                        <input id="inp-prev-img" name="thumbnail" class="form-control" placeholder="Type URL of a image of your product" minlength="2" maxlength="30" data-validations="required">
                    <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                        <a class="form-control-icon" data-toggle="tooltip" title="URL of photos of your product. Link directly to the image, not the page where it is located."><span class="ion-ios-information-outline"></span></a>
                        <div id="btn-prev" class="btn form-btn blue btn-img-style">Add image URL</div>
                    </div>
                    <div id="add-img" class="row form-pad">
                        <div class="col-md-12 col-sm-12 inp-img-style">
                            <input type="file" name="files[]" id="filer_input2" multiple="multiple">
                            <a class="form-control-icon form-control-icon-img" data-toggle="tooltip" title="You can specify one or more additional images. We accept JPEG, PNG or GIF format. Images should be at least 100 x 100 pixels in size"><span class="ion-ios-information-outline"></span></a>
                        </div>
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
        <input <#if !hasError && fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> class="form-control <#if hasError>has-error</#if>" name="${fieldName}" id="${fieldId}" type="text" placeholder="<@spring.message 'ADD.PRODUCT.${fieldKey}.PLACEHOLDER'/>">
        <div class="tooltip-wrapper">
            <span id="${fieldId}-tooltip" class="error-tooltip"><#if hasError><@spring.message '${validationErrors["${fieldName}"]}'/></#if></span>
        </div>
        <a class="form-control-icon" data-toggle="tooltip" title="<@spring.message 'ADD.PRODUCT.${fieldKey}.INFO'/>">
            <span class="ion-ios-information-outline"></span>
        </a>
    </div>
</#macro>
