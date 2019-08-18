#FriendFinder_Backend

Backend API for endpoints to the Friend Finder app
BASE_URL = http://friendfinderbe.herokuapp.com

[Authentication](##Authentication)

- [Register User](######Create_New_User)
- [Login](###Login)
- [Logout](###Logout)

[Users](##Users)

- [Update User](######Update_user)
- [Delete User](######Delete_User)
- [Get User By Id](######Get_User_By_Id)
- [Get Current User](######Get_Current_User)
- [Get Users By City and State](######Get_Users_By_City_And_State)
- [Get Users By Gender](######Get_Users_By_Gender)
- [Get Users By Hobby](######Get_Users_By_Hobby)
- [Get Unfiltered Users](######Get_Unfiltered_Users)

[Quotes](##Quotes)

- [Create Quote](######Create_Quote)
- [Delete Quote](######Delete_Quote_By_Id)
- [Get Quote By Id](######Get_Quote_By_Id)
- [Get a List of All Quotes](######Get_All_Quotes)
- [Get a List of quotes from a User](######Get_Quotes_By_User)

##Authentication

###Register a User

######Create_New_User
`/createnewuser`

Request Type

> post

Expected Data

```javascript
data = {
  username: "someUserName",
  password: "somePassword"
};
```

Example Request

```javascript
axios.post(`${BASE_URL}/createnewuser`, data);
```

Notes

> Will not return a token or a user only a 201 created response

###Login

`/oauth/token`

Request Type

> post

Expected Data

```javascript
data = {
  username: "someUserName",
  password: "somePassword"
};
```

Example Request

```javascript
config = {
  headers: {
    Authorization: `bearer ${btoa("lambda-client")}:${btoa("lambda-secret")}`
  }
};
axios.post(`${BASE_URL}/oauth/token`, data, config);
```

Notes

> Must contain Auth headers or you will receive a 401 error from the auth server

###Logout

`/oauth/revoke-token`

Request Type

> get

Example Request

```javascript
axios.get(`${BASE_URL}/oauth/revoke-token`);
```

Notes

> Revokes token for currently logged in user

---

##Users

###Update User

######Update_user
`/users/user/{id}`

Request Type

> put

Expected Data

```javascript
data = {
  age: 18,
  email: "person@lambdaschool.com",
  gender: "male",
  hobby: "Outdoors",
  location: "Minneapolis, MN",
  password: "**********",
  quotes: [
    {
      quote: "string",
      quotesid: 0
    }
  ],
  userid: 1,
  username: "Chuck"
};
```

Example Request

```javascript
axios.put(`${BASE_URL}/users/user/1`, data);
```

Notes

> Will not return a token or a user only a 201 created response

###Delete User

######Delete_User

`/users/user/{id}`

Request Type

> DELETE

Example Request

```javascript
axios.delete(`${BASE_URL}/users/user/1`);
```

Notes

>

###Get User

######Get_User_By_Id
`/Users/user/1`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/users/user/1`);
```

Notes

> Gets User by user ID

######Get_Current_User
`/Users/currentuser`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/users/currentUSer`);
```

Notes

> Returns user for user with given Auth credentials

######Get_Users_By_City_And_State
`/profiles/city/{city}/state/{state}/count/{count}`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/profiles/city/Salt%20Lake%20City/state/Utah/count/10`);
```

Notes

> Example request returns up to 10 users with city and state matching `Salt Lake City`, `Utah`

######Get_Users_By_Gender
`/profiles/gender/{gender}/count/{count}`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/profiles/gender/male/count/10`);
```

Notes

> Example request returns up to 10 `male` users

######Get_Users_By_Hobby
`/profiles/hobby/{hobby}/count/{count}`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/profiles/hobby/fishing/count/10`);
```

Notes

> Example request returns up to 10 users who have a 'hobby' matching 'fishing'

######Get_Unfiltered_Users
`/profiles/unfiltered`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/profiles/unfiltered`);
```

Notes

> Returns up to 10 users

`/profiles/unfiltered/count/{count}`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/profiles/unfiltered`);
```

Notes

> Returns up to specified number of users

---

##Quotes

###Create Quotes

######Create_Quote

`/quotes/quote`

Request Type

> post

Expected Data

```javascript
data = {
  quote: "Lets hope this woorks",
  user: {
    userid: 14
  }
};
```

Example Request

```javascript
axios.post(`${BASE_URL}/quotes/quote`, data);
```

Notes

> can not create a quote without being given a userid

###Delete Quotes

######Delete_Quote_By_Id
`/quotes/quote/{id}`

Request Type

> DELETE

Example Request

```javascript
axios.delete(`${BASE_URL}/quotes/quote/{id}`);
```

Notes

> Deletes quote with given id, There is no update so maybe delete and make a new quote instead

###Get Quotes

######Get_Quote_By_Id
`/quotes/quote/{id}`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/quotes/quote/47);
```

Notes

> Gets quote by ID, returns a single quote

######Get_All_Quotes
`/quotes/quotes`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/quotes/quotes);
```

Notes

> returns a list of all quotes

######Get_Quotes_By_User
`/quotes/username/{username}`

Request Type

> GET

Example Request

```javascript
axios.get(`${BASE_URL}/quotes/username/Chuck);
```

Notes

> returns a list of all quotes for user with given username
