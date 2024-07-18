# demobank-account-java-springboot-maven
Account Application Component of Demo Bank using below technologies
- Programming Language : java
- Middleware : springboot
- Dependency management : maven

Add Common React Frontend Application Component for all
Add JPA Persistence - Done
Add Events
Add Data Ingestion Pipeline Application Component
Call currency service - Done

Make Account as aggregate root and it needs to contain a Set of transactions. transaction is not an aggregate root. similar to backlogitem and tasks since backlogitemstatus is dependant on tasks estimateTaskHoursRemaining. Similarly, balance of the account is dependant on the transaction.

Change currency to currency code