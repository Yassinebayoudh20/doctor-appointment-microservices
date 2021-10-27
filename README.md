#Doctor appointment microservices

## Table of contents
* [General info](#general-info)
* [Fonctionnalities](#fonctionnalities)
* [Architecture](#architecture)
* [Setup](#setup)

## General info
A simple project with Spring boot and Angular for Doctor appointment using Microservice architector for an application that manage and follow the doctor's appoitments.
	
## Fonctionnalities
User Manegment:
* Create Users with different Roles (Administration , Patient , Doctor)
* Manipulate Users depending on their roles

###Appointement Manegment:
* Create Appointement between two users a doctor and a patient
* Manipulate the Appointement

###Claim Manegment:
* Create claims with different content from several microservices
* Manipulate the claims

###follow-up doctor's appointement Manegment:
* Create follow-up between a patient and his doctor and sessions to it.
* Manipulate the follow-up 
* Create  session and related it to the follow-up
* Manipulate the sessions


###prescription Manegment:
* Create a prescription that contains a list of medecins
* Manipulate the prescription 
* Create medecin with information of use and related it to the prescription
* Manipulate the medecins

##Architecture:	
![Architector schema](https://www.google.com/search?q=zuul+and+docker+architecture&tbm=isch&ved=2ahUKEwics9K35OvzAhUHnRoKHZwsDjEQ2-cCegQIABAA&oq=zuul+and+docker+architecture&gs_lcp=CgNpbWcQAzoECAAQEzoICAAQCBAeEBM6CAgAEAcQHhATUIygA1iGsQNgwbQDaABwAHgAgAGIAYgBzQqSAQQxLjExmAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=E-Z5YdzdNIe6apzZuIgD&bih=753&biw=1536#imgrc=YHl4zvwpv0ha1M)

## Setup
To run this project, install it locally using npm:

```
$ cd ..
$ npm install
$ npm start
```
