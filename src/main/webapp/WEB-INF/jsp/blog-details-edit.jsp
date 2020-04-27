<nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container">
	<a id="logo-container" href="#/blogs" class="brand-logo">Blog Diary</a>
      <ul class="right hide-on-med-and-down">
        <li>Welcome : {{userName}}</li>
		<li><a ui-sref=".newPost" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="New Blog"><i class="material-icons">note_add</i></a></li>
		<li><a ui-sref=".dashboard" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Dashboard"><i class="material-icons">dashboard</i></a></li>
		<li><a class='dropdown-button' href="" data-hover="true" data-constrainwidth="false" data-alignment="left" data-beloworigin="true" data-activates="profile-dropdown"><i class="material-icons ">more_vert</i></a>
		<!-- Dropdown Structure -->
		  <ul id='profile-dropdown' class='dropdown-content'>
			<li><a ui-sref=".dashboard" class="tooltipped light-blue-text" data-position="left" data-delay="50" data-tooltip="User Profile"><i class="material-icons">perm_identity</i></a>
			</li>
			<li><a href="#" class="tooltipped light-blue-text" data-position="left" data-delay="50" data-tooltip="settings"><i class="material-icons">settings</i></a>
			</li>
			<li class="divider"></li>
			<li><a href="logout" class="tooltipped light-blue-text" data-position="left" data-delay="50" data-tooltip="Logout"><i class="material-icons">settings_power</i></a>
			</li>
		  </ul>
		</li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li>Welcome : {{userName}}</li>
		<li><a ui-sref=".newPost" class="tooltipped" data-position="right" data-delay="50" data-tooltip="New Blog"><i class="material-icons">note_add</i></a></li>
		<li><a ui-sref=".dashboard" class="tooltipped" data-position="right" data-delay="50" data-tooltip="Dashboard"><i class="material-icons">dashboard</i></a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
<!-- Main component for a primary marketing message or call to action -->

<!-- Page Content -->
<div class="container">

	<div class="section">
		<!-- Main View area -->
		<div ui-view="mainView"></div>

	</div>
	<!-- /.row -->
</div>