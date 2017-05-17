
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>智能小朵-问题中心</title>
    <link href="/org.xjtusicd3.partner/ico/zyq.ico" type="image/x-icon" rel="shortcut icon">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="new/front/style/reset.css" />
    <link rel="stylesheet" type="text/css" href="new/front/style/util.css" />
    <link rel="stylesheet" type="text/css" href="new/front/style/utilDetails.css" />
    <link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<link rel="stylesheet" type="text/css" href="css/body.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
    <link href="zhao/lunbo/css/jquery.onebyone-min.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/header.js"></script>
    <script type="text/javascript" src="js/lnv_frontMonitor.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="js/modernizr.custom.79639.js"></script>
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
	            	<span>小朵问题中心</span>
	        	</a>
    		</div>
		</div>
    </div>
    <div class="mainContent">
        <div class="contentWra clearfix">
            <div class="leftMainWrapper ">
				<section id="mainL">
				<div id="quickAsk">
					<p>有问题，来问吧~</p>
					<form onsubmit="return false;">
						<input type="text" placeholder="输入问题，如“如何升级至Windows 10？”">
						<button>提交</button>
					</form>
					<div class="wrapper-demo">
						<div id="dd" class="wrapper-dropdown-3" tabindex="1">
							<span>全部</span>
							<ul class="dropdown">
								<li><a href="#"><i class="icon-envelope icon-large"></i>全部</a></li>
								<li><a href="#"><i class="icon-truck icon-large"></i>已解决</a></li>
								<li><a href="#"><i class="icon-plane icon-large"></i>待回答</a></li>
							</ul>
						</div>
					​</div>
				</div>

				<!-- 问题查询列表 -->
				<ul id="searchResult">
					<#list communityViews as communityViews>
					<li>
						<article id="${communityViews.communityId}_">
							<div class="tag">
								<ul>
									<li>${communityViews.classifyName}</li>
									<#if communityViews.userId ??>
									<li class="type">回答</li>
									<#else>
									<li class="type">问题</li>
									</#if>
								</ul>
								<div class="time"><p>${communityViews.time}</p></div>
							</div>
							<div class="title">
								<h2><a href="question2.html?q=${communityViews.communityId}">${communityViews.communityTitle}</a></h2>
							</div>
							<#if communityViews.userId ??>
							<div class="description">
								<div class="answerer" data-id="270369">
									<img class="answerImg" src="${communityViews.userImage}">
									<div>
										<a href="">
											<span class="user_name">${communityViews.userName}</span>
												&nbsp;&nbsp;<span>${communityViews.signature}</span>
										</a>
									</div>
									<div>
										<img src="images/bluepoint.png" class="bluepoint">贡献${communityViews.totalCommunityNumber}个回答，获得${communityViews.totalLikesNumber}个赞
									</div>
								</div>
								<div class="detail">
									<#if communityViews.answer?length gt 100>
									<div class="detailP">
										${communityViews.answer[0..100]}......
										<span class="readMore">查看更多</span>
									</div>
									<#else>
									<div class="detailP">${communityViews.answer}
									</div>
									</#if>
								</div>
								<div class="fullDetail hidden">
									<p>${communityViews.answer}</p>
								</div>
							</div>
							<div class="options">
								<ul>
									<li class="special"><a data-fun="toVote" class="unVoted fm_ele" fm-type="button" fm-name="answer_vote" fm-operation="click" fm-zoon="option_area"><span class="status">点赞</span>  |  <span class="number">4</span></a></li>
									<li><a data-fun="toComment" class="fm_ele" fm-type="button" fm-name="answer_comment" fm-operation="click" fm-zoon="option_area"><span>评论 </span><span class="number">1</span></a></li>
									<li><a data-fun="toSave" class="fm_ele" fm-type="button" fm-name="answer_favorite" fm-operation="click" fm-zoon="option_area"><span>收藏</span></a></li>
									<span class="fold"><a data-fun="fold"><span class="foldicon"></span>收起</a></span>
								</ul>
							</div>
							<#else>
							<div class="description">
								<div class="detail">
									<#if communityViews.communityQuestion?length gt 100>
									<div class="detailP">
										${communityViews.communityQuestion[0..100]}......
										<span class="readMore">查看更多</span>
									</div>
									<#else>
									<div class="detailP">${communityViews.communityQuestion}
									</div>
									</#if>
								</div>
								<div class="fullDetail hidden">
									<p>${communityViews.communityQuestion}</p>
								</div>
							</div>
							<div class="options">
								<ul>
									<li class="special"><a onclick="create_edit(this)" class="unFocused fm_ele" ><span class="status" id="${communityViews.communityId}">回答</span></a></li>
									<li><a data-fun="toComment" class="fm_ele" fm-type="button" fm-name="answer_comment" fm-operation="click" fm-zoon="option_area"><span>评论 </span><span class="number">0</span></a></li>
									<span class="fold"><a data-fun="fold"><span class="foldicon"></span>收起</a></span>
								</ul>
							</div>
							</#if>
							
						</article>
					</li>
					</#list>
					<li>
						<article data-question-id="42200" data-asker-id="293435" data-answer-id="13748" data-answerer-id="270359">
							<div class="tag">
								<ul>
									<li>个人电脑</li>
									<li class="type">回答</li>
								</ul>
								<div class="time"><p>2017-03-01 11:07</p></div>
							</div>
							<div class="title">
								<h2><a href="detail.html?qid=42200">window7&nbsp;thinkpad&nbsp;E430C怎么关闭FN的快捷键，</a></h2>
							</div>
							<div class="description">
								<div class="answerer" data-id="270359">
									<img class="answerImg" src="new/front/images/avatar.jpg">
									<div>
										<a href="personal.html?userid=270359">
											<span class="user_name">娜塔莉亚</span>
												&nbsp;&nbsp;<span>上天派来的拯救者</span>
										</a>
									</div>
									<div>
										<img src="images/bluepoint.png" class="bluepoint">贡献2个回答，获得10个赞
									</div>
								</div>
								<div class="detail">
									<div class="detailImg">
										<img src="zhao/lunbo/images/13.jpg">
									</div>
									<div class="detailP">think笔记本作为一个高端商务品牌，这个功能肯定是可以切换的，从官网上找了几个方法，可以供题主参考一下。快捷键Fn+ESC启用或禁用Fn锁定功能禁用Fn 锁定功能后：Fn 锁定指示灯熄灭。要使用每个键上印有图标的特殊功能，请直接按...<span class="readMore">查看更多</span></div>
								</div>
								<div class="fullDetail hidden">
									<p>think笔记本作为一个高端商务品牌，这个功能肯定是可以切换的，从官网上找了几个方法，可以供题主参考一下。</p><ol class=" list-paddingleft-2" ="list--type:="" decimal;"=""><li><p>快捷键Fn+ESC启用或禁用Fn锁定功能</p><p><img src="/ueditor/php/upload/image/20170301/1488336832449137.png" alt="think键盘.png"></p><p><br></p><p><br></p><p>禁用Fn 锁定功能后：Fn 锁定指示灯熄灭。要使用每个键上印有图标的特殊功能，请直接按功能键；要使用传统的F1-F12功能，请按Fn键和相应的功能键。</p><p>启用Fn 锁定功能后：Fn 锁定指示灯点亮。要使用传统的F1-F12功能，请直接按功能键；要使用每个键上印有图标的特殊功能，请按Fn键和相应的功能键。</p><p>注意事项：</p><p>1、ThinkPad E431/E531开始浮岛式键盘采用此功能；</p><p>2、个别早期机型浮岛式键盘除外，例如T430u，X1，ThinkPad X1 Carbon 一代、二代；</p></li><li><p>通过键盘属性设置Fn键的功能</p><p>这个方法首先要安装热键驱动，给题主附上驱动下载链接</p><p>驱动下载链接：<a href="http://think.lenovo.com.cn/support/driver/mainpage.aspx#ThinkPad" _src="http://think.lenovo.com.cn/support/driver/mainpage.aspx#ThinkPad">http://think.lenovo.com.cn/support/driver/mainpage.aspx#ThinkPad</a><br>确认好热键驱动安装完成之后，就可以按照下面的步骤来操作了。</p><p><br></p><p>1.打开控制面板，并将控制面板的视图从“类别”更改为“大图标”或“小图标”。<br><img src="/ueditor/php/upload/image/20170301/1488337442938474.png" alt="控制面板-查看方式.png"><br></p><p>2.找到“键盘”并打开，在“键盘属性”窗口中，单击“Fn和功能键”选项卡。</p><p><img src="/ueditor/php/upload/image/20170301/1488337367473742.jpg" alt="think键盘属性.jpg"><br></p><p>3.按照如下介绍设置为您需要的模式：</p><p>• 若选择“直接按F1-F12以启动F1-F12功能，……”</p><p>此时，要使用F1-F12传统按键功能，请直接按功能键；</p><p>要使用每个键上印有图标的特殊功能，请按Fn键和相应的功能键</p></li><li><p>通过BIOS设置Fn键的功能<br>题主提到了，进不去BIOS界面，这种情况确实有可能出现，推荐不要在开机的时候按F1，是进入操作系统之后，再重启电脑，重启的过程中就开始按F1，这样更容易进入BIOS。</p><p>电脑重启到ThinkPad Logo标识时连续敲击键盘F1键，进入BIOS，使用←→左右方向键选择Config菜单项，使用↑↓上下方向键选择Keyboard/Mouse选项并按下Enter回车键，其中：</p><p>通过“Fn and Ctrl Key swap”选项的开关，可以设置Fn与Ctrl键功能是否互换；</p><p>通过“Fn Key Lock”选项的开关，可以设置Fn键是否锁定</p><p><br></p></li></ol>
								</div>
														</div>
							<div class="options">
								<ul>
								
										<li class="special"><a data-fun="toVote" class="unVoted fm_ele" fm-type="button" fm-name="answer_vote" fm-operation="click" fm-zoon="option_area"><span class="status">点赞</span>  |  <span class="number">10</span></a></li>
									<li><a data-fun="toComment" class="fm_ele" fm-type="button" fm-name="answer_comment" fm-operation="click" fm-zoon="option_area"><span>评论 </span><span class="number">1</span></a></li>
										<li><a data-fun="toSave" class="fm_ele" fm-type="button" fm-name="answer_favorite" fm-operation="click" fm-zoon="option_area"><span>收藏</span></a></li>
																<span class="fold"><a data-fun="fold"><span class="foldicon"></span>收起</a></span>
								</ul>
							</div>
	
						</article>
					</li>
				</ul>
				
				<div id="loadStatus">
					<div id="loading" class="">
						<span>加载中</span>
						<div class="spinner">
  							<div class="bounce1"></div>
  							<div class="bounce2"></div>
  							<div class="bounce3"></div>
						</div>
					</div>
					<div id="loadMore" class="hidden">
						<button>加载更多</button>
					</div>
					<div id="noMore" class="hidden">
						<span>没有更多</span>
					</div>
				</div>
			</section>
                
            </div>
            
            <div class="rightBarWrapper">
            	<div id="mainR">
            	<div style="height:85px;"><button class="fm_ele" id="ask" fm-type="button" fm-name="button_ask" fm-operation="click" fm-zoon="header_area" onclick="questionForm();">提新问题</button></div>
				<div><a href="http://iknow.lenovo.com/"><img id="wenba" src="images/iknow.png"></a></div>
				<div id="topic">
					<div id="topicTitle"><img src="images/topic.png">话题</div>
					<!-- 问题标签列表 -->
					<ul id="tagFilter">
					<#list classifyList as classifyList>
						<li><a class="fm_ele" fm-type="button" fm-name="tag_filter" fm-operation="click" fm-zoon="tag_area">${classifyList.FAQCLASSIFYNAME}</a></li>
					</#list>
					</ul>
				</div>
			</div>
        	</div>
        </div>
    </div>
    
    <div id="foot" class="footer">
    	<p style="color: #ffffff;text-align: center;">© 西安交通大学社会智能与复杂数据处理实验室  2017.</p>
    </div>
    <div id="questionForm" class="popup" style="display: none;">		
    	<div class="fade"></div>			
    	<div id="question-f">				
    		<div id="question-s" class="">					
    			<a href="javascript:" id="close"></a>
				<h1 id="titH">添加问题</h1>					
				<textarea rows="1" name="question_content" id="title" placeholder="请输入您的问题，如：IPhone 6指纹识别如何破解？" maxlength="100"></textarea>
				<script id="editor" type="text/plain" style="width:650px;height:300px;"></script>
