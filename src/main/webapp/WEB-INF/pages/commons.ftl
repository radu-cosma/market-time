<#function buildName fieldId>
    <#return fieldId?replace('-', ' ')?capitalize?replace(' ', '')?uncap_first >
</#function>

<#function buildKey fieldId>
    <#return fieldId?replace('-', '.')?upper_case >
</#function>
