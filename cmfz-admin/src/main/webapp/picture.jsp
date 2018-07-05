<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
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
            {field:"pictureId",title:"轮播图编号",width:80},
            {field:"picturePath",title:"路径",width:100,sortable:true},
            {field:"pictureDate",title:"创建时间",width:80,align:"right",sortable:true},
            {field:"pictureDesc",title:"描述信息",width:80,align:"right",sortable:true},
            {field:"pictureStatus",title:"轮播图状态",width:150,sortable:true},
            {field:"operation",title:'操作',width:60,align:'center'}
        ]],
        view:detailview,
        pagination:true,
        pageList:[2,4,6,8,10],
        pageSize:2,
        detailFormatter: function(rowIndex, rowData){
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="img/' + rowData.picturePath + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '</td>' +
                '</tr></table>';
        }

    });
</script>

<table id="t_picture"></table>
<div id="td" style="display:none">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改'" onclick="modify()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'添加'" onclick="add1()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,text:'删除'" onclick="remove()"></a>
</div>