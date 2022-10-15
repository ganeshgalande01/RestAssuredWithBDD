Feature: I am testing PATCH request for Go rest Api

Scenario: Patch request to update a user in DB

		Given API is up and running
		And I have a new user created in the system
		When I hit the api with patch request to update the existing user
		Then API should update the user
		And I can find the updated information for that user