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
                
1、$.ajax("/findBook",// 发送请求的URL字符串，可以发送action,到注解为
@RequestMapping("/findBook")的controller方法

2、dataType : "json", // 预期服务器返回的数据类型

3、contentType:"application/json", //  发送信息至服务器时的内容编码类型

4、 // 发送到服务器的数据。

   data:JSON.stringify({id : 1, name : "Spring MVC企业应用实战"}),
   
   发送的数据格式是json,根据controller的后端配置，会自动映射到对象book的id，name属性中
   
5、// 请求成功后的回调函数。

   success :function(data){
   
6、$("#image").attr("src","images/"+data.image+"");
 
    #image 是html 中标签的id,attr 是设置 src 属性的值

7、 $("#name").html(data.name);

    #name 是html 中标签id,html设置显示值
    
四、controller中，json的支持

public Book findBook(@RequestBody Book book)

@RequestBody 表示发送过来的请求的body内容自动转到book对象

五、getjson中，List json的支持
        
              function findBooks(){
                    $.post("/findBooks",null,
                        function(data){
                            $.each(data,function(){
                                var tr  = $("<tr/>");
                                $("<img/>").attr("src","images/"+this.image).attr("height",60).appendTo("<td/>").appendTo(tr);
                                $("<td/>").html(this.name).appendTo(tr);
                                $("<td/>").html(this.author).appendTo(tr);
                                $("#booktable").append(tr);
                            })
                        },"json");
                }
 controller的返回值是，public List<Book> findBooks() 这个方法，List<Book>,
 
 在js函数中，遍历取出来，append到表格中。
 
 六、@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
 
 返回值是json,要用 @RestController 这个注解
 
 
          
