
<head>
    <meta charset="utf-8">
    <title>卖家后端管理系统</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>

<script>
    $(document).ready(function(){
        console.log(sessionStorage.getItem("user"));
        if (sessionStorage.getItem("user")==null||sessionStorage.getItem("user")=="") {
            window.location.href = "/sell/login";
        }
    });
</script>