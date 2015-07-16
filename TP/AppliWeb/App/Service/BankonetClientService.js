"use strict"

angular.module("BankonetClient")

	.factory('BankonetClientService', function($http){
				return {
				
				version : "1.0",

				getAllEmployes : function (){
						return $http.get('http://localhost:8080/bankonet-REST/api/employes')
							.then( function (resulte) {
								return resulte.data
							})
					},
				};
	})