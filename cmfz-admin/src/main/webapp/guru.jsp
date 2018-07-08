<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#t_guru").datagrid({
            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            fit:true,
            toolbar:"#td_guru",
            url:"${pageContext.request.contextPath}/Guru/showAllGuru.do",
            columns:[[
                {field:"guruId",title:"上师ID",width:80,align:"center"},
                {field:"guruName",title:"上师法名",width:100,sortable:true,align:"center"},
                {field:"guruPhoto",title:"上师图片",width:80,align:"center",sortable:true,},
                {field:"guruSummary",title:"上师简介",width:80,align:"center",sortable:true},
            ]],
            view:detailview,
            pagination:true,
            pageList:[2,4,6,8,10],
            pageSize:2,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/guru-img/' + rowData.guruPhoto + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
        });


    });

    function qq(value, key) {
        $("#t_guru").datagrid({
            url:"${pageContext.request.contextPath}/Guru/showAllGuru.do?key="+key+"&value="+value,
        });
    }


    function add(){
        $("#dd_guru").dialog({
            title: "新增上师",
            width: 400,
            height: 250,
            closed: false,
            modal: true,
            minimizable:true,
            maximizable:true,
            collapsible:true,
            href:"${pageContext.request.contextPath}/addGuru.jsp",
        });
    }
    function addAll(){
        $("#dd_guru").dialog({
            title: "批量上传",
            width: 400,
            height: 250,
            closed: false,
            modal: true,
            minimizable:true,
            maximizable:true,
            collapsible:true,
            href:"${pageContext.request.contextPath}/addAllGuru.jsp",
        });
    }
    function modify(){
        var rowData = $("#t_guru").datagrid("getSelected");
        $("#dd_guru").dialog({
            title: "修改信息",
            width: 400,
            height: 200,
            closed: false,
            modal: true,
            href:"${pageContext.request.contextPath}/modifyGuru.jsp",
            onLoad:function(){
                $("#f_guru").form("load",rowData);
            },
        });
    }

</script>

<table id="t_guru"></table>
<div id="td_guru" style="display:none">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改上师信息'" onclick="modify()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'" onclick="add()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量上传'" onclick="addAll()"></a>
   <input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'请输入您输入查询的内容',menu:'#mm'" />
    <div id="mm" style="width:120px">
        <div data-options="key:'name',iconCls:'icon-ok'">guruName</div>
    </div>
</div>
<div id="dd_guru" style="display:none;"align="center">
</div>