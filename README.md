# Microservices demo

This is a sample application with 3 microservices:

1. category-service
2. supplier-service
3. product-service


In addition, there is a `eureka-service` which is a discovery server to 
which all these services are going to do self-registration.

There is also an api-gateway service that looks up the discovery service
for any requests coming from the client, and redirects the same
to the appropriate service.

```
/api/categories/*  --> category-service
/api/suppliers/*  --> supplier-service
/api/products/*  --> products-service
```

It's worth to note that none of these services are directly 
exposed to the client, but accessible only via the api-gateway service.

The api-gateway service is exposed on port 8080