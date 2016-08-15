<#if orders??>
    <#list orders as order>
    	<#if order.id??>
    		Order ${order.id} -> <a href="orders/${order.id}">Details</a>
    		</br>
    	</#if>
    	<#if order.date??>
    		Date: ${order.date?date}
    		</br>
    	</#if>
    	<#if order.marketplace??>
    		Marketplace: ${order.marketplace}
    		</br>
    	</#if>
    	<#if order.status??>
    		Status: ${order.status}
    		</br>
    	</#if>
    	<#if order.total??>
    		Total: ${order.total}
    		</br>
    	</#if>
		</br>
    </#list>
</#if>