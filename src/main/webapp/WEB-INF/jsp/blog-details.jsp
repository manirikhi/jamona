<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" ui-sref=".blogs" ng-click="listPosts();">Blogs</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li ng-hide="loginFlag"><a ui-sref=".dashboard.manageUser" ng-click="userList();">Dashboard</a></li>
				<li ng-hide="loginFlag"><a ui-sref=".newPost">New Blog</a></li>
				<li><a ui-sref=".about">About</a></li>
			</ul>
			
			<!-- User details -->
			<div ng-hide="loginFlag">
				<ul style="color: #777;"  class="nav navbar-top-links navbar-right">
		                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a ui-sref=".dashboard.manageUser" ng-click="userList();"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
		</ul>
		
		<ul class="nav navbar-top-links navbar-right">
				<li style="color: #777;margin-top: 10px;">Welcome : {{userName}}</li>
		</ul>
		</div>
		<!-- End User details -->
			
		<!-- Inline login form -->
		<div ng-hide="!loginFlag">
			<div class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form" action="validate" method="post">
            <div class="form-group">
              <input type="email" placeholder="Email" class="form-control" name="email">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control" name="password">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div><!--/.navbar-collapse -->
		</div>
		<!-- End Inline login form -->
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
<!-- Main component for a primary marketing message or call to action -->
<h3>
	<small>Trends, insights and tools on thought collaboration</small>
</h3>
<hr>
<!-- Page Content -->
<div class="container">

	<div class="row">
		<!-- Main View area -->
		<div ui-view="mainView"></div>

	</div>
	<!-- /.row -->