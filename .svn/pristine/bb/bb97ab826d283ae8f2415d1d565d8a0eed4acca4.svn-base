<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<!-- 头部 -->
	<div class="top-navbar header b-b">
	
		<!-- 折叠菜单 -->
		<a data-original-title="Toggle navigation" class="toggle-side-nav pull-left" href="#">
			<i class="icon-reorder"></i> 
		</a>
		<!-- 折叠菜单end -->
		
		<!-- 左上角logo -->
		<div class="brand pull-left">
			<a href="${ctx}/page/admin/index.jsp">
				<img src="${ctx}/page/common/js/thin/images/logo.png" width="180" height="40">
			</a>
		</div>
		<!-- 左上角logoend -->
		
		<!-- 自定义通知导航项 -->
		<ul class="nav navbar-nav navbar-right  hidden-xs">
		
			<%--我的待办任务列表 --%>
			<!-- 通知列表 -->
			<!-- <li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
					<i class="icon-warning-sign"></i>
					<span class="badge">5</span>
				</a>
				<ul class="dropdown-menu extended notification">
					<li class="title">
						<p>You have 5 new notifications</p>
					</li>
					<li>
						<a href="#"> 
							<span class="label label-success">
								<i class="icon-plus"></i>
							</span> 
							<span class="message">New user registration.</span> 
							<span class="time">1 mins</span>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="label label-danger">
								<i class="icon-warning-sign"></i>
							</span> 
							<span class="message">High CPU load on cluster #2.</span> 
							<span class="time">1 mins</span>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="label label-info">
								<i class="icon-bullhorn"></i>
							</span> 
							<span class="message">New items are in queue.</span> 
							<span class="time">25 mins</span>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="label label-warning">
								<i class="icon-bolt"></i>
							</span> 
							<span class="message">Disk space to 85% full.</span> 
							<span class="time">35 mins</span>
					</a></li>
					<li class="footer"><a href="#">View all notifications</a></li>						
				</ul>
			</li> -->
			<!-- 通知列表 end -->
			<%--
			<!-- 任务列表 -->
			<li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
					<i class="icon-tasks"></i> 
					<span class="badge">7</span>
				</a>
				<ul class="dropdown-menu extended notification">
					<li class="title">
						<p>You have 7 pending tasks</p>
					</li>
					<li>
						<a href="#"> 
							<span class="task"> 
								<span class="desc">Preparing new release</span> <span class="percent">30%</span>
							</span>
							<div class="progress progress-small">
								<div class="progress-bar progress-bar-info" style="width: 30%;"></div>
							</div>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="task"> 
								<span class="desc">Change management</span> <span class="percent">80%</span>
							</span>
							<div class="progress progress-small progress-striped active">
								<div class="progress-bar progress-bar-danger" style="width: 80%;"></div>
							</div>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="task"> 
								<span class="desc">Mobile development</span> <span class="percent">60%</span>
							</span>
							<div class="progress progress-small">
								<div class="progress-bar progress-bar-success" style="width: 60%;"></div>
							</div>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="task"> 
								<span class="desc">Database migration</span> <span class="percent">20%</span>
							</span>
							<div class="progress progress-small">
								<div class="progress-bar progress-bar-warning" style="width: 20%;"></div>
							</div>
						</a>
					</li>
					<li class="footer"><a href="#">View all tasks</a></li>
				</ul>
			</li>
			<!-- 任务列表 end -->
				
			<!-- 邮件列表 -->
			<li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
					<i class="icon-envelope"></i>
					<span class="badge">1</span>
				</a>
				<ul class="dropdown-menu extended notification">
					<li class="title">
						<p>You have 3 new messages</p>
					</li>
					<li>
						<a href="#"> 
							<span class="photo"> 
								<img src="${ctx}/page/common/js/thin/images/profile.png" width="34" height="34">
							</span> 
							<span class="subject"> 
								<span class="from">John Doe</span> 
								<span class="time">Just Now</span>
							</span> 
							<span class="text"> Consetetur sadipscing elitr...</span>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="photo">
								<img src="${ctx}/page/common/js/thin/images/profile.png" width="34" height="34">
							</span> 
							<span class="subject"> 
								<span class="from">John Doe</span> 
								<span class="time">35 mins</span>
							</span> 
							<span class="text"> Sed diam nonumy... </span>
						</a>
					</li>
					<li>
						<a href="#"> 
							<span class="photo">
								<img src="${ctx}/page/common/js/thin/images/profile.png" width="34" height="34">
							</span> 
							<span class="subject"> 
								<span class="from">John Doe</span> 
								<span class="time">5 hours</span>
							</span> 
							<span class="text"> No sea takimata sanctus... </span>
						</a>
					</li>
					<li class="footer"><a href="#">View all messages</a></li>
				</ul>
			</li>
			<!-- 邮件列表 end -->
			 --%>
			 
			<!-- 用户信息列表 -->
			<li class="dropdown user  hidden-xs">
				<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
					<i class="icon-male"></i>
					<span class="username"> ${SPRING_SECURITY_CONTEXT.authentication.principal.username}</span> 
					<i class="icon-caret-down small"></i>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a href="javascript:void(0);" onclick="forward('${ctx}/page/admin/user/userInfo.jsp')">
							<i class="icon-user"></i> 个人信息
						</a>
					</li>
					<!-- 
					<li>
						<a href="fullCalendar.html">
							<i class="icon-calendar"></i> 我的日历
						</a>
					</li>
					 -->
					<li><a href="javascript:void(0);" onclick="forward('${ctx}/page/admin/activiti/taskList.jsp')"><i class="icon-tasks"></i> 待办任务</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);" onclick="forward('${ctx}/page/logout?type=0');"><i class="icon-key"></i> 注销</a></li>
				</ul>
			</li>
			<!-- 用户信息列表end -->
				
		</ul>
		<!-- 自定义通知导航项end -->
		
		<!-- 全局搜索 -->
		<!-- <form class="pull-right">
			<input type="search" placeholder="搜索..." class="search" id="search-input">
		</form> -->
		<!-- 全局搜索end -->
		
	</div>
	<!-- 头部end -->
</div>
