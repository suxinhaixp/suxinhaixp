<!DOCTYPE html>

<#include "../common/header.ftl">
<body>
<#--边栏sidebar-->

<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <div>
        查看数据
        <label for="dateing">选择时间：</label><input id="now" type="date" />
        <li>
            <button id="select" onclick="javascript:getdatenow()"><i class="fa fa-fw fa-list-alt"></i>查询</button>
        </li>
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table id="tTable" class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>菜品</th>
                                <th>销售数量</th>
                            </tr>
                            </thead>
                            <tbody id="tbBody">

                            <#--<#list data.content as orderDTO>-->
                                <#--<tr>-->
                                    <#--<td>${orderDTO.productName}</td>-->
                                    <#--<td>${orderDTO.sellnumber}</td>-->
                                <#--</tr>-->
                            <#--</#list>-->
                            </tbody>
                        </table>
                    </div>
    </div>
</body>
</html>
<script>
    $(document).ready(function(){
        var date = new Date().Format("yyyy-MM-dd");
            console.log(date);
       $("#now").val(date);

    });

    Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "H+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    function getdatenow() {
        if (document.getElementById("tbBody") != null)
            document.getElementById("tbBody").remove();
        var date = $("#now").val();
         var hrefnow = "/sell/selectsell?create_time="+date;
        $.ajax({
            url: hrefnow,
            type: "GET",
            contentType: "application/json",
            dataType: 'json',
            success: function (res) {
                    console.log(res);
                var tbody = document.createElement('tbody');
                tbody.id = "tbBody";
                for (i in res) {
                    var row1 = document.createElement('tr'); //创建行
                    var name = document.createElement('td'); //创建第一列id
                    name.innerHTML = res[i].productName; //填充数据
                    row1.appendChild(name); //加入行 ，下面类似
                    var num = document.createElement('td'); //创建第一列id
                    num.innerHTML = res[i].sellnumber; //填充数据
                    row1.appendChild(num); //加入行 ，下面类似
                    tbody.appendChild(row1);
                }

                var table = document.getElementById("tTable")
                table.appendChild(tbody);
            }
        });
    }
</script>