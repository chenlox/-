<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#t_picture").datagrid({
            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            fit:true,
            toolbar:"#td",
            url:"${pageContext.request.contextPath}/Picture/showAllPicture.do",
            columns:[[
                {field:"pictureId",title:"轮播图编号",width:80,align:"center"},
                {field:"picturePath",title:"路径",width:100,sortable:true,align:"center"},
                {field:"pictureDate",title:"创建时间",width:80,align:"center",sortable:true,},
                {field:"pictureDesc",title:"描述信息",width:80,align:"center",sortable:true},
                {field:"pictureStatus",title:"轮播图状态",width:150,sortable:true,align:"center"},
                {field:"operation",title:'操作',width:60,align:'center',align:"center"}
            ]],
            view:detailview,
            pagination:true,
            pageList:[2,4,6,8,10],
            pageSize:2,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picturePath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
        });


    });


    function add(){
        $("#dd").dialog({
            title: "新增轮播图",
            width: 400,
            height: 250,
            closed: false,
            modal: true,
            minimizable:true,
            maximizable:true,
            collapsible:true,
            href:"${pageContext.request.contextPath}/addPicture.jsp",
        });
    }
    function modify(){
        var rowData = $("#t_picture").datagrid("getSelected");
        $("#dd").dialog({
            title: "修改信息",
            width: 400,
            height: 200,
            closed: false,
            modal: true,
            href:"${pageContext.request.contextPath}/modifyPicture.jsp",
            onLoad:function(){
                $("#f1").form("load",rowData);
            },
        });
    }

</script>

<table id="t_picture"></table>
<div id="td" style="display:none">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改'" onclick="modify()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'" onclick="add()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
</div>
<div id="dd" style="display:none;"align="center">
</div>