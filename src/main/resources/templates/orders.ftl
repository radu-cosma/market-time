<section class="content-header">
      <h1><@spring.message 'ORDERS.PAGE.TITLE'/></h1>
      <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
        <li class="active"><@spring.message 'NAVIGATION.ORDERS'/></li>
      </ol>
</section>

<section class="content">
	<div class="box box-success">
        <div class="box-header with-border"></div>
        <div id="orders-id" class="row-style row">
              <div class="padding-0 col-xs-12 col-sm-offset-1 col-sm-10">
                <div id="success-message" class="success-message alert alert-success hidden">
                      <a href="#" class="close-message close">&times;</a>
                      <strong>!</strong>
                </div>
                <label><@spring.message 'ORDERS.SORT.LABEL'/></label>
                <div class="dropdown-select">
                      <select name="sort">
                        <option value="1"><@spring.message 'ORDERS.SORT.DATE'/></option>
                        <option value="2"><@spring.message 'ORDERS.SORT.STATUS'/></option>
                      </select>
                </div>
                <label><@spring.message 'ORDERS.PER.PAGE.LABEL'/></label>
                <div class="dropdown-select">
                      <select name="orders per page">
                        <option value="1">10</option>
                        <option value="2">25</option>
                        <option value="3">50</option>
                        <option value="4">100</option>
                        <option value="5"><@spring.message 'ORDERS.PER.PAGE.ALL'/></option>
                      </select>
                </div>
                <#if orders??>
                    <#list orders as order>
                        <ul class="order-list">
                            <li>
                                <div class="order">
                                    <#if order.id??>
                                        <a href="orders/${order.id}"><div class="btn form-btn blue go-right"><@spring.message 'ORDERS.DETAILS.VIEW.BUTTON'/></div></a>
                                        <h2 class="order-nr-title"><@spring.message 'ORDERS.DETAILS.NUMBER'/>: ${order.id}</h2> 
                                    </#if>
                                    <div class="row"> 
                                    <#if order.date??>
                                        <div class="col-sm-2 col-xs-4"> 
                                            <strong><@spring.message 'ORDERS.DETAILS.DATE'/></strong> 
                                            <p>${order.date?date}</p>
                                        </div>
                                    </#if> 
                                    <#if order.marketplace??>
                                        <div class="col-sm-4 col-xs-8">
                                            <strong><@spring.message 'ORDERS.DETAILS.MARKETPLACE'/></strong>
                                            <p>${order.marketplace}</p>
                                        </div>
                                    </#if>
                                    <#if order.total??>
                                        <div class="col-sm-2 col-xs-4">
                                            <strong><@spring.message 'ORDERS.DETAILS.TOTAL'/>
                                            <p>${order.total}</strong>
                                        </div>
                                    </#if>
                                    <#if order.status??>
                                        <div class="col-sm-4 col-xs-8">
                                            <strong><@spring.message 'ORDERS.DETAILS.STATUS'/></strong>
                                            <p class="order-status">${order.status}</p>
                                        </div>
                                    </#if>
                                </div>
                            </li>
                        </ul>
                    </#list>
                </#if>
            </div>
        </div>
    </div>
</section>
