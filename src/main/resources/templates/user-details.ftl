<section class="content-header">
    <h1>Healthysoft Consulting</h1> 
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
        <li><a href="/market-time/users"><@spring.message 'NAVIGATION.USERS'/></a></li>
        <li class="active"><@spring.message 'NAVIGATION.USER.DETAILS'/></li>
    </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
        <div class="row"> 
            <div class="col-sm-offset-1 col-sm-10 col-xs-12 ">
                <h2 class="subtitle"><@spring.message 'USER.DETAILS.PROFILE.TITLE'/></h2>
                <div class="separator-line"></div> 
                <div class="col-sm-6 col-xs-12">
                    <p><strong><@spring.message 'PROFILE.FIRST.NAME.LABEL'/>:</strong> Daniel</p>
                    <p><strong><@spring.message 'PROFILE.LAST.NAME.LABEL'/>:</strong> Huluban</p>
                    <p><strong><@spring.message 'PROFILE.COMPANY.NAME.LABEL'/>:</strong> Healthysoft</p>
                </div>
                <div class="col-sm-6 col-xs-12">
                    <p><strong><@spring.message 'PROFILE.COMPANY.ADDRESS.LABEL'/>:</strong> Cluj Napoca</p>
                    <p><strong><@spring.message 'PROFILE.COMPANY.PHONE.LABEL'/>:</strong> 07454545453</p>
                    <p><strong><@spring.message 'PROFILE.EMAIL.LABEL'/>:</strong> daniel@huluban.com</p>
                </div>
                <h2 class="subtitle"><@spring.message 'USER.DETAILS.SUBSCRIPTIONS.TITLE'/></h2>
                <div class="separator-line"></div> 
                <div class="col-sm-12">
                    <h4><strong><@spring.message 'USER.DETAILS.ACTIVE.SUBSCRIPTIONS'/></strong></h4>
                    <ul id="active-subscriptions-list">
                        <@createSubscriptionSection/>
                        <@createSubscriptionSection/>
                        <@createSubscriptionSection/>
                    </ul>
                </div> 
                <div id="inactive-subscriptions-section">                   
                    <a data-toggle="collapse" href="#inactive-subscriptions-list"><@spring.message 'USER.DETAILS.INACTIVE.SUBSCRIPTIONS'/></a>
                    <ul id="inactive-subscriptions-list" class="collapse">
                        <@createSubscriptionSection isActive=false/>
                        <@createSubscriptionSection isActive=false/>
                </div>
                <h2 class="subtitle"><@spring.message 'USER.DETAILS.ORDERS.TITLE'/></h2>
                <div class="separator-line"></div> 
                <div id="orders">
                    <a id="view-all-orders"><@spring.message 'USER.DETAILS.ALL.ORDERS'/></a>
                    <ul id="orders-list">
                       <@createOrderSection/>   
                       <@createOrderSection/>                 
                    </ul> 
                </div> 
                <h2 class="subtitle"><@spring.message 'USER.DETAILS.INVOICES.TITLE'/></h2>
                <div class="separator-line"></div>  
                <div id="invoices">
                    <a id="view-all-invoices"><@spring.message 'USER.DETAILS.ALL.INVOICES'/></a>
                    <ul id="invoices-list">
                        <@createInvoiceSection/>
                        <@createInvoiceSection/>
                    </ul> 
                </div>       
            </div>    
        </div>
    </div>
</section>

<#macro createSubscriptionSection isActive=true >
    <li>
        <div class="active-mark-section<#if !isActive> inactive-mark-section</#if> col-sm-6">
            <p><strong>Standard Subscription (6 month)</strong></p>
            <p>Start date: 12/01/2017 - End date: 12/06/2017</p>
            <p>Price: 150.50 euro/month</p>
            <p>Total price: <strong>903.00 euro</strong></p>
        </div>
    </li>
</#macro>

<#macro createOrderSection>
    <li>
        <div class="order">
            <a><div class="btn form-btn blue pull-right"><@spring.message 'ORDERS.DETAILS.VIEW.BUTTON'/></div></a>
            <h2 class="order-nr-title"><@spring.message 'ORDERS.DETAILS.NUMBER'/>: 12345</h2>                                 
            <div class="row order-body"> 
                <div class="col-sm-2 col-xs-6"> 
                    <strong><@spring.message 'USER.DETAILS.ORDERS.DATE'/></strong> 
                    <p>12/2/2017</p>
                </div>
                <div class="col-sm-4 col-xs-6"> 
                    <strong><@spring.message 'USER.DETAILS.ORDERS.MARKETPLACE'/></strong>
                    <p>eBay</p> 
                </div>
                <div class="col-sm-2 col-xs-6">
                    <strong><@spring.message 'USER.DETAILS.ORDERS.PRICE'/></strong> 
                    <p>523.23</p>
                </div>
                <div class="col-sm-4 col-xs-6"> 
                    <strong><@spring.message 'USER.DETAILS.ORDERS.STATUS'/></strong>
                    <p class="order-status">done</p> 
                </div>
            </div>
        </div>
    </li> 
</#macro>

<#macro createInvoiceSection>
    <li>
        <div class="row invoice-details">
            <div class="col-sm-2 col-xs-6">
                <strong><@spring.message 'USER.DETAILS.INVOICE.NUMBER'/></strong>
                <p>12342</p>
            </div>
            <div class="col-sm-2 col-xs-6">
                <strong><@spring.message 'USER.DETAILS.INVOICE.TYPE'/></strong>
                <p>Subcription</p>
            </div> 
            <div class="col-sm-2 col-xs-6">
                <strong><@spring.message 'USER.DETAILS.INVOICE.CREATED.DATE'/></strong>
                <p>11/2/2017</p>
            </div>
            <div class="col-sm-2 col-xs-6">
                <strong><@spring.message 'USER.DETAILS.INVOICE.DUE.DATE'/></strong>
                <p>12/2/2017</p>
            </div>
            <div class="col-sm-2 col-xs-6">
                <strong><@spring.message 'USER.DETAILS.INVOICE.PRICE'/></strong>
                <p>$345.50</p>
            </div>
            <div class="col-sm-2 col-xs-6">
                <a><div class="btn form-btn blue pull-right"><@spring.message 'USER.DETAILS.INVOICE.VIEW.BUTTON'/></div></a>
            </div>
        </div>
    </li> 
</#macro>
