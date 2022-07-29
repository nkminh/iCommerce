# Getting Started

### Steps to setup development environment

**1. Setup Postgres Database**

- Install postgres tool version 11 with information to below

    ```bash
    user:     postgres
    password: postgres
    database: nabdb
    ```

**2. Build & Run Application**

- Open source code at root folder: <i>~/iCommerce</i>
    ```bash
    iCommerce
    │
    │───README.md
    │
    │───src/main/java/minh/nguyen/com/example/iCommerce/
    │   │───controller
    │   │───dto
    │   │───entity
    │   │───filter
    │   │───repository
    │   │───services
    │   │───util  
    │───DOC
    │   │───1.Postman
    │   │───2.Diagram
    │   │───3.Test-cases
    ```

- Use apache maven version 3.6.3 to build all application by typing the following command:
    ```sh
    $ cd iCommerce
    $ mvn clean install
    ```

- Use jdk version 1.8 and spring boot version 2.7.2 to run iCommerce application by typing the following command:
    ```sh
    $ java -jar iCommerce/target/iCommerce-0.0.1-SNAPSHOT.jar
    ```
- Implement API ( You can import APIs by Postman Application.
  file iCommerce/DOC/1.Postman/NAB.postman_collection.json)
    ```sh
    API : Get a list of products by filtering multiple criteria  including category, price, brand, colour:
  
    URL: http://localhost:8080/product/search
    Method: GET
    Header: 'Content-Type: application/json'
    Body: {
    "id": null,
    "productName": null,
    "price":null,
    "categoryName": null,
    "branchName": null,
    "color": null
    }
  ```
  
  ```sh
  API: Add a product to shopping cart

  URL: http://localhost:8080/detail-cart
  Method: POST
  Header: 'Content-Type: application/json'
  Body: {
  "productId": 1,
  "count": 1
  }
  ```
- Diagram: Open file in "iCommerce/DOC/2.Diagram/diagram_database.PNG" 
  
- Test-Cases: Open file in "iCommerce/DOC/3.Test-cases/test-case.xlsx"

