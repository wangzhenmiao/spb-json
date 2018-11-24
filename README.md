# spb-json-base

一、程序访问两个地址

localhost:8080/index

localhost:8080/getjson

二、jquery-文档加载完，执行js函数

        $(document).ready(function(){
                    findBook();
                });

html文档加载完，就执行 findBook()函数

三、query函数

           function findBook(){
                    $.ajax("/findBook",// 发送请求的URL字符串。
                        {
                            dataType : "json", // 预期服务器返回的数据类型。
                            type : "post", //  请求方式 POST或GET
                            contentType:"application/json", //  发送信息至服务器时的内容编码类型
                            // 发送到服务器的数据。
                            data:JSON.stringify({id : 1, name : "Spring MVC企业应用实战"}),
                            async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
                            // 请求成功后的回调函数。
                            success :function(data){
                                console.log(data);
                                $("#image").attr("src","images/"+data.image+"");
                                $("#name").html(data.name);
                                $("#author").html(data.author);
                                $("#price").html(data.price);
                                $("#remark").html(data.remark);
                            },
                            // 请求出错时调用的函数
                            error:function(){
                                alert("数据发送失败");
                            }
                        });
                }
          
