#docker build -t [exercise_one]-[1.0.0] -f Dockerfile .
FROM openjdk:11
ADD build/libs/exercise_one-0.0.1-SNAPSHOT.jar /usr/share/app.jar
ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]