<p class="askTitleTip" style="display: none;"></p>	
				<ul id="similarAsk" style="display: block;"></ul>					
				<h1 id="desH">添加问题的详细描述</h1>					
				<div id="ueditor" class="edui-default" style="margin: 20px 0px 0px 35px; width: 650px; font-size: 14px;">
				<div id="edui1" class="edui-editor  edui-default" style="width: 650px; z-index: 1;">
				<div id="edui1_toolbarbox" class="edui-editor-toolbarbox edui-default">
				<div id="edui1_toolbarboxouter" class="edui-editor-toolbarboxouter edui-default"><div class="edui-editor-toolbarboxinner edui-default"><div id="edui2" class="edui-toolbar   edui-default" onselectstart="return false;" onmousedown="return $EDITORUI[&quot;edui2&quot;]._onMouseDown(event, this);" style="-webkit-user-select: none;"><div id="edui38" class="edui-box edui-button edui-for-fullscreen edui-default"><div id="edui38_state" onmousedown="$EDITORUI[&quot;edui38&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui38&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui38&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui38&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui38_body" unselectable="on" title="全屏" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui38&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui38&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div><div class="edui-box edui-label edui-default"></div></div></div></div></div><div id="edui3" class="edui-box edui-button edui-for-bold edui-default"><div id="edui3_state" onmousedown="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui3_body" unselectable="on" title="加粗" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui3&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui3&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div></div></div></div></div><div id="edui4" class="edui-box edui-button edui-for-italic edui-default"><div id="edui4_state" onmousedown="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui4_body" unselectable="on" title="斜体" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui4&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui4&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div></div></div></div></div><div id="edui5" class="edui-box edui-button edui-for-underline edui-default"><div id="edui5_state" onmousedown="$EDITORUI[&quot;edui5&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui5&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui5&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui5&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui5_body" unselectable="on" title="下划线" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui5&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui5&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div></div></div></div></div><div id="edui6" class="edui-box edui-menubutton edui-for-insertorderedlist edui-default"><div title="有序列表" id="edui6_state" onmousedown="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-menubutton-body edui-default"><div id="edui6_button_body" class="edui-box edui-button-body edui-default" onclick="$EDITORUI[&quot;edui6&quot;]._onButtonClick(event, this);"><div class="edui-box edui-icon edui-default"></div></div><div class="edui-box edui-splitborder edui-default"></div><div class="edui-box edui-arrow edui-default" onclick="$EDITORUI[&quot;edui6&quot;]._onArrowClick();"></div></div></div></div><div id="edui19" class="edui-box edui-menubutton edui-for-insertunorderedlist edui-default"><div title="无序列表" id="edui19_state" onmousedown="$EDITORUI[&quot;edui19&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui19&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui19&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui19&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-menubutton-body edui-default"><div id="edui19_button_body" class="edui-box edui-button-body edui-default" onclick="$EDITORUI[&quot;edui19&quot;]._onButtonClick(event, this);"><div class="edui-box edui-icon edui-default"></div></div><div class="edui-box edui-splitborder edui-default"></div><div class="edui-box edui-arrow edui-default" onclick="$EDITORUI[&quot;edui19&quot;]._onArrowClick();"></div></div></div></div><div id="edui26" class="edui-box edui-combox edui-for-fontsize edui-default"><div title="字号" id="edui26_state" onmousedown="$EDITORUI[&quot;edui26&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui26&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui26&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui26&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-combox-body edui-default"><div id="edui26_button_body" class="edui-box edui-button-body edui-default" onclick="$EDITORUI[&quot;edui26&quot;]._onButtonClick(event, this);"></div><div class="edui-box edui-splitborder edui-default"></div><div class="edui-box edui-arrow edui-default" onclick="$EDITORUI[&quot;edui26&quot;]._onArrowClick();"></div></div></div></div><div id="edui31" class="edui-box edui-separator  edui-default"></div><div id="edui32" class="edui-box edui-button edui-for-justifyleft edui-default"><div id="edui32_state" onmousedown="$EDITORUI[&quot;edui32&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui32&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui32&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui32&quot;].Stateful_onMouseOut(event, this);" class="edui-default edui-state-checked"><div class="edui-button-wrap edui-default"><div id="edui32_body" unselectable="on" title="居左对齐" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui32&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui32&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div><div class="edui-box edui-label edui-default"></div></div></div></div></div><div id="edui33" class="edui-box edui-button edui-for-justifycenter edui-default"><div id="edui33_state" onmousedown="$EDITORUI[&quot;edui33&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui33&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui33&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui33&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui33_body" unselectable="on" title="居中对齐" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui33&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui33&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div><div class="edui-box edui-label edui-default"></div></div></div></div></div><div id="edui34" class="edui-box edui-button edui-for-justifyright edui-default"><div id="edui34_state" onmousedown="$EDITORUI[&quot;edui34&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui34&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui34&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui34&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui34_body" unselectable="on" title="居右对齐" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui34&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui34&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div><div class="edui-box edui-label edui-default"></div></div></div></div></div><div id="edui35" class="edui-box edui-button edui-for-justifyjustify edui-default"><div id="edui35_state" onmousedown="$EDITORUI[&quot;edui35&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui35&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui35&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui35&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui35_body" unselectable="on" title="两端对齐" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui35&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui35&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"></div><div class="edui-box edui-label edui-default"></div></div></div></div></div><div id="edui36" class="edui-box edui-separator  edui-default"></div><div id="edui37" class="edui-box edui-button edui-for-simpleupload edui-default"><div id="edui37_state" onmousedown="$EDITORUI[&quot;edui37&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui37&quot;].Stateful_onMouseUp(event, this);" onmouseover="$EDITORUI[&quot;edui37&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui37&quot;].Stateful_onMouseOut(event, this);" class="edui-default"><div class="edui-button-wrap edui-default"><div id="edui37_body" unselectable="on" title="单图上传" class="edui-button-body edui-default" onmousedown="return $EDITORUI[&quot;edui37&quot;]._onMouseDown(event, this);" onclick="return $EDITORUI[&quot;edui37&quot;]._onClick(event, this);"><div class="edui-box edui-icon edui-default"><iframe style="display: block; width: 20px; height: 20px; overflow: hidden; border: 0px; margin: 0px; padding: 0px; position: absolute; top: 0px; left: 0px; opacity: 0; cursor: pointer;"></iframe></div></div></div></div></div></div></div></div><div id="edui1_toolbarmsg" class="edui-editor-toolbarmsg edui-default" style="display:none;"><div id="edui1_upload_dialog" class="edui-editor-toolbarmsg-upload edui-default" onclick="$EDITORUI[&quot;edui1&quot;].showWordImageDialog();">点击上传</div><div class="edui-editor-toolbarmsg-close edui-default" onclick="$EDITORUI[&quot;edui1&quot;].hideToolbarMsg();">x</div><div id="edui1_toolbarmsg_label" class="edui-editor-toolbarmsg-label edui-default"></div><div style="height:0;overflow:hidden;clear:both;" class="edui-default"></div></div><div id="edui1_message_holder" class="edui-editor-messageholder edui-default"></div></div><div id="edui1_iframeholder" class="edui-editor-iframeholder edui-default" style="width: 650px; height: 300px; z-index: 1; overflow: hidden;"><iframe id="ueditor_0" width="100%" height="100%" frameborder="0" src="javascript:void(function(){document.open();document.write(&quot;<!DOCTYPE html><html xmlns='http://www.w3.org/1999/xhtml' class='view' ><head><style type='text/css'>.view{padding:0;word-wrap:break-word;cursor:text;height:90%;}
body{margin:8px;font-family:sans-serif;font-size:16px;}p{margin:5px 0;}</style>
<link rel='stylesheet' type='text/css' href='http://ask.lenovo.com.cn/ask_edit/themes/iframe.css'/>
<style>p{line-height:20px;font-family: Microsoft YaHei;font-size:13px;}</style>
</head><body class='view' ></body>
<script type='text/javascript'  id='_initialScript'>setTimeout(function(){editor = window.parent.UE.instants['ueditorInstant0'];editor._setup(document);},0);var _tmpScript = document.getElementById('_initialScript');_tmpScript.parentNode.removeChild(_tmpScript);</script></html>&quot;);document.close();}())"></iframe></div><div id="edui1_bottombar" class="edui-editor-bottomContainer edui-default"><table class="edui-default"><tbody class="edui-default"><tr class="edui-default"><td id="edui1_elementpath" class="edui-editor-bottombar edui-default" style="display: none;"></td><td id="edui1_wordcount" class="edui-editor-wordcount edui-default" style="display: none;"></td><td id="edui1_scale" class="edui-editor-scale edui-default" style="display: none;"><div class="edui-editor-icon edui-default"></div></td></tr></tbody></table></div><div id="edui1_scalelayer" class="edui-default"></div></div></div>					<button id="toStep2">下一步</button>				</div>				<div id="tag-s" class="hidden">					<a href="javascript:" id="close"></a>					<h1 id="tagH">添加标签</h1>					<h2>可选</h2>					<p id="titP">“asfdsdafa”</p>					<ul id="systemTag">
			<li>
				<input type="checkbox" name="category_id" value="1" data-text="个人电脑">
				<label>个人电脑</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="2" data-text="智能手机">
				<label>智能手机</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="3" data-text="平板电脑">
				<label>平板电脑</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="4" data-text="网络安全">
				<label>网络安全</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="5" data-text="影音数码">
				<label>影音数码</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="6" data-text="硬件外设">
				<label>硬件外设</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="7" data-text="操作系统">
				<label>操作系统</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="8" data-text="智能设备">
				<label>智能设备</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="9" data-text="评测选购">
				<label>评测选购</label>
			</li>
			<li>
				<input type="checkbox" name="category_id" value="10" data-text="应用软件">
				<label>应用软件</label>
			</li>
		</ul>					
		<ul id="customTag"></ul>					
		<div></div>					
		<button id="toStep1">返回</button>				
		<button id="submit"  onclick="saveCommunityQuestion()">提交</button>				</div>			</div>		</div>
	<div id="lasturl" style="display:none"></div>
    	<script type="text/javascript" src="new/front/js/util.js"></script>
		<script>
			function questionForm(){
				document.getElementById("questionForm").style.display="block";
			}
		</script>
				    <script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
