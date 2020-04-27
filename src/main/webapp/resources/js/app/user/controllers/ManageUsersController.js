/**
 * compose new post controller
 */
'use strict';
app
		.controller(
				"ManageUsersController",
				[
						'$scope',
						'$rootScope',
						'userService',
						'$location',
						'postService',
						function($scope, $rootScope, userService, $location,postService) {
							
							$(document).ready(function(){
							    $('ul.tabs').tabs();
							  });
							
							$(document).ready(function(){
							    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
							    $('.modal-trigger').leanModal();
							  });
							
							$("#profile_img").click(function() {
							    $("input[id='load_image']").click();
							});
							
							$scope.animationsEnabled = true;
						/*	$scope.openViewUser = function(size, user) {

								var modalInstance = $modal
										.open({
											animation : $scope.animationsEnabled,
											templateUrl : 'resources/templates/userDetailsModalTemplate.html',
											controller : 'UserDetailModalController',
											size : size,
											resolve : {
												user : function() {
													return user;
												}
											}
										});
							}

							$scope.openEditUser = function(size, user) {

								var modalInstance = $modal
										.open({
											animation : $scope.animationsEnabled,
											templateUrl : 'resources/templates/editUserDetailsModalTemplate.html',
											controller : 'EditUserDetailModalController',
											size : size,
											resolve : {
												user : function() {
													return user;
												}
											}
										});
							}
							$scope.toggleAnimation = function() {
								$scope.animationsEnabled = !$scope.animationsEnabled;
							};*/

							// As user list is fetched from index.jsp which is
							// parent scope so
							// we have to user rootscope to access user list
							$rootScope.userList = function() {
								userService.userList().then(function(data) {
									$rootScope.users = data.data.result;
								});
							};
							
							/*$rootScope.listUserPosts =function(criteria){
								postService.getPostsByCriteria(criteria).then(function(data){
									$rootScope.userPosts = data.data.result;
								});
							};*/
							// delete the selected user from db
						/*	$scope.deleteUser = function(userId) {
								var dlg = dialogs.confirm('Confirmation','Do you want to delete user?',{size:'sm'});
								dlg.result.then(function(btn){
									userService
									.deleteUser(userId)
									.then(
											function(data) {
												if (data.data) {
													dialogs.notify('Notification','User Deleted sucssfully',{size:'sm'});
													$scope.userList();
												} else {
													dialogs.notify('Notification','Error while deleting User!',{size:'sm'});
												}
											});
								});
								
							};*/

						} ]);