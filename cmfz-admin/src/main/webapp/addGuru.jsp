<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#btn3_guru").linkbutton({
            text:"提交",
            onClick:function(){
                $("#ff_guru").form("submit",{
                    url:"${pageContext.request.contextPath}/Guru/addGuru.do",
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
        $("#btn4_guru").linkbutton({
            text:"取消",
            onClick:function(){
                $("#dd_guru").dialog("close");
            }
        });

    });
</script>
<form id="ff_guru" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上师法名:</td>
            <td><input class="easyui-textbox" name="guruName" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>上师图片:</td>
            <td><input class="easyui-filebox" name="file" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>上师简介:</td>
            <td>
                <input class="easyui-textbox" name="guruSummary" data-options="width:150" />
            </td>
        </tr>
        <tr>
            <td><a id="btn3_guru"></a></td>
            <td><a id="btn4_guru"></a></td>
        </tr>
    </table>
</form>