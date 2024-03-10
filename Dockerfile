FROM openjdk:14
EXPOSE 9090
VOLUME /image
ADD target/stock-0.0.1-SNAPSHOT.jar /image/stock-0.0.1-SNAPSHOT.jar
# RUN sh -c 'touch /stock.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /image/stock-0.0.1-SNAPSHOT.jar" ]
