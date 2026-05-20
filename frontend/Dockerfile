# Step 1: Build React app
FROM node:20-alpine AS build
WORKDIR /app

ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=$REACT_APP_API_BASE_URL

COPY package*.json ./
RUN npm install --legacy-peer-deps

COPY . .
RUN npm run build

# Step 2: Serve with OpenShift-friendly Nginx
FROM nginxinc/nginx-unprivileged:alpine
COPY --from=build /app/build /usr/share/nginx/html

EXPOSE 8080