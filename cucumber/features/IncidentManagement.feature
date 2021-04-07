Feature: IncidentManagement

#Background:
#Given set the End point
#And set the Authorization
#And set the ContentType as Json

Scenario: Create Incident without Body

When send the request as post
Then Confirm the response status code as 201

Scenario Outline: Create Incident with Body

When send the request as post with short_description as <fileName>
Then Confirm the response status code as 201

Examples:
#|Column header1|Column header2|
|fileName|
#1st Data Row
|Incident1.json|
#2st Data Row
|Incident2.json|

