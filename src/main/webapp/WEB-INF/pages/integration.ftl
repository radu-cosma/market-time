<div id="integration-page-header">
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <div class="md-title">
                Integrated marketplaces biggest in the world 
            </div>
            <div class="sub-title">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            </div>
        </div>
	</div>
</div>

<div id="integration-page-body">
	<div class="row">
	    <@integrationTitleModul />
		<ul class="nav nav-pills">
			<div class="col-md-10 col-md-offset-1 integration-section-mobile">
			    <li><a data-toggle="tab" href="#whish-datails"><@marketIntegrated marketImg="wish-logo.png" altImg="wish image" /></a></li>
			    <li><a data-toggle="tab" href="#"><@marketIntegrated marketImg="amazon-logo.png" altImg="amazon image" /></a></li>
			    <li><a data-toggle="tab" href="#"><@marketIntegrated marketImg="ebay-logo.png" altImg="ebay image" /></a></li>
			    <li><a data-toggle="tab" href="#"><@marketIntegrated marketImg="spartoo-logo.png" altImg="spartoo image" /></a></li>  
			    <li><a data-toggle="tab" href="#"><@marketIntegrated marketImg="amazon-logo.png" altImg="amazon image" /></a></li>
			    <li><a data-toggle="tab" href="#"><@marketIntegrated marketImg="ebay-logo.png" altImg="ebay image" /></a></li>
			    <li><a data-toggle="tab" href="#"><@marketIntegrated marketImg="spartoo-logo.png" altImg="spartoo image" /></a></li>      
	        </div>
        </ul>
	</div>
</div>

	
    	<div class="tab-content">
	        <div id="whish-datails" class="tab-pane fade">
	           test test test
	        </div>
   	    </div>

<#macro integrationTitleModul>
	<div class="col-md-10 col-md-offset-1">
		<div class="integration-header">
			<div class="integration-title">
				<h3>Lorem ipsum dolor sit amet</h3>
			</div>
		</div>
	</div>
</#macro>

<#macro marketIntegrated marketImg altImg>
	<div class="col-sm-4 col-md-3 market-integration-section">
		<div class="market-integration">
		    <img class="market-integration-image img-responsive" src="/market-time/images/${marketImg}" alt="${altImg}">
		</div>
	</div>
</#macro>

