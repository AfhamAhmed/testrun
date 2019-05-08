//You can find your project ID in the DialogFlow agent settings
const projectId = ('atosseniordesign');
const sessionId = 'quickstart-session-id';
const languageCode = 'en-US';
const port = 8080; //was 3000 before

var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

//instantiate DialogFlow client
var dialogflow = require('dialogflow');
var sessionClient = new dialogflow.SessionsClient();
var sessionPath = sessionClient.sessionPath(projectId,sessionId);

var serveStatic = require('serve-static');

//var i = 0; //new
app.use(serveStatic('images/'));

app.get('/', function(req, res) {
   res.sendFile(__dirname + '/test.html');
});

http.listen(port, function(){
	console.log('listening on port ' + port);
});

io.on ('connection', function(socket){
	//i++; //new
	//var myOwnId = i; //new 
	//sessionClient = new dialogflow.SessionsClient();
	//sessionPath = sessionClient.sessionPath(projectId,myOwnId); //moved
	socket.on('chat message', function(msg) //io.on previous
	{ 
		//Text query request
		const request = 
		{
			session: sessionPath,
			queryInput: { text: { text: msg, languageCode: languageCode }
			}
		};

		sessionClient.detectIntent(request).then(responses => 
		{
			console.log('Detected intent');
			let result = responses[0].queryResult;
			console.log(`Query: ${result.queryText}`);
			console.log(`Response: ${result.fulfillmentText}`);
			if (result.intent)
			{
				console.log(`Intent: ${result.intent.displayName}`);
			}
			else
			{
				console.log('No Intent matched.')
			}

			console.log(JSON.stringify(responses,null,2));

			//sending a message of type chat message to clients
			io.emit('chat message', result.fulfillmentText);
		})
		.catch(err => 
	    {
	      console.error('ERROR:', err);
	    });
	});
	
});

