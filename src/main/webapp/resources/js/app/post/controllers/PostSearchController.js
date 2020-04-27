/**
 * compose new post controller
 */
(function() {
	'use strict';
	app
			.controller(
					"PostSearchController",
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

						/* Fetch posts for given author email id */

						$rootScope.listPostsBySearch = function(tag) {
							$scope.filter = {
								mappings : [ {
									key : 'tags',
									value : tag
								} ]
							};
							$scope.includeList = {
								fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags' ]
							}
							$scope.pageChanged(1);
						};
					} ]);

})();