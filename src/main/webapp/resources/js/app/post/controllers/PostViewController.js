/**
 * compose new post controller
 */
(function() {
	'use strict';
	app.controller("PostViewController", [ '$scope',
			'$rootScope','$window','commentService','postService', function($scope, $rootScope,$window,commentService,postService) {
			$scope.newcomment = {};
			$scope.showReplyForm = false;
			$rootScope.summerNoteOptions = {
				    height: 100,
				    toolbar: [
				            ['headline', ['style']],
				            ['style', ['bold', 'italic', 'underline', 'superscript', 'subscript', 'strikethrough', 'clear']],
				            ['fontface', ['fontname']],
				            ['textsize', ['fontsize']],
				            ['fontclr', ['color']],
				            ['alignment', ['ul', 'ol', 'paragraph', 'lineheight']],
				            ['height', ['height']],
				        ]
				  };
			$rootScope.viewPost = function(postId){
					postService.getPost(postId).then(function(data){
						if(data.data.error){
							//dialogs.notify('Notificacion',data.data.message,{size:'sm'});
						}
						else{
							$rootScope.post = data.data.result;
						}
					});
					
					$scope.getComments(postId);
					postService.postHitCount(postId);
				};
				
			$scope.saveComment = function(newcomment,postId){
				newcomment.postId = postId;
				newcomment.commentDate = new Date();
				commentService.saveComment(newcomment).then(function(data) {
					console.log(data);
					if(data.data.error){
						$scope.getComments(postId);
						//dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						$scope.newcomment = {};
						$scope.getComments(postId);
						//dialogs.notify('Notificacion','Comments added successfully!',{size:'sm'});
						$scope.getComments($scope.post.id);
					}
				});
			}
			
			$scope.getComments = function(postId){
				commentService.getComments(postId).then(function(data) {
					$rootScope.comments = data.data.result;
				});
			}
			
			$scope.likeComment = function(commentId){
				var updateRequest = {
						filter : {
								mappings : [ {
									key : 'id',
									value : commentId
								} ]
							},
						mappings : [{ key : 'likes',
						value : 1,
						oper : 'inc',
						type : "java.lang.Integer"}]
				};
				commentService.updateComment(updateRequest).then(function(data) {
					if(data.data.error){
						//dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						//dialogs.notify('Notificacion','You liked it!',{size:'sm'});
						$scope.getComments($scope.post.id);
					}
				});
			};
			
			$scope.disLikeComment = function(commentId){
				var updateRequest ={
						filter : {
							mappings : [ {
								key : 'id',
								value : commentId
							} ]
						},
						mappings : [{ key : 'dislikes',
						value : 1,
						oper : 'inc',
						type : "java.lang.Integer"}]
				};
				commentService.updateComment(updateRequest).then(function(data) {
					if(data.data.error){
						//dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						//dialogs.notify('Notificacion','You disliked it!',{size:'sm'});
						$scope.getComments($scope.post.id);
					}
				});
			};
			
			$scope.likeReply = function(commentId,email,date){
				var updateRequest = {
						filter : {
								mappings : [ {
									key : 'id',
									value : commentId
								},
								{ key : 'replies.email',
									value : email }
								]
							},
						mappings : [{ key : 'replies.$.likes',
						value : 1,
						oper : 'inc',
						type : "java.lang.Integer"}]
				};
				commentService.updateComment(updateRequest).then(function(data) {
					if(data.data.error){
						//dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						$scope.getComments($scope.post.id);
						//dialogs.notify('Notificacion','You liked it!',{size:'sm'});
						
					}
				});
			};
			
			$scope.disLikeReply = function(commentId,email,date){
				var updateRequest ={
						filter : {
							mappings : [ {
								key : 'id',
								value : commentId
							},
							{ key : 'replies.email',
								value : email }
							,
							{ key : 'replies.replyDate',
								value : date }
							]
						},
						mappings : [{ key : 'replies.$.dislikes',
						value : 1,
						oper : 'inc',
						type : "java.lang.Integer"}]
				};
				commentService.updateComment(updateRequest).then(function(data) {
					if(data.data.error){
						//dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						$scope.getComments($scope.post.id);
						//dialogs.notify('Notificacion','You disliked it!',{size:'sm'});
					}
				});
			};
			
			$scope.saveReply = function(commentId,reply){
				reply.replyDate = new Date();
				var updateRequest ={
						filter : {
							mappings : [ {
								key : 'id',
								value : commentId
							} ]
						},
						mappings : [{ key : 'replies',
						value : reply,
						oper : 'push',
						type : "com.ems.blog.model.Reply"}]
				};
				commentService.updateComment(updateRequest).then(function(data) {
					if(data.data.error){
						//dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						$scope.showReplyForm = false;
						//dialogs.notify('Notificacion','Your reply is submitted!',{size:'sm'});
						$scope.getComments($scope.post.id);
					}
				});
			};
			
			
			$scope.updateRating = function(postId,authorId,rating){
				if($rootScope.userId != null && $rootScope.userId != '' && $rootScope.userId != undefined){
					if(authorId == $rootScope.userId){
						//dialogs.notify('Notificacion','Author can not rating his own posts.',{size:'sm'});
					}
					else{
					var userRate = {
							userId : $rootScope.userId,
							rate : rating
					};
					postService.updatePostRating(postId,userRate).then(function(data){
						if(data.data.result){
							//dialogs.notify('Notificacion','Your Rating recorded successfully! Thanks',{size:'sm'});
						}
						else{
							//dialogs.notify('Notificacion','You have already given your Rating. Thanks',{size:'sm'});
						}
					});
					}
				}
				else{
					var dlg = dialogs.confirm('Confirmation','Please login to record your rating!',{size:'sm'});
					dlg.result.then(function(btn){
						$window.location.href  = '/blog/login';
					},function(btn){
						console.log('No');
					});
				}
			}
			} ]);

})();