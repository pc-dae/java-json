# Notifcation Client POC

This is a proof of concept implementation of a notication service client.

## Setup
```
git clone https://github.com/pc-dae/java-json.git
cd java-json
```

## Compile
To compile and build jar...
```
./mvnw clean package
```
## Execute
```
java -jar target/java-json-1.0-SNAPSHOT.jar --input data/email1.mustache --data data/data.json --output data/out.json
```
