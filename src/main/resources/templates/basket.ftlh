<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card-columns">
        <#list baskets as basket>
            <div class="card my-3">
                <#if basket.product.filename??>
                    <img src="/img/${basket.product.filename}" class="card-img-top" height=200px width=300px>
                </#if>
                <div class="m-2">
                    <span>${basket.product.text}</span>
                    <i>${basket.product.tag}</i>
                </div>
                <div class="card-footer text-muted">
                    ${basket.product.authorName}
                </div>
<#--                <form action="/allbasket" method="get">-->
<#--                    <button type="submit" class="btn btn-info">Add to basket</button>-->
<#--                    &lt;#&ndash;                    <input type="hidden" name="_csrf" value="${_csrf.token}" />&ndash;&gt;-->
<#--                </form>-->
                    <form action="/delete/${basket.id}" method="get">
                        <div>
                            <button type="submit" class="btn btn-danger" >Delete</button>

                        </div>
                    </form>
            </div>
        <#else>
            No product
        </#list>
    </div>
</@c.page>
