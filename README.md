# TapRoomMenu

This is my attempt at menu-ing software for brewery tap rooms. It is a Spring Boot application that uses Thymeleaf as a templating engine to display the beers currently on tap. It is currently under development and basically nothing works yet.

## Feature Roadmap
 * Create admin interface for taproom managers to add/update/delete beers and descriptions
 * Create admin interface for taproom managers to select a menu template (or add a custom template) to display the beers on tap
 * Create front end interface to display beers to taproom customers, based on the beers entered by the taproom manager with the desired template
 
## Application architecture
 * Read/Write/Update/Delete beer information and other configuration data to Relational DB
 * REST JSON API provided by Spring RestControllers
 * Serve front end and admin interface through Thymeleaf templates

## Deployment
 * Currently run as a standalone Spring Boot application. Hopefully down the road package it as a Docker image for simplified deployment.
