FROM openjdk:14
VOLUME /tmp
EXPOSE 9090
COPY segurityrest-1.0.0.jar /segurityrest-1.0.0.jar
ENTRYPOINT ["java","-jar","segurityrest-1.0.0.jar"]