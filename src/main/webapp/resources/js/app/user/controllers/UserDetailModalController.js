/**
 * User details Modal window controller
 */
'use strict';
app.controller("UserDetailModalController", [ '$scope', '$rootScope',
		'$modalInstance', 'user',
		function($scope, $rootScope, $modalInstance, user) {
			$scope.user = user;
			$scope.edit = function() {
				$scope.close();
				$rootScope.openEditUser('',$scope.user);
			};

			$scope.close = function() {
				$modalInstance.dismiss('cancel');
			};
		} ]);