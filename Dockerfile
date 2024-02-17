FROM eclipse-temurin as prod

WORKDIR /app

COPY ./build/libs/rb-micronaut-0.1-all-optimized.jar ./

CMD ["java", "-jar", "rb-micronaut-0.1-all-optimized.jar"]