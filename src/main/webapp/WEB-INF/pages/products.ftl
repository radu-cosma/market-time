<section class="content-header">
    <h1><@spring.message 'PRODUCTS.PAGE.TITLE'/></h1>
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAV.HOME'/></a></li>
        <li><a href="/market-time/products?status=published"><@spring.message 'PRODUCTS.NAV.PUBLISHED'/></a></li>
        <li class="active">
            <@spring.message 'PRODUCTS.NAV.PAGE'/>
        </li>
    </ol>
</section>
<section class="content">
  <div class="box box-success">
    <div class="box-header with-border"></div>
      <div id="publish-products-id" class="row">
        <div class="padding-5 [col-xs-12 col-sm-offset-1 col-sm-10 ]">    
          <label><@spring.message 'PRODUCTS.SORT.LABEL'/></label>
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
            <label><@spring.message 'PRODUCTS.PER.PAGE.LABEL'/></label>
            <div class="dropdown-select">
                <select name="products per page">
                    <option value="1">10</option>
                    <option value="2">25</option>
                    <option value="3">50</option>
                    <option value="4">100</option>
                    <option value="5"><@spring.message 'PRODUCTS.PER.PAGE.ALL'/></option>
                </select>
            </div>
            <ul class="event-list">
              <li>
                <div class="info">
                    <img src="../admin-styles/img/tricou-verde.jpg" class="products-img" alt="Product Image" />
                    <h2 class="title prod-list-title">Tricou rosu barbati</h2>
                    <p class="desc">Price: $55.00</p>
                    <p class="desc">Shopping: 30-40 days</p>
                    <p class="desc">Pz: 17</p>
                    <a class="aTag" href="#">details &#9660</a>
                    <div class="divToToggle" style="display: none;">
                        <div class="panel panel-details">
                            <div class="panel-heading">
                                <h3 class="panel-title">Product details</h3>
                                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                            </div>
                            <div class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ul class="list-prod-details">
                                        <li>Category:</li>
                                        <li>Price:</li>
                                        <li>Shipping:</li>
                                        <li>Color:</li>
                                        <li>Size:</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-details">
                            <div class="panel-heading">
                                <h2 class="panel-title">Images</h2>
                                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                            </div>
                            <div class="panel-collapse collapse in">
                                <div class="panel-body">
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
                                                    <img src="../admin-styles/img/tricou-verde.jpg" alt=" ">
                                                </div>
                                                <div class="item">
                                                    <img src="../admin-styles/img/tricou-rosu.jpg" alt=" ">
                                                </div>
                                                <div class="item">
                                                    <img src="../admin-styles/img/tricou-galben.jpg" alt=" ">
                                                </div>
                                            </div>
                                            <!-- Controls -->
                                            <a class="left carousel-control" href="#carousel-prod-image-1" data-slide="prev">
                                                <span class="glyphicon glyphicon-chevron-left"></span>
                                            </a>
                                            <a class="right carousel-control" href="#carousel-prod-image-1" data-slide="next">
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
                        <li class="product-edit"><a href=""><span class="fa fa-edit "></span></a></li>
                        <li class="product-delete"><a href=#delete-product-modal data-toggle="modal"><span class="fa fa-trash-o"></span></a></li>
                    </ul>
                </div>
              </li>
            </ul>
        </div>
      </div>         
  </div>
</section>


        <div class="modal fade" id="delete-product-modal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h2 class="modal-title">Please confirm</h4>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete this product?</p>
                        <button type="button" class="btn form-btn blue btn-img-style" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn form-btn red btn-img-style">Delete</button>
                    </div>
                </div>
            </div>
        </div>
    </div>


<#if products??>
	<#list products as product>
    	<#if product.name??>
    		${product.name}</br>
    	</#if>
    	<#if product.description??>
    		${product.description}</br>
    	</#if>
    	<#if product.color??>
    		${product.color}</br>
    	</#if>
    	<#if product.size??>
    		${product.size}</br>
    	</#if>
    	</br>
	</#list>
</#if>