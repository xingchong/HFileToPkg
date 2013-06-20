
<#list pkgFileBean.includeList as include>
${include}
</#list>

<#list pkgFileBean.clazzBeanList as clazzBean>
${clazzBean.name}
{

	    <#list clazzBean.publicMethodList as publicMethod>
 ${publicMethod}
	    </#list>
};
</#list>


