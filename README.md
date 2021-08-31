# Ecommerce Web JakartaEE Project

## Website Overview

Ecommerce Web is a basic Java Enterprise Edition web application that leverages several of the core
building blocks such as JavaServer Pages (JSP), Java servlets, Java entities, the JPA API, and the
JAX-RS API. In order to build out the frontend of this application, a bit of HTML and CSS was used.
And in order to fully utilize backend features of JavaEE, a basic MySQL database was incorporated
into the application so that the full process of saving and retrieving data use JavaEE features
could be shown.

The Main Features Ecommerce Web Include

- Create and Login as a User to the website
- View vendor partners, products, and products by category within separate pages
- Leveraging CRUD methods to make changes to information about our vendor partners, products, and
  categories easily using the API
- Data validation for specific fields and operations when trying to perform certain functions

Technical features include

- Servlets to perform specific CRUD operations and support page navigation throughout the site.
- Persistent data storage using a local MySQL database instance
- One to many relationships between specific entities

In addition to the code available within
here: <a href="https://github.com/sidney-wells/java_ecommerce" target="_blank">this repo and at this
github link.</a>

Images of the website, as of August 30, 2021, are in the use-case-images directory.

Finally, in order to build this application, I'd recommended using the most recent tomcat server 10
version to deploy this application locally. I also used the most recent release of Java's OpenJDK.
Using an IDE, building this project with the required Maven packages should be seamless. The
database connection within the API and servlets can be commented out if it's causing issue when
loading the pages or navigating the website.

Thank you for this opportunity to learn and use JavaEE to build a simple web application. 