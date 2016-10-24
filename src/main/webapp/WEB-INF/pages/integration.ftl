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
		<div class="col-md-10 col-md-offset-1 integration-section-mobile">
		    <@marketIntegrated marketImg="wish-logo.png" altImg="wish image" />
		    <@marketIntegrated marketImg="amazon-logo.png" altImg="amazon image" />
		    <@marketIntegrated marketImg="ebay-logo.png" altImg="ebay image" />
		    <@marketIntegrated marketImg="spartoo-logo.png" altImg="spartoo image" />
        </div>
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
	<a href="" class="col-sm-4 col-md-3 market-integration-section">
		<div class="market-integration">
		    <img class="market-integration-image img-responsive" src="/market-time/images/${marketImg}" alt="${altImg}">
		</div>
	</a>
</#macro>

