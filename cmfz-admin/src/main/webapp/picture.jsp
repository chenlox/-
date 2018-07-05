<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#t_picture").datagrid({
            url:"${pageContext.request.contextPath}/Picture/showAllPicture.do",
            columns:[[{
                title:"轮播图编号",
                field:"pictureId",
                width:100,
            },{
                title:"路径",
                field:"picturePath",
                width:100,
            },{
                title:"创建时间",
                field:"pictureDate",
                width:100,
            },{
                title:"描述信息",
                field:"pictureDesc",
                width:100
            },{
                title:"轮播图状态",
                field:"pictureStatus",
                width:100
            }/*,{
                title:"操作",
                field:"operation",
                width:100
            }*/]],
            pagination:true,
            pageList:[2,4,6,8,10],
            pageSize:2,
            singleSelect:true,
            fitColumns:true,
        });
    });

</script>

<table id="t_picture"></table>