Feature: Verify all the Posts

Scenario: Verify that list of posts is returned on GET request
Given There are Posts
When I fetch all Posts as Json Array
And I fetch all Posts as List using jsonpath
Then all the Posts are listed