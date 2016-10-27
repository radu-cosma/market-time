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
	    <@createGroupTitle groupTitle="Save BIG on you next subcription" />
		<div class="col-md-10 col-md-offset-1">
        	<@subscriptionSavePriceModule save="save" currency="&euro;" saveValue="75" saveContent="3 months subscription for" priceValue="22" period="/month" only="" procentValue="" procentContent="" />          
		    <@subscriptionSavePriceModule save="" currency="" saveValue="" saveContent="" priceValue="" period="" only="Only" procentValue="5%" procentContent="from products sold" />          
		</div>
	</div>
</div>

<#macro createGroupTitle groupTitle>
	<div class="col-md-10 col-md-offset-1">
		<div class="subscription-header">
			<div class="subscription-title">
				<h3>${groupTitle}</h3>
			</div>
		</div>
	</div>
</#macro>

<#macro subscriptionSavePriceModule save currency saveValue saveContent priceValue period only procentValue procentContent>
    <div class="price-section">
		<div class="row">
			<div class="col-sm-5 subscription-price">
		       <div class="price">
					<h3>${save} <span>${currency}${saveValue}</span></h3>
					<h4>${saveContent} <span>${currency}${priceValue}</span>${period}</h4>
					<h3>${only} <span>${procentValue}</span></h3>
		            <h4>${procentContent} </h4>
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

