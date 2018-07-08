<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#btn3_guruAll").linkbutton({
            text:"提交",
            onClick:function(){
                $("#ff_guruAll").form("submit",{
                    url:"${pageContext.request.contextPath}/Guru/addAllGuru.do",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#dd_guru").dialog("close");
                        $("#t_guru").datagrid({
                            url:"${pageContext.request.contextPath}/Guru/showAllGuru.do",
                        });
                    }
                });
            }
        });
        $("#btn4_guruAll").linkbutton({
            text:"取消",
            onClick:function(){
                $("#dd_guru").dialog("close");
            }
        });

    });
</script>
<form id="ff_guruAll" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上传文件:</td>
            <td><input class="easyui-filebox" name="file" style="width: 150px;" /></td>
        </tr>

        <tr>
            <td><a id="btn3_guruAll"></a></td>
            <td><a id="btn4_guruAll"></a></td>
        </tr>
    </table>
</form>