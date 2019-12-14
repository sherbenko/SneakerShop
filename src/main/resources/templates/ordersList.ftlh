<#import "parts/common.ftlh" as c>

<@c.page>
    List of users

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
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

<#--                CHAnge to EDIT status of orders -->
<#--                <#if isAdmin>-->
<#--                    <form action="/delete/${product.id}" method="get">-->
<#--                        <div>-->
<#--                            <button type="submit" class="btn btn-danger">Delete</button>-->

<#--                        </div>-->
<#--                    </form>-->
<#--                </#if>-->
            </div>
        <#else>
            No product
        </#list>
        </div>
        </tbody>
    </table>

</@c.page>
