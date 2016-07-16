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
        <form>
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-5 col-sm-12">
                    <@createAddProductFieldsLeft />
                </div>
                <div class="col-md-5 col-sm-12">
                    <@createAddProductFieldsRight />
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
                    <input type="radio" id="pub-btn" name="action" value="publish" checked="checked" />
                    <@spring.message 'ADD.PRODUCT.OPTION.PUBLISH'/>
                    <br>
                    <input type="radio" id="unpub-btn" name="action" value="unpublish" />
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


<#macro createAddProductFieldsLeft>
	    <@createProductFields 'name' />
	    <@createProductFields 'description' />
	    <@createProductFields 'tags' />
	    <@createProductFields 'shipping' />
	    <@createProductFields 'shipping-time' />
	    <@createProductFields 'color' />
</#macro>

<#macro createAddProductFieldsRight>
	    <@createProductFields 'size' />
	    <@createProductFields 'inventory' />
	    <@createProductFields 'price' />
	    <@createProductFields 'brand' />
	    <@createProductFields 'landing-page-url' />
	    <@createProductFields 'upc' />
</#macro>

<#macro createProductFields fieldId fieldType="text" >
	<#local fieldName = buildName(fieldId) >
	<#local fieldKey = buildKey(fieldId) >
	<div class="form-group form-icon-poz">
        <label for="${fieldId}"><@spring.message 'ADD.PRODUCT.${fieldKey}.LABEL' />*</label>
        <input type="${fieldType}" class="form-control" id="${fieldId}" name="${fieldName}" <#if fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> placeholder="<@spring.message 'ADD.PRODUCT.${fieldKey}.PLACEHOLDER'/>">
      <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
        <a class="form-control-icon" data-toggle="tooltip" title="<@spring.message 'ADD.PRODUCT.${fieldKey}.INFO'/>"><span class="ion-ios-information-outline"></span></a>
    </div>
</#macro>




<#function buildName fieldId>
  	<#return fieldId?replace('-', ' ')?capitalize?replace(' ', '')?uncap_first >
</#function>

<#function buildKey fieldId>
  	<#return fieldId?replace('-', '.')?upper_case >
</#function>