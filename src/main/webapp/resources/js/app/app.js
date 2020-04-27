/**
 * Main blog app js source
 */
	'use strict';
	var app = angular.module('blogApp', ['ui.router','summernote','ngSanitize','ngCookies','angularUtils.directives.dirPagination','LocalStorageModule']);

	app.config(function($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/blogs');
	
		$stateProvider

		// HOME STATES AND NESTED VIEWS ========================================
		.state('blogs', {
			url : '/blogs',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/blog-main.html',
					controller : 'MainController'
				},
				'blogView@blogs':{
					templateUrl : 'resources/templates/list-blogs.html',
					controller : 'PostListingController'
				},
				'categoriesView@blogs':{
					templateUrl : 'resources/templates/blog-categories.html'
				},
				'searchView@blogs':{
					templateUrl : 'resources/templates/blog-search.html',
					controller : 'PostListingController'
				},
				'widgetView@blogs':{
					templateUrl : 'resources/templates/blog-widget.html'
				}
			}
		})
		.state('blog', {
			url : '/blog/:postId/:permalink',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/blog-main.html',
					controller : 'MainController'
				},
				'blogView@blog':{
					templateUrl : 'resources/templates/view-post.html',
					controller : 'PostViewController'
				},
				'categoriesView@blog':{
					templateUrl : 'resources/templates/blog-categories.html'
				},
				'searchView@blog':{
					templateUrl : 'resources/templates/blog-search.html'
				},
				'widgetView@blog':{
					templateUrl : 'resources/templates/blog-widget.html'
				}
			}
		})
		.state('newPost', {
			url : '/newPost',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/compose-post.html',
					controller : 'ComposePostController'
				}
			}
			
		})
		.state('dashboard', {
			url : '/dashboard',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/users-manage.html',
					controller : 'ManageUsersController'
				}
			}
			
		}).state('dashboard.manageUser', {
			url : '/manageUser',
			parent : 'dashboard',
			views:{
				'userView':{
					templateUrl : 'resources/templates/list-users.html',
					controller : 'ManageUsersController'
				}
			}
			
		}).state('dashboard.managePosts', {
			url : '/managePosts',
			parent : 'dashboard',
			views:{
				'postView':{
					templateUrl : 'resources/templates/list-posts.html',
					controller : 'ManagePostController'
				}
			}
			
		}).state('dashboard.manageBlogs', {
			url : '/manageBlogs',
			parent : 'dashboard',
			views:{
				'blogView':{
					templateUrl : 'resources/templates/list-users.html',
					controller : 'ManageUsersController'
				}
			}
			
		}).state('about', {
			url : '/about',
			views:{
				'blogView':{
					templateUrl : 'resources/templates/list-posts.html',
					//controller : 'ManageUsersController'
				}
			}
			
		});

	}); // closes $routerApp.config()

	
app.run(function($rootScope,parseCookie,$state,$window,postService,localStorageService,commentService,$cookies,$location){
	console.log('run block');
	$rootScope.loginFlag = false;
	$rootScope.categories = [ {
		name : 'News',
		value : 'NEWS'
	}, {
		name : 'Techno',
		value : 'TECHNO'
	}, {
		name : 'Trends',
		value : 'TRENDS'
	}, {
		name : 'Product',
		value : 'PRODUCT'
	}, {
		name : 'Entertainment',
		value : 'ENTERTAINMENT'
	}, {
		name : 'Social',
		value : 'SOCIAL'
	},{
		name : 'Men',
		value : 'MEN'
	},{
		name : 'Women',
		value : 'WOMEN'
	}, ];
	
	if(!$cookies.getObject('email')){
		$rootScope.loginFlag = true;
	}
	
		var hash = $location.hash;
		$rootScope.userEmail = parseCookie.getCookie('email');
		$rootScope.userName = parseCookie.getCookie('userName');
		$rootScope.userCreationDate = parseCookie.getCookie('creationDate');
		$rootScope.userId = parseCookie.getCookie('userId');
		$rootScope.max = 5;
    	$rootScope.isReadonly = false;
    	
      	// Default config to set rating defaults
    	function initDefaults(){
    		$rootScope.userEmail = parseCookie.getCookie('email');
    		$rootScope.userName = parseCookie.getCookie('userName');
			$rootScope.userCreationDate = parseCookie.getCookie('creationDate');
			$rootScope.userId = parseCookie.getCookie('userId');
			$rootScope.max = 5;
	    	$rootScope.isReadonly = false;
    	}
    	
     	function initPost(postId,permalink){
    			$state.go('blog',{ postId : postId,permalink : permalink });
    			postService.getPost(postId).then(function(data){
					if(data.data.error){
						dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						if(data.data.result){
							$rootScope.post = data.data.result;
							commentService.getComments(postId).then(function(data) {
								$rootScope.comments = data.data.result;
							});
						}
						else{
							initPosts();
						}
						
					}
				});
    	}; 
    	
    	function initPosts(){
    		$state.go('blogs');
    		var criteria = {
    				pageRequest : {
    					start : 0,
    					limit : 5,
    					field : 'id',
    					dir : "DESC",
    					page : 1
    				},
    				filter : {},
    				includeList : {
    					fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags','permalink' ]
    				}
    			};
    			postService
    					.getPosts(criteria)
    					.then(
    							function(data) {
    								$rootScope.posts = data.data.result.content;
    								$rootScope.totalPosts = data.data.result.totalElements;
    								localStorageService.set('posts',data.data.result.content);
    								localStorageService.set('totalPosts',data.data.result.totalElements);
    							});
    	}
    	
    	function initilize(){
    		initDefaults();
    		var hash = $window.location.hash;
    		var hashList = hash.split('/');
    		if(hash.indexOf('/blog/') != -1){
    			var postId = hashList[hashList.length-2];
    			var permalink = hashList[hashList.length-1];
    			console.log('post id '+postId);
    			console.log('permalink id '+permalink);
    			if(postId != undefined && postId != null && postId != "" && postId.length > 0){
    				initPost(postId,permalink);
    			}
    			else{
    				initPosts();
    			}
    		}else{
        			initPosts();
    		}
    		
    	};
    	
    	initilize();
});