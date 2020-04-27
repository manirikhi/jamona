<!-- Navigation -->
<nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container">
	<a id="logo-container" href="#/blogs" class="brand-logo">Blog Diary</a>
      <ul class="right hide-on-med-and-down">
        <li> 
        	<a class="waves-effect waves-light btn orange" href="/blog/login">Login</a>
        </li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li>Welcome : {{userName}}</li>
		<li><a ui-sref=".newPost"><i class="material-icons">note_add</i> New Blog</a></li>
		<li><a ui-sref=".dashboard" ><i class="material-icons">dashboard</i> Dashboard</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
<!-- Main component for a primary marketing message or call to action -->

<!-- Page Content -->
<div class="container">

	<div class="section">
		<!-- Main View area -->
		<div class="row">
			<div ui-view="mainView"></div>
		</div>
	</div>
	<!-- /.row -->
</div>