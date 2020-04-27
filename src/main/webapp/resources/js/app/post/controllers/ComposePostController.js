/**
 * compose new post controller
 */
(function() {
	'use strict';
	app.controller("ComposePostController", [
			'$scope',
			'postService',
			'$rootScope',
			'$cookies',
			'$window',
			'parseCookie',
			function($scope, postService, $rootScope, $cookies,
					$window, parseCookie) {
			$(document).ready(function() {
			    $('select').material_select();
			  });
			
			$(document).ready(function(){
			    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
			    $('.modal-trigger').leanModal();
			  });
			
			$scope.newPost = {};
			 var toolbar = [
			                ['style', ['style', 'bold', 'italic', 'underline', 'strikethrough', 'clear']],
			                ['fonts', ['fontsize', 'fontname']],
			                ['color', ['color']],
			                ['undo', ['undo', 'redo', 'help']],
			                ['ckMedia', ['ckImageUploader', 'ckVideoEmbeeder']],
			                ['misc', ['link', 'picture', 'table', 'hr', 'codeview', 'fullscreen']],
			                ['para', ['ul', 'ol', 'paragraph', 'leftButton', 'centerButton', 'rightButton', 'justifyButton', 'outdentButton', 'indentButton']],
			                ['height', ['lineheight']],
			            ];

			            $('#editor').materialnote({
			                toolbar: toolbar,
			                height: 550,
			                minHeight: 100,
			                defaultBackColor: '#fff',
			                followingToolbar: false
			            });
				$scope.savePost = function(newPost) {
					newPost.creationDate = new Date();
					// User email retrived from email cookie
					newPost.authorEmail = parseCookie.getCookie('email');
					newPost.authorName = parseCookie.getCookie('userName');
					newPost.authorId = parseCookie.getCookie('userId');
					newPost.content = $('#editor').code();
				/*	if (newPost.authorEmail == undefined
							|| newPost.authorEmail == ''
							|| newPost.authorEmail == null) {
						var dlg = dialogs.confirm('Confirmation',
								'Please login to write your post!', {
									size : 'sm'
								});
						dlg.result.then(function(btn) {
							$window.location.href = '/blog/login';
						}, function(btn) {
							// console.log('No');
						});
					}*/

					if (newPost.content) {
						var span = document.createElement('span');
						var content = $(span).html($scope.newPost.content).text();
						newPost.shortContent = content.substring(0, 430)
								+ ".......";
					}

					postService.savePost(newPost).then(
							function(data) {
								console.log(data);
								if (data.data.error) {
									/*dialogs.notify('Notificacion',
											data.data.message, {
												size : 'sm'
											});*/
								} else {
									$scope.newPost = {};
									$scope.newTag = undefined;
									/*dialogs.notify('Notificacion',
											'Post created successfully!', {
												size : 'sm'
											});*/
								}
							});
				};

				$scope.addtag = function(newTag) {
					if (!$scope.newPost) {
						$scope.newPost = {};
						$scope.newPost.tags = [];
					}
					if (!$scope.newPost.tags) {
						$scope.newPost.tags = [];
					}
					if (newTag) {
						var index = $scope.newPost.tags.indexOf(newTag);
						if (index <= -1) {
							$scope.newPost.tags.push(newTag);
						}

					}

				};

				$scope.popTag = function(popTag) {
					var index = $scope.newPost.tags.indexOf(popTag);
					if (index > -1) {
						$scope.newPost.tags.splice(index, 1);
					}
				};
			} ]);

})();