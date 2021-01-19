# CityInfoTelegramBot

Telegram bot that response with a description of the city by the given city name. 

Name in **telegram**: @CitySightsBot

Token: 1060467825:AAHKijTwsSVXWh28cPwumguQUlKKkVLkowM

Link: https://teleg.run/CitySightsBot
 
 Bot deployed on Heroku. Available cities in database: Минск, Киев
 
 
 ### Rest api
 
 Supported commands:
 
 To get all cities use: GET ```https://city-sights-bot.herokuapp.com/api/city```
 
 To add new city: POST ```https://city-sights-bot.herokuapp.com/api/city``` 
 ```
 {
	"name":"City name",
	"citySights": "Description"
}
 ```
 
 To update city: PUT ```https://city-sights-bot.herokuapp.com/api/city/{id}```
 ```
 {
	"name":"City name",
	"citySights": "Description"
}
 ```
 To delete city: DELETE ```https://city-sights-bot.herokuapp.com/api/city/{id}```
 
 ### How to edit and run on your pc
 
 Download and install https://ngrok.com
 
 Create shortcut and write *http 5000* in shortcut object path.(For example: *C:\ngrok.exe http 5000*) 
 
 Write *server.port=5000* in application.properties
 
 Run ngrok with shortcut and you will get web adress like ```https://822d3ed3fe05.ngrok.io```
 
 Write that adress to *telegrambot.webHookPath* in application.properties (For example: telegrambot.webHookPath=https://822d3ed3fe05.ngrok.io)
 
 Execute in your browser ```https://api.telegram.org/bot(yourToken)/setWebhook?url=``` (your url from ngrok)
 
 In my case its:
 ```https://api.telegram.org/bot1060467825:AAHKijTwsSVXWh28cPwumguQUlKKkVLkowM/setWebhook?url=https://822d3ed3fe05.ngrok.io```
 
 Run spring app
 
 
