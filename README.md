Zerobounce Java API wrapper
=====================

[ZeroBounce](https://www.zerobounce.net>) Java API


This is a java wrapper class example for the ZeroBounce API.

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

```java
ZeroBounceApi zeroBounceApi = new ZeroBounceApi("YOUR_API_KEY");
int credits = zeroBounceApi.getCredits()
JSONObject validation = zeroBounceApi.validate("some@email.com")
JSONOBject validationWithIp = zeroBounceApi.validateWithIpAddress("some@email.com", "some.ip.address")
```
