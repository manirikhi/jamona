/**
 * User details Modal window controller
 */
'use strict';
app.controller("EditUserDetailModalController", [ '$scope', '$rootScope',
		'$modalInstance', 'user','userService',
		function($scope, $rootScope, $modalInstance, user,userService) {
			$scope.user = user;
			$scope.save = function(updatedUser) {
				userService
				.updateUser(updatedUser)
				.then(
						function(data) {
							if (data.data) {
								alert("User updated sucssfully");
							} else {
								alert("Error while saving User details!");
							}
							$scope.close();
						});
			};

			$scope.close = function() {
				$modalInstance.dismiss('cancel');
			};
		} ]);