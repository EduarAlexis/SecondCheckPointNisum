#docker build -t [exercise_one]-[1.0.0] -f Dockerfile .
FROM openjdk:11
ADD build/libs/exercise_two-0.0.1-SNAPSHOT.jar /usr/share/app.jar
ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]