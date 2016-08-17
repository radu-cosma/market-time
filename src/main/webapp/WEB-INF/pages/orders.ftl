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
    <div id="publish-oredrs-id" class="row-style row">
      <div class="padding-0 col-xs-12 col-sm-offset-1 col-sm-10">
	    <div id="success-message" class="success-message alert alert-success hidden">
		  <a href="#" class="close-message close">&times;</a>
		  <strong>!</strong>
		</div>
		<div id="general-error-message" class="error-message alert alert-danger hidden">
		  <a href="#" class="close-message close">&times;</a>
		  <strong>!</strong>
		</div>
        <label>
          <@spring.message 'ORDERS.SORT.LABEL'/>
        </label>
        <div class="dropdown-select">
          <select name="sort">
	        <option value="1"><@spring.message 'ORDERS.SORT.DATE'/></option>
	        <option value="2"><@spring.message 'ORDERS.SORT.STATUS'/></option>
          </select>
        </div>
        <label>
          <@spring.message 'ORDERS.PER.PAGE.LABEL'/>
        </label>
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
	    		    <p class="desc"><@spring.message 'ORDERS.DETAILS.DATE'/>: ${order.date?date}</p>
	    	      </#if>
	            </div>
	            <div class="order-separator"></div>
	            <div class="order-body">  
	    	      <#if order.marketplace??>
	    		    <p class="desc"><@spring.message 'ORDERS.DETAILS.MARKETPLACE'/>: ${order.marketplace}</p>
	    	      </#if>
	    	      <#if order.total??>
	    		    <p class="desc"><@spring.message 'ORDERS.DETAILS.TOTAL'/>: ${order.total}</p>
	    	      </#if>
	              <#if order.status??>
	    		    <p class="order-status">${order.status}</p>
	    	      </#if>
	              <div class="delete-order"><a href=#delete-order-modal data-toggle="modal"><span class="fa fa-trash-o"></span></a>
			    </div>
			  </li>
	        </ul>
		  </#list>
		</#if>
      </div>
    </div>
  </div>
</section>

<div class="modal fade" id="delete-order-modal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="delete-modal-header modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h2 class="delete-modal-title modal-title"><@spring.message 'ORDERS.DETAILS.DELETE.MODAL.HEADER'/></h2>
      </div>
      <div class="modal-body">
        <p><@spring.message 'ORDERS.DETAILS.DELETE.MODAL.CONTENT'/></p>
        <button type="button" class="btn form-btn blue btn-img-style" data-dismiss="modal"><@spring.message 'ORDERS.DETAILS.DELETE.MODAL.BUTTON.CANCEL'/></button>
        <button type="button" class="btn form-btn red btn-img-style"><@spring.message 'ORDERS.DETAILS.DELETE.MODAL.BUTTON.DELETE'/></button>
      </div>
    </div>
  </div>
</div>
                           