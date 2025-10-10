# Etapa de build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

ENV PATH="/app/bin:$PATH"
ENV NO_COLOR=true
ENV TERM=dumb

COPY --from=build /app/target/locacao.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]