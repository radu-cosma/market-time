<section class="content-header">
    <h1><@spring.message 'PRODUCTS.PAGE.TITLE'/></h1>
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
        <li>
            <a href="/market-time/products?status=published">
                <@spring.message 'NAVIGATION.PRODUCTS.PUBLISHED'/>
            </a>
        </li>
        <li class="active">
            <@spring.message 'NAVIGATION.PRODUCTS'/>
        </li>
    </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
        <div id="publish-products-id" class="row-style row">
            <div class="padding-5 col-xs-12 col-sm-offset-1 col-sm-10">
                <label>
                    <@spring.message 'PRODUCTS.SORT.LABEL'/>
                </label>
                <div class="dropdown-select">
                    <select name="sort">
                        <option value="1"><@spring.message 'PRODUCTS.SORT.DATE'/></option>
                        <option value="2"><@spring.message 'PRODUCTS.SORT.CATEGORY'/></option>
                        <option value="3"><@spring.message 'PRODUCTS.SORT.PRICE.HIGH.LOW'/></option>
                        <option value="4"><@spring.message 'PRODUCTS.SORT.PRICE.LOW.HIGH'/></option>
                        <option value="5"><@spring.message 'PRODUCTS.SORT.NAME.AZ'/></option>
                        <option value="6"><@spring.message 'PRODUCTS.SORT.NAME.ZA'/></option>
                        <option value="7"><@spring.message 'PRODUCTS.SORT.PRODUCTS.HIGH.LOW'/></option>
                        <option value="8"><@spring.message 'PRODUCTS.SORT.PRODUCTS.LOW.HIGH'/></option>
                    </select>
                </div>
                <label>
                    <@spring.message 'PRODUCTS.PER.PAGE.LABEL'/>
                </label>
                <div class="dropdown-select">
                    <select name="products per page">
                        <option value="1">10</option>
                        <option value="2">25</option>
                        <option value="3">50</option>
                        <option value="4">100</option>
                        <option value="5"><@spring.message 'PRODUCTS.PER.PAGE.ALL'/></option>
                    </select>
                </div>
                <#if products??>
                    <#list products as product>
                        <ul class="event-list">
                            <li>
                                <div class="info">
                                    <img class="img-responsive product-img" src="images/inovation.png" alt="Product Image" />
                                    <#if product.name??>
                                        <h2 class="title">${product.name}</h2>
                                    </#if>
                                    <div class="row product-details">
                                        <#if product.price??>
                                            <div class="col-sm-2 col-xs-6 inside-label">
                                                <strong><@spring.message 'PRODUCTS.DETAILS.PRICE'/></strong>
                                                <p class="inside"> ${product.price}</p>
                                            </div>
                                        </#if>
                                        <#if product.inventory??>
                                            <div class="col-sm-3 col-xs-6 inside-label">
                                                <strong><@spring.message 'PRODUCTS.DETAILS.INVENTORY'/></strong>
                                                <p class="inside">${product.inventory}</p>
                                            </div>
                                        </#if>
                                        <#if product.brand??>
                                            <div class="col-sm-7 col-xs-12 inside-label">
                                                <strong><@spring.message 'PRODUCTS.DETAILS.BRAND'/></strong>
                                                <p class="inside">${product.brand}</p>
                                            </div>
                                        </#if>
                                    </div>
                                    <a class="form-btn blue details-btn" href="#">product details &#9660</a>
                                    <div class="details-container hidden">
                                        <div class="panel panel-details">
                                            <div class="panel-heading">
                                                <h3 class="panel-title"><@spring.message 'PRODUCTS.DETAILS.SECTION.HEADER'/></h3>
                                                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                                            </div>
                                            <div class="panel-collapse collapse in">
                                                <div class="product-panel-body">
                                                    <#if product.marketplace??>
                                                        <div  class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCT.DETAILS.MARKETPLACE'/></strong></div>
                                                            <div class="col-md-10 col-xs-12"> ${product.marketplace}</div>
                                                        </div>
                                                    </#if>
                                                    <#if product.shipping??>
                                                        <div  class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.SHIPPING'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.shipping}</div>
                                                        </div>
                                                    </#if>
                                                    <#if product.tags??>
                                                        <div class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.TAGS'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.tags}</div>
                                                        </div>
                                                    </#if> 
                                                    <#if product.shippingTime??>
                                                        <div class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.SHIPPING-TIME'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.shippingTime}</div>
                                                        </div>
                                                    </#if>
                                                    <#if product.color??>
                                                        <div class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.COLOR'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.color}</div>
                                                        </div>
                                                    </#if>
                                                    <#if product.size??>
                                                        <div class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.SIZE'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.size}</div>
                                                        </div>
                                                    </#if>
                                                    <#if product.landingPageUrl??>
                                                        <div class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.LANDING-PAGE-URL'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.landingPageUrl}</div>
                                                        </div>
                                                    </#if>
                                                    <#if product.upc??>
                                                        <div class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.UPC'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.upc}</div>
                                                        </div>
                                                    </#if>
                                                    <#if product.description??>
                                                        <div class="row">
                                                            <div class="col-md-2 col-xs-12"><strong><@spring.message 'PRODUCTS.DETAILS.DESCRIPTION'/>:</strong></div>
                                                            <div class="col-md-10 col-xs-12">${product.description}</div>
                                                        </div>
                                                    </#if>
                                                    <div class="variation-title"><@spring.message 'PRODUCTS.DETAILS.VARIATION.TITLE'/></div>
                                                    <div class="row">
                                                        <div class="col-md-4 col-xs-4"><strong><@spring.message 'PRODUCTS.DETAILS.INVENTORY'/></strong></div>
                                                        <div class="col-md-4 col-xs-4"><strong><@spring.message 'PRODUCTS.DETAILS.SIZE'/></strong></div>
                                                        <div class="col-md-4 col-xs-4"><strong><@spring.message 'PRODUCTS.DETAILS.COLOR'/></strong></div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-4 col-xs-3">${product.inventory}</div>
                                                        <div class="col-md-4 col-xs-4">${product.size}</div>
                                                        <div class="col-md-4 col-xs-5">${product.color}</div>
                                                        <div class="separator-line"></div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-4 col-xs-3">${product.inventory}</div>
                                                        <div class="col-md-4 col-xs-4">${product.size}</div>
                                                        <div class="col-md-4 col-xs-5">${product.color}</div>
                                                        <div class="separator-line"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="panel panel-details">
                                            <div class="panel-heading">
                                                <h2 class="panel-title"><@spring.message 'PRODUCTS.DETAILS.SECTION.HEADER.IMAGES'/></h2>
                                                <span class="pull-right clickable">
                                                    <i class="glyphicon glyphicon-chevron-up"></i>
                                                </span>
                                            </div>
                                            <div class="panel-collapse collapse in">
                                                <div class="image-panel-body">
                                                    <div class="img-container img-carousel-container">
                                                        <div id="carousel-prod-image-1" class="carousel slide" data-ride="carousel">
                                                            <!-- Indicators -->
                                                            <ol class="carousel-indicators">
                                                                <li data-target="#carousel-prod-image" data-slide-to="0" class="active"></li>
                                                                <li data-target="#carousel-prod-image" data-slide-to="1"></li>
                                                                <li data-target="#carousel-prod-image" data-slide-to="2"></li>
                                                            </ol>
                                                            <!-- Wrapper for slides -->
                                                            <div class="carousel-inner">
                                                                <div class="item active">
                                                                    <img src="images/inovation.png” alt="">
                                                                </div>
                                                                <div class="item">
                                                                    <img src="images/inovation.png” alt="">
                                                                </div>
                                                                <div class="item">
                                                                    <img src="images/inovation.png” alt="">
                                                                </div>
                                                            </div>
                                                            <!-- Controls -->
                                                            <a class="product-carousel-control left carousel-control" href="#carousel-prod-image-1" data-slide="prev">
                                                                <span class="glyphicon glyphicon-chevron-left"></span>
                                                            </a>
                                                            <a class="product-carousel-control right carousel-control" href="#carousel-prod-image-1" data-slide="next">
                                                                <span class="glyphicon glyphicon-chevron-right"></span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-edit-delete">
                                    <ul>
                                        <li class="product-edit"><a href=""><span class="fa fa-edit"></span></a></li>
                                        <li class="product-delete"><a href=#delete-product-modal data-toggle="modal"><span class="fa fa-trash-o"></span></a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </#list>
                </#if>
            </div>
        </div>
    </div>
</section>

<div class="modal fade" id="delete-product-modal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title"><@spring.message 'PRODUCTS.DETAILS.DELETE.MODAL.HEADER'/></h2>
            </div>
            <div class="modal-body">
                <p><@spring.message 'PRODUCTS.DETAILS.DELETE.MODAL.CONTENT'/></p>
                <button type="button" class="btn form-btn blue btn-img-style" data-dismiss="modal"><@spring.message 'PRODUCTS.DETAILS.DELETE.MODAL.BUTTON.CANCEL'/></button>
                <button type="button" class="btn form-btn red btn-img-style"><@spring.message 'PRODUCTS.DETAILS.DELETE.MODAL.BUTTON.DELETE'/></button>
            </div>
        </div>
    </div>
</div>