</script> 
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<script>
		function codefans(){
			var box=document.getElementById("success");
			box.style.display="none"; 
		}
		function codefans2(){
			var box=document.getElementById("chongfu");
			box.style.display="none"; 
		}
		function saveCommunityQuestion(){
			var title = document.getElementById("title").value;
			var description = UE.getEditor('editor').getContent();
			var obj = document.getElementsByName("category_id");
			check_val = [];
		    for(k in obj){
		        if(obj[k].checked)
		            check_val.push(obj[k].value);
		    }
				$.ajax({
					type:"POST",
					url:"/org.xjtusicd3.partner/saveCommunityQuestion.html",
					data:{
						"title":title,
						"description":description,
						"check_val":check_val[0]
					},
					dataType:"json",
					success:function(data){
						if(data.value=="0"){
							self.location='login.html';
						}else if(data.value=="1"){
						setTimeout("location.reload()",1000)
							document.getElementById('lasturl').innerHTML=data.url;
							document.getElementById('questionForm').style.display='none';
							document.getElementById('success').style.display='block';
							setTimeout("codefans()",3000);
							
						}else{
						setTimeout("location.reload()",1000)
							document.getElementById('lasturl').innerHTML=data.url;
							document.getElementById('questionForm').style.display='none';
							document.getElementById('chongfu').style.display='block';
							setTimeout("codefans2()",3000);
							
						}
					}
				})
			}
			function create_edit(obj){
				var a = document.getElementById(event.target.id+"_");
				if(document.getElementById('userNameText')==null){
					self.location='login.html';
				}else{
					if(a.lastChild.id=="addcomment"){
						a.lastChild.remove();
					}else{
						var b = document.getElementById('userNameText').textContent;
						$.ajax({
							type:"POST",
							url:"/org.xjtusicd3.partner/getUserInfo.html",
							data:{
								"useremail":b.replace(/您好：/,"")
							},
							dataType:"json",
							success:function(data){
								jsondata=$.parseJSON(data);
								var oDiv = document.createElement('div');
								oDiv.setAttribute("id","addcomment");
		    					oDiv.innerHTML  = '<div class="comment"><img class="deco" src="images/dia-deco.png"><div class="comment-outer"><div class="comment-Editor"><img class="userImg" src="'+jsondata[0].aVATAR+'"><input id="input_'+a.id.replace(/_/,"")+'" class="comment-Editor-input" type="text" placeholder="添加一个评论" growing-track="true"><button class="submitComment" onclick="addComment()" id="button_'+a.id.replace(/_/,"")+'">评论</button></div><ul class="commentList"></ul></div></div>';
		    					a.appendChild(oDiv);
							}
						})
					}
				}
			}
			
			function addComment(){
				var a = document.getElementById(event.target.id);
				var questionId = a.id.replace(/button_/,"");
				var commentContent = document.getElementById('input_'+questionId).value;
				$.ajax({
					type:"POST",
					url:"/org.xjtusicd3.partner/addComment.html",
					data:{
						"questionId":questionId,
						"commentContent":commentContent
					},
					dataType:"json",
					success:function(data){
						
					}
				})
			}
