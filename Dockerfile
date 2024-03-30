# Use an official Maven image as a base
FROM maven:3.8.4-openjdk-17-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the Maven project's pom.xml file
COPY pom.xml .

# Copy the rest of the project
COPY src ./src

# Run Maven clean install to download dependencies
RUN mvn clean 

# Expose any ports the app is expecting in runtime
# EXPOSE 8096

# Set the entry point to run the Maven tests
CMD ["mvn", "test"]
