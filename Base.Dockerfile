# Use a imagem oficial do Maven como base
FROM maven:3.8.1-openjdk-11

# Copie seu código fonte para o contêiner
COPY . /app
WORKDIR /app

# Define a versão do Java
ARG JAVA_VERSION=11
ARG SPRING_BOOT_VERSION=2.5.4
ARG MAVEN_VERSION=3.8.1
ARG RELEASE_VERSION=21

# Define as variáveis de ambiente para a versão do Java, Spring Boot e Maven
ENV JAVA_HOME=/usr/lib/jvm/java-${JAVA_VERSION}-openjdk-amd64
ENV PATH=$PATH:$JAVA_HOME/bin
ENV SPRING_BOOT_VERSION=${SPRING_BOOT_VERSION}
ENV MAVEN_VERSION=${MAVEN_VERSION}
ENV RELEASE_VERSION=${RELEASE_VERSION}

# Instale o apt-utils
RUN apt-get update && \
    apt-get install -y apt-utils
