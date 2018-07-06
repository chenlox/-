<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#btn3").linkbutton({
            text:"提交",
            onClick:function(){
                $("#ff").form("submit",{
                    url:"${pageContext.request.contextPath}/Picture/addPicture.do",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#dd").dialog("close");
                        $("#t_picture").datagrid({
                            url:"${pageContext.request.contextPath}/Picture/showAllPicture.do",
                        });
                    }
                });
            }
        });
        $("#btn4").linkbutton({
            text:"取消",
            onClick:function(){
                $("#dd").dialog("close");
            }
        });

    });
</script>
<form id="ff" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>轮播图描述:</td>
            <td><input class="easyui-textbox" name="pictureDesc" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>轮播图状态:</td>
            <td>
                <%--<input class="easyui-combobox" name="pictureStauts" data-options="width:150" />--%>
                <select class="easyui-combobox" name="pictureStatus" style="width:150px;">
                    <option>未展示</option>
                    <option>展示中</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>上传轮播图:</td>
            <td><input class="easyui-filebox" name="file" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td><a id="btn3"></a></td>
            <td><a id="btn4"></a></td>
        </tr>
    </table>
</form>