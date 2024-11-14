# Usa una imagen oficial de Java como base
FROM openjdk:17-jdk-slim

# Instala Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Configura el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y resuelve las dependencias para optimizar la caché
COPY pom.xml /app
RUN mvn -B dependency:resolve dependency:resolve-plugins

# Copia el código fuente de la aplicación
COPY src /app/src

# Compila el proyecto y genera el archivo JAR
RUN mvn -B clean package -DskipTests

# Expone el puerto que utiliza Spring Boot
EXPOSE 8080

# Ejecuta la aplicación
CMD ["java", "-jar", "target/microservicio-login-logout-1.0.0.jar"]
