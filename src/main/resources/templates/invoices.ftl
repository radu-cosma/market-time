<section class="content-header">
    <h1><@spring.message 'INVOICES.PAGE.TITLE'/></h1>
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
        <li class="active"><@spring.message 'NAVIGATION.INVOICES'/></li>
    </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
        <div class="row-style row">
            <div class="padding-0 col-xs-12 col-sm-offset-1 col-sm-10">
                <label><@spring.message 'INVOICES.SORT.LABEL'/></label>
                <div class="dropdown-select">
                    <select name="sort">
                        <option value="1"><@spring.message 'INVOICES.SORT.DATE'/></option>
                        <option value="2"><@spring.message 'INVOICES.SORT.STATUS'/></option>
                    </select>
                </div>
                <label><@spring.message 'INVOICES.PER.PAGE.LABEL'/></label>
                <div class="dropdown-select">
                    <select name="invoices per page">
                        <option value="1">10</option>
                        <option value="2">25</option>
                        <option value="3">50</option>
                        <option value="4">100</option>
                        <option value="5"><@spring.message 'INVOICES.PER.PAGE.ALL'/></option>
                    </select>
                </div>
                <div>
                    <ul id="invoices-list">
                        <@createInvoiceSection/>
                        <@createInvoiceSection/>
                    </ul> 
                </div> 
                
                <#macro createInvoiceSection>
                    <li>
                        <div class="row invoice-details">
                            <div class="col-md-2 col-sm-4 col-xs-6">
                                <strong><@spring.message 'INVOICES.DETAILS.NUMBER'/></strong>
                                <p>12342</p>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6">
                                <strong><@spring.message 'INVOICES.DETAILS.TYPE'/></strong>
                                <p>Subcription</p>
                            </div> 
                            <div class="col-md-2 col-sm-4 col-xs-6">
                                <strong><@spring.message 'INVOICES.DETAILS.CREATED.DATE'/></strong>
                                <p>11/2/2017</p>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6">
                                <strong><@spring.message 'INVOICES.DETAILS.DUE.DATE'/></strong>
                                <p>12/2/2017</p>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6">
                                <strong><@spring.message 'INVOICES.DETAILS.PRICE'/></strong>
                                <p>$345.50</p>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6">
                                <a><div class="btn form-btn blue"><@spring.message 'INVOICES.DETAILS.VIEW.BUTTON'/></div></a>
                            </div>
                        </div>
                    </li> 
                </#macro>
            </div>
        </div>
    </div>
</section>