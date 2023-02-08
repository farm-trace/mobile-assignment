# Taking Root Mobile Assignment

## About

Hello and welcome to the Taking Root Mobile Assignment.

In this project, you will find:
* Some Jetpack Compose basic configuration
* Android Room configured and ready for use
* A Survey repository and view model
* Functionality to upload a survey to a server
* Functionality to get responses from the server

## Instructions

### Task 

Please fork this repository and then make the follow changes:

* Implement a form:
    * User form validation
        * Type: `user`
        * Fields:
            * First name
            * Last name
            * Email
            * Birth date
        * Validations:
            * First and Last name cannot be null or blank
            * Must be a valid email
            * Only users over 18 are allowed
* Identify any existing issues with the codebase you think are worth fixing
    * Fix the issues using your choice of solution, or if a much larger refactor is required, just explain what
      further changes you'd make if more time was available.

### Timing

You are welcome to spend whatever time you want on the assignment, but please think critically about where you choose
to spend your time, as you would on a typical work assignment. Reaching a reasonable solution should take approximately 90 minutes. 
It is important to use your time appropriately and ensure you have the assignment submitted by the deadline communicated to you by the recruiter.

### API Authorization

All API calls need to include your assigned account_id header key/value pair.  The value is a UUID that is supplied at the time the assignment is provided.

For example:
GET http://assignment.takingroot.app/survey/user
headers: { "account_id": "00000000-0000-0000-0000-000000000000" }

If not provided or not valid, you will see an error message:
```
{
    "name": "BadRequest",
    "message": "account lookup failed",
    "code": 400,
    "className": "bad-request",
    "data": [
        {
            "instancePath": "/account_id",
            "schemaPath": "#/request/header/account_id",
            "keyword": "msising account_id",
            "message": "account_id must be in the request header"
        }
    ]
}
```

### API Definitions

GET http://assignment.takingroot.app/survey/user

POST http://assignment.takingroot.app/survey/user
```json
{
    "id": uuid,
    "first_name": string,
    "last_name": string,
    "birth_date": date,
    "email": string
}
```

DELETE http://assignment.takingroot.app/survey/user/{id}
