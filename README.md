Zerobounce Java API wrapper
=====================

[ZeroBounce](https://www.zerobounce.net>) Java API


This is a Java wrapper class example for the ZeroBounce API.

The project has 2 dependencies:
1) Apache HttpClient
2) JSON (org.json)

Either download the dependencies separately and add them to
the relevant path or add the following dependencies to your
pom.xml file if you're building via Maven (already added if you're cloning this repo):

```xml
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.4</version>
</dependency>

<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20171018</version>
</dependency>
```

##### Example usage:

The validation methods return objects on which you call get methods which return the relevant information. Please see the code for all getters and below for a sample:

```java
ZeroBounceApi zeroBounceApi = new ZeroBounceApi("YOUR_API_KEY");

// Get credits and assign to int variable
int credits = zeroBounceApi.getCredits();

// validate email and assign result to a ZeroBounceResponse object
ZeroBounceResponse validation = zeroBounceApi.validate("some@email.com");
validation.getEmailAddress();
validation.getStatus();
validation.isDisposable();

// validate email with ip and assign result to a ZeroBounceResponseWithIp object
ZeroBounceResponseWithIp validationWithIp = zeroBounceApi.validateWithIpAddress("some@email.com", "some.ip.address");
validationWithIp.getEmailAddress();
validationWithIp.getCountry();
```
