<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#btn1_guru").linkbutton({
            text:"提交",
            onClick:function(){
                $("#f_guru").form("submit",{
                    url:"${pageContext.request.contextPath}/Guru/modifyGuru.do",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#dd_guru").dialog("close");
                        $("#t_guru").datagrid({
                            url:"${pageContext.request.contextPath}/Guru/showAllGuru.do",
                        });
                    },
                });
            }
        });
        $("#btn2_guru").linkbutton({
            text:"取消",
            onClick:function(){
                $("#dd_guru").dialog("close");
            }
        });

    });
</script>
<form id="f_guru" method="post">
        <table>
        <tr>
            <td>上师ID:</td>
            <td><input class="easyui-textbox" name="guruId" style="width: 150px;" readonly="true"/></td>
        </tr>
        <tr>
            <td>上师法名:</td>
            <td><input class="easyui-textbox" name="guruName" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>上师图片:</td>
            <td><input class="easyui-textbox" name="guruPhoto" style="width: 150px;" readonly="true"/></td>
        </tr>
        <tr>
            <td>上师简介:</td>
            <td><input class="easyui-textbox" name="guruSummary" style="width: 150px;" /></td>
        </tr>

        <tr>
            <td><a id="btn1_guru"></a></td>
            <td><a id="btn2_guru"></a></td>
        </tr>
    </table>
</form>