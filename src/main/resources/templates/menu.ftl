<aside>
    <section class="sidebar">
        <#if userContext.menu??>
            <ul class="sidebar-menu">
                <#list userContext.menu.menuItems as menuItem>
                    <@createMenuItem menuItem/>
                </#list>
            </ul>
        </#if>
    </section>
</aside>

<#macro createMenuItem menuItem>
    <#if menuItem.subMenuItems??>
        <#local subMenuItems = menuItem.subMenuItems />
    </#if>
    
    <#if subMenuItems?? || menuItem.active>
        <#local needsClass = true />
    <#else>
        <#local needsClass = false />
    </#if>
    
    <li<#if needsClass> class="</#if><#if subMenuItems??>treeview</#if><#if menuItem.active> active</#if><#if needsClass>"</#if>>
        <a href="${menuItem.url}">
            <i class="fa<#if menuItem.iconClass??> ${menuItem.iconClass}</#if>"></i><span><@spring.message '${menuItem.titleKey}' /></span>
            <#if subMenuItems??>
                <i class="fa fa-angle-left pull-right"></i>    
            </#if>
        </a>
        <#if subMenuItems??>
            <ul class="treeview-menu">
                <#list subMenuItems as subMenuItem>
                    <@createMenuItem subMenuItem />
                </#list>
            </ul>
        </#if>
    </li>
</#macro>