@echo off

if exist build (
  cd build/libs
  java -classpath ../lib/*;kaza-rest-api-1.0.0-SNAPSHOT.jar com.kaza.Main
  cd..
  cd..
)
