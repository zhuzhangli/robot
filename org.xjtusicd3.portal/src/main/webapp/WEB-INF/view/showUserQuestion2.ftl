<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>展示事件信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <script type="text/javascript" src="js/classify.js"></script>

</head>

<body class="gray-bg">
<#list userQuestionInfoList as uqls>
    <div class="wrapper wrapper-content animated fadeInRight">      
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>事件信息 </h5>                        
                    </div>
                    
                    
						<div class="ibox-content" style="display:block" id="subinfo">
                           <form method="post" class="form-horizontal" >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">问题标题</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static" id="title">${uqls.userQuestionTitle}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>

	                        <div class="form-group">
                                <label class="col-sm-2 control-label">提问用户</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static">${uqls.userName}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">提问时间</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static">${uqls.userQuestionTime}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                             
                             <div class="form-group">
                                <label class="col-sm-2 control-label">问题答案</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static" id="faqcontent">${uqls.faqAnswer}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group" id ="${uqls.UserQuestionId}" >
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" "><a href="/org.xjtusicd3.portal/incidentindex.html#tab-32">返回</a></button>
                                    <input   class="btn btn-submit" value="添加至知识库" id="update_">
                                </div>
                            </div>
                            </form>
                    </div>
                    
                    
                    
                    
                    <div class="ibox-content"  style="display:none" id="updateinfo">
                        <form method="" class="form-horizontal"  action="">
                            <div class="form-group">
                                <span class="col-sm-2 control-label">问题标题</span>

                                <div class="col-sm-10">
                                    <input type="text" name="UserName" class="form-control"  required="required" value="${uqls.userQuestionTitle}">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                     
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">关键字</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="keywords" placeholder="在输入关键词时请使用半角逗号间隔" style="height: 35px">
                                </div>
                            </div>
                            <div class="hr-line-dashed spa3"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">分类</label>

                                <div class="col-sm-10">
                                    <select class="select" id="specialCategoryId" onchange="selectSecondChild()" style="height: 35px;width: 180px"></select>
                   			 		<select class="select" id="subspecialCategoryId" name="classifyName" style="height: 35px;width: 180px"></select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            
                            
                             <div class="form-group">
                                <label class="col-sm-2 control-label">摘要说明</label>
                                <div class="col-sm-10">
                                    <textarea class="text" id="description" style="width: 1200px;height: 60px"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed spa5"></div>
                                                                                                    
                            <div class="hr-line-dashed"></div>
                             <div class="form-group">
                                <label class="col-sm-2 control-label">问题答案</label>

                                <div class="col-sm-10">
                                    <textarea name="UserBrief" id="message" required="required" class="form-control" rows="8">${uqls.faqAnswer}</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group" id ="${uqls.UserQuestionId}" >
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" "><a href="/org.xjtusicd3.portal/incidentindex.html#tab-2">返回</a></button>
                                    <input type="" name="" class="btn btn-submit" value="完成" id="">
                                </div>
                            </div>
                        </form>
                    </div>
                
               </div>
            </div>
        </div>
    </div>
 
 </#list>
    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
<script>
$(document).ready(
		   function(){
		         $.ajax({
		             type: "GET",
		             url: "/org.xjtusicd3.partner/getFirstLevel.html",            
		             dataType: "json",
		             success: function(data){            
		     			 for(var i in data){ 
		     			 	 document.getElementById("specialCategoryId").options.add(new Option(data[i].fAQCLASSIFYNAME, data[i].fAQCLASSIFYID));					        
					      }                                                                      
		             }
		         });
		    })
		    
		function selectSecondChild(){
		var element = document.getElementById("specialCategoryId");
		var classifyId = element.options[element.selectedIndex].value;
		$.ajax({
		     type: "GET",
		     url: "/org.xjtusicd3.partner/getSecondLevel.html"+"?"+"classifyId="+classifyId,            
		     dataType: "json",
		     success: function(data){
		     			 document.getElementById("subspecialCategoryId").options.length=0;              	
		     			 for(var i in data){ 
		     			 	 document.getElementById("subspecialCategoryId").options.add(new Option(data[i].fAQCLASSIFYNAME, data[i].fAQCLASSIFYID));					        
						      }                                                                      
		                  }
		     });         
		}
		
		
		
function addToFaq(){
	var userQuestionId = event.target.parentNode.parentNode.id;
	var keywords = document.getElementById("keywords").value;
	var subspecialCategoryId = document.getElementById("subspecialCategoryId").value;
	var description = document.getElementById("description").value;
	$.ajax({
		type:"POST",
		url:"/org.xjtusicd3.portal/saveFAQ.html",
		data:{
			"userQuestionId":userQuestionId,
			"keywords":keywords,
			"subspecialCategoryId":subspecialCategoryId,
			"description":description,
		},
		dataType:"json",
		success:function(data){
			if(data.value=="0"){
				self.location='login.html';
			}else if(data.value=="1"){
				self.location='index.html';
			}else{
				self.location='index.html';
			}
		}
	})
}

function windowclose(){
	var url = document.getElementById('lasturl').innerHTML;
	self.location=url;
}

$("#update_").click(function(){
	$("#subinfo").css('display','none');
	$("#updateinfo").css('display','block');	
});


//$("#submit_").click(function(){
	//$("#subinfo").css('display','block');
//	$("#updateinfo").css('display','none');
//});
</script>  

</body>

</html>
