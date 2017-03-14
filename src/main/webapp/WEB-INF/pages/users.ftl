<section class="content-header">
    <h1><@spring.message 'USERS.PAGE.TITLE'/></h1>
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
        <li class="active"><@spring.message 'NAVIGATION.USERS'/></li>
    </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"></div>
        <div class="row-style row">
            <div class="padding-0 col-xs-12 col-sm-offset-1 col-sm-10">
                <div class="sort">
                    <label><@spring.message 'USERS.SORT.LABEL'/></label>
                    <div class="dropdown-select">
                        <select name="sort">
                            <option value="1"><@spring.message 'USERS.SORT.DATE'/></option>
                            <option value="2"><@spring.message 'USERS.SORT.STATUS'/></option>
                        </select>
                    </div>
                </div>
                <form action="#" class=" pull-right search-form">
                    <div class="input-append">
                        <input type="text" class="search-input search" placeholder="<@spring.message 'USERS.SEARCH.PLACEHOLDER'/>">
                        <button class="btn search-btn" type="button"><i class="fa fa-search"></i></button>
                    </div>
                </form>
                <ul class="user-list">
                    <li>
                        <div class="user-box user-status">
                            <div class="user-details">
                                <aside class="col-sm-7 col-xs-12 user-profile">
                                    <h2 class="company-name">Healthysoft Consulting SRL </h2>
                                    <p>Daniel Huluban</p>
                                </aside>
                                <aside class="col-sm-5 col-xs-12 user-info">
                                    <p>daniel@huluban.com</p>
                                    <p>0747858585</p>
                                </aside>
                            </div>
                            <a href="users/details"><div class="btn form-btn blue go-right"><@spring.message 'USERS.DETAILS.VIEW.BUTTON'/></div></a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>