# Use a imagem oficial do Maven como base
FROM maven:3.8.1-openjdk-11

# Copie seu código fonte para o contêiner
COPY . /app
WORKDIR /app
