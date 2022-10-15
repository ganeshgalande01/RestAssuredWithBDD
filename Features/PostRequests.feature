Feature: I am testing Post request for Go rest Api

Scenario: Post request to create a user in DB

		Given API is up and running
		And I set header and body to create new user
		When I hit the api with post request and end point as "/public/v2/users/"
		Then API created a new user in the system
		And I can find the new user in the system when i get the user