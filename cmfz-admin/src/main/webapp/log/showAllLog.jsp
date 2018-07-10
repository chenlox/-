<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#t_log").datagrid({
            url:"${pageContext.request.contextPath}/Log/showAllLog.do",
            columns:[[
                {title:"logId", field:"logId", width:100,},
                {title:"managerName", field:"managerName", width:100,},
                {title: "logTime", field: "logTime", width: 100,},
                {title:"logResource", field:"logResource", width:100},
                {title:"logAction", field:"logAction", width:100},
                {title:"logMessage", field:"logMessage", width:100},
                {title:"logResult", field:"logResult", width:100}
                ]],
            pagination:true,
            pageList:[2,4,6,8,10],
            pageSize:2,
            singleSelect:true,
            fitColumns:true,
            toolbar:"#td_log",
        });
    });

    function refresh(){
        $("#t_log").datagrid({
            url:"${pageContext.request.contextPath}/Log/showAllLog.do",
        });
    }

</script>
<table id="t_log"></table>
<div id="td_log" style="display:none">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-mini-refresh',text:'刷新'" onclick="refresh()"></a>
</div>













