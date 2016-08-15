<#if order??>
	<#if order.id??>
		order id:${order.id}
		</br
	</#if>
	
	<#if order.product??>
		<#assign product = order.product/>
		product info: 
		</br>
		<#if product.name??>
			product name: ${product.name}
		</#if>
		</br>. 
		</br>. 
		</br>. 
		</br>
	</#if>
	
	<#if order.shippingInfo??>
		<#assign shippingInfo = order.shippingInfo/>
		<#if shippingInfo.firstName??>
			name: ${shippingInfo.firstName} 
		</#if>
		<#if shippingInfo.lastName??>
			${shippingInfo.lastName}
			</br>
		</#if>
		<#if shippingInfo.address??>
			address: ${shippingInfo.address}
			</br>
		</#if>
		<#if shippingInfo.email??>
			email: ${shippingInfo.email}
			</br>
		</#if>
		<#if shippingInfo.phoneNumber??>
			phoneNumber: ${shippingInfo.phoneNumber}
			</br>
		</#if>
	</#if>
	
	<#if order.transactionId??>
		transaction id:${order.transactionId}
		</br>
	</#if>
	<#if order.transactionDate??>
		transaction date:${order.transactionDate?datetime}
		</br>
	</#if>
	<#if order.transactionStatus??>
		transaction status:${order.transactionStatus}
		</br>
	</#if>
	<#if order.quantity??>
		quantity:${order.quantity}
		</br>
	</#if>
	<#if order.shippingCost??>
		shippingCost:${order.shippingCost}
		</br>
	</#if>
	<#if order.total??>
		total:${order.total}
		</br>
	</#if>
</#if>