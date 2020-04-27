/**
 * compose new post controller
 */
(function() {
	'use strict';
	app
			.controller(
					"PostListingController",
					[
							'$scope',
							'postService',
							'$rootScope','localStorageService',
							function($scope, postService, $rootScope,localStorageService) {
						/* Default pagination values */
						$rootScope.posts = localStorageService.get('posts');
						$rootScope.totalPosts = localStorageService.get('totalPosts');
						$rootScope.postsPerPage = 5;
						$rootScope.currentPage = 1;
						$scope.filter = {};
						$scope.includeList = {};

						$rootScope.listPosts = function() {
							$scope.includeList = {
									fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags','permalink' ]
								}
							$scope.pageChanged(1);
						};

						$rootScope.pageChanged = function(newPage) {
							$rootScope.currentPage = newPage;
							$scope.getPostList();
						};
						
						$scope.getPostList = function() {
							var offset = $rootScope.currentPage > 1 ? ($rootScope.currentPage - 1)
									* $rootScope.postsPerPage
									: 0;
							var criteria = {
								pageRequest : {
									start : offset,
									limit : $rootScope.postsPerPage,
									field : 'id',
									dir : "DESC",
									page : $rootScope.currentPage
								},
								filter : $scope.filter,
								includeList : $scope.includeList
							};
							postService
									.getPosts(criteria)
									.then(
											function(data) {
												$rootScope.posts = data.data.result.content;
												$rootScope.totalPosts = data.data.result.totalElements;
											});
						};

						$rootScope.listPostsByAuthor = function(
								authorEmail) {
							$scope.filter = {
								mappings : [ {
									key : 'authorEmail',
									value : authorEmail
								} ]
							};
							$scope.includeList = {
								fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags','permalink' ]
							}
							$scope.pageChanged(1);
						};

						/* Fetch posts for given author email id */

						$rootScope.listPostsByTag = function(tag) {
							$scope.filter = {
								mappings : [ {
									key : 'tags',
									value : tag
								} ]
							};
							$scope.includeList = {
								fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags','permalink' ]
							}
							$scope.pageChanged(1);
						};
						
				    	$rootScope.listPostsByCategory = function(categoryName){
				    		$scope.filter = {
									mappings : [ {
										key : 'category',
										value : categoryName
									} ]
								};
								$scope.includeList = {
									fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags','permalink' ]
								}
								$rootScope.pageChanged(1);
				    	};
				    	
				    	$rootScope.listPostsBySearch = function(SearchString) {
							$scope.filter = {
								mappings : [ {
									key : '',
									value : SearchString
								} ]
							};
							$scope.includeList = {
								fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags','permalink' ]
							};

							$rootScope.currentPage = 1 ;
							var offset = $rootScope.currentPage > 1 ? ($rootScope.currentPage - 1)
									* $rootScope.postsPerPage
									: 0;
							var criteria = {
								pageRequest : {
									start : offset,
									limit : $rootScope.postsPerPage,
									field : 'id',
									dir : "DESC",
									page : $rootScope.currentPage
								},
								filter : $scope.filter,
								includeList : $scope.includeList
							};
							postService
									.getPostsBySearch(criteria)
									.then(
											function(data) {
												$rootScope.posts = data.data.result.content;
												$rootScope.totalPosts = data.data.result.totalElements;
											});
						
						};
						
						
					} ]);

})();