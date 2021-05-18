# Restful Web Services

Social Media Application: 
User can make a number of posts, So relationship between them is one-to-many
User -> Posts

User:
Retrieve all users  : GET /users
Create a user		: POST /users
Retrieve one user	: GET /users/{id} -> /users/1
Delete a user		: DELETE /users/{id} -> /users/1

Posts:
Retrieve all posts for a User	: GET /users/{id}/posts
Create a post for a User		: POST /users/{id}/posts
Retrieve details of a post 		: GET /users/{id}/posts/{posts_id}
