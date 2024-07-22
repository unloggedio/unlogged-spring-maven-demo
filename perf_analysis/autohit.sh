#!/bin/bash

sendRequest() {
    url="http://localhost:8080/perf/ping"
    headers="Content-Type: application/json"
    data='{
              "id" : 1,
              "title" : "postman title",
              "description" : "postman desc",
              "published" : true
          }'

    response=$(curl -s -X POST "$url" -H "$headers" -d "$data")
    echo "$response"
}

if [ "$#" -ne 1 ]; then
    echo "Usage: ./autohit.sh count"
    exit 1
fi

count=$1
for (( i=1; i<=count; i++ )); do
    echo "request_id = $i"
    response=$(sendRequest)
    echo "response = $response"
done