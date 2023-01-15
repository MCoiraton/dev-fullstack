### STAGE 1: Build ###
FROM node:16.18-alpine AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build
### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY --from=build /usr/src/app/dist/covidFront /usr/share/nginx/html
