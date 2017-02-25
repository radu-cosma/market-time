<section class="content-header">
    <#if order.id??>
        <h1><@spring.message 'ORDERS.DETAILS.NUMBER'/>: ${order.id}</h1>
    </#if>
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
        <li><a href="/market-time/orders"><@spring.message 'NAVIGATION.ORDERS'/></a></li>
        <li class="active"><@spring.message 'NAVIGATION.ORDER.DETAILS'/></li>
    </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
            <div class="row-style row">
                <div class="order-details-padding col-xs-12 col-sm-offset-1 col-sm-10">
                    <div id="success-message" class="order-error-message success-message alert alert-success hidden">
                    <a href="#" class="close-message close">&times;</a>
                    <strong>!</strong>
                </div>
                <div id="general-error-message" class="order-error-message error-message alert alert-danger hidden">
                    <a href="#" class="close-message close">&times;</a>
                    <strong>!</strong>
                </div>
                <#if order??>
                    <#if order.product??>
                        <#assign product = order.product/>    
                        <div class="row">
                            <h2 class="subtitle"><@spring.message 'ORDER.DETAILS.PRODUCT.TITLE'/></h2>
                            <div class="order-separator-order-details"></div> 
                            <div class="order-product-padding col-md-2 col-xs-5">
                                <img class="product-img-order img-responsive" src="../images/inovation.png" alt="Product image" />
                            </div>
                            <div class="col-md-4 col-xs-7">
                                <#if product.price??>
                                    <p><strong><@spring.message 'ORDER.DETAILS.PRODUCT.PRICE'/>:</strong> ${product.price}</p>
                                </#if>
                                <p><strong><@spring.message 'ORDER.DETAILS.PRODUCT.QUANTITY'/>:</strong> HARDCODED</p>
                                <p class="total-order-details"><@spring.message 'ORDER.DETAILS.PRODUCT.TOTAL'/>: HARDCODED</p>
                            </div>
                            <div class="order-product-padding col-md-6 col-xs-12">
                                <#if product.name??>
                                    <p><strong><@spring.message 'ORDER.DETAILS.PRODUCT.NAME'/>:</strong> ${product.name}</p> 
                                </#if>
                                <#if product.brand??>
                                      <p><strong><@spring.message 'ORDER.DETAILS.PRODUCT.BRAND'/>:</strong> ${product.brand}</p>
                                </#if>
                                <#if product.color??>
                                      <p><strong><@spring.message 'ORDER.DETAILS.PRODUCT.COLOR'/>:</strong> ${product.color}</p>
                                </#if>
                                <#if product.size??>
                                      <p><strong><@spring.message 'ORDER.DETAILS.PRODUCT.SIZE'/>:</strong> ${product.size}</p>
                                </#if>
                            </div>  
                       </div>      
                    </#if>              
              
                    <#if order.shippingInfo??>
                        <#assign shippingInfo = order.shippingInfo/>    
                        <div class="row">
                            <h2 class="subtitle"><@spring.message 'ORDER.DETAILS.SHIPPING.TITLE'/></h2>
                            <div class="order-separator-order-details"></div>
                            <div class="ship-details col-sm-6">
                                <#if shippingInfo.firstName??>
                                    <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.FIRST.NAME.LABEL'/>:</strong> ${shippingInfo.firstName}</p>
                                </#if>
                                <#if shippingInfo.lastName??>
                                    <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.LAST.NAME.LABEL'/>:</strong> ${shippingInfo.lastName}</p>
                                </#if>
                                <#if shippingInfo.address??>
                                    <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.ADDRESS.LABEL'/>:</strong> ${shippingInfo.address}</p>
                                </#if>
                                <#if shippingInfo.email??>
                                    <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.EMAIL.LABEL'/>:</strong> ${shippingInfo.email}</p>
                                </#if>
                                <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.COUNTRY.LABEL'/>:</strong> HARCODED</p>
                            </div>
                            <div class="ship-details col-sm-6">
                                <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.STATE.LABEL'/>:</strong> HARDCODED</p>
                                <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.CITY.LABEL'/>:</strong> HARDCODED</p>
                                <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.POSTAL.CODE.LABEL'/>:</strong> HARDCODED</p>
                                <#if shippingInfo.phoneNumber??>
                                    <p><strong><@spring.message 'ORDER.DETAILS.SHIPPING.PHONE.LABEL'/>:</strong> ${shippingInfo.phoneNumber}</p>
                                </#if>
                            </div>
                        </div>  
                    </#if>   
          
                    <div class="row">
                        <div class="order-details col-sm-6">
                            <h2 class="subtitle"><@spring.message 'ORDER.DETAILS.ORDER.TITLE'/></h2>
                            <div class="order-separator-order-details"></div>
                            <#if order.quantity??>
                                <p><strong><@spring.message 'ORDER.DETAILS.ORDER.QUANTITY'/>:</strong> ${order.quantity}</p>
                            </#if>           
                                <p><strong><@spring.message 'ORDER.DETAILS.ORDER.PRICE'/>:</strong> HARDCODED</p>
                            <#if order.shippingCost??>
                                <p><strong><@spring.message 'ORDER.DETAILS.ORDER.SHIPPING'/>:</strong> ${order.shippingCost}</p>
                            </#if>
                            <#if order.total??>
                                <p class="total-order-details"><@spring.message 'ORDER.DETAILS.ORDER.TOTAL'/>: ${order.total}</p>
                            </#if>
                        </div> 
                        <div class="trans-info col-sm-6">
                            <h2 class="subtitle"><@spring.message 'ORDER.DETAILS.TRANSACTION.TITLE'/></h2>
                            <div class="order-separator-order-details"></div>
                            <#if order.transactionId??>  
                                <p><strong><@spring.message 'ORDER.DETAILS.TRANSACTION.ID'/>:</strong> ${order.transactionId}</p>
                            </#if>  
                            <#if order.transactionDate??>
                                <p><strong><@spring.message 'ORDER.DETAILS.TRANSACTION.TIME'/>:</strong> ${order.transactionDate?datetime}</p>
                            </#if>
                            <#if order.transactionStatus??>
                                <p><strong><@spring.message 'ORDER.DETAILS.TRANSACTION.STATE'/>:</strong> ${order.transactionStatus}</p>
                            </#if>
                        </div>
                    </div>
          
                    <div class="row">
                        <h2 class="subtitle">Action</h2>
                        <div class="order-separator-order-details"></div>
                        <ul class="nav nav-pills">
                            <li><a data-toggle="tab" href="#ship_order"><@spring.message 'ORDER.DETAILS.ACTION.SHIP.TAB.TITLE'/></a></li>
                            <li><a data-toggle="tab" href="#refund_order"><@spring.message 'ORDER.DETAILS.ACTION.REFUND.TAB.TITLE'/></a></li>
                            <li><a data-toggle="tab" href="#edit_shipping_address_order"><@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.TAB.TITLE'/></a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="ship_order" class="tab-pane fade">
                                <div class="action-details">
                                    <h2 class="subtitle-black"><@spring.message 'ORDER.DETAILS.ACTION.SHIP.SUBTITLE'/></h2>
                                    <br>
                                    <label><@spring.message 'ORDER.DETAILS.ACTION.SHIP.PROVIDER.LABEL'/> *</label>
                                    <div class="dropdown-select">
                                        <select name="shipping provider">
                                            <option value="1" selected="true" disabled="disabled"><@spring.message 'ORDER.DETAILS.ACTION.SHIP.PROVIDER.DROPDOWN'/></option>
                                            <option value="2">HARDCODED provider China</option>
                                            <option value="3">HARDCODED provider Romania</option>
                                            <option value="4">HARDCODED provider Germania</option>
                                            <option value="5">HARDCODED provider Italia</option>
                                        </select>
                                    </div>
                                    <textarea class="textarea-style" rows="5" cols="50" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.SHIP.TEXTAREA.NOTE.PLACEHOLDER'/>"></textarea>
                                    <br>
                                    <button type="submit" class="btn btn-default"><@spring.message 'ORDER.DETAILS.ACTION.SHIP.SAVE.BUTTON.NAME'/></button>
                                    <a class="cancel-form"><@spring.message 'ORDER.DETAILS.ACTION.SHIP.CANCEL.BUTTON.NAME'/></a>
                                </div>
                            </div>
                        
                            <div id="refund_order" class="tab-pane fade">
                                <div class="action-details">
                                    <h2 class="subtitle-black"><@spring.message 'ORDER.DETAILS.ACTION.REFUND.SUBTITLE'/></h2>
                                    <br>
                                    <label><@spring.message 'ORDER.DETAILS.ACTION.REFUND.LABEL'/> *</label>
                                    <div class="dropdown-select">
                                        <select name="refund reasons">
                                            <option value="1" selected="true" disabled="disabled"><@spring.message 'ORDER.DETAILS.ACTION.REFUND.REASON.DROPDOWN'/></option>
                                            <option value="2"><@spring.message 'ORDER.DETAILS.ACTION.REFUND.REASON.UNABLE.FULFILL'/></option>
                                            <option value="3"><@spring.message 'ORDER.DETAILS.ACTION.REFUND.REASON.ORDER.SYSTEM'/></option>
                                        </select>
                                    </div>
                                    <textarea class="textarea-style" rows="5" cols="50" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.REFUND.DESCRIPTION.PLACEHOLDER'/>"></textarea>
                                    <br>
                                    <button type="submit" class="btn btn-default"><@spring.message 'ORDER.DETAILS.ACTION.REFUND.SAVE.BUTTON.NAME'/></button>
                                    <a class="cancel-form"><@spring.message 'ORDER.DETAILS.ACTION.REFUND.CANCEL.BUTTON.NAME'/></a>
                                </div>
                            </div>
                            
                            <div id="edit_shipping_address_order" class="tab-pane fade">
                                <div class="action-details">
                                    <h2 class="subtitle-black"><@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.SUBTITLE'/></h2>
                                    <br>
                                    <div class="row">
                                        <div class="edit-shipping-padding col-md-6 col-sm-12">
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.FIRST.NAME.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.FIRST.NAME.PLACEHOLDER'/> " value="${shippingInfo.firstName}" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                            </div>
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.LAST.NAME.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.LAST.NAME.PLACEHOLDER'/>" value="${shippingInfo.lastName}" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                                </div>
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.ADDRESS.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.ADDRESS.PLACEHOLDER'/>" value="${shippingInfo.address}" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                            </div>
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.EMAIL.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.EMAIL.PLACEHOLDER'/>" value="${shippingInfo.email}" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                            </div>
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.COUNTRY.LABEL'/></label>
                                                <div class="country-shipping-action dropdown-select">
                                                    <select name="refund reasons">
                                                        <option value="1" selected="true" disabled="disabled">HARDCODED</option>
                                                        <option value="2"><@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.COUNTRY.ROMANIA'/></option>
                                                        <option value="3"><@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.COUNTRY.FRANCE'/></option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="edit-shipping-padding col-md-6 col-sm-12">
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.STATE.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.STATE.PLACEHOLDER'/>" value="HARDCODED" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                            </div>
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.CITY.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.CITY.PLACEHOLDER'/>" value="HARDCODED" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                            </div>
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.POSTAL.CODE.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.POSTAL.CODE.PLACEHOLDER'/>" value="HARDCODED" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                            </div>
                                            <div class="form-group form-icon-poz">
                                                <label for="text"><@spring.message 'ORDER.DETAILS.SHIPPING.PHONE.LABEL'/></label>
                                                <input type="text" class="form-control" placeholder="<@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.PHONE.PLACEHOLDER'/>" value="${shippingInfo.phoneNumber}" data-validations="required">
                                                <div class="tooltip-wrapper"><span class="error-tooltip"></span></div>
                                            </div>
                                        </div>
                                        <div class="edit-shipping-button-padding col-md-12 col-sm-12">
                                            <button type="submit" class="btn btn-default"><@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.SAVE.BUTTON.NAME'/></button>
                                            <a class="cancel-form"><@spring.message 'ORDER.DETAILS.ACTION.EDIT.SHIPPING.CANCEL.BUTTON.NAME'/></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                    </div>  
                </#if>
            </div>
        </div>
    </div>
</section>
