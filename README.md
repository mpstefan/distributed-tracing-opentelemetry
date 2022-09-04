# Mini Distributed Tracing
A not very random string generator that is instrumented with OpenTelemetry to export Jaeger traces to the included Jaeger deployment. This is the easiest implementation possible using the OpenTelemetry java agent with no custom spans. If you run the project, you will be able to generate and view traces in the Jaeger UI:

![image](https://user-images.githubusercontent.com/7340923/188333657-e09aa135-2b95-4df2-bf87-6e1e75bc20c0.png)

## Architecture
Calls to the random-gateway will return a somewhat random string of characters, where every character is dervived from an API call to either random-letters or random-numbers:

```
                       +----------------+
                       | random-letters |
+----------------+     +----------------+
| random-gateway |  <
+----------------+     +----------------+
                       | random-numbers |
                       +----------------+
```

Each of the above services are instrumented with the Java OpenTelemetry Agent (see dockerfile) and configured to send traces to Jaeger (see docker compose).

## How to Run

Pre-requisites:
*docker
*docker-compose

Open a terminal in the root of this repository, build, then run using docker-compose:
```
docker-compose build
docker-compose up
```
You can generate traces by obtaining random strings via your browser at http://localhost:8080/randomString. Generate a few by refreshing the page, then check the Jaeger UI by going to http://localhost:16686 in your browser.
