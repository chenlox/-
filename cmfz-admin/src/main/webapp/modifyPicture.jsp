<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#btn1").linkbutton({
            text:"提交",
            onClick:function(){
                $("#f1").form("submit",{
                    url:"${pageContext.request.contextPath}/Picture/modifyPicture.do",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#dd").dialog("close");
                        $("#t_picture").datagrid({
                            url:"${pageContext.request.contextPath}/Picture/showAllPicture.do",
                        });
                    },
                });
            }
        });
        $("#btn2").linkbutton({
            text:"取消",
            onClick:function(){
                $("#dd").dialog("close");
            }
        });

    });
</script>
<form id="f1" method="post">
        <table>
        <tr>
            <td>轮播图ID:</td>
            <td><input class="easyui-textbox" name="pictureId" style="width: 150px;" readonly="true"/></td>
        </tr>
        <tr>
            <td>轮播图路径:</td>
            <td><input class="easyui-textbox" name="picturePath" style="width: 150px;" readonly="true" /></td>
        </tr>
        <tr>
            <td>轮播图描述:</td>
            <td><input class="easyui-textbox" name="pictureDesc" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>轮播图状态:</td>
            <td><input class="easyui-textbox" name="pictureStatus" style="width: 150px;" /></td>
        </tr>

        <tr>
            <td><a id="btn1"></a></td>
            <td><a id="btn2"></a></td>
        </tr>
    </table>
</form>