# Pagination

*PaginationService* - A REST API Service to fetch data from the storage / database and show the results to user in a sorted manner.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Eclipse / IntelliJ IDE, JDK1.8, Maven, Apache Tomcat, MongoDB 

## Running the tests

Here is the endpoint to test - http://localhost:{PORT}/Pagination/getPerson?searchText=TEXT&limit=LIMIT&orderBy=name
The values will be fetched from UI and sent to the service. orderBy element can be used to sort a particular field. 

## Deployment

It can be run on local in an eclipse as a maven project for testing purpose. Make sure to install all dependencies from pom file.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

