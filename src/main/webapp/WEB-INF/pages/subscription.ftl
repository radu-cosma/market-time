<div id="subscription-page-header">
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <div class="md-title">
                Save BIG on your pricing choice 
            </div>
            <div class="sub-title">
                Contact us and we'll get back to you within 24 hours.
            </div>
        </div>
	</div>
</div>

<div id="subscription-page-body">
	<div class="row">
	    <@subscriptionTitleModul />
		<div class="col-md-10 col-md-offset-1">
        	<@subscriptionSavePriceModul valueSave="11" valuePrice="22" />
			<@subscriptionProcentPriceModul valueProcent="2.5" />
		</div>
	</div>
</div>

<#macro subscriptionTitleModul>
	<div class="col-md-10 col-md-offset-1">
		<div class="subscription-header">
			<div class="subscription-title">
				<h3>Save BIG on you next subcription</h3>
			</div>
		</div>
	</div>
</#macro>

<#macro subscriptionSavePriceModul valueSave valuePrice>
    <div class="price-section">
		<div class="row">
			<div class="col-sm-5 subscription-price">
				<div class="price">
					<h3>Save <span>&euro;${valueSave}</span></h3>
					<h4>3 months subscription for <span>&euro;${valuePrice}</span>/month</h4>
                    <a class="stylish-btn stylish-sav-btn btn button-default" data-toggle="modal"> Book now </a>
				</div>
			</div>
			<div class="col-sm-7 subscription-info">
				<p>Participants: all marketplace integrated</p>
				<p>No linitation products</p>
				<p>Participants: all marketplace integrated</p>
				<p>No linitation products</p>
			</div>
  		</div>
	</div>
</#macro>

<#macro subscriptionProcentPriceModul valueProcent>
	<div class="price-section">
		<div class="row">
			<div class="col-sm-5 subscription-price">
				<div class="price">
					<h3>Only <span>${valueProcent}</span><span>%</span></h3>
					<h4>from products sold </h4>
	                <a class="stylish-btn stylish-sav-btn btn button-default" data-toggle="modal"> Book now </a>
				</div>
			</div>
			<div class="col-sm-7 subscription-info">
				<p>Participants: all marketplace integrated</p>
				<p>No linitation products</p>
				<p>Participants: all marketplace integrated</p>
				<p>No linitation products</p>
			</div>
		</div>
	</div>
</#macro>

