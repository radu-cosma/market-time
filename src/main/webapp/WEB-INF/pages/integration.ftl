<div id="integration-page-header">
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <div class="md-title">
                <@spring.message 'INTEGRATION.DETAILS.TITLE'/>
            </div>
            <div class="sub-title">
                <@spring.message 'INTEGRATION.DETAILS.SUBTITLE'/>
            </div>
        </div>
	</div>
</div>

<div id="integration-page-body">
	<div class="row">
	    <@createIntegrationTitle />
		<div class="col-md-10 col-md-offset-1 integration-section-mobile">
			<div class="integration-details">
				<div class="info-details first-level-markets">
				    <a class="toggle-description"><@createIntegratedMarket marketId="wish" marketImg="wish-logo.png" altImg="wish image" /></a>
				    <@createMarketInfo forMarket='wish' detailsTitleKey='WISH.DETAILS.TITLE' detailsSubtitleKey='WISH.DETAILS.SUBTITLE' 
				    detailsMarketFirstSectionTitleKey='WISH.DETAILS.MARKET.FIRST.SECTION.TITLE' detailsMarketFirstSectionP1Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.1'
				    detailsMarketFirstSectionP2Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.2' detailsMarketFirstSectionP3Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.3'
				    detailsMarketSecondSectionTitleKey='WISH.DETAILS.MARKET.SECOND.SECTION.TITLE' detailsMarketSecondSectionP1Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.1' 
				    detailsMarketSecondSectionP2Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.2' detailsMarketSecondSectionP3Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.3'
				    marketDiagramImg="MarketTime_wish_Diagram.png" altImg="market time diagrame" detailsMarketFlowTitleKey='WISH.DETAILS.MARKET.FLOW.TITLE' detailsMarketFlowP1Key='WISH.DETAILS.MARKET.FLOW.PARAGRAPH' />				  	
				</div> 
				<div class="info-details first-level-markets">	
				    <a class="toggle-description"><@createIntegratedMarket marketId="amazon" marketImg="amazon-logo.png" altImg="amazon image" /></a> 
				    <@createMarketInfo forMarket='amazon' detailsTitleKey='WISH.DETAILS.TITLE' detailsSubtitleKey='WISH.DETAILS.SUBTITLE' 
				    detailsMarketFirstSectionTitleKey='WISH.DETAILS.MARKET.FIRST.SECTION.TITLE'detailsMarketFirstSectionP1Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.1'
				    detailsMarketFirstSectionP2Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.2' detailsMarketFirstSectionP3Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.3'
				    detailsMarketSecondSectionTitleKey='WISH.DETAILS.MARKET.SECOND.SECTION.TITLE' detailsMarketSecondSectionP1Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.1' 
				    detailsMarketSecondSectionP2Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.2' detailsMarketSecondSectionP3Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.3' 
				    marketDiagramImg="MarketTime_wish_Diagram.png" altImg="market time diagrame" detailsMarketFlowTitleKey='WISH.DETAILS.MARKET.FLOW.TITLE' detailsMarketFlowP1Key='WISH.DETAILS.MARKET.FLOW.PARAGRAPH' />	 
				</div> 
				<div class="info-details first-level-markets">	
				    <a class="toggle-description"><@createIntegratedMarket marketId="ebay" marketImg="ebay-logo.png" altImg="ebay image" /></a>
				    <@createMarketInfo forMarket='ebay' detailsTitleKey='WISH.DETAILS.TITLE' detailsSubtitleKey='WISH.DETAILS.SUBTITLE' 
				    detailsMarketFirstSectionTitleKey='WISH.DETAILS.MARKET.FIRST.SECTION.TITLE' detailsMarketFirstSectionP1Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.1'
				    detailsMarketFirstSectionP2Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.2' detailsMarketFirstSectionP3Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.3'
				    detailsMarketSecondSectionTitleKey='WISH.DETAILS.MARKET.SECOND.SECTION.TITLE' detailsMarketSecondSectionP1Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.1' 
				    detailsMarketSecondSectionP2Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.2' detailsMarketSecondSectionP3Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.3' 
				    marketDiagramImg="MarketTime_wish_Diagram.png" altImg="market time diagrame" detailsMarketFlowTitleKey='WISH.DETAILS.MARKET.FLOW.TITLE' detailsMarketFlowP1Key='WISH.DETAILS.MARKET.FLOW.PARAGRAPH' />	
			    </div>
				<div class="info-details first-level-markets">	
				    <a class="toggle-description"><@createIntegratedMarket marketId="spartoo" marketImg="spartoo-logo.png" altImg="spartoo image" /></a>
					<@createMarketInfo forMarket='spartoo' detailsTitleKey='WISH.DETAILS.TITLE' detailsSubtitleKey='WISH.DETAILS.SUBTITLE' 
					detailsMarketFirstSectionTitleKey='WISH.DETAILS.MARKET.FIRST.SECTION.TITLE' detailsMarketFirstSectionP1Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.1'
				    detailsMarketFirstSectionP2Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.2' detailsMarketFirstSectionP3Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.3'
				    detailsMarketSecondSectionTitleKey='WISH.DETAILS.MARKET.SECOND.SECTION.TITLE' detailsMarketSecondSectionP1Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.1' 
				    detailsMarketSecondSectionP2Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.2' detailsMarketSecondSectionP3Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.3' 
				    marketDiagramImg="MarketTime_spartoo_Diagram.png" altImg="market time diagrame" detailsMarketFlowTitleKey='WISH.DETAILS.MARKET.FLOW.TITLE' detailsMarketFlowP1Key='WISH.DETAILS.MARKET.FLOW.PARAGRAPH' />	 
				</div>    
				<div class="info-details second-level-markets">	
				    <a class="toggle-description"><@createIntegratedMarket marketId="ebay1" marketImg="ebay-logo.png" altImg="ebay image" /></a>
				    <@createMarketInfo forMarket='ebay1' detailsTitleKey='WISH.DETAILS.TITLE' detailsSubtitleKey='WISH.DETAILS.SUBTITLE' 
				    detailsMarketFirstSectionTitleKey='WISH.DETAILS.MARKET.FIRST.SECTION.TITLE' detailsMarketFirstSectionP1Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.1'
				    detailsMarketFirstSectionP2Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.2' detailsMarketFirstSectionP3Key='WISH.DETAILS.MARKET.FIRST.SECTION.PARAGRAPH.3'
				    detailsMarketSecondSectionTitleKey='WISH.DETAILS.MARKET.SECOND.SECTION.TITLE' detailsMarketSecondSectionP1Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.1' 
				    detailsMarketSecondSectionP2Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.2' detailsMarketSecondSectionP3Key='WISH.DETAILS.MARKET.SECOND.SECTION.PARAGRAPH.3' 
				    marketDiagramImg="MarketTime_wish_Diagram.png" altImg="market time diagrame" detailsMarketFlowTitleKey='WISH.DETAILS.MARKET.FLOW.TITLE' detailsMarketFlowP1Key='WISH.DETAILS.MARKET.FLOW.PARAGRAPH' />	
			    </div> 
				</div> 	  
			</div>    
     	</div>   
	</div>
