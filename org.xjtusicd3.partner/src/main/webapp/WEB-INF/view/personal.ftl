<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>智能小朵-知识库</title>
    <link href="/org.xjtusicd3.partner/ico/zyq.ico" type="image/x-icon" rel="shortcut icon">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="new/front/style/reset2.css" />
    <link rel="stylesheet" type="text/css" href="new/front/style/util2.css" />
    <link href="css/main.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="zhao/upload/cropper/cropper.min.css" rel="stylesheet">
	<link href="zhao/upload/sitelogo/sitelogo.css" rel="stylesheet">
    <link href="zhao/radio&check/css/labelauty.css" rel="stylesheet" />
    <link href="zhao/password/css/gloab.css" rel="stylesheet">
	<link href="zhao/password/css/index.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="zhao/tankuang/css/reveal.css" />
	<link type="text/css" rel="stylesheet" href="jedate/skin/jedate.css">
	<script src="zhao/upload/jquery-2.1.js"></script>
	<script src="zhao/upload/cropper/cropper.min.js"></script>
	<script src="zhao/upload/sitelogo/sitelogo.js"></script>
	<script src="zhao/upload/bootstrap/js/bootstrap.min.js"></script>
	<script src="zhao/password/js/register.js"></script>
    <script type="text/javascript" src="jedate/jquery.jedate.js"></script>
	<style>
		.datainp { width: 128px; height: 35px; border: 1px #A5D2EC solid; }
		.datep { margin-bottom: 40px; line-height: 24px; margin-right: 15px; }
		.wicon { background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABkAAAAQCAYAAADj5tSrAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAALEgAACxIB0t1+/AAAABZ0RVh0Q3JlYXRpb24gVGltZQAwNi8xNS8xNGnF/oAAAAAcdEVYdFNvZnR3YXJlAEFkb2JlIEZpcmV3b3JrcyBDUzVxteM2AAAAoElEQVQ4jWPceOnNfwYqAz9dYRQ+E7UtwAaGjyUsDAyYYUgJ2HT5LXZLcEmSCnA6duOlN///////H0bDALl8dPH/////Z8FuNW6Qtvw2nL3lyjsGBgYGhlmRqnj1kGwJuqHIlhJlCXq8EOITEsdqCXLEbbr8FisfFkTo+vBZRFZwERNEFFkCiw90nxJtCalxQmzegltCzVyP1RJq5HZ8AABuNZr0628DMwAAAABJRU5ErkJggg=="); background-repeat: no-repeat; background-position: right center;    margin-left: -13px; }
		.showcase-form textarea .ng-dirty.ng-invalid,
		.showcase-form select .ng-dirty.ng-invalid,
		.showcase-form input.ng-dirty.ng-invalid {
   		 border-color: #e9322d;
    	-webkit-box-shadow: 0 0 6px #f8b9b7;
    	-moz-box-shadow: 0 0 6px #f8b9b7;
    	box-shadow: 0 0 6px #f8b9b7;
	</style>
</head>
<body>
	<div class="header" id="head">      
        <div class="loginRegistHead" role="banner">
            <div class="content clearfix">
                <div class="header_top_wrap_left">
		            <ul>
		                <li><a class="new_a" href="robot.html" data-pos="categorys_1_1">智能小朵</a></li>
		                <li><a class="new_a" href="faq.html" data-pos="categorys_1_1">知识库</a></li>
		                <li><a class="new_a" href="question.html" data-pos="categorys_1_1">问题中心</a></li>
		                <li>
		                    <a class="new_a" href="service.html">关于我们</a>
		                </li>
		            </ul> 
                </div>
                <div class="header_top_wrap_right">
		             <ul>
		              <#if UserEmail??>
		                <div class="unlogin">
		                    <li class="loginLinkLi"><span class="person_icon"></span></li>
		                    <li class="loginLinkLi" id="userNameText">您好：${UserEmail}</li>
		                    <li class="left_margin my_center loginLinkLi" id="my_center" onmouseover="Util.showPersonCenter()" onmouseout="Util.hidePersonCenter()">个人中心<span class="v_center_arrow"></span>
		                        <div class="my_service_list" style="display: none; height: 116px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
		                            <div class="top_icon"></div>
		                            <ul class="ul_list">
		                                <li><a href="personal.html">个人信息</a></li>
		                                <li><a href="personal3.html">我的设备</a></li>
		                                <li><a href="personal2.html">我的主页</a></li>
		                                <li><a href="notice.html">消息通知</a></li>
		                            </ul>
		                        </div>
		                    </li>
		                    <li class="left_margin loginLinkLi"><a href="loginout.html" id="headExit">退出</a>
		                    </li>
		                </div>
		             <#else>
				       	<div class="unlogin">
		                    <li class="unloginLinkLi">
		                        <a href="login.html" id="headLogin" class="listen_btn" data-pos="categorys_1_2">登录/注册</a>
		                        </li>
		                    </li>
		                </div>
		             </#if>
		            </ul> 
                </div>
            </div>
        </div>
       	<div class="headContent">
    		<div class="headTop clearfix">
	        	<a href="" class="logoCon">
	            	<img src="images/logo.jpg" class="logo">
	            	<span>个人信息</span>
	        	</a>
    		</div>
		</div>
    </div>
    <div class="mainContent">
        <div class="contentWra clearfix">
        	<section id="shortcodes">
        <div class="container">
            <div id="tab-container">
                <div class="row">
                    <div class="col-md-12">
                    </div>
                    <div class="col-md-6" style="width:100%;">
                        <ul id="tab2" class="nav nav-pills">
                            <li class="active"><a href="#tab2-item1" data-toggle="tab">个人资料</a></li>
                            <li><a href="#tab2-item2" data-toggle="tab">密码安全</a></li>
                        </ul>
                        <div class="tab-content" style="margin-left: 165px;margin-top: 30px;width: 1000px;float: left;min-height:500px;">
                            <div class="tab-pane fade active in" id="tab2-item1" style="width: 889px;float: left;">
                            <#list personal_list as userinfo>
                            	<div class="ibox-content" style="width:400px;float:left;">
									<div class="row">
										<div id="crop-avatar" class="col-md-6">
											<div class="avatar-view" title="Change Logo Picture">
			    								<img src="${userinfo.userImage}" alt="Logo">
			    							</div>
									    </div>
									</div>
								</div>
								<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<form class="avatar-form" action="uploadUserImage.html" enctype="multipart/form-data" method="post">
												<div class="modal-header">
													<button class="close" data-dismiss="modal" type="button">&times;</button>
													<h4 class="modal-title" id="avatar-modal-label">头像变更</h4>
												</div>
												<div class="modal-body">
													<div class="avatar-body">
														<div class="avatar-upload">
															<input class="avatar-src" name="avatar_src" type="hidden">
															<input class="avatar-data" name="avatar_data" type="hidden">
															<label for="avatarInput">图片上传</label>
															<input class="avatar-input" id="avatarInput" name="avatar_file" type="file">
														</div>
														<div class="row">
															<div class="col-md-9">
																<div class="avatar-wrapper"></div>
															</div>
															<div class="col-md-3">
																<div class="avatar-preview preview-lg"></div>
																<div class="avatar-preview preview-md"></div>
																<div class="avatar-preview preview-sm"></div>
															</div>
														</div>
														<div class="row avatar-btns">
															<div class="col-md-9">
																<div class="btn-group">
																	<button class="btn" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"><i class="fa fa-undo"></i> 向左旋转</button>
																</div>
																<div class="btn-group">
																	<button class="btn" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"><i class="fa fa-repeat"></i> 向右旋转</button>
																</div>
															</div>
															<div class="col-md-3">
																<button class="btn btn-success btn-block avatar-save" type="submit"><i class="fa fa-save"></i> 保存修改</button>
															</div>
														</div>
													</div>
												</div>
  											</form>
  										</div>
  									</div>
								</div>
								
								<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
								
									<div class="col-sm-6" style="float:right;display:none" id="updateinfo" >
					                    <div class="project-name overflow">
										    <form id="main-contact-form" name="contact-form" method="post" action="addUserInfo.html">
					                            <div class="form-group" style="width: 370px;height: 36px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>用户名：</span></div>
					                                <div style="float:right;width:314px;height:50px;"><input type="text" name="UserName" class="form-control"  required="required" value="${userinfo.userName}"></div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height: 36px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>性别：</span></div>
													<div class="rdo">
												        <input type="radio" name="UserSex" class="rdolist" value="${userinfo.userSex}"/ >
												        <label class="rdobox">
												            <span class="check-image"></span>
												            <span class="radiobox-content">男</span>
												        </label>
												        <input type="radio" name="UserSex" class="rdolist" value="${userinfo.userSex}" />
												        <label class="rdobox">
												            <span class="check-image"></span>
												            <span class="radiobox-content">女</span>
												        </label>
												    </div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height: 37px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>生日：</span></div>
					                                <div style="float:right;width:314px;height:50px;">
														<li class="datep"><input class="datainp wicon" id="date03" type="text" placeholder="YYYY-MM-DD" name="UserBirthday" value="${userinfo.userBirthday}" readonly ></li>
					                                </div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height:125px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>所在地：${Province}</span></div>
					                                <div style="float:right;width:314px;height:50px;">
					                                	<div id="distpicker5">
													        <div class="form-group">
													          <label class="sr-only" for="province10">Province</label>
													          <select class="form-control1" id="province10" name="Province" ></select>
													        </div>
													        <div class="form-group">
													          <label class="sr-only" for="city10">City</label>
													          <select class="form-control1" id="city10" name="City"></select>
													        </div>
													        <div class="form-group">
													          <label class="sr-only" for="district10">District</label>
													          <select class="form-control1" id="district10" name="District"></select>
													        </div>
													    </div>
					                                </div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height: 77px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>简介：</span></div>
					                            	<div style="float:right;width:314px;height:130px;">
					                                	<textarea name="UserBrief" id="message" required="required" class="form-control" rows="8" placeholder="请留下你的个性签名" >${userinfo.userBrief}</textarea>
					                            	</div>
					                            </div>                        
					                            <div class="form-group">
					                                <input type="submit" name="submit" class="btn btn-submit" value="完成" id="submit_">
					                            </div>
					                        </form>
					                    </div>
					                </div>
					                
					                <div class="col-sm-6" style="float:right;display:block" id="subinfo">
					                    <div class="project-name overflow">
					                            <div class="form-group" style="width: 370px;height: 36px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>用户名：</span></div>
					                                <div style="float:right;width:314px;height:50px;"><input type="text" name="UserName" class="form-control"  required="required" value="${userinfo.userName}"></div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height: 36px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>性别：</span></div>
													<div style="float:right;width:314px;height:50px;"><input type="text" name="UserSex" class="form-control"  required="required" value="${userinfo.userSex}"></div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height: 37px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>生日：</span></div>
					                                <div style="float:right;width:314px;height:50px;">
														<li class="datep"><input class="datainp wicon" id="date03" type="text" placeholder="YYYY-MM-DD" name="UserBirthday" value="${userinfo.userBirthday}" readonly ></li>
					                                </div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height:40px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>所在地：</span></div>
					                                <div style="float:right;width:314px;height:50px;"><input type="text" name="UserAddress" class="form-control"  required="required" value="${address}"></div>
					                            </div>
					                            <div class="form-group" style="width: 370px;height: 77px;">
					                            	<div style="float:left;margin-top:10px;width:56px;"><span>简介：</span></div>
					                            	<div style="float:right;width:314px;height:130px;">
					                                	<textarea name="UserBrief" id="message" required="required" class="form-control" rows="8" placeholder="请留下你的个性签名" >${userinfo.userBrief}</textarea>
					                            	</div>
					                            </div>                        
					                            <div class="form-group">
					                                <input   class="btn btn-submit" value="修改信息" id="update_">
					                            </div>
					                    </div>
					                </div>
					                
                        	</div>
                        	</#list>
                            <div class="tab-pane fade" id="tab2-item2" style="width: 800px;float: left;">
                            	<div class="col-sm-6" style="margin-left: 180px;width:80%;">
					                    <div class="project-name overflow">
											    <div class="form-group">
											            <div class="reg-box" id="verifyCheck" style="margin-top:20px;">
											            		<div class="item col-xs-12" style="margin-top: 30px;">
											                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>原始密码：</span>    
											                        <div class="f-fl item-ifo">
											                            <input type="text"  class="txt03 f-r3 required"  id="password" oninput="_password()"/>
											                            <label class="focus valid spa1"></label>
											                        </div>
											                    </div>
											                    <div class="item col-xs-12" style="margin-top: 30px;">
											                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>    
											                        <div class="f-fl item-ifo">
											                            <input type="password" id="password2"  class="txt03 f-r3 required""return  false" oninput="_password2()" />
											                            <label class="focus valid error spa2"></label>
											                        </div>
											                    </div>
											                    <div class="item col-xs-12" style="margin-top: 30px;">
											                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>    
											                        <div class="f-fl item-ifo">
											                            <input type="password" id="repassword2" maxlength="20" class="txt03 f-r3 required"  oninput="_repassword2()" />
											                        	<label class="focus valid error spa3"></label>
											                        </div>
											                    </div>
											            </div>
											    </div>
											    <div class="form-group">
					                                <button  class="btn btn-submit" style="width:42%;margin-left: 17px;margin-top: 40px;"  id="submitupdatePassword">确认提交</button>
					                            </div>
					                    </div>
					                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/#table-container-->
            <div class="padding"></div>
        </div>
    </section>
		</div>
        		
    </div>
    <div id="foot" class="footer">
    	<p style="color: #ffffff;text-align: center;">© 西安交通大学社会智能与复杂数据处理实验室  2017.</p>
    </div>
    
    <div id="myModal" class="reveal-modal" style="visibility:hidden">			
		<h1>密码修改成功</h1>
		<br/>			
		<a class="close-reveal-modal" id="cancelModal">&#215;</a>
	</div>
	<div class="reveal-modal-bg" id="modal_bg" style="display:none;cursor: pointer;"></div>
    <script>

	  </script>
	   	<script type="text/javascript">
		$("#date03").jeDate({
		    isinitVal:true,
		    festival:true,
		    ishmsVal:false,
		    minDate: '1900-01-01 00:00:00',
		    maxDate: $.nowDate(0),
		    format:"YYYY-MM-DD",
		    zIndex:3000,
		});
		$("#update_").click(function(){
			$("#subinfo").css('display','none');
			$("#updateinfo").css('display','block');	
		});
		$("#submit_").click(function(){
			$("#subinfo").css('display','block');
			$("#updateinfo").css('display','none');
		});
		
		$("#submitupdatePassword").click(function(){
		var pw = /^\w{6,16}$/;
		var rpw = $("#repassword2").val();
	if(pw.test($("#password").val())&&pw.test($("#password2").val())&&(rpw==($("#password2").val()))){
		$.ajax({
			type:"POST",
			url:"/org.xjtusicd3.partner/updateUserPassword.html",
			data:{
				"password":$("#password").val(),
				"password2":$("#password2").val(),
				"repassword2":$("#repassword2").val()
			},
			dataType:"json",
			success:function(data){
				if(data=="0"){
					$(".spa2").text('新密码不能与原密码相同');
				}if(data="1"){
					$(".spa1").text('原密码错误');
				}if(data="2"){
					document.getElementById("modal_bg").style.display="block";
					document.getElementById("myModal").style.visibility = "visible";
				}
			}
		})
		return true;
	}else{
		if($("#password").val()==""){
			$(".spa1").text('请填写密码');
		}
		if($("#password2").val()==""){
			$(".spa2").text('请填写密码');
		}
		if($("#repassword2").val()==""){
			$(".spa3").text('请再次填写密码');
		}
		return false;
	}
});
function _password(){
	if($("#password").val()!=""){
		var pw = /^\w{6,16}$/;
		if(!(pw.test($("#password").val()))){
			$(".spa1").text("密码由字母、数字、下划线组成且6-16位");
			return false;
		}else if (pw){
			$(".spa1").text("");
			return true;
		}
	}else{
		$(".spa1").text("");
	}
}
function _password2(){
	if($("#password2").val()!=""){
		var pw = /^\w{6,16}$/;
		if(!(pw.test($("#password2").val()))){
			$(".spa2").text("密码由字母、数字、下划线组成且6-16位");
			return false;
		}else if (pw){
			$(".spa2").text("");
			return true;
		}
	}else{
		$(".spa2").text("");
	}
}
function _repassword2(){
	if($("#repassword2").val()!=""){
		var pw = $("#password2").val();
		if(!(pw==$("#repassword2").val())){
			$(".spa3").text("两次输入的密码不一致");
			return false;
		}else if (pw){
			$(".spa3").text("");
			return true;
		}
	}else{
		$(".spa3").text("");
	}
}
//取消弹出框
$("#cancelModal").click(function(){
	document.getElementById("modal_bg").style.display="none";
	document.getElementById("myModal").style.visibility = "hidden";
	window.location.reload(); 
})
		</script>
    	<script type="text/javascript" src="new/front/js/util.js"></script>
		<script src="zhao/radio&check/js/labelauty.js"></script>
    <script>
        $(document).ready(function () {
            $(".rdolist").labelauty("rdolist", "rdo");
        });
	</script>
	
	  <script src="zhao/address/js/distpicker.data.js"></script>
	  <script src="zhao/address/js/distpicker.js"></script>
	  <script src="zhao/address/js/main.js"></script>

</body>
</html>
