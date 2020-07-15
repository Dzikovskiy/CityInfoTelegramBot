# CityInfoTelegramBot

Telegram bot that response with a description of the city by the given city name. 

Name in **telegram**: @CitySightsBot


 
 Bot deployed on Heroku. Available cities in database: Минск, Киев, Вильнюс 
 
 
 ### Rest api
 
 Supported commands:
 
 To get all cities use: GET https://city-sights-bot.herokuapp.com/api/cities 
 
 To add new city: POST https://city-sights-bot.herokuapp.com/api/city 
 ```
 {
	"name":"City name",
	"citySights": "Description"
}
 ```
 
 To update city: PUT https://city-sights-bot.herokuapp.com/api/city/{id}
 ```
 {
	"name":"City name",
	"citySights": "Description"
}
 ```
 To delete city: DELETE https://city-sights-bot.herokuapp.com/api/city/{id}
