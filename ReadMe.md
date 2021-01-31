Atm Locator Spring Boot application provides a REST API to get the list of ING ATMs in a given city or all the cities

CURL commands to Test :

Get all ATMs :

curl -X GET --header 'Accept: application/json' 'http://localhost:8080/atms'

Get ATMs by cityName :

curl -X GET --header 'Accept: application/json' 'http://localhost:8080/atms/<CITY_NAME>'

FYI :

Third party API is return bad format json ( which causes Json processing Exception as it encounters unexpected characters) 
We need to exclude them manually. See AtmWrapper utilty class for more details.

If search for City not exist in the ING API response then return error message with response not found.