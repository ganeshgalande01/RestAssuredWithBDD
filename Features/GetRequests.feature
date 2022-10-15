Feature: I am testing get request for Go rest Api

#Scenario: Get request to fetch all the users
#
#		Given Go Rest API is up and running
#		When I hit the api with get request and end point as "/public-api/users/"
#		Then API should return all the users
		
#Scenario: Get Request to fetch single user

#		Given Go Rest API is up and running
#		When I hit the api with get request and end point as "/public-api/users/3044"
#		Then API should return user details of user id "3044"

Scenario: Get Api Request to get all users 

		Given API is up and running
		When Hit API as get request and end point as "/public/v2/users/"
		Then API should return list of the users
		
#Scenario: Get Api Request to get single user
#
#		Given API is up and running
#		When Hit API as get request and end point as "/public/v2/users/4084"
#		Then API should return details of single user