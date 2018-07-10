<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/Article/upload.do';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称

    editor.create();

    $(function(){
        $('#author').combobox({
            url:'${pageContext.request.contextPath}/Guru/showAll.do',
            valueField:'guruId',
            textField:'guruName',
        });

        $("#btn_article").linkbutton({
            text:"提交",
            onClick:function(){

                $("#ff_article").form("submit",{
                    url:"${pageContext.request.contextPath}/Article/addArticle.do",
                    queryParams:{'introduction':editor.txt.html()},
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        if(res != null){
                            $.messager.show({
                                title:"我的消息",
                                msg:"添加成功,消息框将在3秒后关闭",
                                timeout:3000,
                                showType:"slide",
                            });
                        }
                        $("#ff_article").form("reset");
                        editor.txt.clear();
                    }
                });
            }
        });


    });

</script>

<form id="ff_article" method="post">
    <table>
        <tr>
            <td>文章标题:</td>
            <td><input class="easyui-textbox" name="articleName" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>文章作者:</td>
            <td><input id="author" name="guruId"></td>
        </tr>
        <tr>
            <td>文章内容:</td><br />
            <td>
                <div id="editor">
                    <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
                </div>
            </td>
        </tr>
        <tr>
            <td><a id="btn_article"></a></td>
        </tr>

    </table>
</form>