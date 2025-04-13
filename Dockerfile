FROM debian
EXPOSE 8080
WORKDIR /app
COPY . /app/
RUN apt update \
    && apt install -y default-jre default-jdk maven
RUN mvn clean package
RUN mvn install

CMD ["mvn", "spring-boot:run"]