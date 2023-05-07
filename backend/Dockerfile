FROM maven:3.8.5-openjdk-18 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /usr/src/app/target/*.jar /usr/app/*.jar
EXPOSE 9876
ENTRYPOINT ["java","-jar","-Xmx4g","/usr/app/*.jar"]