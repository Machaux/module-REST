
"use strict"

angular.module("BankonetClient",["ngRoute"])


		.config(function($routeProvider) {
				
				$routeProvider
					.when ("/" , {})

					.when ("/employe", {
						templateUrl: "/Views/listeEmploye.html"
					})
					
					.otherwise({
						redirectTo :"/"
					});
					
		})