Selenium tests

Below are descriptions for the automated frontend tests for sprint 5 
located at public/seleniumtests.java

Test 1: 
Google Chrome browser test- 
	Opens a new instance of the app in google chrome, then 
	creates a new user and logs in with created credentials, 
	then logs out after signing in.

Test 2: 
Firefox browser test- 
	Opens a new instance of the app in firefox, then 
	creates a new user and logs in with created credentials, 
	then logs out after signing in.
	
Test 3:
Incorrect password test-
	Opens a new instance of the app in google chrome, then 
	creates a new user. Then, attempts to log in with the 
	wrong password. This log in attempt should be blocked.
	
Test 4:
Sample listing test-
	Opens a new instance of the app in google chrome, then 
	creates a new user and logs in with created credentials.
	This user then creates a post, inputting a title, image link, 
	and description. Once the listing is posted, then the user 
	edits the listing's title, image, and description. Finally, 
	the user deletes the post after confirming from the home page 
	that it has been edited. User logs out afterwards.
	
Test 5:
User authentication and comment test-
	Opens a new instance of the app in google chrome, then 
	creates a new user(User1) and logs in with created credentials, 
	then adds a post with title, image link, and description.
	User1 logs out, then clicks on the created listing and 
	attempts to add a comment, which should bring them to a
	redirection page asking for a login. Logs in as User2, 
	then goes back to the post and leaves a comment on it as
	User2. User2 then edits the comment and logs out afterwards.
	Logs back in as User1, then adds a comment on the post, then
	deletes the post, and finally logs out.