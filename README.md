# Doctor appointment microservices

## Table of contents
* [General info](#general-info)
* [Fonctionnalities](#fonctionnalities)
* [Routes List](#routes-list)
* [Architecture](#architecture)
* [Setup](#setup)

## General info
A simple project with Spring boot and Angular for Doctor appointment using Microservice architector for an application that manage and follow the doctor's appoitments.
	
## Fonctionnalities
User Manegment:
* Create Users with different Roles (Administration , Patient , Doctor)
* Manipulate Users depending on their roles

### Appointement Manegment:
* Create Appointement between two users a doctor and a patient
* Manipulate the Appointement

### Claim Manegment:
* Create claims with different content from several microservices
* Manipulate the claims

### follow-up doctor's appointement Manegment:
* Create follow-up between a patient and his doctor and sessions to it.
* Manipulate the follow-up 
* Create  session and related it to the follow-up
* Manipulate the sessions


### prescription Manegment:
* Create a prescription that contains a list of medecins
* Manipulate the prescription 
* Create medecin with information of use and related it to the prescription
* Manipulate the medecins

## User Routes List
| Route Name  | Action  | Method |
| :------------ |:---------------:| -----:|
| Discovery Server      | http://localhost:9001/eureka | POST |
| Zuul Gateway      | http://localhost:9000/ | Nan |
| Signup user      | http://localhost:9000/user-service/api/auth/signup | POST |
| Signin user      | http://localhost:9000/user-service/api/auth/signin        |   POST |
| Get user by id | http://localhost:9000/user-service/auth/users/1        |   Get |
| Update user | http://localhost:9000/user-service/auth/users/1        |   PUT |
| Delete user | http://localhost:9000/user-service/auth/users/1        |   DELETE |
| Get List users | http://localhost:9000/user-service/api/auth/users        |   GET |
| Add patient appointement | http://localhost:9000/user-service/api/auth/1/doctors/2        |   POST |




## Architecture:	
![Architector schema](https://i1.wp.com/thebasictechinfo.com/wp-content/uploads/2021/06/maxresdefault.jpg?w=1280&ssl=1)

## Setup
To run this project, install it locally using npm:

```
$ cd ..
$ npm install
$ npm start
```
