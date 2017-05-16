<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-8
  Time: 下午1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:iterator value="keyWordLinkList" status="st">
    <li id="<s:property value="Id"/>">
        <a href="javascript:ruleContent(<s:property value="Id"/>);">
            <s:property value="ruleName"/>
        </a>
    </li>
</s:iterator>
