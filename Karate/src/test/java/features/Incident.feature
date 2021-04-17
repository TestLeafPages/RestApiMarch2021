Feature: IncidentManagemant in ServiceNow

Background:
# set Endpoint
Given url 'https://dev79032.service-now.com/api/now/table/incident'
# set Header with Authorization
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='

Scenario Outline: Create a incident

# set body
When request { 'short_description' : <short_description>}
# Request Type
And method post
Then match header Content-Type contains 'json'
And assert responseTime < 5000
#print response
And print response

Examples:
|short_description|
|This from karate data1|
|This from karate data2|