</script>
		<script type="text/javascript">
			function DropDown(el) {
				this.dd = el;
				this.placeholder = this.dd.children('span');
				this.opts = this.dd.find('ul.dropdown > li');
				this.val = '';
				this.index = -1;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;
					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						return false;
					});
					obj.opts.on('click',function(){
						var opt = $(this);
						obj.val = opt.text();
						obj.index = opt.index();
						obj.placeholder.text(obj.val);
					});
				},
				getValue : function() {
					return this.val;
				},
				getIndex : function() {
					return this.index;
				}
			}
			$(function() {
				var dd = new DropDown( $('#dd') );
				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-3').removeClass('active');
				});
			});
		</script>
		<div class="success" id="success" style="z-index:1001;position:fixed;top:40%;left:45%;width:220px;background: #f3f3f3;text-align: center;border:1px solid black;border-radius:3px;display:none"><div style="margin-top:30px; margin-bottom:30px;"><img src="images/true.png" style="width:20px;height:20px;margin-right:10px;"><h2 style="font-size:16px;display:inline-block;line-height:22px;vertical-align:top">提交成功</h2></div></div>
		<div class="success" id="chongfu" style="z-index:1001;position:fixed;top:40%;left:45%;width:220px;background: #f3f3f3;text-align: center;border:1px solid black;border-radius:3px;display:none"><div style="margin-top:30px; margin-bottom:30px;"><img src="images/cuo.png" style="width:20px;height:20px;margin-right:10px;"><h2 style="font-size:16px;display:inline-block;line-height:22px;vertical-align:top">切勿重复提交</h2></div></div>
</body>
</html>
