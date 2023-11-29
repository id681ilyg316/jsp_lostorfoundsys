
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
    //图片自动预览
    $(function() {
        $("#picture").change(
            function() {
                var $file = $(this);
                var fileObj = $file[0];
                var windowURL = window.URL || window.webkitURL;
                var dataURL;
                var $img = $("#viewuserpicture");
                //当图片名称为空时，照片不显示。
                if(document.getElementById('picture').value.trim()==""){
                    document.getElementById('tr_userpicture').style.display = 'none';
                }
                if (fileObj && fileObj.files && fileObj.files[0]) {
                    dataURL = windowURL.createObjectURL(fileObj.files[0]);
                    //允许上传的图片格式
                    var newPreview = document.getElementById("picture").value;
                    var regext = /\.jpg$|\.gif$|\.jpeg$|\.png$|\.bmp$/gi;
                    if (!regext.test(newPreview)) {
                        newPreview=="";
                        alert("选择的照片格式不正确，请重新选择！");
                        $(fileObj).after($(fileObj).clone($(fileObj)));
                        $(fileObj).remove();
                        $("#tr_userpicture").hide();
                        return false;
                    }
                    $img.attr("src", dataURL);
                    $("#tr_userpicture").show();

                } else {
                    dataURL = $file.val();
                    var imgObj = document.getElementById("viewuserpicture");

                    imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                    imgObj.filters
                        .item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
                }
            });
    });
</script>
<head>
       <title>文件上传</title>
    </head>
  <body>
    <form action="xiaoxiServlet?method=add_Xiaoxi" enctype="multipart/form-data" method="post">
          上传用户：<input type="text" name="xuehao"><br/>
          上传文件1：<input type="file" name="file1" id="picture"><br/>
           <input type="submit" value="提交">
       </form>
   </body>
 </html>
