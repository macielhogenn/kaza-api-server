#!/bin/bash

if [-d build]
then
  java -classpath ../lib/*;kaza-rest-api-1.0.0-SNAPSHOT.jar com.kaza.Main
fi

exit 0
