<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    ${product?ifExists}
    <@l.login "/login" false/>
</@c.page>