</div>

<#macro createIntegrationTitle>
	<div class="col-md-10 col-md-offset-1">
		<div class="integration-header">
			<div class="integration-title">
				<h3><@spring.message 'INTEGRATION.DETAILS.HEADER.1'/></h3>
			</div>
		</div>
	</div>
</#macro>

<#macro createIntegratedMarket marketId marketImg altImg>
	<div class="col-sm-4 col-md-3 market-integration-section">
		<div class="market-integration" id="${marketId}">
		    <img class="market-integration-image img-responsive" src="/market-time/images/${marketImg}" alt="${altImg}">
		</div>		
	</div>
</#macro>

<#macro createMarketInfo forMarket detailsTitleKey detailsSubtitleKey detailsMarketFirstSectionTitleKey detailsMarketFirstSectionP1Key detailsMarketFirstSectionP2Key 
detailsMarketFirstSectionP3Key detailsMarketSecondSectionTitleKey detailsMarketSecondSectionP1Key detailsMarketSecondSectionP2Key detailsMarketSecondSectionP3Key 
marketDiagramImg altImg detailsMarketFlowTitleKey detailsMarketFlowP1Key >
	<div class="info" for-market='${forMarket}'>
    	<a 	class="close close-market-details"> <@spring.message 'INTEGRATION.DETAILS.CLOSE.BUTTON'/> </a>
    	<div class="md-title market-details-title">
        	<@spring.message detailsTitleKey/>
		</div>
	    <div class="sub-title market-details-subtitle">
	    	<@spring.message detailsSubtitleKey/>
		</div>
		<div class="row">
			<div class="col-md-6 col-xs-12">
				<div class="details-section-title">
    				<strong><@spring.message detailsMarketFirstSectionTitleKey/></strong>
    			</div>
				<p><@spring.message detailsMarketFirstSectionP1Key/></p>
				<p><@spring.message detailsMarketFirstSectionP2Key/></p>
				<p><@spring.message detailsMarketFirstSectionP3Key/></p>
				<div class="details-section-title">
    				<strong><@spring.message detailsMarketSecondSectionTitleKey/></strong>
    			</div>
				<p><@spring.message detailsMarketSecondSectionP1Key/></p>
				<p><@spring.message detailsMarketSecondSectionP2Key/></p>
				<p><@spring.message detailsMarketSecondSectionP3Key/></p>
			</div>
			<div class="col-md-6 col-xs-12 ">
			    <img class="img-responsive details-market-img" src="./images/wish-site-img.png" alt="Test" />
			</div>
		</div>
		
		<div class="row">
	        <div id="how-works" class="col-md-12">
	            <div class="details-section-title">
	                <strong><@spring.message detailsMarketFlowTitleKey/></strong>
	                <p></p>
    				<p><@spring.message detailsMarketFlowP1Key/></p>
    			</div>
    		</div>		
            <div class="col-md-8 col-md-offset-2 col-xs-12">
		    	<img class="img-responsive" src="./images/${marketDiagramImg}" alt="${altImg}" />
		    </div>
		</div>
		
		<div class="row">
			<div id="backgroung-integration-contact">
    			<div id="integration-about-contact" class="row">
			        <div class="col-md-6  col-xs-12">
			            <div class="details-section-title">
			                <strong><@spring.message 'INTEGRATION.DETAILS.FOOTER.TITLE'/></strong>
			                <p></p>
            				<strong><@spring.message 'INTEGRATION.DETAILS.FOOTER.SUBTITLE'/></strong>
            			</div>
    					<p><@spring.message 'INTEGRATION.DETAILS.FOOTER.PARAGRAPH.1'/></p>
						<p><@spring.message 'INTEGRATION.DETAILS.FOOTER.PARAGRAPH.2'/></p>
    					<p><@spring.message 'INTEGRATION.DETAILS.FOOTER.PARAGRAPH.3'/></p>

			        </div>   
			        <div id="integration-contact" class="col-md-6  col-xs-12">
			            <div class="details-section-title">
			            <strong><@spring.message 'INTEGRATION.DETAILS.FOOTER.CONTACT.TITLE'/></strong>
			            </div>
			            <br>
			            <p><@spring.message 'INTEGRATION.DETAILS.FOOTER.CONTACT.EMAIL'/></p>
			            <br>
			            <p><@spring.message 'INTEGRATION.DETAILS.FOOTER.CONTACT.PHONE'/></p>
			            <br>
			            <p><strong><@spring.message 'INTEGRATION.DETAILS.FOOTER.CONTACT.WEBSITE'/></strong></p>        
			        </div>
		        </div>
		    </div>    
	    </div>
  	</div>
</#macro>
