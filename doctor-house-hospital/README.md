# Dr. House Hospital


What: simulate the process of handling of a patient in the hospital 

Contents of apps: Admission, Diagnoses, Beds, Pharmacy, Accountancy, Administration

Overview: when the patient arrives at the hospital:

1. The administration will welcome him, ask about his symptoms and than send him to the Admission.
2. Admission: will provide id and will send him to Diagnoses
3. Diagnoses: it is the actual doctor. It checks the symptoms and decides to send the patient either to Beds or to Pharmacy.
4. Beds: -receive the patient 
         -save the patient in Beds MongoDB database
         -give him a treatment
         -send him to Accountancy
5. Pharmacy: -receives the patient 
         -saves it in Pharmacy MongoDB database
         -gives him the medicine
         -sends him to Accountancy

6.Accountancy: -receives the patient 
               -saves him in Accountancy SQL database
               -creates the invoice
               -sends all info to Administration

7. Administration: has a link to invoice page which is accessible only to Accountant to mark it as paid.


A big challenge was to receive real symptoms from an external API (ApiMedic). For that I created an API media account and configured my rest template with the token and other security stuff.

The future for this app is to upgrade to the version, where the symptoms are evaluated by ApiMedic and diagnosis is sent back. 

Technology stack: Java 11, JUnit5, Spring Boot, Thymeleaf, Spring Boot Security, HTML5, CSS3, Web API, NoSQL (MongoDB), SQL.
80% of the code is tested.
100% of the code follows programming design principles.

GitHub repository: git@github.com:5Rabie5/projects.git
