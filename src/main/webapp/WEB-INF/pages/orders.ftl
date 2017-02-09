<section class="content-header">
      <h1><@spring.message 'ORDERS.PAGE.TITLE'/></h1>
      <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAV.HOME'/></a></li>
        <li class="active"><@spring.message 'ORDERS.NAV.PAGE'/></li>
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
                                <div class="order-head">
                                      <#if order.id??>
                                        <a href="orders/${order.id}"><div class="btn form-btn blue go-right"><@spring.message 'ORDERS.DETAILS.VIEW.BUTTON'/></div></a>
                                        <h2 class="order-nr-title"><@spring.message 'ORDERS.DETAILS.NUMBER'/>: ${order.id}</h2> 
                                      </#if>
                                      <#if order.date??>
                                        <p><@spring.message 'ORDERS.DETAILS.DATE'/>: ${order.date?date}</p>
                                      </#if>
                                </div>
                                <div class="order-separator"></div>
                                <div class="order-body">  
                                      <#if order.marketplace??>
                                        <p>${order.marketplace}</p>
                                      </#if>
                                      <#if order.total??>
                                        <strong><@spring.message 'ORDERS.DETAILS.TOTAL'/>: ${order.total}</strong>
                                      </#if>
                                      <#if order.status??>
                                        <p class="order-status">${order.status}</p>
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
